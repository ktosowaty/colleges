package pl.edu.wat.wcy.generator.relation;

import pl.edu.wat.wcy.model.node.Student;
import pl.edu.wat.wcy.model.relation.Knows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class KnowsGenerator {

    public List<Knows> generate(List<Student> students) {
        List<Knows> knowsList = new ArrayList<>();
        int id = 1;
        for (Student student : students) {
            int student1Id = student.getId();
            for (int i = 0; i < 10; i++) {
                int student2Id = students.get(ThreadLocalRandom.current().nextInt(0, students.size())).getId();
                LocalDate since = generateDate();
                Knows knows = new Knows(id, student1Id, student2Id, since);
                knowsList.add(knows);
                id++;
            }
        }

        return knowsList;
    }

    private LocalDate generateDate() {
        long minDay = LocalDate.of(2010, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2018, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }

}
