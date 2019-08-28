package com.res.models;

import javax.persistence.*;

@Entity
@Table(name = "post_images")
public class PostImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int image_ID;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)    //
    private Post post;

    @Column(nullable = false, length = 100)
    private String url;

    public int getImage_ID() {
        return image_ID;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public PostImages() { }
}
