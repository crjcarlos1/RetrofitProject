package com.cralos.myretrofitproject.httpGet.models;

import java.util.List;

public class GetResponse {

    private int page;
    private int perPage;
    private int total;
    private int totalPages;
    private List<User> data = null;

    /**
     * @param total
     * @param perPage
     * @param data
     * @param totalPages
     * @param page
     */
    public GetResponse(int page, int perPage, int total, int totalPages, List<User> data) {
        super();
        this.page = page;
        this.perPage = perPage;
        this.total = total;
        this.totalPages = totalPages;
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

}
