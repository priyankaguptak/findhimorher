package com.build.something.view;

import com.yammer.dropwizard.views.View;

/**
 *
 */
public abstract class Viewer extends View {

    public Viewer(String templateName) {
        super(templateName);
    }

    abstract String getContent();
}
