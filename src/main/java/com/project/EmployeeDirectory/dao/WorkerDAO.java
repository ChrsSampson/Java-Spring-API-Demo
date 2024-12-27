package com.project.EmployeeDirectory.dao;

import com.project.EmployeeDirectory.entity.Worker;

import java.util.List;

//define all the methods on the worker model
public interface WorkerDAO {
//    public void save(Worker worker);
    public List<Worker> findAll();
    public Worker save(Worker worker);
    public Worker findById(int id);
    public void deleteById(int id);
    public Worker update(Worker worker);
}
