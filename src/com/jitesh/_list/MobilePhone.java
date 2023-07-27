package com.jitesh._list;

import java.util.ArrayList;
 class  Contact{
    private String name;
     private String phoneNumber;

     public Contact(String name, String phoneNumber) {
         this.name = name;
         this.phoneNumber = phoneNumber;
     }

     public String getName() {
         return name;
     }

     public String getPhoneNumber() {
         return phoneNumber;
     }
     public static Contact createContact(String name, String phoneNumber){
         return  new Contact(name,phoneNumber);
     }
 }
public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String phoneNumber) {
        this.myNumber = phoneNumber;
        this.myContacts = new ArrayList<>();
    }
    public boolean addNewContact(Contact contact){
        if (findContact(contact)!=-1){
            return false;
        }else {
            return myContacts.add(contact);
        }
    }

//    public boolean updateContact(Contact oldContact,Contact newContact){
//
//    }
    public int findContact(Contact contact){
          return findContact(contact.getName());
    }
    public  int findContact(String contactName){
        for (int i = 0; i < myContacts.size(); i++) {
         Contact contact = myContacts.get(i);
        if (contact.getName().equals(contactName)) return i;
        }
return -1;
    }
    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            System.out.println(i+1 + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }

}
