package uscs.TaskM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uscs.TaskM.model.THistory;
import uscs.TaskM.model.Task;
import uscs.TaskM.repository.THistoryRepository;
import uscs.TaskM.repository.TaskRepository;

import java.util.List;
import java.time.LocalDateTime;
import java.util.Optional;

@Service

public class TaskService {
    @Autowired

    private TaskRepository taskRepository;

    @Autowired

    private THistoryRepository tHistoryRepository;

    public Task create(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public List<Task> findByProjectId(String projectId) {
        return taskRepository.findByProjectId(projectId);
    }

    public Optional<Task> findById(String id) {
        return taskRepository.findById(id);
    }

    public Task update(String id, Task updatedTask) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task existingTask = optionalTask.get();

            if (!existingTask.getStatus().equals(updatedTask.getStatus())) {
                THistory history = new THistory();

                history.setTaskId(id);
                history.setOldStatus(existingTask.getStatus());
                history.setNewStatus(updatedTask.getStatus());
                history.setChangedAt(LocalDateTime.now());
                tHistoryRepository.save(history);
            }

            updatedTask.setId(id);
            updatedTask.setCreatedAt(existingTask.getCreatedAt());
            return taskRepository.save(updatedTask);

        } else {
            return null;
        }
    }

    public void delete(String id){
        taskRepository.deleteById(id);
    }

    public Task updateStatus(String taskId, String newStatus){
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        task.setStatus(newStatus);
        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }
}