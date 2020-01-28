package com.cralos.myretrofitproject.httpPut.models;

public class PutResponse {
    private String name;
    private String job;
    private String updatedAt;

    /**
     * @param name
     * @param job
     * @param updatedAt
     */
    public PutResponse(String name, String job, String updatedAt) {
        super();
        this.name = name;
        this.job = job;
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
