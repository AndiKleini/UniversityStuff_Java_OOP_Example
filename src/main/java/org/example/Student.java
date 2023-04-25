package org.example;

public class Student extends UniversityStuff {

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBranch() {
        return branch;
    }

    private String branch;

    public Student(String name, int age, String id, String branch) {
        super(name, age, id);
        this.branch = branch;
    }

    @Override
    public String represent() {
        return super.represent() + String.format("I am doing %s." , this.branch);
    }

    @Override
    public String getRole() {
        return "Student";
    }

    public void learn() {
        System.out.println("I am learning !");
    }
}
