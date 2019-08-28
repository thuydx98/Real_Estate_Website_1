package com.res.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_ID;

    @Column(nullable = false, length = 100,name = "fullname")
    private String fullname;

    @Column(nullable = false, length = 100,name = "email")
    private String email;

    @Column(nullable = false, length = 200,name = "address")
    private String address;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Account account;

    @Column(nullable = false,name = "createDate")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date createDate ;

    @OneToMany(mappedBy = "author")
    private Set<Post> posts = new HashSet<>();

    @OneToMany(mappedBy = "reporter")
    private Set<ReportedPost> reportedPosts = new HashSet<>();

    public int getCustomer_ID() {
        return customer_ID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<ReportedPost> getReportedPosts() {
        return reportedPosts;
    }

    public void setReportedPosts(Set<ReportedPost> reportedPosts) {
        this.reportedPosts = reportedPosts;
    }

    public Customer() { }
}