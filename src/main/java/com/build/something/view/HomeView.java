package com.build.something.view;

/**
 *
 */
public class HomeView extends Viewer {
    private final String content;

    public HomeView(String content) {
        super("home.ftl");
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
