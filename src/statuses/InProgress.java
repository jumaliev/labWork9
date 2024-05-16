package statuses;

import exceptions.TaskStatusException;
import model.Task;

public class InProgress implements Status{
    @Override
    public void in_progress(Task task) throws TaskStatusException {
        throw new TaskStatusException("Нельзя сменить статус на \"InProgress\"!");
    }

    @Override
    public void done(Task task) {
        task.setStatus(new Done());
        System.out.println("Статус успешно изменен на \"Done\"");
    }

    @Override
    public void editDescription(Task task, String description) throws TaskStatusException {
        throw new TaskStatusException("Нельзя менять описание задачи!");
    }

    @Override
    public void removeTask(Task task) throws TaskStatusException {
        throw new TaskStatusException("Нельзя удалить задачу!");
    }
}
