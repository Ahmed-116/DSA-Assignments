import java.util.PriorityQueue;
import java.util.Comparator;

class Task {
    String taskID;
    int priority;
    int temp; // Used for ordering tasks with the same priority

    public Task(String taskID, int priority, int temp) {
        this.taskID = taskID;
        this.priority = priority;
        this.temp = temp; // Assign temp correctly
    }
}

public class TaskScheduler {

    public PriorityQueue<Task> taskQueue;
    public int counter;

    public TaskScheduler() {
        // Comparator to sort tasks by priority, then by timestamp if priorities are equal
        this.taskQueue = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                if (t1.priority != t2.priority) {
                    return Integer.compare(t1.priority, t2.priority);
                }
                return Integer.compare(t1.temp, t2.temp); // Maintain order for same priority
            }
        });
        this.counter = 0; // Initialize counter
    }

    public void addTask(String taskID, int priority) {
        int timestamp = counter++; // Assign a unique timestamp
        Task task = new Task(taskID, priority, timestamp);
        taskQueue.add(task);
        System.out.println("Task " + taskID + " with priority " + priority + " added.");
    }

    public void performTask() {
        if (taskQueue.isEmpty()) {
            System.out.println("No tasks to perform.");
            return;
        }
        Task task = taskQueue.poll(); // Remove and return the highest priority task
        System.out.println("Performing task: " + task.taskID + " with priority " + task.priority);
    }

    public void viewPendingTasks() {
        if (taskQueue.isEmpty()) {
            System.out.println("No tasks pending.");
            return;
        }
        System.out.println("Pending tasks:");
        for (Task task : taskQueue) {
            System.out.println("Task ID: " + task.taskID + ", Priority: " + task.priority);
        }
    }

    public void cancelTask(String ID) {
        for (Task task : taskQueue) {
            if (task.taskID.equals(ID)) {
                taskQueue.remove(task);
                System.out.println("Task " + ID + " removed.");
                return;
            }
        }
        System.out.println("Task " + ID + " not found.");
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addTask("T1", 3);
        scheduler.addTask("T2", 1);
        scheduler.addTask("T3", 2);

        System.out.println();
        scheduler.performTask();
        System.out.println();
        scheduler.addTask("T4", 3);
        scheduler.addTask("T5", 5);

        System.out.println();
        scheduler.cancelTask("T2");
        System.out.println();
        scheduler.viewPendingTasks();
    }
}
