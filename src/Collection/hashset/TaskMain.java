package Collection.hashset;

import java.util.*;

public class TaskMain {
    public static void main(String[] args) {
        Set<Task> taskList = TaskData.getTasks("ALl task");

        sortAndPrint(taskList,"TASK");

        Set<Task> annsTasks = TaskData.getTasks("Ann");
        sortAndPrint(annsTasks,"AnnaTask");
        Set<Task> bobTasks = TaskData.getTasks("bob");
        sortAndPrint(bobTasks,"BobTask");
        Set<Task> carolTasks = TaskData.getTasks("carol");
        sortAndPrint(carolTasks,"carolTask");
             Set<Task> union=    getUnion(annsTasks,bobTasks,carolTasks);
             sortAndPrint(union,"Union of all");
        Set<Task> intersection=    getIntersection(annsTasks,bobTasks);
        sortAndPrint(intersection,"Intersection of all");
        Set<Task> difference=    getDifference(annsTasks,bobTasks);
        sortAndPrint(difference,"Difference of all");
    }
    public static  void sortAndPrint(Collection<Task> taskList, String header){
        sortAndPrint(taskList,header,null);
    }

    public static Set<Task> getUnion( Set<Task> annsTasks, Set<Task> bobTasks,Set<Task> carolTasks){
        Set<Task> unionSet = new HashSet<>(annsTasks);
        unionSet.addAll(bobTasks);
        unionSet.addAll(carolTasks);
        return unionSet;

    }
    public static Set<Task> getIntersection( Set<Task> annsTasks, Set<Task> bobTasks){
        Set<Task> intersectionSet = new HashSet<>(annsTasks);
        intersectionSet.retainAll(bobTasks);
        return intersectionSet;

    }
    public static Set<Task> getDifference( Set<Task> annsTasks, Set<Task> bobTasks){
        Set<Task> differenceSet = new HashSet<>(annsTasks);
        differenceSet.removeAll(bobTasks);
        return differenceSet;

    }
    public static  void sortAndPrint(Collection<Task> taskList, String header, Comparator<Task> comparable){
        String lineSeparator = "_".repeat(90);
        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);
        List<Task> list = new ArrayList<>(taskList);
        list.sort(comparable);
        list.forEach(System.out::println);

    }
}
