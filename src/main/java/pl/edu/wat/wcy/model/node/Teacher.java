package pl.edu.wat.wcy.model.node;

import pl.edu.wat.wcy.model.CSVRow;
import pl.edu.wat.wcy.model.InsertQuery;

import java.time.LocalDate;

public class Teacher implements CSVRow, InsertQuery {

    private int id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private String sex;

    private String degree;

    public Teacher(int id, String firstName, String lastName, LocalDate birthDate, String sex, String degree) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.sex = sex;
        this.degree = degree;
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

    public String getDegree() {
        return degree;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", sex='" + sex + '\'' +
                ", degree='" + degree + '\'' +
                '}';
    }

    @Override
    public String getHeader() {
        return "id,firstName,lastName,birthDate,sex,degree\n";
    }

    @Override
    public String toCSVRow() {
        return id + "," + firstName + "," + lastName + "," + birthDate + "," + sex + "," + degree + "\n";
    }

    @Override
    public String toInsertQuery() {
        return "INSERT INTO Teacher(id,firstName,lastName,birthDate,sex,degree) " +
                "VALUES (" + id + ",'" + firstName + "','" + lastName + "','" + birthDate + "','" + sex + "','" + degree + "');";
    }
}
