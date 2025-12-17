package com.example.demo.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentreport extends JpaRepository<student,Integer>{

}