package com.project.EmployeeDirectory.service;

import com.project.EmployeeDirectory.dao.WorkerRepo;
import com.project.EmployeeDirectory.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//middleman between DAO interface and Rest Controller;

@Service //
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepo workerRepo;

    @Autowired // spring inject worker DAO using AUTOWIRED
    public WorkerServiceImpl(WorkerRepo repo) {
        workerRepo = repo;
    }

    @Override
    public List<Worker> findAll() {
        return workerRepo.findAll();
    }

    @Override
    public Worker save(Worker worker){
      return workerRepo.save(worker);
    };

    @Override
    public Worker findById(int id) {
        Optional<Worker> result = workerRepo.findById(id);

        Worker record =  null;

        if(result.isPresent()) {
            record = result.get();
        } else {
            throw new RuntimeException("No Employee Found: (" + id + ")");
        }

        return record;
    }

    @Override
    public void deleteById(int id) {
        workerRepo.deleteById(id);
    }

    @Override
    public Worker update(Worker worker){
        return workerRepo.save(worker);
    }

}
