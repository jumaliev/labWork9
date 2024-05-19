package statuses;

import exceptions.TaskStatusException;
import model.Task;

public class Done implements Status{
    private String name;
    public Done() {
        this.name = "Done";
    }
    @Override
    public void in_progress(Task task) throws TaskStatusException {
        System.err.println("Нельзя изменить статус на \"InProgress\"");
    }

    @Override
    public void done(Task task) throws TaskStatusException {
        System.err.println("Нельзя изменить статус на \"Done\"");
    }

    @Override
    public void editDescription(Task task, String description) throws TaskStatusException {
        System.err.println("Нельзя изменять описание задачи!");
    }

    @Override
    public void removeTask() throws TaskStatusException {
        System.err.println("Нельзя удалить задачу!");
    }

    @Override
    public String toString() {
        return name;
    }
}







