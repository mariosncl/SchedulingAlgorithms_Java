/**
 * @file SJF.java
 * @brief This file contains the implementation of the Shortest Job First (SJF) scheduling algorithm.
 */
package projectPackage;

import java.util.List;
import java.util.Collections;

/**
 * @class SJF
 * @brief Implementation of the Shortest Job First (SJF) scheduling algorithm.
 */
public class SJF implements Algorithm {
    private List<Task> tasks;
    //object of type class CPU
    private CPU myCPU = new CPU();
    /**
     * @brief Constructor for SJF algorithm.
     * @param tasks List of tasks to be scheduled.
     */
    public SJF(List<Task> tasks) {
        // Assert that the tasks list is not null
        assert tasks != null : "Tasks list cannot be null";

        this.tasks = tasks;
    }

    /**
     * @brief Schedule method to execute the SJF algorithm.
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
     * @brief Pick the next task to be scheduled according to SJF.
     * @return Task object representing the next task to be scheduled.
     */
    @Override
    public Task pickNextTask() {
        if (tasks.isEmpty()) {
            return null;
        }
        // Sort tasks by CPU burst in ascending order (shortest job first)
        Collections.sort(tasks, (t1, t2) -> t1.getCpuBurst() - t2.getCpuBurst());
        return tasks.remove(0);
    }
}