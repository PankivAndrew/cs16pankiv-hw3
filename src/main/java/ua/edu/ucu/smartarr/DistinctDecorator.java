package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    public DistinctDecorator(SmartArray smartarray) {
        super(smartarray);
        distinct();


    }
    public void remove(int index){
        Object[] new_arr = new Object[size()-1];
        Integer a = 0;
        for (int i = 0; i < index; i++){
            new_arr[i] = smartArray.toArray()[i];
            a++;
        }
        for (int i = index + 1; i < smartArray.size(); i++){
            new_arr[a] = smartArray.toArray()[i];
            a++;
        }
        smartArray = new BaseArray(Arrays.copyOfRange(new_arr,0,new_arr.length));




    }
    public void distinct(){
        for (int i = 0; i < size(); i++){
            for (int j = i + 1; j < size(); j++){
                if (smartArray.toArray()[i].equals(smartArray.toArray()[j])){
                    remove(i);
                }
            }
        }
    }


    @Override
    public Object[] toArray() {
       return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Distinct";
    }

    @Override
    public int size() {
        return smartArray.size();
    }

    @Override
    public String getDescription() {
        return "";
    }


}
