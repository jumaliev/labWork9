package data;

public enum Priority {

    LOW(1),
    MEDIUM(2),
    HIGH(3);
    final int i;

    Priority(int i) {
        this.i = i;
    }
    public static Priority getInstance() {
        return LOW;
    }

    public int getI() {
        return i;
    }
}
