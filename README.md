CPU Scheduling Algorithms

This project implements several CPU scheduling algorithms in Java. The scheduler is capable of handling a predefined set of tasks and scheduling them based on the selected algorithm. The implemented scheduling algorithms include:

    First-come, first-served (FCFS)
    Shortest-job-first (SJF)
    Priority scheduling
    Round-robin (RR) scheduling
    Priority with round-robin scheduling
    Run the Driver class with the desired scheduling algorithm and input file. The command syntax is as follows:

How to Run
Run the Driver class with the desired scheduling algorithm and input file. The command syntax is as follows:
java projectPackage.Driver <scheduling_algorithm> <input_file>
Replace <scheduling_algorithm> with one of the following: fcfs, sjf, priority, rr, priority_rr. Replace <input_file> with the path to the input file containing task details.

Input Format

The input file should contain task details in the following format:

TaskName, Priority, CPU_Burst

For example:

T1, 4, 20
T2, 2, 25
T3, 3, 25
T4, 3, 15
T5, 10, 10

Dependencies

The project does not have any external dependencies. It uses only standard Java libraries.

Contributors

    Marios Nikolaou
