package ru.otus;

import java.util.Comparator;
import java.util.List;

public class Main {
    List<Task> taskList = List.of(
            new Task(1L, TaskStatus.NEW, "купить булку"),
            new Task(2L, TaskStatus.DONE, "отжаться 10 раз"),
            new Task(3L, TaskStatus.IN_PROGRESS, "похлопать в ладоши"),
            new Task(4L, TaskStatus.IN_PROGRESS, "сделать сальто"),
            new Task(5L, TaskStatus.DONE, "пошутить"),
            new Task(6L, TaskStatus.NEW, "посмотреть кино"),
            new Task(7L, TaskStatus.IN_PROGRESS, "написать поэму")
    );

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.getTask(TaskStatus.DONE));
        System.out.println("---------------------------------");
        System.out.println(m.checkTaskExists(8L));
        System.out.println(m.checkTaskExists(3L));
        System.out.println("---------------------------------");
        System.out.println(m.sortedByStatus());
        System.out.println("---------------------------------");
        System.out.println(m.taskCount(TaskStatus.DONE));

    }
    public List<Task> getTask(TaskStatus taskStatus) {
        return taskList.stream().filter(x -> x.getTaskStatus().equals(taskStatus)).toList();
    }
    public boolean checkTaskExists(long id) {
        return taskList.stream().anyMatch(x -> x.getId() == id);
    }
    public List<Task> sortedByStatus() {
        return taskList.stream().sorted(Comparator.comparing(Task::getTaskStatus)).toList();
    }
    public long taskCount(TaskStatus taskStatus) {
        return taskList.stream().filter(x -> x.getTaskStatus().equals(taskStatus)).count();
    }
}