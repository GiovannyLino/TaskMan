package uscs.TaskM.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class User{
    @Id
    private String id;
    private String name;
    private String email;
}

