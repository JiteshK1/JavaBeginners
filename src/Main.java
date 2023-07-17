import Generics.BaseClass;
import comsumer.specific.ChildClass;

public class Main {
    public static void main(String[] args) {

        BaseClass baseClass = new BaseClass();
        ChildClass childClass = new ChildClass();
        BaseClass childReferredAsBase = new ChildClass();

        baseClass.recommendedMethod();
        System.out.println("+++++++++++++++++++++++++++");
      childClass.recommendedMethod();
        System.out.println("+++++++++++++++++++++++++++");
      childReferredAsBase.recommendedMethod();
        System.out.println("+++++++++++++++++++++++++++");
     baseClass.recommendedStatic();
        System.out.println("+++++++++++++++++++++++++++");

        childClass.recommendedStatic();
        System.out.println("+++++++++++++++++++++++++++");
childReferredAsBase.recommendedStatic();
    }
}