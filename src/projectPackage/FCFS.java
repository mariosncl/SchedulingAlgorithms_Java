/**
 * @file FCFS.java
 * @brief This file contains the implementation of the First-Come-First-Served (FCFS) scheduling algorithm
 */
package projectPackage;
import java.util.List;
/**
 * @class FCFS
 * @brief Implementation of the First-Come, First-Served (FCFS) scheduling algorithm
 */
public class FCFS implements Algorithm {

    private List<Task> tasks;

    //object of type class CPU
    private CPU myCPU = new CPU();

    /**
     * @brief Constructor for FCFS algorithm
     * @param tasks List of tasks to be scheduled
     */
    public FCFS(List<Task> tasks) {
        // Assert that the tasks list is not null
        assert tasks != null : "Tasks list cannot be null";

        this.tasks = tasks;
    }

    /**
     * @brief Schedule method to execute the FCFS algorithm
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
     * @brief pick the next task to be scheduled according to FCFS
     * @return task object representing the next task to be scheduled
     */
    @Override
    public Task pickNextTask() {
        return tasks.isEmpty() ? null : tasks.remove(0);
    }
}