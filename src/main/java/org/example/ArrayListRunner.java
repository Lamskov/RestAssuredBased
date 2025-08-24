package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArrayListRunner {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);


        for(int i : list) {
            System.out.println(i);
        }



    }
}
