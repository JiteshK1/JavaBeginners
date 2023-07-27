package streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class MainTerminalOptional {
    public static void main(String[] args) {
        Course pymc= new Course("PYMC", "Python Masterclass");
        Course jmc= new Course("JMC", "Java Masterclass");

        List<Student> students= Stream.generate(()->Student.getRandomStudent(pymc,jmc))
                .limit(1000)
                .toList();

        int minAge=21;

        students.stream()
                .filter(s->s.getAge()<=minAge)
                .findAny()
                .ifPresentOrElse(s-> System.out.printf("Student of ID %d from %s have age of %d%n",s.getStudentId(),s.getCountryCode(),s.getAge()),()-> System.out.println("No Student found of "+minAge));


        students.stream()
                .filter(s->s.getAge()<=minAge)
                .findFirst()
                .ifPresentOrElse(s-> System.out.printf("Student of ID %d from %s have age of %d%n",s.getStudentId(),s.getCountryCode(),s.getAge()),()-> System.out.println("No Student found of "+minAge));

        students.stream()
                .filter(s -> s.getAge() <= minAge).min(Comparator.comparing(Student::getAge))
                .ifPresentOrElse(s-> System.out.printf("Student of ID %d from %s have age of %d%n",s.getStudentId(),s.getCountryCode(),s.getAge()),()-> System.out.println("No Student found of "+minAge));

        students.stream()
                .filter(s -> s.getAge() <= minAge).max(Comparator.comparing(Student::getAge))
                .ifPresentOrElse(s-> System.out.printf("Student of ID %d from %s have age of %d%n",s.getStudentId(),s.getCountryCode(),s.getAge()),()-> System.out.println("No Student found of "+minAge));

        students.stream()
                .filter(s -> s.getAge() <= minAge)
                .mapToInt(Student::getAge)
                .average()
                .ifPresentOrElse(s-> System.out.printf("Avg Student under 21 : %.2f%n",s),()-> System.out.println("no Student found of age "+minAge));
        students.stream()
                 .filter(s -> s.getAge() <= minAge)
                .map(Student::getCountryCode)
                .distinct()
                .reduce((a,b)->String.join(",",a,b))
                .ifPresentOrElse(System.out::println,()-> System.out.println("Did'nt find any students under "+minAge));
    }
}
