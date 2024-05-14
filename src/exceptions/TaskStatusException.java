package exceptions;

public class TaskStatusException extends Exception {
    public TaskStatusException(){}
    public TaskStatusException(String massage) {
        super(massage);
    }
}
