/**
 * @file Task.java
 * @brief This file contains the definition of the Task class representing a process/task.
 */
package projectPackage;

/**
 * @class Task
 * @brief Represents a process/task with a name, priority, and CPU burst time.
 */
public class Task {
    private String name;
    private int priority;
    private int cpuBurst;

    /**
     * @brief Constructor for Task class.
     * @param name Name of the task.
     * @param priority Priority of the task.
     * @param cpuBurst CPU burst time of the task.
     */
    public Task(String name, int priority, int cpuBurst) {
        // Assert that the name is not null or empty
        assert name != null && !name.isEmpty() : "Task name cannot be null or empty";
        // Assert that the priority is within valid range
        assert priority >= 1 && priority <= 10 : "Priority must be between 1 and 10";
        // Assert that the CPU burst is positive
        assert cpuBurst > 0 : "CPU burst must be positive";

        this.name = name;
        this.priority = priority;
        this.cpuBurst = cpuBurst;
    }

    /**
     * @brief Getter method for the name of the task.
     * @return String representing the name of the task.
     */
    public String getName() {
        return name;
    }

    /**
     * @brief Getter method for the priority of the task.
     * @return Integer representing the priority of the task.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @brief Getter method for the CPU burst time of the task.
     * @return Integer representing the CPU burst time of the task.
     */
    public int getCpuBurst() {
        return cpuBurst;
    }
}