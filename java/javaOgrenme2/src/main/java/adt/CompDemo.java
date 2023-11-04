package adt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompDemo {

    static class Value{
        Value(float x, float y, boolean isAlive, String content){ this.x = x;this.y = y;this.isAlive = isAlive;this.content = content; }
        public float x, y;
        public boolean isAlive;
        public String content;
        public String returnValueString(){ return "("+ this.x + "," + this.y + "," + this.isAlive + "," + this.content  +")"; }
    }


    public static void main(String[] args) {
        /*
        ArrayList<Value> dzl = new ArrayList<Value>();
        dzl.add(new Value(0,0,true,"d"));
        dzl.add(new Value(10,0,true,"b"));
        dzl.add(new Value(100,100,true,"c"));
        dzl.add(new Value(0,10,false,"a"));
        dzl.add(new Value(10,10,false,"f"));
*/
        ArrayList<String> dzl = new ArrayList<String>();
        dzl.add("d");
        dzl.add("a");
        dzl.add("e");
        dzl.add("c");
        dzl.add("b");

//        printList(dzl);

//        sortByBoolean(dzl);
//        sortByFloat(dzl);
        sortByString(dzl);
        for(String s : dzl){
            System.out.println(s);
        }

        System.out.println("\n\n---------------------\n\n");
//        printList(dzl);
    }

    public static void printList(ArrayList<Value> arrayList){
        for(Value val : arrayList) System.out.println(val.returnValueString());
    }

    public static void sortByString(List<? extends Object> arrayList){
        Collections.sort(arrayList, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
    }




    public static void sortByFloat(List<Value> arrayList){
        Collections.sort(arrayList, (val1, val2) -> (int) -(val1.x - val2.x));
    }

    public static void sortByBoolean(List<Value> arrayList){
        Collections.sort(arrayList, (val1, val2) -> String.valueOf(val1.isAlive).compareTo( String.valueOf(val2.isAlive) ));
    }

}