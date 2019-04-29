package com.example.android01_eventbus;

class Web {
    private String name;
    private String url;

    public Web(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Web{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
