package org.example;

import java.util.Comparator;

public class NameLengthComparer implements Comparator<UniversityStuff> {

    @Override
    public int compare(UniversityStuff left, UniversityStuff right) {
        return Integer.compare(left.getName().length(), right.getName().length());
    }
}
