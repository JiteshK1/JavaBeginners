package com.jitesh.nested_classes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(10001, "Ralph", 2015),
                new Employee(10005, "Carole", 2021),
                new Employee(10022, "Jane", 2013),
                new Employee(13151, "Laura", 2020),
                new Employee(10050, "Jim", 2018)));


        employees.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());

        for (Employee e : employees) {
            System.out.println(e);
        }
        System.out.println("Store Members");

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10015, "Meg", 2019,
                        "Target"),
                new StoreEmployee(10515, "Joe", 2021,
                        "Walmart"),
                new StoreEmployee(10105, "Tom", 2020,
                        "Macys"),
                new StoreEmployee(10215, "Marty", 2018,
                        "Walmart"),
                new StoreEmployee(10322, "Bud", 2016,
                        "Target")));

        var comparator = new StoreEmployee().new StoreComparator<>();
        storeEmployees.sort(comparator);

        for(StoreEmployee e : storeEmployees){
            System.out.println(e);
        }
        addPigLatinName(storeEmployees);
    }
    public static void addPigLatinName(List<? extends StoreEmployee> list){

        class  DecoratedEmployee extends StoreEmployee implements  Comparable<DecoratedEmployee>{
            private  String pinLatinName;
            private  Employee originalInstance;

            public DecoratedEmployee(String pinLatinName, Employee originalInstance) {
                this.pinLatinName = pinLatinName;
                this.originalInstance = originalInstance;

            }

            @Override
            public String toString() {
                return  originalInstance.toString() + " " + pinLatinName;
            }

            @Override
            public int compareTo(DecoratedEmployee o) {
                return pinLatinName.compareTo(o.pinLatinName);
            }
        }
        List<DecoratedEmployee> myList = new ArrayList<>(list.size());

          for (Employee e : list){
              String name = e.getEmployeeName();
              String pinLatinName= name.substring(1)+ name.charAt(0)+"ay";
              myList.add(new DecoratedEmployee(pinLatinName,e));

          }
              myList.sort(null);
          for (var e : myList){
              System.out.println(e);
          }

    }
}