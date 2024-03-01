/**
 * LinkedList.java
 * [Jelaskan kegunaan class ini]
 * @author [NIM] [Nama]
 */

 public class DoubleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Konstruktor
     * buat Double linked list dengan size = 0 dan head = tail = null
     */
    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Cari elemen yang terletak pada posisi position
     * @param position
     * @return elemen pada posisi position jika ada, null jika tidak ada
     */
    public Node<T> getNode(int position) {
        int i = 0;
        Node<T> loc = head;
        while ((loc != null) && (i < position)) {
            loc = loc.getNext();
            i++;
        }
        return loc;
    }

    /**
     * Tambah elemen dengan nilai item dengan menambahkan
     * node sebagai elemen paling belakang
     * @param item
     */
    public void add(T item) {
        Node<T> loc = new Node<T>(item, tail, null);
        if (size == 0) {
            head = loc;
        } else {
            tail.setNext(loc);
        }
        tail = loc;
        size++;
    }

    /**
     * Cari nilai elemen pada posisi position
     * @param position
     * @return nilai elemen pada posisi position jika ada, null jika tidak ada
     */
    public T get(int position) {
        Node<T> loc = getNode(position);
        if (loc != null) {
            return (loc.getValue());
        } else {
            return null;
        }
    }

    /**
     * Ubah nilai elemen pada posisi position menjadi nilai item jika ada
     * @param position
     * @param item
     */
    public void set(int position, T item) {
        Node<T> loc = getNode(position);
        if (loc != null) {
            loc.setValue(item);
        }
    }

    /**
     * Hapus elemen pada posisi position jika ada
     * @param position
     */
    public void remove(int position) {
        Node<T> loc = getNode(position);
        if (loc != null) {
            if (size == 1) {
                clear();
            } else {
                if (position == 0) {
                    head = loc.getNext();
                    head.setPrev(null);
                } else if (position == size-1) {
                    tail = loc.getPrev();
                    tail.setNext(null);
                } else {
                    loc.getPrev().setNext(loc.getNext());
                    loc.getNext().setPrev(loc.getPrev());
                }
            }
            loc.setNext(null);
            loc.setPrev(null);
            size--;
        }
    }

    /**
     * Hapus semua elemen dari Double Linked List
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Getter size
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * Menampilkan keseluruhan isi Double Linked List
     * Format yang dikeluarkan adalah sebagai berikut, misal isi list adalah [1,2,3,4]
     * Maka output yang dihasilkan adalah (dengan enter) :
     * 1 2 3 4
     */
    public void display() {
        Node<T> loc = head;
        while (loc != null) {
            System.out.print(loc.getValue());
            if (loc.getNext() != null) {
                System.out.print(" ");
            }
            loc = loc.getNext();
        }
        System.out.println();
    }

    /**
     * Find element position
     * jika terdapat lebih dari 1 elemen dengan nilai yang sama, maka ambil posisi
     * yang ditemukan pertama kali dari head
     * Jika posisi elemen tidak ditemukan maka return -1
     * @return posisi dari sebuah item mulai dari head dengan zero indexing
     */
    public Integer find(T item) {
        Node<T> loc = head;
        int position = 0;
        while (loc != null) {
            if (loc.getValue().equals(item)) {
                return position;
            }
            loc = loc.getNext();
            position++;
        }
        return -1;
    }
}