package com.example.internshipexercices.model;

public class Item {
    private int icon;
    private String title;
    private String subtitle;
    private boolean isChecked;

    public Item(int icon, String title, String subtitle, boolean isChecked) {
        this.icon = icon;
        this.title = title;
        this.subtitle = subtitle;
        this.isChecked = isChecked;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
