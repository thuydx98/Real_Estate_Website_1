package com.res.repositories;

import com.res.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//   @Query("SELECT e FROM Customer e WHERE e.fullname like %:name%")
//   List<Customer> findByName(String name);
}
