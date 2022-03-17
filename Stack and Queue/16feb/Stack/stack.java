public class stack {

    // class variables
    private int[] arr;
    private int sizeOfArray = 0;
    private int sizeOfStack = 0;
    private int tos = -1;

    // constructor
    public stack() {
        this.initialize(5);
    }

    public stack(int size) {
        this.initialize(size);
    }

    public void initialize(int size) {
        this.arr = new int[size];
        this.sizeOfArray = size;
        this.sizeOfStack = 0;
        this.tos = -1;
    }

    protected int sizeOfArray(){
        return this.sizeOfArray;
    }

    // exceptions
    private void stackOverflowException() throws Exception {
        if (this.sizeOfArray == this.sizeOfStack)
            throw new Exception("stackIsFull");
    }

    private void stackUnderflowException() throws Exception {
        if (this.sizeOfStack == 0)
            throw new Exception("stackIsEmpty");
    }

    // basic
    public boolean isEmpty() {
        return this.sizeOfStack == 0;
    }

    public int size() {
        return this.sizeOfStack;
    }

    // functions

    public void push(int val) throws Exception {
        stackOverflowException();
        this.tos++;
        this.arr[this.tos] = val;
        this.sizeOfStack++;
    }

    public int pop() throws Exception {
        stackUnderflowException();
        int val = this.top();
        this.arr[this.tos] = 0;
        this.tos--;
        this.sizeOfStack--;

        return val;
    }

    public int top() throws Exception {
        stackUnderflowException();
        return this.arr[this.tos];
    }
}