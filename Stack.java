public class Stack {

    private int maxsize;
    private int top = -1;
    private int data[];
    //O(1)


    public Stack(int maxsize) {
        this.maxsize = maxsize;
        this.data = new int[maxsize];
    }

    //O(1)
    public int getMaxsize() {
        return maxsize;
    }

    //O(1)
    public void setMaxsize(int maxsize) {
        this.maxsize = maxsize;
    }

    //O(1)
    public int getTop() {
        return top;
    }

    //O(1)
    public void setTop(int top) {
        this.top = top;
    }

    //O(1)


    //O(1)
    boolean IsEmpty() {
        if (this.top == -1) return true;
        return false;
    }

    //O(1)
    boolean IsFull() {
        if (this.top == this.maxsize) return true;
        return false;
    }

    //O(1)
    boolean push(int x) {
        if (this.IsFull()) return false;
        this.top++;
        this.data[this.top] =x;
        return true;
    }

    //O(1)
    int pop() {
        if (this.IsEmpty()) return -3;
        return this.data[this.top--];
    }

    //O(1)
    int view() {
        return this.data[this.top];
    }
}


