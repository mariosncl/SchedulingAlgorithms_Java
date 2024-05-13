/**
 * @file Algorithm.java
 * @brief This file contains the interface for scheduling algorithms.
 */
package projectPackage;

/**
 * @interface Algorithm
 * @brief Interface for scheduling algorithms.
 */
public interface Algorithm {
    /**
     * * @brief Schedule method to execute the scheduling algorithm.
     */
    void schedule();
    /**
     * @brief Pick the next task to be scheduled.
     * @return Task object representing the next task to be scheduled.
     */
    Task pickNextTask();
}