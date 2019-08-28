package com.res.services;


import com.res.models.Post;
import com.res.models.ReportedPost;

import java.util.List;

public interface PostService {
    int totalPosts();

    int totalBlockedPosts();

    int totalPostsByYear(int year);

    List<Post> findAll();

    List<Post> pendingPosts();

    List<ReportedPost> reportedPosts();

    Post findById(int id);

    boolean createOrEdit(Post post);

    public boolean approve(int post_id);

    public boolean block(int post_id);

    public boolean approveReport(int report_id);

    public boolean deleteReport(int report_id);
}
