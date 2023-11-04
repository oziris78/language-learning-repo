package adt;

import java.util.ArrayList;
import java.util.Stack;

public class MyStackDemo {

    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<Integer>();
        myStack.push(12, "test12");
        myStack.push(22, "test22");
        myStack.push(32, "test32");
        for(Object item : myStack)
            System.out.println("theObject: " + item + " | itsName: " + myStack.getName(item));

        System.out.println(myStack.getName("item"));
        Object obj = myStack.push(15674);
        System.out.println(obj);
        System.out.println(myStack.getName("item"));
    }

    static class MyStack<T> extends Stack {
        private ArrayList<String> names;
        public MyStack(){
            names = new ArrayList<String>();
        }

        public String getName(Object item) {
            int i = this.indexOf(item);
            if( i == -1) return "item does not exist";
            return this.names.get(i);
        }


        public Object push(Object item, String name) {
            this.names.add(name);
            return super.push(item);
        }

        @Override
        public synchronized Object pop() {
            this.names.remove(this.size()-1);
            return super.pop();
        }

        @Override
        public Object push(Object item) {
            return null;
        }
    }

}