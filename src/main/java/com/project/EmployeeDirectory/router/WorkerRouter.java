package com.project.EmployeeDirectory.router;

import com.project.EmployeeDirectory.entity.Worker;
import com.project.EmployeeDirectory.service.WorkerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workers")
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

////    create a new worker
//    @PostMapping(value = "/", consumes = "APPLICATION_JSON_VALUE")
//    public String createRoute(HttpEntity<String> req) {
//        String json = req.getBody();
//
//        Worker worker = new Worker();
//        return "maybe";
//    }

    @GetMapping(value = "/")
    public List<Worker> getAllRouter() {
        return workerService.findAll();
    }

    @GetMapping(value="/{idParam}")
    public Worker getOne(@PathVariable(value="idParam") int id) {
        return workerService.findById(id);
    }

    @DeleteMapping(value="/{idParam}")
    public String deleteOne(@PathVariable(value="idParam") int id) {
        workerService.deleteById(id);
        return "Deleted: " + id;
    }

}
