package com.project.EmployeeDirectory.dao;

import com.project.EmployeeDirectory.entity.Worker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
//implements the methods defined in the DAO model
@Repository
public class WorkerImpl implements WorkerDAO {

    private EntityManager entityManager;

    @Autowired // auto-injects entity manager
    public WorkerImpl(EntityManager manager) {
        entityManager = manager;
    }

    @Override
    public List<Worker> findAll(){
//        make sure query is registered Entity ("Worker", not "workers") to object not table
        TypedQuery<Worker> query = entityManager.createQuery(
                "FROM Worker", Worker.class
        );
        return query.getResultList();
    }

    @Override
    public void save(Worker worker) {
//        update or save based on primary key
        Worker record = entityManager.merge(worker);
    }

    @Override
    public Worker findById(int id) {
//        entity manager find by primary id;
        return entityManager.find(Worker.class, id);
    }

    @Override
    public void deleteById(int id) {
//        find existing record
        Worker record = entityManager.find(Worker.class, id);

//        remove record
        entityManager.remove(record);
    }
}
