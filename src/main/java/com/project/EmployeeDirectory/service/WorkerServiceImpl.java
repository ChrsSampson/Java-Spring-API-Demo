package com.project.EmployeeDirectory.service;

import com.project.EmployeeDirectory.dao.WorkerDAO;
import com.project.EmployeeDirectory.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//middleman between DAO interface and Rest Controller;

@Service //
public class WorkerServiceImpl implements WorkerService {

    private final WorkerDAO workerDAO;

    @Autowired // spring inject worker DAO using AUTOWIRED
    public WorkerServiceImpl(WorkerDAO dao) {
        workerDAO = dao;
    }

    @Override
    public List<Worker> findAll() {
        return workerDAO.findAll();
    }

    @Override
    @Transactional
    public Worker save(Worker worker){
      return workerDAO.save(worker);
    };

    @Override
    public Worker findById(int id) {
        return workerDAO.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        workerDAO.deleteById(id);
    }

    @Override
    @Transactional
    public Worker update(Worker worker){
        return workerDAO.update(worker);
    }

}
