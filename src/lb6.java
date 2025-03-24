import java.util.Scanner;

class Nodeq {
    double data;
    Nodeq next;

    public Nodeq(double data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    private Nodeq front, rear;

    public Queue() {
        this.front = this.rear = null;
    }

    public void enqueue(double data) {
        Nodeq newNode = new Nodeq(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }


    public void dequeue() {
        if (front == null) {
            System.out.println("Черга порожня");
            return;
        }
        front = front.next;
        if (front == null) {
            rear = null;
        }
    }


    public void display() {
        Nodeq temp = front;
        while (temp != null) {
            System.out.print((int) Math.round(temp.data) + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    public void printDerivatives() {
        Nodeq temp = front;
        System.out.print("Похідні елементів черги: ");
        while (temp != null) {
            System.out.print("0 ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class lb6 {


    public static void start(Scanner scanner) {
        Queue queue = new Queue();


        queue.enqueue(-2.2);
        queue.enqueue(2.3);
        queue.enqueue(2.2);
        queue.enqueue(5.1);
        queue.enqueue(6.7);

        System.out.println("Вміст черги після додавання:");
        queue.display();


        queue.dequeue();
        queue.dequeue();
        queue.dequeue();


        queue.enqueue(1.9);

        System.out.println("Вміст черги після видалення і додавання:");
        queue.display();


        queue.printDerivatives();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        start(scanner);
    }
}
