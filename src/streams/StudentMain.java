package streams;

import Generics.Line;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentMain {
    public static void main(String[] args) {

        Course pymc= new Course("PYMC", "Python Masterclass");
        Course jmc= new Course("JMC", "Java Masterclass");
        Student[] students = new Student[1000];
        Arrays.setAll(students, (i) -> Student.getRandomStudent(jmc, pymc));
        var maleStudents = Arrays.stream(students)
                .filter(s -> s.getGender().equals("M"));

        System.out.println("# of male students " + maleStudents.count());
   for (String gender: List.of("M","F","U")){
    var myStudents=Arrays.stream(students)
            .filter(s->s.getGender().equals(gender));
       System.out.println("For "+gender+" total count is "+myStudents.count());
   }

   List<Predicate<Student>> list = List.of(s-> s.getAge()<30,s->s.getAge()>=30 &&s.getAge()<=60);

   long total=0;
        for (int i = 0; i < list.size(); i++) {
            var myStudents=Arrays.stream(students).filter(list.get(i));
            long cnt = myStudents.count();
            total+=cnt;
            System.out.printf("# of students (%s) = %d%n",
                    i == 0 ? " < 30" : ">= 30 & < 60", cnt);
        }
        System.out.println("# of students >= 60 = " + (students.length - total));

        var enrolledAge =Arrays.stream(students)
                .mapToInt(Student::getAgeEnrolled);
        System.out.println(enrolledAge.summaryStatistics());

        var currentAge =Arrays.stream(students)
                .mapToInt(Student::getAge);
        System.out.println(currentAge.summaryStatistics());
        Arrays.stream(students)
                .map(Student::getCountryCode)
                .distinct()
                .sorted()
                .forEach(s-> System.out.print(s+" "));
        System.out.println();
        boolean longTerm=Arrays.stream(students)
                .anyMatch(s-> (s.getAge() -s.getAgeEnrolled()>=7) &&(s.getMonthsSinceActive()<12));
        System.out.println("Long term Students "+longTerm);
        var longTermCount=Arrays.stream(students)
                .filter(s-> (s.getAge() -s.getAgeEnrolled()>=7) &&(s.getMonthsSinceActive()<12));
        System.out.println("Long term Students "+longTermCount.count());
      var longTermLearners=  Arrays.stream(students)
                .filter(s-> (s.getAge() -s.getAgeEnrolled()>=7) &&(s.getMonthsSinceActive()<12))
                .filter(s-> !s.hasProgrammingExperience())
                .limit(5)
                .toList();
        var longTermLearners1=  Arrays.stream(students)
                .filter(s-> (s.getAge() -s.getAgeEnrolled()>=7) &&(s.getMonthsSinceActive()<12))
                .filter(s-> !s.hasProgrammingExperience())
                .limit(5)
                .toArray(Student[]::new);
        var longTermLearners2=  Arrays.stream(students)
                .filter(s-> (s.getAge() -s.getAgeEnrolled()>=7) &&(s.getMonthsSinceActive()<12))
                .filter(s-> !s.hasProgrammingExperience())
                .limit(5)
                .collect(Collectors.toList());
        Collections.shuffle(longTermLearners2);



    }

}
