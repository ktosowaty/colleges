package pl.edu.wat.wcy.generator.node;

import pl.edu.wat.wcy.model.node.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class StudentNodeGenerator implements NodeGenerator<Student> {

    private String[] firstNamesMale = {"Piotr", "Paweł", "Adam", "Zbigniew", "Jan", "Kamil", "Damian",
            "Mariusz", "Stefan", "Tomasz"};

    private String[] firstNamesFemale = {"Paulina", "Monika", "Aleksandra", "Kinga", "Karolina", "Joanna", "Martyna",
            "Dominika", "Sylwia", "Danuta"};

    private String[] lastNames = {"Nowak", "Kowalski", "Wiśniewski", "Wójcik", "Kowalczyk", "Kamiński",
            "Lewandowski", "Zieliński", "Szymański", "Woźniak", "Dąbrowski", "Kozłowski", "Grabowski",
            "Jankowski", "Mazur", "Wojciechowski", "Kwiatkowski", "Krawczyk", "Kaczmarek", "Wysocki"};

    @Override
    public List<Student> generate() {
        List<Student> students = new ArrayList<>();
        int id = 1;
        int studentCardNumber = 72612;
        for (String lastName : lastNames) {
            for (String firstNameMale : firstNamesMale) {
                LocalDate birthDate = generateDate();
                Student student = new Student(id, firstNameMale, lastName, birthDate, "male", studentCardNumber);
                students.add(student);
                id++;
                studentCardNumber++;
            }
            for (String firstNameFemale : firstNamesFemale) {
                LocalDate birthDate = generateDate();
                String femaleLaseName = lastName;
                if (femaleLaseName.endsWith("i")) femaleLaseName = femaleLaseName.substring(0, femaleLaseName.length() - 1) + "a";
                Student student = new Student(id, firstNameFemale, femaleLaseName, birthDate, "female", studentCardNumber);
                students.add(student);
                id++;
                studentCardNumber++;
            }
        }
        return students;
    }

    private LocalDate generateDate() {
        long minDay = LocalDate.of(1995, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(1997, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }
}
