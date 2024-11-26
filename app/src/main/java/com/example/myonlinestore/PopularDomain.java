package com.example.myonlinestore;

import java.io.Serializable;

public class PopularDomain implements Serializable {
    private String title;
    private String description;
    private String picURL;
    private int review;
    private double score;
    private int numberinCart;
    private double price;

    // Default constructor (needed for Firestore)
    public PopularDomain(String macbookProMc13chip, double v, String url) {}

    public PopularDomain(String title, String description, String picURL, int review, double score, double price) {
        this.title = title;
        this.description = description;
        this.picURL = picURL;
        this.review = review;
        this.score = score;
        this.price = price;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getNumberinCart() {
        return numberinCart;
    }

    public void setNumberinCart(int numberinCart) {
        this.numberinCart = numberinCart;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PopularDomain{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", picURL='" + picURL + '\'' +
                ", review=" + review +
                ", score=" + score +
                ", numberinCart=" + numberinCart +
                ", price=" + price +
                '}';
    }
}
