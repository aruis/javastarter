package com.aruistar.javastarter.core;

public class Greeting {

    private final long id;
    private final String content;
    private final String who;

    public Greeting(long id, String content, String who) {
        this.id = id;
        this.content = content;
        this.who = who;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getWho() {
        return who;
    }
}
