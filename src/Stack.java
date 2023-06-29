public class Stack<t> {
    int top;
    private int size = 0;
    t[] Array;
    int capacity=100;
    public Stack() {
        Array = (t[]) new Object[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean IS_FULL() {
        return size==capacity-1;
    }

    public void push(t element) {
        if (!IS_FULL ( )) {
            ++top;
            Array[top] = element;
            ++size;
        } else {
            System.out.println ( "can not add element" );
        }
    }

    public t pop() {
        t x = null;
        if (isEmpty ( )) {
            System.out.println ( "the stack is empty" );
            System.exit ( 1 );
        } else {
            x = Array[top];
            --top;
            --size;
        }
        return x;
    }

    public t peek() {
        if (isEmpty ( )) {
            System.out.println ( "the stack is empty" );
        }
        return Array[top];
    }

    public int getSize() {
        return top;
    }

    public void PrintStack() {
        Stack<t> temp = new Stack (  );
        while (!isEmpty ( )) {
            t x = pop ( );
            System.out.print ( x + "  " );
            temp.push ( x );
        }
        System.out.println ( "Ended" );
        while (!temp.isEmpty ( )) {
            t x = temp.pop ( );
            push ( x );
        }
    }

}

