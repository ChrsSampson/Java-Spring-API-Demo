package com.project.EmployeeDirectory.router;

import com.project.EmployeeDirectory.entity.Worker;
import com.project.EmployeeDirectory.service.WorkerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
//Important this needs to be a capital class name
public class WorkerRouter {

    private final WorkerService workerService;

    public WorkerRouter(WorkerService service){
        workerService = service;
    }

//    handle incoming request to /api/workers/test
    @GetMapping("/test")
    public String testRoute() {
        return "this is a test worker";
    }

    @GetMapping(value = "/workers")
    public List<Worker> getAllRouter() {
        return workerService.findAll();
    }

    @GetMapping(value="/workers/{idParam}")
    public Worker getOne(@PathVariable(value="idParam") int id) {
        return workerService.findById(id);
    }

    @DeleteMapping(value="/workers/{idParam}")
    public String deleteOne(@PathVariable(value="idParam") int id) {
        workerService.deleteById(id);
        return "Deleted: " + id;
    }

    @PostMapping("/workers")
    public Worker createRoute(@RequestBody Worker workerData) {
//      init the id to 0 - this forces the save of a new item rather than an update
        workerData.setId(0);

//      make or update operation
        return workerService.save(workerData);
    }

    @PutMapping("/workers")
    public Worker updateRoute(@RequestBody Worker workerData){
        return workerService.save(workerData);
    }

}
