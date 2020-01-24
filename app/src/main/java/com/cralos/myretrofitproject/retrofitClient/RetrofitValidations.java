package com.cralos.myretrofitproject.retrofitClient;

import android.content.Context;

import com.cralos.myretrofitproject.R;

import java.io.IOException;

public class RetrofitValidations {
    /**
     * Validate responseCode
     *
     * @param responseCode
     * @return
     */
    public static boolean checkSuccessCode(int responseCode) {
        if (responseCode == StatusCodes.SUCCESS_CODE) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 400 Bad Request.
     * 401 Unauthorized.
     * 402 Payment Required.
     * 403 Forbidden.
     * 404 Not Found.
     * 500 Internal Server Error.
     */

    //public String getErrorByStatus(int responseCode, Context context) {
    public static String getErrorByStatusCode(int responseCode, Context context) {
        String error;
        if (responseCode == StatusCodes.BAD_CODE) {
            error = context.getString(R.string.wrongSyntax);
        } else if (responseCode == StatusCodes.UNAUTHORIZED_CODE) {
            error = context.getString(R.string.unauthorizedRequest);
        } else if (responseCode == StatusCodes.NOT_FOUND_CODE) {
            error = context.getString(R.string.resourceNotFound);
        } else if (responseCode == StatusCodes.INTERNAL_SERVER_ERROR_CODE) {
            error = context.getString(R.string.serverError);
        } else {
            error = context.getString(R.string.unknownError);
        }
        return error;
    }

    // public String getOnFailureResponse(Context context, Throwable t, int requestType) {
    public static String getOnFailureResponse(Throwable t, Context context) {
        if (t instanceof IOException) {
            return context.getString(R.string.internetConection);
        } else if (t instanceof IllegalStateException) {
            return context.getString(R.string.invalidateFormatResponse);
        } else {
            return context.getString(R.string.unknownError1);
        }
    }
}
