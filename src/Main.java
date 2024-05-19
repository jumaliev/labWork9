import exceptions.TaskStatusException;

import java.time.format.DateTimeFormatter;

public class Main {
    public static final DateTimeFormatter TO = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static void main(String[] args) throws TaskStatusException {
        TaskManager app = new TaskManager();
        app.app();
    }
}
