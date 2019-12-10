package pl.edu.wat.wcy;

import pl.edu.wat.wcy.generator.node.*;
import pl.edu.wat.wcy.generator.relation.*;
import pl.edu.wat.wcy.model.node.*;
import pl.edu.wat.wcy.model.relation.*;

import java.util.List;

public class App {

    public static void main(String[] args) {
        IOManager ioManager = new IOManager();

        List<College> colleges = new CollegeNodeGenerator().generate();
        List<Group> groups = new GroupNodeGenerator().generate();
        List<Student> students = new StudentNodeGenerator().generate();
        List<Teacher> teachers = new TeacherNodeGenerator().generate();
        List<Address> addresses = new AddressNodeGenerator().generate();

        ioManager.saveToCsv("src/main/resources/colleges.csv", colleges);
        ioManager.saveToCsv("src/main/resources/groups.csv", groups);
        ioManager.saveToCsv("src/main/resources/students.csv", students);
        ioManager.saveToCsv("src/main/resources/teachers.csv", teachers);
        ioManager.saveToCsv("src/main/resources/addresses.csv", addresses);

        List<Attends> attendsList = new AttendsGenerator().generate(students, groups);
        List<BelongsTo> belongsToList = new BelongsToGenerator().generate(colleges, groups);
        List<IsEstablished> isEstablishedList = new IsEstablishedGenerator().generate(colleges, addresses);
        List<Knows> knowsList = new KnowsGenerator().generate(students);
        List<LivesStudent> livesStudentList = new LivesStudentGenerator().generate(students, addresses);
        List<LivesTeacher> livesTeacherList = new LivesTeacherGenerator().generate(teachers, addresses);
        List<Teaches> teachesList = new TeachesGenerator().generate(teachers, groups);

        ioManager.saveToCsv("src/main/resources/attends.csv", attendsList);
        ioManager.saveToCsv("src/main/resources/belongsTo.csv", belongsToList);
        ioManager.saveToCsv("src/main/resources/isEstablished.csv", isEstablishedList);
        ioManager.saveToCsv("src/main/resources/knows.csv", knowsList);
        ioManager.saveToCsv("src/main/resources/livesStudent.csv", livesStudentList);
        ioManager.saveToCsv("src/main/resources/livesTeacher.csv", livesTeacherList);
        ioManager.saveToCsv("src/main/resources/teaches.csv", teachesList);

        ioManager.saveNodeToSql("src/main/resources/colleges.sql", "College", colleges);
        ioManager.saveNodeToSql("src/main/resources/groups.sql", "Group", groups);
        ioManager.saveNodeToSql("src/main/resources/students.sql", "Student", students);
        ioManager.saveNodeToSql("src/main/resources/teachers.sql", "Teacher", teachers);
        ioManager.saveNodeToSql("src/main/resources/addresses.sql", "Address", addresses);

        ioManager.saveRelationToSql("src/main/resources/attends.sql", attendsList);
        ioManager.saveRelationToSql("src/main/resources/belongsTo.sql", belongsToList);
        ioManager.saveRelationToSql("src/main/resources/isEstablished.sql", isEstablishedList);
        ioManager.saveRelationToSql("src/main/resources/knows.sql", knowsList);
        ioManager.saveRelationToSql("src/main/resources/livesStudent.sql", livesStudentList);
        ioManager.saveRelationToSql("src/main/resources/livesTeacher.sql", livesTeacherList);
        ioManager.saveRelationToSql("src/main/resources/teaches.sql", teachesList);

    }

}
