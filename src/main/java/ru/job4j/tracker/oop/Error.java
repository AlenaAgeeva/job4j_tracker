package ru.job4j.tracker.oop;

public class Error {
    public boolean active;
    public int status;
    public String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void console() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error error = new Error(true, 7, "123");
        error.console();
    }
}
