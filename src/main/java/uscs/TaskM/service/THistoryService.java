package uscs.TaskM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uscs.TaskM.model.THistory;
import uscs.TaskM.repository.THistoryRepository;

import java.util.List;

@Service

public class THistoryService{
    @Autowired

    private THistoryRepository historyRepository;
    public List<THistory> findByTaskId(String taskId){
        return historyRepository.findByTaskId(taskId);
    }
}