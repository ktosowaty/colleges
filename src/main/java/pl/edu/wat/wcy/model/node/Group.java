package pl.edu.wat.wcy.model.node;

import pl.edu.wat.wcy.model.CSVRow;
import pl.edu.wat.wcy.model.InsertQuery;

import java.time.LocalDate;

public class Group implements CSVRow, InsertQuery {

    private int id;

    private String number;

    private String fieldOfStudy;

    private LocalDate creationDate;

    private int semester;

    public Group(int id, String number, String fieldOfStudy, LocalDate creationDate, int semester) {
        this.id = id;
        this.number = number;
        this.fieldOfStudy = fieldOfStudy;
        this.creationDate = creationDate;
        this.semester = semester;
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public int getSemester() {
        return semester;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                ", creationDate=" + creationDate +
                ", semester=" + semester +
                '}';
    }

    @Override
    public String getHeader() {
        return "id,number,fieldOfStudy,creationDate,semester\n";
    }

    @Override
    public String toCSVRow() {
        return id + "," + number + "," + fieldOfStudy + "," + creationDate + "," + semester + "\n";
    }

    @Override
    public String toInsertQuery() {
        return "INSERT INTO [Group](id,number,fieldOfStudy,creationDate,semester) " +
                "VALUES (" + id + ",'" + number + "','" + fieldOfStudy + "','" + creationDate + "'," + semester + ");";
    }
}
