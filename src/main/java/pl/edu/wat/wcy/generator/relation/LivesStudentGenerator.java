package pl.edu.wat.wcy.generator.relation;

import pl.edu.wat.wcy.model.node.Address;
import pl.edu.wat.wcy.model.node.Student;
import pl.edu.wat.wcy.model.relation.LivesStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LivesStudentGenerator {

    public List<LivesStudent> generate(List<Student> students, List<Address> addresses) {
        List<LivesStudent> livesStudentList = new ArrayList<>();
        int id = 1;
        for (Student student : students) {
            int studentId = student.getId();
            int addressId = addresses.get(ThreadLocalRandom.current().nextInt(3, addresses.size())).getId();
            LivesStudent livesStudent = new LivesStudent(id, studentId, addressId);
            livesStudentList.add(livesStudent);
            id++;
        }
        return livesStudentList;
    }

}
