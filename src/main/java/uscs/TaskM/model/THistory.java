package uscs.TaskM.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "task_history")

public class THistory {
    @Id
    private String id;
    private String taskId;
    private String oldStatus;
    private String newStatus;
    private LocalDateTime changedAt;
}