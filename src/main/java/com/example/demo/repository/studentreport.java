package com.example.demo.repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface studentreport extends JpaRepository<student,Integer>{

}

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.student;

@Repository
public interface studentreport extends JpaRepository<student, Integer> {

}
