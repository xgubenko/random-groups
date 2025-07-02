package ru.profitgate.group_selector.controller;

public class GroupResponse {
    String url;

    public GroupResponse(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "GroupResponse{" +
                "url='" + url + '\'' +
                '}';
    }
}
