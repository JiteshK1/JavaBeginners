package com.jitesh.collection.hashset;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactMain {
    public static void main(String[] args) {
        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");
        printList("Contact list",phones);
        printList("Email list",emails);

        Set<Contact> phoneContacts = new HashSet<>(phones);
        Set<Contact> emailContacts = new HashSet<>(emails);
        printList("SET Phone",phoneContacts);
        printList("SET Email",emailContacts);

        int index = emails.indexOf(new Contact("Robin Hood"));
         Contact robinHood = emails.get(index);
        robinHood.addEmail("Sherwood Forest");
        robinHood.replaceEmailIfExists("RHood@sherwoodforest.com",
                "RHood@sherwoodforest.org");
        System.out.println(robinHood);
        Set<Contact> unionAB = new HashSet<>();
        unionAB.addAll(phoneContacts);
        unionAB.addAll(emailContacts);
        printList("(A ∪ B) Union of emails (A) with phones (B)", unionAB);

        Set<Contact> intersectAB = new HashSet<>(emailContacts);
        intersectAB.retainAll(phoneContacts);
        printList("(A ∩ B) Intersect emails (A) and phones (B)",
                intersectAB);
        Set<Contact> intersectBA = new HashSet<>(phoneContacts);
        intersectBA.retainAll(emailContacts);
        printList("(B ∩ A) Intersect phones (B) and emails (A)",
                intersectBA);
        Set<Contact> AMinusB = new HashSet<>(emailContacts);
        AMinusB.removeAll(phoneContacts);
        printList("(A - B) emails (A) - phones (B)",
                AMinusB);

        Set<Contact> BMinusA = new HashSet<>(phoneContacts);
        BMinusA.removeAll(emailContacts);
        printList("(B - A) phones (B) - emails (A)",
                BMinusA);

        Set<Contact> symmetricDiff = new HashSet<>(AMinusB);
        symmetricDiff.addAll(BMinusA);
        printList("Symmetric Difference: phones and emails", symmetricDiff);

        Set<Contact> symmetricDiff2 = new HashSet<>(unionAB);
        symmetricDiff2.removeAll(intersectAB);
        printList("Symmetric Difference: phones and emails", symmetricDiff2);

    }

    public static void  printList(String headers,Collection<Contact> contacts ){

        System.out.println("-".repeat(35));
        System.out.println(headers);
        System.out.println("-".repeat(35));
         contacts.forEach(System.out::println);
    }


}
