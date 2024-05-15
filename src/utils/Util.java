package utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Task;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Util {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path PATH = Paths.get("src/data/tasks.json");
    private static final String FILENAME = "src/data/tasks.json";


    public static void writeFile(List<Task> tasks) {
        try (FileWriter writer = new FileWriter(FILENAME)) {
            GSON.toJson(tasks, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Task> readFile() {
        try (FileReader reader = new FileReader(FILENAME)) {
            return GSON.fromJson(reader, new TypeToken<List<Task>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
