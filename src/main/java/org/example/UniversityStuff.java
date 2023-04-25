package org.example;

public abstract class UniversityStuff implements IPerson, Comparable<UniversityStuff> {

    private String name;
    private int age;
    private String id;

    protected UniversityStuff(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public abstract String getRole();

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getID() {
        return this.id;
    }

    public String represent() {
        return String.format(
                " I am %s and %s old . My role is %s.",
                this.name,
                this.age,
                this.getRole());
    }

    @Override
    public int compareTo(UniversityStuff toCompare) {
        return Integer.compare(this.age, toCompare.age);
    }
}
