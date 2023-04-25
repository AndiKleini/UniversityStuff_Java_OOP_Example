package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final int EOF = -1;

    public static void main(String[] args) throws Exception {

        FileReader fileReader =
                new FileReader(
                        "C:\\sources\\PersonDemo\\src\\main\\java\\org\\example\\Students.txt");
        StringBuilder buildFileContent = new StringBuilder();
        try {
            int currentChar = 0;
            while((currentChar = fileReader.read()) != -1) {
                buildFileContent.append((char) currentChar);
            }
        } catch (IOException exception) {
            System.out.println(exception);
            throw exception;
        } finally  {
            fileReader.close();
        }

        String file = buildFileContent.toString();
        String[] lines = file.split("\r\n");

        List<Student> students = new ArrayList<>();
        for(String line: lines) {
            students.add(readStudentFromLine(line));
        }

        students.add(new Student("Hedwig Monster", 45, "wer345", "Physics"));

        FileWriter fileWriter = new FileWriter("./rewrittenStudents.txt");
        try {
            for(Student current: students) {
                fileWriter.write(current.represent() + "\n");
            }
        } catch (IOException exception) {
            System.out.println(exception);
            throw exception;
        } finally {
            fileWriter.close();
        }



        /*

        String studentLine = buildFileContent.toString().replace(';',' ');
        String[] splittedStudent = studentLine.split(",");
        System.out.println(String.format("Name -> %s", splittedStudent[0]));
        System.out.println(String.format("Age -> %s", splittedStudent[1].trim()));
        System.out.println(String.format("Id -> %s", splittedStudent[2]));
        System.out.println(String.format("Branch -> %s", splittedStudent[3]));

        Student myStudentFromFile =
                new Student(
                        splittedStudent[0],
                        Integer.parseInt(splittedStudent[1].trim()),
                        splittedStudent[2],
                        splittedStudent[3]);

        System.out.println(myStudentFromFile.represent());

        /*

        String inputString = "This is some kind of input string";
        OutputStreamWriter streamWriter =
                new OutputStreamWriter(
                    new FileOutputStream("./data.txt"));

        try {
            streamWriter.write(inputString);
        } catch (IOException exception) {
            System.out.println(exception.toString());
        } finally {
            streamWriter.close();
        }


        InputStreamReader reader =
                new InputStreamReader(
                        new FileInputStream("./data.txt"));
        StringBuilder fileInputBuilder = new StringBuilder();
        try {
            int currentChar;
            while ((currentChar = reader.read()) != EOF) {
                fileInputBuilder.append((char) currentChar);
            }
        } catch (IOException exception) {
            // TODO handle exception
        } finally {
            reader.close();
        }

        System.out.println(fileInputBuilder.toString());



        FileReader fileReader = new FileReader("./data.txt");
        StringBuilder buildFileContent = new StringBuilder();
        try {
            int currentChar = 0;
            while((currentChar = fileReader.read()) != -1) {
                buildFileContent.append((char) currentChar);
            }
        } catch (IOException exception) {

        } finally  {
            fileReader.close();
        }

        System.out.println(buildFileContent.toString());

        FileWriter fileWriter = new FileWriter("./output.txt");

        try {
            fileWriter.write("I am some string");
        } catch (IOException exception) {

        } finally {
            fileWriter.close();
        }

        

        Path file = Paths.get("anotherfile.txt");
        Files.writeString(file, "Erste Zeile\n");
        Files.writeString(file, "Zweite Zeile\n", StandardOpenOption.APPEND);
        String content = Files.readString(file);
        content.lines().forEach(System.out::println);

        /*
        List<UniversityStuff> personsOnTheUniversity = new ArrayList<>();

        personsOnTheUniversity.add(new Student("Daniel Kurz", 23, "231345", "IT"));
        personsOnTheUniversity.add(new Student("Peter Lang", 21, "2313567", "Embedded System"));
        personsOnTheUniversity.add(new Student("Stefanie Wurst", 19, "2123456", "Math"));
        personsOnTheUniversity.add(new Student("Katrin Berger", 20, "99891345", "Physics"));

        personsOnTheUniversity.add(new Teacher("Heinz Kunz", 42, "75478573543", "Math"));
        personsOnTheUniversity.add(new Teacher("Gerhard Grader", 56, "7325689", "Chemistry"));

        personsOnTheUniversity.add(new Assistance("Sabine Kemer", 26, "78437483"));

        personsOnTheUniversity.add(new ITWorker("Hansi Huber", 34, "28451088"));

        for (UniversityStuff universityPerson : personsOnTheUniversity) {
            System.out.println(universityPerson.represent());
        }

        UniversityStuff maxAged = null;
        Iterator<UniversityStuff> stepThrough = personsOnTheUniversity.iterator();
        while(stepThrough.hasNext()) {
            UniversityStuff current = stepThrough.next();
            if (maxAged == null || maxAged.getAge() < current.getAge()) {
                maxAged = current;
            }
        }
        System.out.println("Max age of university stuff is " + maxAged);

        personsOnTheUniversity.sort(null);
        for(UniversityStuff current : personsOnTheUniversity) {
            System.out.println(current.represent());
        }

        System.out.println("Sort by length of name");
        personsOnTheUniversity.sort(new NameLengthComparer());
        for(UniversityStuff current: personsOnTheUniversity) {
            System.out.println(current.represent());
        }

        File file = new File("C:\\sources\\PersonDemo\\src\\main\\java\\org\\example\\");
        // File file = new File(".\\resources\\myNewFile.txt");

        try {
            getCountryCodeFor(2);
            getCountryCodeFor(3);
            getCountryCodeFor(1);
        } catch(Exception ex) {
            System.out.println("Was raised");
            System.out.println(ex.getStackTrace());
        }


        /*
        System.out.println(String.format("The path is %s", file.getPath()));
        File[] files = file.listFiles();
        for(File currentFile: files) {
            System.out.println(String.format("%s", currentFile.getName()));
        }
        if (file.exists()) {
            System.out.println("The file exists");
        } else {
            System.out.println("The file does not exist");
            // file.createNewFile();
        }

         */
    }

    private static Student readStudentFromLine(String line) {
        String[] studentData = line.split(",");
        Student student =
                new Student(
                        studentData[0],
                        Integer.parseInt(studentData[1].trim()),
                        studentData[2],
                        studentData[3]
                );
        return student;
    }

    private static String getCountryCodeFor(Integer code) throws Exception {
        System.out.println("Get country code for " + code);
        switch(code) {
            case 1: {
                return "AT";
            }
            case 2: {
                return "DE";
            }
            default: throw new Exception(String.format("Invalid country code supplied /d", code));
        }
    }

    private static String createResult() throws Exception {
        throw new Exception("Invalid situation");
    }
}