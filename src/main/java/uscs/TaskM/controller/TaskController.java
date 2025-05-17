package uscs.TaskM.controller;

import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import uscs.TaskM.model.THistory;
import uscs.TaskM.model.Task;
import uscs.TaskM.repository.THistoryRepository;
import uscs.TaskM.repository.TaskRepository;
import uscs.TaskM.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private THistoryRepository historyRepository;

    @Autowired
    private TaskService service;

    @PostMapping
    public Task create(@RequestBody Task task) {
        return service.create(task);
    }

    @GetMapping
    public List<Task> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable String id) {
        return service.findById(id).orElse(null);
    }

    @GetMapping("/project/{projectId}")
    public List<Task> getByProject(@PathVariable String projectId) {
        return service.findByProjectId(projectId);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable String id, @RequestBody Task task) {
        return service.update(id, task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Task> updateStatus(@PathVariable String id, @RequestBody Map<String, String> body) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            String newStatus = body.get("status");
            String oldStatus = task.getStatus();

            task.setStatus(newStatus);
            task.setUpdatedAt(LocalDateTime.now());

            Task updatedTask = taskRepository.save(task);

            THistory history = new THistory();
            history.setTaskId(task.getId());
            history.setOldStatus(oldStatus);
            history.setNewStatus(newStatus);
            history.setChangedAt(LocalDateTime.now());
            historyRepository.save(history);

            return ResponseEntity.ok(updatedTask);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}