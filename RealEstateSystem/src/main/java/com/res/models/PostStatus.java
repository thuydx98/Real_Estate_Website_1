package com.res.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "post_status")
public class PostStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int status_ID;

    @Column(nullable = false, length = 100)
    private String status_Title;

    @OneToMany(mappedBy = "status")
    private Set<Post> posts = new HashSet<>();

    public int getStatus_ID() {
        return status_ID;
    }

    public String getStatus_Title() {
        return status_Title;
    }

    public void setStatus_Title(String status_Title) {
        this.status_Title = status_Title;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public PostStatus() { }
}
