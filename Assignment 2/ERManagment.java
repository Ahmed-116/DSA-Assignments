public class ERManagment {
class Patient1 {
    String type0;
    String Id0;

    Patient1(String type0, String Id0) {
        this.type0 = type0;
        this.Id0 = Id0;
    }

    public boolean isCritical() {
        if (type0 == "Critical") {
            return true;
        }
        return false;
    }
}

class Pq {
    Patient1 p0[];
    int size;
    int rear;

    Pq(int size) {
        p0 = new Patient1[size];
        rear = -1;

        this.size = size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return rear == size - 1;
    }
    public void insert0(Patient1 p) {
        if(isFull()) {
            System.out.println("Queue is full");
        }
       p0[++rear] = p;
    }
    public int highPriority(){
        for(int i = 0; i <=rear; i++) {
            if(p0[i].isCritical()) {
                return i;
            }
        }
        return -1;
    }
    public Patient1 remove0() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
        }
       int highPriority = highPriority();
      Patient1 p2 = p0[highPriority];
      for(int i = highPriority; i <= rear; i++) {
          p0[i]=p0[i+1];
      }
      rear--;
      return p2;
    }
    public void removebyId(String id) {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return ;
        }
        for(int i = 0; i <= rear; i++) {
            if(p0[i].Id0.equals(id)) {
                p0[i]=p0[i+1];
                rear--;
                break;
            }
        }
        return;
    }
    public void print() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        for(int i = 0; i <= rear; i++) {
            System.out.println(p0[i].type0+p0[i].Id0);
        }
    }
}


    Pq pq=new Pq(10);

    public void addPatient(String type0, String Id0) {
        pq.insert0(new Patient1(type0, Id0));
    }
    public void treatPatient() {
        pq.remove0();
    }
    public void declareEmergency(String id) {
        pq.removebyId(id);
    }
    public void display() {
        pq.print();
    }



    public static void main(String[] args) {
      ERManagment er=new ERManagment();
      er.addPatient("Critical", "009");

        er.addPatient("Critical", "090");
      //er.treatPatient();
      er.display();


    }
}
