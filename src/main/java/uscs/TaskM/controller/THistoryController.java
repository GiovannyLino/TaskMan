package uscs.TaskM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import uscs.TaskM.model.THistory;
import uscs.TaskM.repository.THistoryRepository;
import uscs.TaskM.service.THistoryService;

import java.util.List;

@RestController
@RequestMapping("/api/history")
@CrossOrigin(origins = "*")

public class THistoryController{
    @Autowired

    private THistoryRepository historyRepository;

    @GetMapping("/task/{taskId}")
    public List <THistory> getHistoryByTaskId(@PathVariable String taskId){
        return historyRepository.findByTaskId(taskId);
    }

}
