package com.cralos.myretrofitproject.httpGet.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cralos.myretrofitproject.R;
import com.cralos.myretrofitproject.httpGet.interfaces.OnClickUserCardView;
import com.cralos.myretrofitproject.httpGet.models.User;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class GetAdapter extends RecyclerView.Adapter<GetAdapter.ViewHolder> {

    private Context context;
    private List<User> users;
    private OnClickUserCardView userCardViewListener;

    public GetAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_get, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.txvUserName.setText(users.get(position).getFirstName());

        holder.txvUserEmail.setText(users.get(position).getEmail());

        Glide.with(context)
                .load(users.get(position).getAvatar())
                .into(holder.circleImageView);

        holder.userCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userCardViewListener != null) {
                    userCardViewListener.onClickUserCard(users.get(position).getId(), users.get(position).getFirstName());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setOnClickUserCardView(OnClickUserCardView userCardViewListener) {
        this.userCardViewListener = userCardViewListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView circleImageView;
        private TextView txvUserName, txvUserEmail;
        private CardView userCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userCardView = itemView.findViewById(R.id.cardUserGet);
            circleImageView = itemView.findViewById(R.id.profile_image);
            txvUserName = itemView.findViewById(R.id.txvUserName);
            txvUserEmail = itemView.findViewById(R.id.txvUserEmail);
        }
    }

}
