/**
 * @file Driver.java
 * @brief This file contains the main class for running the scheduling algorithm.
 */
package projectPackage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * @class Driver
 * @brief Main class for running the scheduling algorithm.
 */
public class Driver {

    /**
     * @brief Main method for executing the scheduling algorithm.
     * @param args Command-line arguments: scheduling algorithm and input file.
     */
    public static void main(String[] args) {
        //ensure correct number of arguments are provided
        assert args.length == 2 : "Usage: java Driver <scheduling_algorithm> <input_file>";

        //extract the scheduling algorithm and input file from command-line arguments
        String algorithmName = args[0];
        String inputFile = args[1];

        //read tasks from the input file
        List<Task> tasks = readTasksFromFile(inputFile);

        //create scheduler based on the selected algorithm
        Algorithm scheduler = createScheduler(algorithmName, tasks);
        assert scheduler != null : "Invalid scheduling algorithm specified.";

        //execute the scheduling algorithm
        scheduler.schedule();
    }

    /**
     * @brief Read tasks from the input file.
     * @param inputFile Name of the input file containing task information.
     * @return List of tasks read from the input file.
     */
    private static List<Task> readTasksFromFile(String inputFile) {
        List<Task> tasks = new ArrayList<>();
        try (InputStream inputStream = Driver.class.getClassLoader().getResourceAsStream("projectPackage/" + inputFile);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            //read each line from the input file
            while ((line = br.readLine()) != null) {
                //split the line into task name, priority, and CPU burst
                String[] parts = line.split(",");
                assert parts.length == 3 : "Invalid input file format.";
                String name = parts[0].trim();
                int priority = Integer.parseInt(parts[1].trim());
                int cpuBurst = Integer.parseInt(parts[2].trim());
                //create Task object and add it to the list
                tasks.add(new Task(name, priority, cpuBurst));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    /**
     * @brief create scheduler based on the selected algorithm, from the inputted  Driver.main() args
     * @param algorithmName Name of the scheduling algorithm
     * @param tasks List of tasks to be scheduled
     * @return scheduler object for the selected algorithm
     */
    private static Algorithm createScheduler(String algorithmName, List<Task> tasks) {
        switch (algorithmName) {
            case "fcfs":
                return new FCFS(tasks);
            case "sjf":
                return new SJF(tasks);
            case "priority":
                return new PriorityScheduling(tasks);
            case "rr":
                // Change quantum value as needed
                return new RoundRobin(tasks, 10);
            case "priority_rr":
                // Change quantum value as needed
                return new PriorityWithRoundRobin(tasks, 10);
            default:
                return null;
        }
    }
}

