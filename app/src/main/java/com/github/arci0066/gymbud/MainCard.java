package com.github.arci0066.gymbud;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainCard {
    private String title;
    private String desc;
    private String activity;

    public MainCard(String title, String desc, String activity) {
        this.title = title;
        this.desc = desc;
        this.activity = activity;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getActivity() {
        return activity;
    }

    @Override
    public String toString() {
        return "MainCard{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", activity='" + activity + '\'' +
                '}';
    }
}
