package statuses;

import exceptions.TaskStatusException;
import model.Task;

public class Done implements Status{
    @Override
    public void in_progress(Task task) throws TaskStatusException {
        throw new TaskStatusException("Нельзя изменить статус на \"InProgress\"");
    }

    @Override
    public void done(Task task) throws TaskStatusException {
        throw new TaskStatusException("Нельзя изменить статус на \"Done\"");
    }

    @Override
    public void editDescription(Task task, String description) throws TaskStatusException {
        throw new TaskStatusException("Нельзя изменять описание задачи!");
    }

    @Override
    public void removeTask(Task task) throws TaskStatusException {
        throw new TaskStatusException("Нельзя удалить задачу!");
    }
}







