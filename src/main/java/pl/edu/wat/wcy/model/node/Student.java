package pl.edu.wat.wcy.model.node;

import pl.edu.wat.wcy.model.CSVRow;
import pl.edu.wat.wcy.model.InsertQuery;

import java.time.LocalDate;

public class Student implements CSVRow, InsertQuery {

    private int id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private String sex;

    private int studentCardNumber;

    public Student(int id, String firstName, String lastName, LocalDate birthDate, String sex, int studentCardNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.sex = sex;
        this.studentCardNumber = studentCardNumber;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getSex() {
        return sex;
    }

    public int getStudentCardNumber() {
        return studentCardNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", sex='" + sex + '\'' +
                ", studentCardNumber=" + studentCardNumber +
                '}';
    }

    @Override
    public String getHeader() {
        return "id,firstName,lastName,birthDate,sex,studentCardNumber\n";
    }

    @Override
    public String toCSVRow() {
        return id + "," + firstName + "," + lastName + "," + birthDate + "," + sex + "," + studentCardNumber + "\n";
    }

    @Override
    public String toInsertQuery() {
        return "INSERT INTO Student(id,firstName,lastName,birthDate,sex,studentCardNumber) " +
                "VALUES (" + id + ",'" + firstName + "','" + lastName + "','" + birthDate + "','" + sex + "'," + studentCardNumber + ");";
    }
}
