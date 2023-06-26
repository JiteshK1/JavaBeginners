package nestedClasses;

import java.util.Comparator;

public class Employee {

    public static class EmployeeComparator<T extends Employee> implements Comparator<Employee> {

        private String sortType;


        public EmployeeComparator() {
        this("name");
        }


        public EmployeeComparator(String sortType) {
            this.sortType = sortType;
        }
        @Override

        public int compare(Employee o1, Employee o2) {
            if (sortType.equalsIgnoreCase("yearStarted")){
                return o1.yearStart-o2.yearStart;
            }
            else {
                return o1.EmployeeName.compareTo(o2.EmployeeName);
            }
        }

    }


    private  int EmployeeId;
    private  String EmployeeName;
    private int yearStart;

    public Employee(int employeeId, String employeeName, int yearStart) {
        EmployeeId = employeeId;
        EmployeeName = employeeName;
        this.yearStart = yearStart;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }
    public String toString() {
        return "%d %-8s %d".formatted(EmployeeId, EmployeeName, yearStart);
    }


    public Employee() {
    }
}
