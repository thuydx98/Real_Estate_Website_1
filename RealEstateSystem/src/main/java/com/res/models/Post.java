package com.res.models;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int post_ID;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)    //
    private PostType postType;

    @Column(nullable = true)
    private Date postTime = new Date();

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    @NumberFormat(pattern = "#,###,###,###.##")
    private double area;

    @Column(nullable = true)
    private String project;

    @Lob
    @Column(nullable = false)
    private String description;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RealEstaleType realEstaleType;

    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private PostDetails details;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Customer author;

    @OneToMany(mappedBy = "post")
    private Set<PostImages> postImages = new HashSet<>();

    @OneToMany(mappedBy = "post")
    private Set<ReportedPost> reportedPosts = new HashSet<>();

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PostStatus status;

    public int getPost_ID() {
        return post_ID;
    }

    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return String.format("%,.0f", price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RealEstaleType getRealEstaleType() {
        return realEstaleType;
    }

    public void setRealEstaleType(RealEstaleType realEstaleType) {
        this.realEstaleType = realEstaleType;
    }

    public PostDetails getDetails() {
        return details;
    }

    public void setDetails(PostDetails details) {
        this.details = details;
    }

    public Customer getAuthor() {
        return author;
    }

    public void setAuthor(Customer author) {
        this.author = author;
    }

    public Set<PostImages> getPostImages() {
        return postImages;
    }

    public void setPostImages(Set<PostImages> postImages) {
        this.postImages = postImages;
    }

    public Set<ReportedPost> getReportedPosts() {
        return reportedPosts;
    }

    public void setReportedPosts(Set<ReportedPost> reportedPosts) {
        this.reportedPosts = reportedPosts;
    }

    public PostStatus getStatus() {
        return status;
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }

    public Post() { }

    public Post(PostType postType, Date postTime, String title, double price, String location, double area, String project, String description, RealEstaleType realEstaleType, PostDetails details, Customer author, Set<PostImages> postImages, PostStatus status) {
        this.postType = postType;
        this.postTime = postTime;
        this.title = title;
        this.price = price;
        this.location = location;
        this.area = area;
        this.project = project;
        this.description = description;
        this.realEstaleType = realEstaleType;
        this.details = details;
        this.author = author;
        this.postImages = postImages;
        this.status = status;
    }
}
