package statuses;

import exceptions.TaskStatusException;
import model.Task;

public class New implements Status{
    @Override
    public void in_progress(Task task) {
        task.setStatus(new InProgress());
        System.out.println("Статус задачи изменен на \"InProgress\"!");
    }


    @Override
    public void done(Task task) throws TaskStatusException {
        throw new TaskStatusException("Нельзя сменить статут на \"Done\"!");
    }

    @Override
    public void editDescription(Task task, String description) {
        task.setDescription(description);
    }

    @Override
    public void removeTask(Task task) throws TaskStatusException {

    }

}
