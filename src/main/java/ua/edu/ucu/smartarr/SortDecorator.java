package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator func;
    private SmartArray sortarray;

    public SortDecorator(SmartArray smartArray,MyComparator func) {
        super(smartArray);
        this.func = func;
        this.sortarray = sort();
    }
    public SmartArray sort(){
        Object temp;
        for (int i = 0; i < smartArray.size() - 1; i++) {

            for (int j = 1; j < smartArray.size() - i; j++) {
                if (func.compare(smartArray.toArray()[j - 1], smartArray.toArray()[j]) > 0) {
                    temp = smartArray.toArray()[j - 1];
                    smartArray.toArray()[j - 1] = smartArray.toArray()[j];
                    smartArray.toArray()[j] = temp;
                }
            }
        }
        return smartArray;
    }


    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Sort";
    }

    @Override
    public int size() {
        return smartArray.size();
    }

    @Override
    public String getDescription() {
        return "";
    }

    public static void main(String[] args) {
        Integer a = 0;
        Integer f = 0;
        String addd = "afaafaf";
        Character v = 'a';
        Character b = 'b';
        Character c = 'c';
        Character as = 'A';
        Character sdd = 'B';
        a = v + b;
        f = v - b;
        System.out.println("a");
        System.out.println(Character.getNumericValue(v));
        System.out.println("b");
        System.out.println(addd.substring(0,1));



    }

}
