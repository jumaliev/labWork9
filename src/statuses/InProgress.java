package statuses;

import exceptions.TaskStatusException;
import model.Task;

public class InProgress implements Status{
    @Override
    public void in_progress(Task task){
        System.err.println("Нельзя сменить статус на \"InProgress\"!");
    }

    @Override
    public void done(Task task) {
        task.setStatus(new Done());
        task.setStatusStr("Done");
        System.out.println("Статус успешно изменен на \"Done\"");
    }

    @Override
    public void editDescription(Task task, String description) throws TaskStatusException {
        System.err.println("Нельзя менять описание задачи!");
    }
    @Override
    public void removeTask() throws TaskStatusException {
        System.err.println("Нельзя удалить задачу!");
    }
}
