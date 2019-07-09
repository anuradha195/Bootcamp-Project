package com.example.BootcampProject;

import java.io.IOException;

public class User {
    private String username;
    private String password;
    private String accessToken;
    DailySteps[] results = new DailySteps[7];

    public User(String login, String password) {
        this.username = login; //store login
        this.password = password; //store password
    }

    public DailySteps[] login() throws IOException {
        Requests google = new Requests(this);
        results = google.requestData();
        return results;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public DailySteps[] getResults() {
        return results;
    }

    public void setResults(DailySteps[] results) {
        this.results = results;
    }
}
