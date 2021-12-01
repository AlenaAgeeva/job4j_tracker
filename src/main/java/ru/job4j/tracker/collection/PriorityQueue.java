package ru.job4j.tracker.collection;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int index = 0;
        for (Task element : tasks) {
            if (task.getPriority() < element.getPriority()) {
                break;
            }
            index++;
        }
        tasks.add(index, task);

    }

    public Task take() {
        return tasks.poll();
    }

    public LinkedList<Task> getTasks() {
        return this.tasks;
    }
}
