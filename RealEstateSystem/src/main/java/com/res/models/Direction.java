package com.res.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "direction")
public class Direction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int direction_ID;

    @Column(nullable = false, length = 50)
    private String direction_Title;

    @OneToMany(mappedBy = "direction")
    private Set<PostDetails> postsDetail = new HashSet<>();

    public int getDirection_ID() {
        return direction_ID;
    }

    public String getDirection_Title() {
        return direction_Title;
    }

    public void setDirection_Title(String direction_Title) {
        this.direction_Title = direction_Title;
    }

    public Set<PostDetails> getPostsDetail() {
        return postsDetail;
    }

    public void setPostsDetail(Set<PostDetails> postsDetail) {
        this.postsDetail = postsDetail;
    }

    public Direction() { }
}
