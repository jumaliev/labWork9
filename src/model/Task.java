package model;

import com.google.gson.JsonElement;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import data.Priority;
import exceptions.TaskStatusException;
import statuses.New;
import statuses.Status;
import utils.Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Task {
    private String title;
    private String description;
    private LocalDate completionDate;
    private LocalDate createdDate;
    private Priority priority;
    private transient Status status;
    private String statusStr;
    public static final DateTimeFormatter TO = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public Task() {
    }

    public Task(String title, LocalDate completionDate, Priority priority) {
        this.title = title;
        this.description = "Без описания";
        this.completionDate = completionDate;
        this.createdDate = LocalDate.now();
        this.priority = priority;
        this.status = new New();
        this.statusStr = "New";
    }

    public Task(String title, LocalDate completionDate, Priority priority, Status status) {
        this.title = title;
        this.description = "Без описания";
        this.completionDate = completionDate;
        this.createdDate = LocalDate.now();
        this.priority = priority;
        this.status = status;
        this.statusStr = "New";
    }

    public LocalDate getCompletionDate() {
        return completionDate;
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

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }
    public void inProgress() {
        try {
            status.in_progress(this);
        } catch (TaskStatusException e) {
            System.out.println(e.getMessage());
        }
    }
    public void editDescription(Task task,String description) throws TaskStatusException {
        status.editDescription(task ,description);

    }
    public void done(Task task) {
        try {
            status.done(task);
        } catch (TaskStatusException e) {
            System.out.println(e.getMessage());

        }
    }
    public void remove() {
        try {
            status.removeTask();
        } catch (TaskStatusException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String toString() {
        return "\nНазвание: " + title +
                "\nОписание: " + description +
                "\nДата завершения: " + completionDate.format(TO) +
                "\nДата создания: " + createdDate.format(TO) +
                "\nПриоритет: " + priority +
                "\nСтатус: " + statusStr + "\n===========================================\n";
    }

}
