import data.Priority;
import model.Task;
import utils.Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final DateTimeFormatter TO = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.parse("25.05.2024", TO);
        Task task = new Task("написать код", localDate , Priority.HIGH);
        System.out.println(task);
        LocalDate.now().format(TO);
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        Util.writeFile(taskList);
        System.out.println(Util.readFile());
        ;

    }
}
