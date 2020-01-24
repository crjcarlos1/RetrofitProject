package com.cralos.myretrofitproject.login.models;

public class LoginRequest {

    private String email;
    private String password;

    /**
     * @param password
     * @param email
     */
    public LoginRequest(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }

}
