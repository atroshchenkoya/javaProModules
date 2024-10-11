package ru.otus.multiT;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;

public class CustomThreadPoolExecutor implements Executor {

    private final List<Runnable> taskList = new LinkedList<>();
    private volatile boolean isRunning = true;
    private final Object monitor = new Object();

    @Override
    public void execute(Runnable command) {
        if (isRunning) {
            synchronized (monitor) {
                taskList.add(command);
            }
        } else {
            throw new IllegalStateException("Executor is not running");
        }
    }

    public void shutdown() {
        isRunning = false;
    }

    public CustomThreadPoolExecutor(int threadCount) {
        for (int i = 0; i < threadCount; i++) {
            new Thread(new TaskWorker()).start();
        }
    }

    private final class TaskWorker implements Runnable {

        @Override
        public void run() {
            while (isRunning) {
                Runnable nextTask;
                synchronized (monitor) {
                    if (taskList.isEmpty()) {
                        continue;
                    }
                    nextTask = taskList.get(0);
                    taskList.remove(0);
                }
                if (nextTask != null) {
                    nextTask.run();
                }
            }
        }
    }
}
