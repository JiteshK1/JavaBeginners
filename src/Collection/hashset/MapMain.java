package Collection.hashset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMain {
    public static void main(String[] args) {
        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.forEach(System.out::println);

        Map<String,Contact> contacts = new HashMap<>();

        for (Contact c:
             fullList) {
            contacts.put(c.getName(),c);
        }
        System.out.println("-------------------------------");
        contacts.forEach((k,v)-> System.out.println("key="+k +", value = "+ v));
        System.out.println("-------------------------------");
        System.out.println(contacts.get("Minnie Mouse")   );
        System.out.println("-------------------------------");
          contacts.clear();

        for (Contact c:
              fullList) {
            Contact duplicate = contacts.put(c.getName(), c);
            if (duplicate != null) {
//                System.out.println("duplicate = " + duplicate);
//                System.out.println("current = " + c);
             contacts.put(c.getName(), c.mergeContact(duplicate));

             }
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("-------------------------------");
       contacts.clear();
       for (Contact c : fullList){
           Contact duplicate = contacts.putIfAbsent(c.getName(),c);
           if (duplicate!=null){
               contacts.put(c.getName(),c.mergeContact(duplicate));
           }
       }

        System.out.println("-----------------------------");
        contacts.clear();
        fullList.forEach(contact -> contacts.merge(contact.getName(),contact,
                (pervious,current)->{
                    System.out.println("pervious "+pervious +" current "+current);
                    Contact merge = pervious.mergeContact(current);
                    System.out.println("merged "+ merge);
                    return merge;
                }
        ));
        System.out.println("-----------------------------");
        contacts.clear();
        fullList.forEach(contact -> contacts.merge(contact.getName(),contact,Contact::mergeContact));
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("-----------------------------");

        for (String contactName : new String[] {"Daisy Duck", "Daffy Duck",
                "Scrooge McDuck"}) {

            contacts.compute(contactName,(k,v)->new Contact(k));

        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("-----------------------------");
        System.out.println("-----------------------------");

        for (String contactName : new String[] {"Daisy Duck", "Daffy Duck",
                "Scrooge McDuck"}) {

            contacts.computeIfAbsent(contactName,(k)->new Contact(k));

        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));
        System.out.println("-----------------------------");

        for (String contactName : new String[] {"Daisy Duck", "Daffy Duck",
                "Scrooge McDuck"}) {

            contacts.computeIfPresent(contactName,(k,v)->{
                v.addEmail("Fun Place"); return v;
            });

        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));
        System.out.println("-----------------------------");
contacts.replaceAll((k,v)->{
    String newEmail= k.replaceAll(" ","")+"@funPlace.com";
    v.replaceEmailIfExists("DDuck@funplace.com",newEmail);
    return v;
});
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("-----------------------------");
        Contact daisy = new Contact("Daisy Jane DUck","daisyj@gmail.com");
        Contact replacedContact = contacts.replace("Daisy Duck",daisy);
        System.out.println("Daisy "+daisy);
        System.out.println("replacedContact "+replacedContact);
        System.out.println("-----------------------------");
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

    }

}
