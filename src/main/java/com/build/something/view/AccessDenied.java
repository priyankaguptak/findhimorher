package com.build.something.view;

/**
 *
 */
public class AccessDenied extends Viewer {
    private String content;

    public AccessDenied(String content) {
        super("accessdenied.ftl");
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
