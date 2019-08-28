package com.res.controllers;

import com.res.models.Post;
import com.res.models.ReportedPost;
import com.res.services.NotificationService;
import com.res.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private NotificationService notifyService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String index(Model model) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        List<Post> lstPost = this.postService.findAll().stream().filter(p -> Objects.equals(formatter.format(p.getPostTime()), formatter.format(new Date()))).collect(Collectors.toList());

        model.addAttribute("lstPost", lstPost);

        return "posts/index";
    }

    @RequestMapping(value = "/searchPosts", method = RequestMethod.GET)
    public String index(Model model, int typeOfPost, int typeOfRE, String dateInput) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date;

        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateInput);
        } catch (ParseException e) {
            return "/404";
        }

        List<Post> lstPost = null;

        if (typeOfPost == 0 && typeOfRE == 0) {
            lstPost = this.postService.findAll().stream().filter(p -> Objects.equals(formatter.format(p.getPostTime()), formatter.format(date))).collect(Collectors.toList());
        } else {
            if (typeOfPost == 0) {
                lstPost = this.postService.findAll().stream().filter(p -> Objects.equals(p.getRealEstaleType().getRealestate_ID(), typeOfRE) && Objects.equals(formatter.format(p.getPostTime()), formatter.format(date))).collect(Collectors.toList());
            } else {
                if (typeOfRE == 0) {
                    lstPost = this.postService.findAll().stream().filter(p -> Objects.equals(p.getPostType().getType_ID(), typeOfPost) && Objects.equals(formatter.format(p.getPostTime()), formatter.format(date))).collect(Collectors.toList());
                } else {
                    lstPost = this.postService.findAll().stream().filter(p -> Objects.equals(p.getPostType().getType_ID(), typeOfPost) && Objects.equals(p.getRealEstaleType().getRealestate_ID(), typeOfRE) && Objects.equals(formatter.format(p.getPostTime()), formatter.format(date))).collect(Collectors.toList());
                }
            }
        }

        model.addAttribute("lstPost", lstPost);
        model.addAttribute("typeOfPost", typeOfPost);
        model.addAttribute("typeOfRE", typeOfRE);
        model.addAttribute("date", dateInput);

        return "posts/index";
    }

    @RequestMapping(value = "/posts/pending", method = RequestMethod.GET)
    public String pending(Model model) {
        List<Post> lstPending = this.postService.pendingPosts();

        model.addAttribute("lstPending", lstPending);

        return "posts/PendingPost";
    }

    @RequestMapping(value = "/posts/reported", method = RequestMethod.GET)
    public String reported(Model model) {
        List<ReportedPost> lstReported = this.postService.reportedPosts();

        model.addAttribute("lstReported", lstReported);

        return "posts/ReportPost";
    }

    @RequestMapping(value = "/posts/approve", method = RequestMethod.GET)
    @ResponseBody
    public String approve(int post_id) {
        try {
            if (this.postService.approve(post_id)) {
                return "1";
            }
        } catch (Exception e) {
        }

        return "0";
    }

    @RequestMapping(value = "/posts/block", method = RequestMethod.GET)
    @ResponseBody
    public String block(int post_id) {
        try {
            if (this.postService.block(post_id)) {
                return "1";
            }
        } catch (Exception e) {
        }

        return "0";
    }

    @RequestMapping(value = "/posts/approveReport", method = RequestMethod.GET)
    @ResponseBody
    public String approveReport(int report_id) {
        try {
            if (this.postService.approveReport(report_id)) {
                return "1";
            }
        } catch (Exception e) {
        }

        return "0";
    }

    @RequestMapping(value = "/posts/deleteReport", method = RequestMethod.GET)
    @ResponseBody
    public String deleteReport(int report_id) {
        try {
            if (this.postService.deleteReport(report_id)) {
                return "1";
            }
        } catch (Exception e) {
        }

        return "0";
    }
}
