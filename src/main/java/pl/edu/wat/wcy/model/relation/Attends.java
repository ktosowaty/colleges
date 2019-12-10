package pl.edu.wat.wcy.model.relation;

import pl.edu.wat.wcy.model.CSVRow;
import pl.edu.wat.wcy.model.InsertQuery;

public class Attends implements CSVRow, InsertQuery {

    private int id;

    private int studentId;

    private int groupId;

    public Attends(int id, int studentId, int groupId) {
        this.id = id;
        this.studentId = studentId;
        this.groupId = groupId;
    }

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getGroupId() {
        return groupId;
    }

    @Override
    public String getHeader() {
        return "id,studentId,groupId\n";
    }

    @Override
    public String toCSVRow() {
        return id + "," + studentId + "," + groupId + "\n";
    }


    @Override
    public String toInsertQuery() {
        return "INSERT INTO attends ($from_id, $to_id) VALUES " +
                "((SELECT $node_id FROM Student WHERE id = " + studentId + "), " +
                "(SELECT $node_id FROM [Group] WHERE id = " + groupId + "));";
    }
}
