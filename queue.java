public class GenericQueue<T extends Object> {
    private int _capacity;
    private int _front;
    private int _rear;
    private int _currentSize;
    private T[] _queue;

    GenericQueue(int _capacity) {
        this._capacity = _capacity;
        this._currentSize = 0;
        this._front = 0;
        this._rear = -1;
        _queue = (T[]) new Object[_capacity];
    }

    public void enqueue(T value) {
        if (isFull())
            p("Over flow");
        else {
            _currentSize++;
            if (_rear == (_capacity - 1)) {
                _rear = 0;
                _queue[_rear] = value;
                p("Pushed " + _queue[this._rear]);
            } else {
                ++this._rear;
                _queue[_rear] = value;
                p("Pushed " + _queue[this._rear]);
                printQueue();
            }
        }
    }

    public boolean isFull() {
        return (_currentSize == _capacity);
    }

    public boolean isEmpty() {
        return (_currentSize == 0);
    }

    public void dequeue() {
        if (isEmpty())
            p("its empty now");
        else {
            _currentSize--;
            if (_front == (_capacity -1) ) {
                p("Removed " + _queue[_front]);
                _front = 0;
            } else {
                p("Removed " + _queue[_front]);
                _front++;
            }
            printQueue();
        }
    }

    public static void main(String[] args) {
        GenericQueue<Integer> stack =  new GenericQueue<>(5);
        stack.enqueue(4);
        stack.enqueue(5);
        stack.dequeue();
        stack.dequeue();
        stack.dequeue();
        stack.enqueue(4);
        stack.enqueue(42);
        stack.enqueue(44);
        stack.enqueue(34);
        stack.enqueue(334);
        stack.enqueue(334);
        stack.enqueue(4);
        stack.enqueue(5);
        stack.dequeue();
        stack.dequeue();
        stack.dequeue();
        stack.dequeue();
        stack.dequeue();
        stack.dequeue();
    }

    public void printQueue() {
        for (int i =0, j = _front; i < _currentSize; i++, j++) {
            if (j == (_capacity)) {
                j = 0;
            }
            System.out.print(_queue[j] + ", ");
        }
        p("");
    }

    public static void p(String out) {
        System.out.println(out);
    }
}
