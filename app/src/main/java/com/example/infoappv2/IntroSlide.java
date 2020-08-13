package com.example.infoappv2;

import android.widget.ImageView;
import android.widget.TextView;

public class IntroSlide {
    String title;
    TextView description;
    ImageView icon;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TextView getDescription() { return description; }

    public void setDescription(TextView description) {
        this.description = description;
    }

    public ImageView getIcon() {
        return icon;
    }

    public void setIcon(ImageView icon) {
        this.icon = icon;
    }
}
