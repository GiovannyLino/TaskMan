package uscs.TaskM.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;


@Document(collection = "tasks")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Task {
    @Id
    private String id;
    private String title;
    private String description;
    private String projectId;

    @DBRef
    private List<User> assignedUserId;

    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
