package com.cralos.myretrofitproject.httpPut.models;

public class PutRequest {

    private String name;
    private String job;

    /**
     * @param name
     * @param job
     */
    public PutRequest(String name, String job) {
        super();
        this.name = name;
        this.job = job;
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

}
