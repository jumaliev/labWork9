import data.Priority;
import exceptions.TaskStatusException;
import model.Task;
import statuses.Done;
import statuses.InProgress;
import statuses.New;
import utils.Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TaskManager {
    protected Scanner sc = new Scanner(System.in);
    List<Task> tasks;
    public final DateTimeFormatter TO = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final Util UTIL = new Util();

    public TaskManager() {
        this.tasks = new ArrayList<>();
        Task task1 = new Task("Сдать дз", LocalDate.now().plusDays(2), Priority.HIGH);
        Task task2 = new Task("Написать весь код", LocalDate.now().plusDays(1), Priority.MEDIUM);
        tasks.add(task1);
        tasks.add(task2);
    }

    public void app() throws TaskStatusException {
        while (true) {
            readFile();
            actions(userInteraction());
            UTIL.writeFile(tasks);
        }

    }

    public Task userInteraction() throws TaskStatusException {
        while (true) {
            if (tasks.isEmpty()) {
                addTask();
            }
            readFile();
            printTasks();
            print("Выберите порядковый номер задачки, которую хотите изменить: ");
            String userTaskChoice = sc.nextLine();
            if (userTaskChoice.matches("[1-9]")) {
                int userTaskChoiceInt = Integer.parseInt(userTaskChoice);

                if (userTaskChoiceInt <= tasks.size()) {
                    System.out.println(tasks.get(userTaskChoiceInt - 1));
                    return tasks.get(userTaskChoiceInt - 1);
                } else {
                    print("Введен неправильный номер, попробуйте еще раз!\n");
                }
            } else {
                print("Введен неправильный номер, попробуйте еще раз!\n");
            }
        }
    }

    public void sortTasksByPriority() {
        tasks.sort(Comparator.comparing(Task::getPriority));
    }

    public void printTasks() {
        readFile();
        int i = 1;
        for (Task t : tasks) {
            print("Задача номер " + i + t);
            i++;
        }
    }

    public void addTask() {
        print("Введите название новой задачи: ");
        String taskName = sc.nextLine();
        print("""
                Выберите приоритет новой задачи: \s
                1) LOW
                2) MEDIUM
                3) HIGH
                Поле для ввода: (1, 2 или 3)\s""");
        Priority priority = null;
        int priorityChoice = sc.nextInt();
        sc.nextLine();
        switch (priorityChoice) {
            case 1:
                priority = Priority.LOW;
                break;
            case 2:
                priority = Priority.MEDIUM;
                break;
            case 3:
                priority = Priority.HIGH;
                break;
            default:
                print("Введено неправильное значение, попробуйте еще раз!");
                return;
        }
        while (true) {
            print("Введите дату завершения задачи в формате dd.MM.yyyy: ");
            String userDate = sc.nextLine();
            try {
                LocalDate userTaskDate = LocalDate.parse(userDate, TO);
                if (userTaskDate.isAfter(LocalDate.now())) {
                    Task task = new Task(taskName, userTaskDate, priority, new New());
                    tasks.add(task);
                    UTIL.writeFile(tasks);
                    break;
                }
            } catch (Exception e) {
                print("Неверный формат даты, попробуйте еще раз!");
            }
        }

    }

    public void editDescription(Task task) throws TaskStatusException {
        print("Введите новое описание: ");
        String userDescription = sc.nextLine();
        task.editDescription(task, userDescription);
        UTIL.writeFile(tasks);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        UTIL.writeFile(tasks);
        print("Задачка удалена");
    }

    private void print(String str) {
        System.out.print("\n" + str);
    }

    private Task actions(Task task) throws TaskStatusException {
        while (true) {
            print("""
                    Введите действие, которое хотите сделать с задачей:
                    1) Вывести на экран все задачи
                    2) Добавить новую задачу
                    3) Изменить описание задачи
                    4) Пометить как (“New”, “In progress”, “Done”)
                    5) Удалить задачу
                    Поле для ввода: \s
                    """);
            String userActionStr = sc.nextLine();
            if (userActionStr.matches("[1-5]")) {
                readFile();
                int userAction = Integer.parseInt(userActionStr);
                switch (userAction) {
                    case 1:
                        readFile();
                        printTasks();
                        break;
                    case 2:
                        readFile();
                        addTask();
                        UTIL.writeFile(tasks);
                        System.out.println(task);
                        break;
                    case 3:
                        readFile();
                        editDescription(task);
                        UTIL.writeFile(tasks);
                        System.out.println(task);
                        break;
                    case 4:
                        editStatus(task);
                        UTIL.writeFile(tasks);
                        System.out.println(task);
                        break;
                    case 5:
                        if (task.getStatusStr().equals("New")) {
                            removeTask(task);
                            UTIL.writeFile(tasks);
                        } else {
                            print("Нельзя удалить задачу!\n");
                        }
                        UTIL.writeFile(tasks);
                        break;
                }
                UTIL.writeFile(tasks);
                break;
            } else {
                print("Введено неверное значение, попробуйте еще раз!\n");

            }
        }
        return new Task();
    }

    private void editStatus(Task task) {
        while (true) {
            print("""
                    Введите номер статуса, на который хотите поменять:
                    1) "New"
                    2) "In progress"
                    3) "Done"
                    """);
            String userStatusStr = sc.nextLine();
            if (userStatusStr.matches("[1-3]")) {
                int userStatus = Integer.parseInt(userStatusStr);
                switch (userStatus) {
                    case 1:
                        print("Нельзя сменить статус на 'New'\n");
                        break;
                    case 2:
                        task.inProgress();
                        UTIL.writeFile(tasks);
                        break;
                    case 3:
                        task.done(task);
                        UTIL.writeFile(tasks);
                        break;
                }
                break;
            } else {
                print("Введено неверное значение, попробуйте еще раз!\n");
            }
        }
    }

    public void readFile() {
        tasks = UTIL.readFile();
        for (Task t : tasks) {
            if (t.getStatusStr().equals("New")) {
                t.setStatus(new New());
            } else if (t.getStatusStr().equals("In progress")) {
                t.setStatus(new InProgress());
            } else {
                t.setStatus(new Done());
            }
        }
    }
}
