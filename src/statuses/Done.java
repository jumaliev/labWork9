package statuses;

import exceptions.TaskStatusException;
import model.Task;

public class Done implements Status{
    @Override
    public void in_progress(Task task) throws TaskStatusException {

    }

    @Override
    public void New(Task task) throws TaskStatusException {

    }

    @Override
    public void done(Task task) throws TaskStatusException {

    }
}
