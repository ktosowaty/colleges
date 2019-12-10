package pl.edu.wat.wcy.generator.relation;

import pl.edu.wat.wcy.model.node.Address;
import pl.edu.wat.wcy.model.node.Teacher;
import pl.edu.wat.wcy.model.relation.LivesTeacher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LivesTeacherGenerator {

    public List<LivesTeacher> generate(List<Teacher> teachers, List<Address> addresses) {
        List<LivesTeacher> livesTeacherList = new ArrayList<>();
        int id = 1;
        for (Teacher teacher : teachers) {
            int teacherId = teacher.getId();
            int addressId = addresses.get(ThreadLocalRandom.current().nextInt(3, addresses.size())).getId();
            LivesTeacher livesTeacher = new LivesTeacher(id, teacherId, addressId);
            livesTeacherList.add(livesTeacher);
            id++;
        }
        return livesTeacherList;
    }

}
