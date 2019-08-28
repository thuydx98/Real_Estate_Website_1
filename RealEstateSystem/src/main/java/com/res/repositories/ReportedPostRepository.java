package com.res.repositories;

import com.res.models.ReportedPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportedPostRepository extends JpaRepository<ReportedPost, Integer> {
}
