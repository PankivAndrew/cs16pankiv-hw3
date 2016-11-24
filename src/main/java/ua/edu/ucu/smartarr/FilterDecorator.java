package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;


// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private SmartArray filter_arr;
    private MyPredicate func;

    public FilterDecorator(SmartArray smartArray,MyPredicate func) {
        super(smartArray);
        this.func = func;
        this.filter_arr = filter();

    }
    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Filter";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
    @Override
    public String getDescription() {
        return "";
    }
    public SmartArray filter(){
        Object[] new_arr = new Object[size()];
        int index = 0;
        for (int i = 0; i < size(); i++){
            if (func.test(smartArray.toArray()[i])){
                new_arr[index] = smartArray.toArray()[i];
                index++;


            }
        }
        smartArray = new BaseArray(Arrays.copyOfRange(new_arr,0,index));
        return smartArray;
    }


}
