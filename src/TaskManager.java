import exceptions.TaskStatusException;
import model.Task;
import utils.Util;

import java.util.*;

public class TaskManager {
    protected Scanner sc = new Scanner(System.in);
    List<Task> tasks;
    public TaskManager() {
        this.tasks = new ArrayList<>();
    }
    public void userInteraction() {

    }

    public void sortTasksByPriority() {
        Collections.sort(tasks, Comparator.comparing(Task::getPriority));

    }
    public void printTasks(){
        System.out.println(tasks);
    }
    public void addTask(Task task) {
        tasks.add(task);
        Util.writeFile(tasks);
    }
    public void editDescription(Task task, String description) throws TaskStatusException {
        task.editDescription(description);
    }
    public void removeTask(Task task) {
        System.out.print("Введите номер задачи которую хотите удалить: ");
            try {
                int userChoiseIntForRemoveTask = sc.nextInt();
                tasks.remove(tasks.get(userChoiseIntForRemoveTask));
                Util.writeFile(tasks);
            } catch (InputMismatchException e) {
                System.out.println("Введено неверное значение! Попробуйте еще раз");
            }
    }

    public void editStatus(Task task) {
        Util.writeFile(tasks);
    }
}
