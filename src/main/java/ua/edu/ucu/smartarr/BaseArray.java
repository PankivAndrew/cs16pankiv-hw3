package ua.edu.ucu.smartarr;

import java.util.Arrays;
// Base array for decorators
public class BaseArray implements SmartArray{
    public Object[] arr;
    public BaseArray(Object [] arr) {
        this.arr = arr;
    }

    @Override
    public Object[] toArray() {
        return arr;
    }

    @Override
    public String operationDescription() {
        return "This is BaseArray";
    }

    @Override
    public int size() {
        return arr.length;
    }

    public static void main(String[] args) {
        SmartArray d = new BaseArray(new Integer[]{1,23,4});
        System.out.println(Arrays.toString(d.toArray()));
    }
}
