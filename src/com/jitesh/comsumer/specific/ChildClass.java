package com.jitesh.comsumer.specific;

import com.jitesh.generics.BaseClass;

public class ChildClass extends BaseClass {
    @Override
    protected void optionalMethod() {

        System.out.println("[Child:optionalMethod] EXTRA Stuff Here");
        super.optionalMethod();
    }

}
