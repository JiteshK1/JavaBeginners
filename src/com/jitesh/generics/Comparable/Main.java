package com.jitesh.generics.Comparable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Integer[] other={6,2,3,4,5};
        Integer five = 5;
        for (int i:
              other) {
          int value = five.compareTo(i);
            System.out.printf("%d %s %d: compare to: %d%n",five,value==0?"==":(value<0)?"<":">",i,value);
            }

        Student tim = new Student("Tim");

        Student[] Students= {new Student("Rakhi"),new Student("Badam"),new Student("Chilli")};

        Arrays.sort(Students);
        System.out.println(Arrays.toString(Students));
Comparator<Student> studentComparator = new StudentGpaComparator();

     Arrays.sort(Students,studentComparator);
        System.out.println(Arrays.toString(Students));

    }


    }

    class  StudentGpaComparator implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return  (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
        }
    }

class Student implements  Comparable<Student>{
    private static int LAST_ID=1000;
    private static Random random=new Random();
     int id;
    protected double gpa;
     String name;

    public Student(String name) {
        this.name = name;
       this.id=LAST_ID++;
        this.gpa= random.nextDouble(1.0,4.0);
    }


    @Override
    public String toString() {
        return "%d - %s(%.2f)".formatted(id,name,gpa);                }

    @Override
    public int compareTo(Student o){
        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
    }
//    @Override
//    public int compareTo(Object o) {
//        Student other = (Student) o;
//        return this.name.compareTo(other.name);
//    }


}

