package model;

import data.Priority;
import statuses.Status;

import java.time.LocalDate;

public class Task {
    private final String title;
    private String description;
    private LocalDate completionDate;
    private LocalDate createdDate;
    private Priority priority;
    private Status status;

    public Task(String title, LocalDate completionDate, Priority priority) {
        this.title = title;
        this.completionDate = completionDate;
        this.priority = priority;
    }

    public Task(String title, String description, LocalDate completionDate, LocalDate createdDate, Priority priority) {
        this.title = title;
        this.description = description;
        this.completionDate = completionDate;
        this.createdDate = createdDate;
        this.priority = priority;
    }

}
