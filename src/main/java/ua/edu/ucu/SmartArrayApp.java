package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }
    public static void Sort( String[] students) {
        String Array[] = students;

        for (int j = 0; j < Array.length; j++) {
            for (int i = j + 1; i < Array.length; i++) {
                if (Array[i].compareTo(Array[j]) < 0) {
                    String temp = Array[j];
                    Array[j] = Array[i];
                    Array[i] = temp;


                }
            }

        }
    }



    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {
        Integer counter = 0;
        for (int i = 0; i < students.length;i++){
            if (students[i].getGPA() >= 4 && students[i].getYear() == 2){
                counter++;
            }
        }
        String[] to_return =new String[counter];
        Integer index = 0;

        for (int i = 0; i < students.length;i++){
            String a = "";
            if (students[i].getGPA() >= 4 && students[i].getYear() == 2){
                a += students[i].getSurname() + " " + students[i].getName();
                to_return[index] = a;
                index++;
            }
        }






        Sort(to_return);

        return to_return;
    }


}
