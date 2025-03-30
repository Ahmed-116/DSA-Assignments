class Task1 {
    int priority;
    String taskId;

    Task1(int priority, String taskId) {
        this.priority = priority;
        this.taskId = taskId;
    }
}

class PriorityQueue1 {
    public Task1 arr[];
    int size;
    int rear;

    public PriorityQueue1(int size) {
        this.size = size;
        rear = -1;
        arr = new Task1[size];
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public boolean isFull() {
        return rear == size - 1;
    }

    public void insert(Task1 task) {
        if (isFull()) {
            System.out.println("Task queue is full");
            return;
        }
        arr[++rear] = task;
//        int i = rear;
//        while (i >= 0 && arr[i].priority < task.priority) {
//            arr[i + 1] = arr[i];
//            i--;
//        }
//        arr[i + 1] = task;
//        rear++;
    }

    public Task1 peek() {
        return arr[rear];
    }

    public int highestPriority() {
        if (rear == -1) {
            System.out.println("Queue is empty.");
            return -1;
        }

        int number = arr[0].priority;
        for (int i = 1; i <= rear; i++) {
            if (arr[i].priority > arr[number].priority) {
                number = i;
            }
        }
        return number;

    }

    public Task1 remove() {
        if (isEmpty()) {
            System.out.println("No pending task");
            return null;
        }
        int item = highestPriority();
        Task1 task = arr[item];
        for (int i = item; i < rear; i++) {
            arr[i] = arr[i + 1];
        }
        rear--;
        return task;
    }

    public void cancel(String taskId) {
        if (isEmpty()) {
            System.out.println("No pending task");
            return;
        }


        for (int i = 0; i <= rear; i++) {
            if (arr[i].taskId.equals(taskId)) {
                arr[i] = arr[i + 1];
            }
        }
        rear--;
        return;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = 0; i <= rear; i++) {
            System.out.println("TaskId : " + arr[i].taskId + "  Priority : " + arr[i].priority);
        }
        System.out.println();

    }

}


public class TaskAssign {
    PriorityQueue1 pq = new PriorityQueue1(15);

    public void addTask(int priority, String taskId) {
        pq.insert(new Task1(priority, taskId));
    }

    public Task1 performTask() {
        Task1 performed = pq.remove();
        return performed;
    }

    public void cancelTask(String taskId) {
        pq.cancel(taskId);
    }

    public void displayTask() {
        pq.display();
    }

    public static void main(String[] args) {
        TaskAssign ta = new TaskAssign();
        ta.addTask(1, "1");
        ta.addTask(3, "3");
        ta.addTask(12, "12");
        ta.addTask(5, "5");
        ta.addTask(17, "7");


        ta.displayTask();
        ta.performTask();
        ta.displayTask();
        ta.performTask();
        ta.displayTask();
        ta.cancelTask("3");
        ta.displayTask();
    }


}
