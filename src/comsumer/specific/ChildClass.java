package comsumer.specific;

import Generics.BaseClass;

public class ChildClass extends BaseClass {
    @Override
    protected void optionalMethod() {

        System.out.println("[Child:optionalMethod] EXTRA Stuff Here");
        super.optionalMethod();
    }

}
