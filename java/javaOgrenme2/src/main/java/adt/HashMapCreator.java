package adt;

import java.util.HashMap;

public class HashMapCreator {


    public static void main(String[] args) {
        HashMap<String, MyValue> myHashMap = createHashMap(new String[]{}, new MyValue[]{});
        MyValue[] valuesArray = new MyValue[]{new MyValue(2f, 3f, 10, 20), new MyValue(2f, 30f, 60, 30)};
        for(MyValue myValue : valuesArray)
            myHashMap.put(myValue.getSpecialID(), myValue);

        myHashMap.get( new MyValue(2f, 3f, 10, 20).getSpecialID() ).setH(1000);

        System.out.println(myHashMap.get( new MyValue(2f, 3f, 10, 20).getSpecialID() ).getTheValue());

    }

    static class MyValue{
        private float x,y; private int w,h;
        MyValue(){this.x=0;this.y=0;this.w=0;this.h=0;}
        MyValue(float x, float y, int w,int h){this.x=x;this.y=y;this.w=w;this.h=h;}
        public void setX(float x) { this.x = x; } public void setY(float y) { this.y = y; }
        public void setW(int w) { this.w = w; } public void setH(int h) { this.h = h; }
        public float getX() { return this.x; }  public float getY(){ return this.y; }
        public int getH() { return this.h; }  public int getW(){ return this.w; }
        public String getSpecialID(){return "("+String.valueOf(x)+","+String.valueOf(y)+")";}
        public String getTheValue(){ return String.format("(%.1f,%.1f,%d,%d)", this.x, this.y, this.w, this.h); }
    }

    // O(n) where n is the number of elemnents in the key/value array
    public static <T1, T2> HashMap<T1,T2> createHashMap(T1[] keys, T2[] values){
        HashMap<T1, T2> newMap = new HashMap<T1, T2>();
        try{
            if(keys.length != values.length) throw new Exception("Number of keys and values aren't equal");
            for(int i=0; i<keys.length; i++) newMap.put( keys[i], values[i] );
        }
        catch (Exception e) { e.printStackTrace(); }
        return newMap;
    }




}
