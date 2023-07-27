package com.jitesh.collection.hashset;

import java.util.*;

public class MapViewMain {
    public static void main(String[] args) {
        Map<String,Contact> contacts = new HashMap<>();
        ContactData.getData("phone").forEach(c-> contacts.put(c.getName(),c));
        ContactData.getData("email").forEach(c-> contacts.put(c.getName(),c));

        Set<String> keyView=contacts.keySet();
        System.out.println(keyView);

        Set<String> copyOfKey = new TreeSet<>(contacts.keySet());
        System.out.println(copyOfKey);

        if (contacts.containsKey("Linus Van Pelt")){
            System.out.println("GGG HOW ARE YOU");
        }

        keyView.remove("Daffy Duck");
        System.out.println(keyView);
        contacts.forEach((k,v)-> System.out.println(v));

        copyOfKey.remove("Linus Van Pelt");
        System.out.println(copyOfKey);
        contacts.forEach((k,v)-> System.out.println(v));

        keyView.retainAll(List.of("Linus Van Pelt","Maid Marion","Daffy Duck","Charlie Brown"));
        System.out.println(keyView);
        contacts.forEach((k,v)-> System.out.println(v));

        keyView.clear();
        System.out.println(keyView);

        ContactData.getData("phone").forEach(c-> contacts.put(c.getName(),c));
        ContactData.getData("email").forEach(c-> contacts.put(c.getName(),c));
        System.out.println(keyView);
        contacts.forEach((k,v)-> System.out.println(v));
        System.out.println("========================");
          var values =contacts.values();
           values.forEach(System.out::println);
        System.out.println("========================");

          values.retainAll(ContactData.getData("email"));
        System.out.println(keyView);
        contacts.forEach((k,v)-> System.out.println(v));
        System.out.println("========================");

        List<Contact> list = new ArrayList<>(values);
           list.sort(Comparator.comparing(Contact::getNameLastFirst));
           list.forEach(c-> System.out.println(c.getNameLastFirst()+ ":"+ c));
        System.out.println("========================");

        Contact first = list.get(0);
        contacts.put(first.getNameLastFirst(),first);
            values.forEach(System.out::println);
        keyView.forEach(System.out::println);
        System.out.println("========================");

    HashSet<Contact> set = new HashSet<>(values);
    if (set.size()< contacts.keySet().size()){
        System.out.println("Duplicate key found");
    }
          var nodeSet = contacts.entrySet();
    for(var node : nodeSet){
        if (!node.getKey().equals(node.getValue().getName())){
            System.out.println("key doesn't match name "+node.getKey()+": "+node.getValue());
        }
    }
    }
}
