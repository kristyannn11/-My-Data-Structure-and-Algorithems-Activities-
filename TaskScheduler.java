import java.util.PriorityQueue;
import java.util.Scanner;

class Task implements Comparable<Task> {
    String name;
    int deadline;

    Task(String name, int deadline) {
        this.name = name;
        this.deadline = deadline;
    }

    @Override
    public int compareTo(Task other) {
        return this.deadline - other.deadline; // Sort by deadline (ascending)
    }

    @Override
    public String toString() {
        return "Task: " + name + ", Deadline: " + deadline;
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nTask Scheduler Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. View Next Task");
            System.out.println("3. Complete Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Task Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Deadline (YYYYMMDD): ");
                    int deadline = scanner.nextInt();
                    taskQueue.add(new Task(name, deadline));
                    System.out.println("Task added successfully!");
                    break;
                case 2:
                    if (!taskQueue.isEmpty()) {
                        System.out.println("Next Task: " + taskQueue.peek());
                    } else {
                        System.out.println("No tasks available.");
                    }
                    break;
                case 3:
                    if (!taskQueue.isEmpty()) {
                        System.out.println("Completed Task: " + taskQueue.poll());
                    } else {
                        System.out.println("No tasks available.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting Task Scheduler. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
