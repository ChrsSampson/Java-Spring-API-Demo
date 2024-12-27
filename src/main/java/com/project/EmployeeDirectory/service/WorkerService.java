package com.project.EmployeeDirectory.service;

import com.project.EmployeeDirectory.entity.Worker;

import java.util.List;

public interface WorkerService {
    List<Worker> findAll();

    Worker save(Worker worker);

    Worker findById(int id);

    void deleteById(int id);

    Worker update(Worker worker);
}
