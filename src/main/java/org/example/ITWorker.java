package org.example;

public class ITWorker extends UniversityStuff {

    public ITWorker(String name, int age, String id) {
        super(name, age, id);
    }

    @Override
    public String getRole() {
        return "IT Worker";
    }
}
