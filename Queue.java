import java.util.Scanner;

public class Queue {

    // Variabel untuk melacak posisi depan (front), belakang (rear), ukuran antrean (size), dan kapasitas array
    private int front;
    private int rear;
    private int size;
    private final int[] queue;

    /**
     * Konstruktor untuk menginisialisasi antrean dengan kapasitas tertentu.
     * @param capacity Kapasitas maksimum antrean
     */
    public Queue(int capacity) {
        front = 0;
        rear = -1;
        size = 0;
        queue = new int[capacity];
    }

    /**
     * Memeriksa apakah antrean kosong.
     * @return true jika antrean kosong, false jika tidak
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Memeriksa apakah antrean penuh.
     * @return true jika antrean penuh, false jika tidak
     */
    public boolean isFull() {
        return size == queue.length;
    }

    /**
     * Menambahkan elemen baru ke antrean.
     * @param element Elemen yang akan ditambahkan
     */
    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot enqueue.");
            return;
        }
        rear = (rear + 1) % queue.length; // Menggunakan operasi melingkar
        queue[rear] = element;
        size++;
        System.out.println("Enqueued: " + element);
    }

    /**
     * Menghapus elemen dari antrean.
     * @return Elemen yang dihapus, atau -1 jika antrean kosong
     */
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return -1;
        }
        int dequeuedElement = queue[front];
        front = (front + 1) % queue.length; // Menggunakan operasi melingkar
        size--;
        System.out.println("Dequeued: " + dequeuedElement);
        return dequeuedElement;
    }

    /**
     * Menampilkan elemen dalam antrean.
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % queue.length] + " ");
        }
        System.out.println();
    }

    /**
     * Menghitung jumlah elemen dalam antrean.
     * @return Jumlah elemen dalam antrean
     */
   /** public int count() {
        return size;
    }*/

    /**
     * Metode utama untuk menjalankan program.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the capacity of the queue: ");
        int capacity = scanner.nextInt();
        Queue queue = new Queue(capacity);

        while (true) {
            // Menampilkan menu operasi antrean
            System.out.println("\nQueue Operations:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Check if Empty");
            System.out.println("4. Check if Full");
            System.out.println("5. Display Queue");
           // System.out.println("6. Count Elements");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            // Memilih operasi berdasarkan input pengguna
            switch (choice) {
                case 1:
                    System.out.print("Enter element to enqueue: ");
                    int element = scanner.nextInt();
                    queue.enqueue(element);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    System.out.println("Is Empty: " + queue.isEmpty());
                    break;
                case 4:
                    System.out.println("Is Full: " + queue.isFull());
                    break;
                case 5:
                    queue.display();
                    break;
                //case 6:
                  //  System.out.println("Element Count: " + queue.count());
                    //break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
