package model;

import data.Priority;
import exceptions.TaskStatusException;
import statuses.Status;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {
    private final String title;
    private String description;
    private String completionDate;
    private String createdDate;
    private Priority priority;
    private Status status;
    private transient boolean expired;
    public static final DateTimeFormatter TO = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public Task(String title, String completionDate, Priority priority) {
        this.title = title;
        this.completionDate = completionDate;
        this.createdDate = LocalDate.now().format(TO);
        this.priority = priority;
        this.expired = false;
    }

    public Task(String title, String description, String completionDate, Priority priority) {
        this.title = title;
        this.description = description;
        this.completionDate = completionDate;
        this.createdDate = LocalDate.now().format(TO);
        this.priority = priority;
        this.expired = false;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void inProgress() {
        try {
            status.in_progress(this);
        } catch (TaskStatusException e) {
            System.out.println(e.getMessage());
        }
    }
    public void editDescription(String description) throws TaskStatusException {
        status.editDescription(this, description);

    }
    public void done() {
        try {
            status.done(this);
        } catch (TaskStatusException e) {
            System.out.println(e.getMessage());

        }
    }
    public void removeTask() {

    }
    public void addTask(Task task) {

    }

    @Override
    public String toString() {
        return "\nЗадача: " +
                "\nНазвание: " + title +
                "\nОписание: " + description +
                "\nДата завершения: " + completionDate +
                "\nДата создания: " + createdDate +
                "\nПриоритет: " + priority +
                "\nСтатус: " + status;
    }
}
