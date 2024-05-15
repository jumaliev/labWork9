package model;

import data.Priority;
import exceptions.TaskStatusException;
import statuses.Done;
import statuses.Status;

import javax.xml.transform.TransformerConfigurationException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {
    private final String title;
    private String description;
    private LocalDate completionDate;
    private LocalDate createdDate;
    private Priority priority;
    private Status status;
    private transient boolean expired;
    DateTimeFormatter to = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public Task(String title, LocalDate completionDate, Priority priority) {
        this.title = title;
        this.completionDate = completionDate;
        this.createdDate = LocalDate.now();
        this.priority = priority;
        this.expired = false;
    }

    public Task(String title, String description, LocalDate completionDate, LocalDate createdDate, Priority priority) {
        this.title = title;
        this.description = description;
        this.completionDate = completionDate;
        this.createdDate = createdDate;
        this.priority = priority;
        this.expired = false;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void inProgress() {
        try {
            status.in_progress(this);
        } catch (TaskStatusException e) {
            System.out.println(e.getMessage());
        }
    }
    public void editDescription() {
        try {
            status.editDescription(this);
        } catch (TaskStatusException e) {
            System.out.println(e.getMessage());
        }

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

    @Override
    public String toString() {
        return "\nЗадача: " +
                "\nНазвание: " + title +
                "\nОписание: " + description +
                "\nДата завершения: " + completionDate.format(to) +
                "\nДата создания: " + createdDate.format(to) +
                "\nПриоритет: " + priority +
                "\nСтатус: " + status;
    }
}
