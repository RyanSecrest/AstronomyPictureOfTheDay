package com.example.astronomypictureoftheday;
import com.google.gson.annotations.SerializedName;

public class APOD {
    @SerializedName("date")
    private String date;

    @SerializedName("explanation")
    private String explanation;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String imageUrl;

    @SerializedName("copyright")
    private String copyright;

    // Getters
    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCopyright() {
        return copyright;
    }

    // Setters
    public void setDate(String date) {
        this.date = date;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
}

