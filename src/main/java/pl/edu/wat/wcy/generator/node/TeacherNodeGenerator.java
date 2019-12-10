package pl.edu.wat.wcy.generator.node;

import pl.edu.wat.wcy.model.node.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TeacherNodeGenerator implements NodeGenerator<Teacher> {

    private String[] firstNames = {"Piotr", "Paweł", "Adam", "Zbigniew", "Jan", "Kamil"};

    private String[] lastNames = {"Nowak", "Kowalski", "Wiśniewski", "Wójcik", "Kowalczyk", "Kamiński"};

    @Override
    public List<Teacher> generate() {
        int id = 1;
        List<Teacher> teachers = new ArrayList<>();
        for (String firstName : firstNames) {
            for (String lastName : lastNames) {
                LocalDate birthDate = generateDate();
                String sex = "male";
                String degree = generateDegree();
                Teacher teacher = new Teacher(id, firstName, lastName, birthDate, sex, degree);
                teachers.add(teacher);
                id++;
            }
        }
        return teachers;
    }

    private LocalDate generateDate() {
        long minDay = LocalDate.of(1980, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(1990, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    private String generateDegree() {
        int number = ThreadLocalRandom.current().nextInt(1, 11);
        if (number <= 4) return "mgr inż.";
        else if (number == 9) return "dr";
        else if (number == 10) return "dr inż.";
        else return "mgr";
    }
}
