package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainCollect {
    public static void main(String[] args) {
        Course pymc= new Course("PYMC", "Python Masterclass");
        Course jmc= new Course("JMC", "Java Masterclass");

        List<Student> students= Stream.generate(()->Student.getRandomStudent(pymc,jmc))
                .limit(1000)
                .toList();


        Set<Student> indianStudents=students.stream()
                .filter(s-> s.getCountryCode().equals("IN"))
                .collect(Collectors.toSet());

        System.out.println("# total Indian Students are "+indianStudents.size());
       Set<Student> underThirty=students.stream()
               .filter(s->s.getAgeEnrolled()<30)
               .collect(Collectors.toSet());
        System.out.println("# total  Students under 30 are "+underThirty.size());

        Set<Student> indianStudents1=new TreeSet<>(Comparator.comparing(Student::getStudentId));
        indianStudents1.addAll(indianStudents);
        indianStudents1.retainAll(underThirty);

              indianStudents1.forEach(s-> System.out.print(s.getStudentId()+" "));
        System.out.println();
        Set<Student> indianStudents2= students.stream()
                .filter(s->s.getAgeEnrolled()<30)
                .filter(s-> s.getCountryCode().equals("IN"))
                // first supplier creates new treeSet
       // then the second argument add one element each to treeSet
                //then the third argument adds all the element for both collections
                .collect(()-> new TreeSet<>(Comparator.comparing(Student::getStudentId)),TreeSet::add,TreeSet::addAll);
        indianStudents2.forEach(s-> System.out.print(s.getStudentId()+" "));
        System.out.println();

        String countryList=students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .sorted()
                .reduce("",(r,v)-> r+" "+v);

        System.out.println("Countrylist -> "+countryList);


    }
}
