package statuses;

import exceptions.TaskStatusException;
import model.Task;

public class New implements Status{
    @Override
    public void in_progress(Task task) {
        task.setStatus(new InProgress());
        task.setStatusStr("In progress");
        System.out.println("Статус задачи изменен на \"InProgress\"!");
    }


    @Override
    public void done(Task task) throws TaskStatusException {
        System.err.println("Нельзя сменить статут на \"Done\"!");
        throw new TaskStatusException();
    }

    @Override
    public void editDescription(Task task, String description) {
        System.out.println("ghcfxhtrxtchchtfchtxht-----------=============");
        task.setDescription(description);
    }

    @Override
    public void removeTask() {
        System.out.println("Задачка удалена");
    }

}
