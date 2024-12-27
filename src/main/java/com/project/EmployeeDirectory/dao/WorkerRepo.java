package com.project.EmployeeDirectory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.EmployeeDirectory.entity.Worker;

//use jpa repo in place of writing crud method my hand
public interface WorkerRepo extends JpaRepository<Worker, Integer> {
//    all crud methods are handled by Spring DATA JPA
}
