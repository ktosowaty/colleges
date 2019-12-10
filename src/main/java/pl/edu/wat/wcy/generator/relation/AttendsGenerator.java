package pl.edu.wat.wcy.generator.relation;

import pl.edu.wat.wcy.model.node.Group;
import pl.edu.wat.wcy.model.node.Student;
import pl.edu.wat.wcy.model.relation.Attends;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AttendsGenerator {

    public List<Attends> generate(List<Student> students, List<Group> groups) {
        int id = 1;
        List<Attends> attendsList = new ArrayList<>();
        for (Student student : students) {
            int studentId = student.getId();
            int groupId = groups.get(ThreadLocalRandom.current().nextInt(0, groups.size())).getId();
            Attends attends = new Attends(id, studentId, groupId);
            attendsList.add(attends);
        }
        return attendsList;
    }

}
