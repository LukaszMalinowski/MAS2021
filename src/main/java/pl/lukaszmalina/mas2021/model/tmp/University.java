package pl.lukaszmalina.mas2021.model.tmp;

import java.util.HashMap;
import java.util.Map;

public class University {

    Map<String, Student> students = new HashMap<>();


    public Student getStudentByIndexNumber(String indexNumber) {
        return students.get(indexNumber);
    }

    public void addStudent(String indexNumber, Student student) {
        students.put(indexNumber, student);
    }
}
