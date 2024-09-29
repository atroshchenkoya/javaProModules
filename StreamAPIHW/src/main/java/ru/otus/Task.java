package ru.otus;

import lombok.*;

@Data
@AllArgsConstructor
public class Task {
    private Long id;
    private TaskStatus taskStatus;
    private String name;

}
