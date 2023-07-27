package com.jitesh._list;

import java.util.ArrayList;

public class Boxing {
    public static void main(String[] args) {
      var list = arList(1,2,3,4,55,3,11);
        System.out.println(list);
    }


    public static ArrayList<Integer> arList(int ...argms){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : argms){
            list.add(i);
        }
    return list;
    }

    public static int getInt(Integer i){
        return i;
    }
}
