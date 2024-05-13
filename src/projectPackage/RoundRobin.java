/**
 * @file RoundRobin.java
 * @brief This file contains the implementation of the Round-Robin scheduling algorithm.
 */
package projectPackage;

import java.util.List;

/**
 * @class RoundRobin
 * @brief Implementation of the Round-Robin scheduling algorithm.
 */
public class RoundRobin implements Algorithm {
    private List<Task> tasks;
    private int quantum;
    //object of type class CPU
    private CPU myCPU = new CPU();
    /**
     * @brief Constructor for RoundRobin algorithm.
     * @param tasks List of tasks to be scheduled.
     * @param quantum Time quantum for round-robin scheduling.
     */
    public RoundRobin(List<Task> tasks, int quantum) {
        // Assert that the tasks list is not null
        assert tasks != null : "Tasks list cannot be null";
        // Assert that quantum is positive
        assert quantum > 0 : "Quantum must be positive";

        this.tasks = tasks;
        this.quantum = quantum;
    }

    /**
     * @brief Schedule method to execute the Round-Robin scheduling algorithm.
     */
    @Override
    public void schedule() {
        while (!tasks.isEmpty()) {
            Task nextTask = pickNextTask();
            // Assert that the nextTask is not null
            assert nextTask != null : "Next task cannot be null";

            myCPU.run(nextTask);
        }
    }

    /**
     * @brief Pick the next task to be scheduled according to Round-Robin.
     * @return Task object representing the next task to be scheduled.
     */
    @Override
    public Task pickNextTask() {
        if (tasks.isEmpty()) {
            return null;
        }
        Task nextTask = tasks.remove(0);
        // If the CPU burst of the next task is greater than the quantum, split the task
        if (nextTask.getCpuBurst() > quantum) {
            nextTask = new Task(nextTask.getName(), nextTask.getPriority(), nextTask.getCpuBurst() - quantum);
            tasks.add(nextTask);
        }
        return nextTask;
    }
}