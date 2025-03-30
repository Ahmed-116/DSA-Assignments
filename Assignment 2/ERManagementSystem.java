class Patient {
    String type;
    String id;

    Patient(String type, String id) {
        this.type = type;
        this.id = id;
    }

    public boolean isType() {
        if (type == "critical") {
            return true;
        }
        return false;
    }
}

class PriorityQueue0 {
    Patient patient[];
    int size;
    int rear;

    PriorityQueue0(int size) {
        patient = new Patient[size];
        rear = -1;
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return rear == size - 1;
    }

    public void insert(Patient p) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        patient[++rear] = p;
    }

    public int highPriority() {
        for (int i = 0; i <= rear; i++) {
            if (patient[i].isType()) {
                return i;
            }
        }
        return 0;
    }

    public Patient remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        int highPriority = highPriority();
        Patient p = patient[highPriority];
        for (int i = highPriority; i <= rear; i++) {
            patient[i] = patient[i + 1];
        }
        rear--;
        return p;
    }

    public void removeByID(String id) {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = 0; i <= rear; i++) {
            if (patient[i].id.equals(id)) {
                patient[i] = patient[i + 1];
                rear--;
            }
        }
        return ;
    }

    public void display() {
        for (int i = 0; i <= rear; i++) {
            System.out.println("Patient-Type:" + patient[i].type + "    Patient-ID:" + patient[i].id);
        }
        System.out.println();
    }
}
public class ERManagementSystem {
    PriorityQueue0 priorityQueue = new PriorityQueue0(10);
    public void addPatient(String type, String id) {
        priorityQueue.insert(new Patient(type, id));

    }
    public void treatPatient() {
        priorityQueue.remove();
    }
    public void displayPatients() {
        priorityQueue.display();
    }
    public void declareEmergency(String id) {
        priorityQueue.removeByID(id);
    }
    public static void main(String[] args) {
        ERManagementSystem obj = new ERManagementSystem();
        obj.addPatient("non-critical", "Patient 1");
        obj.addPatient("critical", "Patient 2");
        obj.addPatient("non-critical", "Patient 4");
        obj.addPatient("critical", "Patient 5");
        obj.displayPatients();
        obj.treatPatient();
        obj.displayPatients();
        obj.treatPatient();
        obj.displayPatients();
        obj.declareEmergency("Patient 4");
        obj.displayPatients();
    }
}
