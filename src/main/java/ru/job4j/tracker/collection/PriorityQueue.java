package ru.job4j.tracker.collection;

import java.util.LinkedList;

/**
 * Класс описывает работу простейшей очереди по приоритету, которая работает
 * по принципу FIFO (first in - first out)
 *
 * @author Alena Ageeva
 * @version 1.0
 */
public class PriorityQueue {
    /**
     * Хранение задания осуществляется в коллекции типа LinkedList
     */
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод принимает на вход заявку и добавляет ее в очередь.
     * Если встречаются 2 задания с одинаковым приоритетом, то в очереди
     * они распределяются по принципу FIFO.
     *
     * @param task задача которая добавляется в очередь
     */
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

    /**
     * Метод позволяет получить первую задачу в очереди
     * @return возвращает задачу из головы очереди или null если очередь пуста
     */
    public Task take() {
        return tasks.poll();
    }

    /**
     * Метод(геттер) позволияет получить приватный список задач типа LinkedList
     * @return возвращает инициализированный список задач для данного объекта
     */
    public LinkedList<Task> getTasks() {
        return this.tasks;
    }
}
