package pl.edu.wat.wcy.model.relation;

import pl.edu.wat.wcy.model.CSVRow;
import pl.edu.wat.wcy.model.InsertQuery;

import java.time.LocalDate;

public class Knows implements CSVRow, InsertQuery {

    private int id;

    private int student1Id;

    private int student2Id;

    private LocalDate since;

    public Knows(int id, int student1Id, int student2Id, LocalDate since) {
        this.id = id;
        this.student1Id = student1Id;
        this.student2Id = student2Id;
        this.since = since;
    }

    public int getId() {
        return id;
    }

    public int getStudent1Id() {
        return student1Id;
    }

    public int getStudent2Id() {
        return student2Id;
    }

    public LocalDate getSince() {
        return since;
    }

    @Override
    public String getHeader() {
        return "id,student1Id,student2Id,since\n";
    }

    @Override
    public String toCSVRow() {
        return id + "," + student1Id + "," + student2Id + "," + since + "\n";
    }

    @Override
    public String toInsertQuery() {
        return "INSERT INTO knows ($from_id, $to_id, since) VALUES " +
                "((SELECT $node_id FROM Student WHERE id = " + student1Id + "), " +
                "(SELECT $node_id FROM Student WHERE id = " + student2Id + "), '" + since + "');";
    }
}
