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
        Task task = new Task("написать код", localDate.format(TO) , Priority.HIGH);
        Task task1 = new Task("dewf", "25.05.2025", Priority.LOW);
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        Util.writeFile(tasks);
        tasks.add(task1);
        System.out.println(task1);
        Util.writeFile(tasks);
        System.out.println(Util.readFile());

    }
}
