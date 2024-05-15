package utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Util {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path PATH = Paths.get("src/data/tasks.json");
    public static List<Task> readFile() {
        List<Task> tasks = new ArrayList<>();
        try {
            String str = Files.readString(PATH);
            return List.of(GSON.fromJson(str, Task[].class));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return tasks;
        }
    }
    public static void writeFile(List<Task> trucks) {
        String newJson = GSON.toJson(trucks);
        byte[] bytes = newJson.getBytes();
        try {
            Files.write(PATH, bytes);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


}
