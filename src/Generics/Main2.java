package Generics;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
 int indexCount =10;
   List<Student> students = new ArrayList<>()    ;
 for (int i = 0; i <= indexCount; i++) {
            students.add(new Student());
        }
           students.add(new LPAStudent());
  printList(students);

        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i = 0; i < indexCount; i++) {
            lpaStudents.add(new LPAStudent());
        }
        printList(lpaStudents);
//
    }

    public static <T extends  Student>void printList(List<T> students){

        for (var s:
             students) {
            System.out.println(s);
        }
        System.out.println();
    }
//    public static void printList(List<? extends  Student> students){
//        for (var s:
//                students) {
//            System.out.println(s);
//        }
//        System.out.println();
//    }
    public  static void printMoreList(List<?> list){

        for (var element : list){
            if (element instanceof Integer i ){
                System.out.println("Integer: " + i.floatValue());
            }
            else if (element instanceof String s) {
                System.out.println("String: " + s.toUpperCase());
            }
        }
    }
}
