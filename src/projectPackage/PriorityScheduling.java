/**
 * @file PriorityScheduling.java
 * @brief This file contains the implementation of the Priority Scheduling algorithm.
 */
package projectPackage;

import java.util.List;
import java.util.Collections;

/**
 * @class PriorityScheduling
 * @brief Implementation of the Priority Scheduling algorithm.
 */
public class PriorityScheduling implements Algorithm {
    private List<Task> tasks;
    //object of type class CPU
    private CPU myCPU = new CPU();
    /**
     * @brief Constructor for PriorityScheduling algorithm.
     * @param tasks List of tasks to be scheduled.
     */
    public PriorityScheduling(List<Task> tasks) {
        // Assert that the tasks list is not null
        assert tasks != null : "Tasks list cannot be null";

        this.tasks = tasks;
    }

    /**
     * @brief schedule method to execute the Priority Scheduling algorithm.
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
     * @brief pick the next task to be scheduled according to Priority Scheduling.
     * @return task object representing the next task to be scheduled.
     */
    @Override
    public Task pickNextTask() {
        if (tasks.isEmpty()) {
            return null;
        }
        // Sort tasks by priority in descending order
        Collections.sort(tasks, (t1, t2) -> t2.getPriority() - t1.getPriority());
        return tasks.remove(0);
    }
}