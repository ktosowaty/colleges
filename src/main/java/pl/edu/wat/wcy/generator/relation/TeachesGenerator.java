package pl.edu.wat.wcy.generator.relation;

import pl.edu.wat.wcy.model.node.Group;
import pl.edu.wat.wcy.model.node.Teacher;
import pl.edu.wat.wcy.model.relation.Teaches;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TeachesGenerator {

    private String[] subjects = {"Filozofia", "Etyka", "Ekonomia", "Analiza matematyczna", "Fizyka"};

    public List<Teaches> generate(List<Teacher> teachers, List<Group> groups) {
        int id = 1;
        List<Teaches> teachesList = new ArrayList<>();
        for (Teacher teacher : teachers) {
            int teacherId = teacher.getId();
            String subject = subjects[ThreadLocalRandom.current().nextInt(0, subjects.length)];
            int groupsToTeach = ThreadLocalRandom.current().nextInt(1, 4);
            for (int i = 0; i < groupsToTeach; i++) {
                int groupId = ThreadLocalRandom.current().nextInt(0, groups.size());
                int hours = 2 * ThreadLocalRandom.current().nextInt(5, 31);
                Teaches teaches = new Teaches(id, teacherId, groupId, subject, hours);
                teachesList.add(teaches);
                id++;
            }
        }
        return teachesList;
    }

}
