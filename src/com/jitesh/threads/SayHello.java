package com.jitesh.threads;

public class SayHello {
    public static void main(String[] args) {
         PolitePerson jitesh = new PolitePerson("Jitesh");
         PolitePerson kunal = new PolitePerson("Kunal");
         jitesh.sayHello(kunal);
    }static  class PolitePerson{
        private String name;

        public PolitePerson(String name) {
            this.name = name;
        }public String getName() {
            return name;
        }public synchronized void sayHello(PolitePerson person){
            System.out.printf("%s: %s has said hello to me%n",this.name,person.getName());
                person.sayHelloBack(this);
        }
        public synchronized void sayHelloBack(PolitePerson person) {
            System.out.printf("%s: %s has said hello to me%n",this.name,person.getName());
        }
    }
}
