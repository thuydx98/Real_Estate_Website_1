package com.res.services;

import com.res.models.Employee;
import com.res.models.Post;
import com.res.models.ReportedPost;
import com.res.repositories.EmployeeRepository;
import com.res.repositories.PostRepository;
import com.res.repositories.PostStatusRepository;
import com.res.repositories.ReportedPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepo;
    @Autowired
    private PostStatusRepository postStatusRepo;
    @Autowired
    private ReportedPostRepository reportedPostRepo;
    @Autowired
    private EmployeeRepository employeeRepo;

    @Override
    public int totalPosts() {
        int total = this.postRepo.findAll().size();

        return total;
    }

    @Override
    public int totalBlockedPosts() {

        return this.postRepo.findAll().stream().filter(p -> Objects.equals(p.getStatus().getStatus_ID(), 3)).collect(Collectors.toList()).size();
    }

    @Override
    public int totalPostsByYear(int year) {
        Calendar cal = Calendar.getInstance();
        List<Post> posts = this.postRepo.findAll();

        int i = 0;
        for (Post p : posts) {

            cal.setTime(p.getPostTime());

            if (cal.get(Calendar.YEAR) == year) {
                i++;
            }
        }

        return i;
    }

    @Override
    public List<Post> findAll() {
        return this.postRepo.findAll().stream().filter(p -> p.getStatus().getStatus_ID() != 3).collect(Collectors.toList());
    }

    @Override
    public List<Post> pendingPosts() {
        return this.postRepo.findAll().stream().filter(p -> Objects.equals(p.getStatus().getStatus_ID(), 1) || Objects.equals(p.getStatus(), null)).collect(Collectors.toList());
    }

    @Override
    public List<ReportedPost> reportedPosts() {
        return this.reportedPostRepo.findAll().stream().filter(p -> Objects.equals(p.isStatus(), false) || Objects.equals(p.getCensor(), null)).collect(Collectors.toList());
    }

    @Override
    public Post findById(int id) {
        return this.postRepo.findOne(id);
    }

    @Override
    public boolean createOrEdit(Post post) {
        try {
            this.postRepo.save(post);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean approve(int post_id) {
        try {
            Post post = this.postRepo.findOne(post_id);
            post.setStatus(this.postStatusRepo.findOne(2));
            this.postRepo.save(post);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean block(int post_id) {
        try {
            Post post = this.postRepo.findOne(post_id);
            post.setStatus(this.postStatusRepo.findOne(3));
            this.postRepo.save(post);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean approveReport(int report_id) {
        try {
            ReportedPost reportedPost = this.reportedPostRepo.findOne(report_id);

            if (!block(reportedPost.getPost().getPost_ID()))
                return false;

            Employee censor = this.employeeRepo.findOne(1);
            reportedPost.setCensor(censor);
            reportedPost.setStatus(true);
            this.reportedPostRepo.save(reportedPost);

            return true;

        } catch (Exception e) {
        }

        return false;
    }

    @Override
    public boolean deleteReport(int report_id) {
        try {
            ReportedPost reportedPost = this.reportedPostRepo.findOne(report_id);

            Employee censor = this.employeeRepo.findOne(1);
            reportedPost.setCensor(censor);
            reportedPost.setStatus(true);
            this.reportedPostRepo.save(reportedPost);

            return true;

        } catch (Exception e) {
        }

        return false;
    }
}
