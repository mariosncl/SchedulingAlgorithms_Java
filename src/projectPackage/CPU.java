/**
 * @file CPU.java
 * @brief This file contains the CPU class responsible for running tasks
 */
package projectPackage;
/**
 * @class CPU
 * @brief Class responsible for running tasks on the CPU
 */
public class CPU {

    /**
     * @brief run method to simulate CPU execution of a task
     * @param task Task to be executed on the CPU
     */
    public static void run(Task task) {
        //assert that the task is not null
        assert task != null : "Task cannot be null";

        //display task being run
        System.out.println("Running task: " + task.getName());

        //simulate CPU execution time
        try {
            Thread.sleep(task.getCpuBurst());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}