package com.res.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "realestate_type")
public class RealEstaleType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int realestate_ID;

    @Column(nullable = false, length = 30)
    private String realestate_Title;

    @OneToMany(mappedBy = "realEstaleType")
    private Set<Post> posts = new HashSet<>();

    public int getRealestate_ID() {
        return realestate_ID;
    }

    public String getRealestate_Title() {
        return realestate_Title;
    }

    public void setRealestate_Title(String realestate_Title) {
        this.realestate_Title = realestate_Title;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public RealEstaleType() {
    }
}
