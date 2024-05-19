package utils;

import com.google.gson.*;
import model.Task;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

public class Util {

    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).setPrettyPrinting()
            .create();
    private static final String PATH_STR = "src/data/tasks.json";

    public void writeFile(List<Task> tasks){
        try (FileWriter writer = new FileWriter(PATH_STR)) {
            GSON.toJson(tasks, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Task> readFile(){
        try (FileReader reader = new FileReader(PATH_STR)) {
            Type taskListType = new com.google.gson.reflect.TypeToken<List<Task>>() {
            }.getType();
            return GSON.fromJson(reader, taskListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    private static class LocalDateAdapter implements JsonDeserializer<LocalDate>, JsonSerializer<LocalDate> {

        @Override
        public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
            return LocalDate.parse(json.getAsString());
        }

        @Override
        public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.toString());
        }
    }

}
