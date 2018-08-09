import java.util.EmptyStackException;

public class RingBuffer { //can be changed to use generics -> RingBuffer<E>
    private int size;
    private int capacity;
    private Bin head;
    private Bin tail;
    private Bin lastCreated;

    public RingBuffer(int size) {
        this.size = this.capacity = size;
    }

    class Bin {
        private int value; //generic -> private E value
        private Bin next;

        Bin(int value, Bin next) { //generic -> Bin(E value, Bin next)
            this.value = value;
            this.next = next;
        }

        public int getValue() { //generic -> public E getValue()
            return value;
        }
    }

    /**
     * Writes as many elements as it can before overwriting
     *
     * @param data is a source array to get elements
     * @return the number of elements written to the buffer
     */
    public int write(int[] data) { //generic -> public E write(E[] data)
        if (capacity == 0 || data == null || data.length == 0) return 0;
        int maxCopies = capacity;
        int copied = 0;
        for (int i = 0; i <= maxCopies && capacity > 0; i++) {
            // mark a head for the first element
            if (capacity == size) {
                lastCreated = new Bin(data[i], null);
                lastCreated.next = lastCreated;
                head = lastCreated;
                tail = head;
            } else {
                if (copied == data.length) break;
                tail = new Bin(data[i], head);
                lastCreated.next = tail;
                lastCreated = tail;
            }
            copied++;
            capacity--;
        }
        return copied;
    }

    /**
     * Returns a single buffered int in FIFO order, and removes the element from the buffer
     *
     * @return a head buffered int from the queue
     */
    public int read() { //generic -> public E read()
        if (capacity == size) {
            throw new EmptyStackException();
        }
        int tmp = head.getValue();
        head = head.next;
        tail.next = head;
        capacity++;
        return tmp;
    }

}
