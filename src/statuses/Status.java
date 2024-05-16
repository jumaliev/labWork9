package statuses;

import exceptions.TaskStatusException;
import model.Task;

public interface Status {
    void in_progress(Task task) throws TaskStatusException;
    void done(Task task) throws TaskStatusException;
    void editDescription(Task task, String description) throws TaskStatusException;

    void removeTask(Task task) throws TaskStatusException;
}
