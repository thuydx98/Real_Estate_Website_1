package com.res.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "post_type")
public class PostType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int type_ID;

    @Column(nullable = false, length = 30)
    private String type_Tittle;

    @OneToMany(mappedBy = "postType")
    private Set<Post> posts = new HashSet<>();

    public int getType_ID() {
        return type_ID;
    }

    public String getType_Tittle() {
        return type_Tittle;
    }

    public void setType_Tittle(String type_Tittle) {
        this.type_Tittle = type_Tittle;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public PostType() {
    }
}
