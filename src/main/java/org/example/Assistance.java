package org.example;

public class Assistance extends UniversityStuff {

   public Assistance(String name, int age, String id) {
       super(name, age, id);
   }

    @Override
    public String getRole() {
        return "Secretary";
    }

    public void organize() {
        System.out.println("I am organizing a meeting !");
    }
}
