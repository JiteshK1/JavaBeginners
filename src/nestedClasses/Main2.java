package nestedClasses;

import java.time.LocalDate;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {


        Emp e1 = new Emp("Minnie" , "Mouse", "01/02/2015");
        Emp e2 = new Emp("Mickie" , "Mouse", "05/08/2000");
        Emp e3 = new Emp("Daffy" , "Duck", "11/02/2011");
        Emp e4 = new Emp("Daisy" , "Duck", "05/03/2013");
        Emp e5 = new Emp("Goofy" , "Dog", "23/07/2020");

        List<Emp> list = new ArrayList<>(Arrays.asList(e1, e2, e3, e4, e5));

    }
public static  void sortItems(List<Emp> eList , String sortList){
int currentYear= LocalDate.now().getYear();

        class  storeEmployee{
            Emp employee;
            int yearWorked;
            String fullName;

            public storeEmployee(Emp employee) {
                this.employee = employee;
                this.yearWorked=
                 currentYear - Integer.parseInt(employee.hiredDate().split("/")[2]);
                this.fullName=String.join(" ",employee.fName(),employee.lName());
            }




        }
    List<storeEmployee> list = new ArrayList<>();
    for (Emp employee : eList) {
        list.add(new storeEmployee(employee));
    }

    var comparator = new Comparator<storeEmployee>(){

            @Override
            public int compare(storeEmployee o1, storeEmployee o2) {
                 if (sortList.equals("year")){
                   return   o1.yearWorked - o2.yearWorked;
                 };
                 return o1.fullName.compareTo(o2.fullName);
            }
        };



    }
}
