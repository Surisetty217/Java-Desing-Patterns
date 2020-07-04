package oops.SOLID.lsp.stack.before;

import java.util.ArrayList;
import java.util.List;


/*
 * Stack is-a list with push() pop() methods.
 * So can we create a stack by extending an ArrayList class?
 *
 * No! This implementation violates the Liskov Substitution Principle.
 * Which states that
 * "Objects in a program should be replaceable with instances of their subtypes
 * without altering the correctness of that program."
 *
 * In this case ArrayList has multiple methods which stack is not supposed to have (ex clear(), get(i) etc)
 * so objects of ArrayList are not fully replaceable by the objects of stack.
 *
 */
public class StackWrong {


    private List<Integer> list;


    private StackWrong() {
        list = new ArrayList<Integer>();
    }


    public void push(Integer a) {
        list.add(a);
    }


    public void pop() throws Exception {
        if (list.size() > 0) {
            list.remove(list.size() - 1);
        } else {
            throw new Exception("STACK EMPTY");
        }
    }


    public void clear() {
        list.clear();
    }


    public Integer top() {
        if (list.size() == 0) {
            return null;
        }
        return list.get(list.size() - 1);
    }


    public static void main(String[] args) throws Exception {
        StackWrong st = new StackWrong();
        st.push(1);
        st.push(2);
        System.out.println(st.top());
        st.pop();
        System.out.println(st.top());
        st.clear();
        System.out.println(st.top());
    }


}
