package com.res.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reported_post")
public class ReportedPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int report_ID;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Post post;

    @Column(nullable = false, length = 200)
    private String reason;

    @Column(nullable = false, length = 200)
    private Date reportedTime = new Date();

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Customer reporter;

    @Column(nullable = false)
    private boolean status;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Employee censor;

    public int getReport_ID() {
        return report_ID;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getReportedTime() {
        return reportedTime;
    }

    public void setReportedTime(Date reportedTime) {
        this.reportedTime = reportedTime;
    }

    public Customer getReporter() {
        return reporter;
    }

    public void setReporter(Customer reporter) {
        this.reporter = reporter;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Employee getCensor() {
        return censor;
    }

    public void setCensor(Employee censor) {
        this.censor = censor;
    }


    public ReportedPost() {
    }
}
