package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction func;
    private SmartArray map_arr;


    public MapDecorator(SmartArray smartArray,MyFunction func) {
        super(smartArray);
        this.func = func;
        this.map_arr = map();
    }
    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Map";
    }


    @Override
    public int size() {
        return smartArray.size();
    }
    @Override
    public String getDescription() {
        return "";
    }
    public SmartArray map(){
        for(int i = 0; i < size();i++){
            smartArray.toArray()[i] = func.apply(smartArray.toArray()[i]);
        }
        return smartArray;
    }



}
