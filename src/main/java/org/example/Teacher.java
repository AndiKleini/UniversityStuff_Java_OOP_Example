package org.example;

public class Teacher extends UniversityStuff {

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    private String faculty;

    public Teacher(String name, int age, String id, String faculty) {
        super(name, age, id);
        this.faculty = faculty;
    }

    @Override
    public String getRole() {
        return "Professor";
    }

    @Override
    public String represent() {
        return super.represent() + String.format("I am employed at %s", this.faculty);
    }

    public void teach() {
        System.out.println("I am teaching !");
    }
}
