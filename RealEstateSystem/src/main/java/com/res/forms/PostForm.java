package com.res.forms;

import javax.validation.constraints.*;

public class PostForm {

    @NotNull
    @Size(min = 10, max = 300, message = "Title size should be in the range [10...300]")
    private String title;

    @NotNull
    @DecimalMin("1.0")
    private double price;

    @NotNull
    @DecimalMin(value = "10.0", message = "You must input area")
    private double area;

    @NotNull
    @Size(min = 50, max = 600, message = "Description size should be in the range [50...600]")
    private String description;

    @NotNull
    @Size(min = 10, max = 600, message = "Location size should be in the range [10...600]")
    private String location;

    @NotNull
    @Min(value = 1, message = "You must choose post type")
    private int post_type;

    @NotNull
    @Min(value = 1, message = "You must choose real estate type")
    private int re_type;

    private int bedroom;
    private int bathroom;
    private int floor;
    private int alley;
    private int direction;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPost_type() {
        return post_type;
    }

    public void setPost_type(int post_type) {
        this.post_type = post_type;
    }

    public int getRe_type() {
        return re_type;
    }

    public void setRe_type(int re_type) {
        this.re_type = re_type;
    }

    public int getBedroom() {
        return bedroom;
    }

    public void setBedroom(int bedroom) {
        this.bedroom = bedroom;
    }

    public int getBathroom() {
        return bathroom;
    }

    public void setBathroom(int bathroom) {
        this.bathroom = bathroom;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getAlley() {
        return alley;
    }

    public void setAlley(int alley) {
        this.alley = alley;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
