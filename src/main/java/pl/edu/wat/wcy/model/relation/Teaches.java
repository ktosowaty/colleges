package pl.edu.wat.wcy.model.relation;

import pl.edu.wat.wcy.model.CSVRow;
import pl.edu.wat.wcy.model.InsertQuery;

public class Teaches implements CSVRow, InsertQuery {

    private int id;

    private int teacherId;

    private int groupId;

    private String subject;

    private int hours;

    public Teaches(int id, int teacherId, int groupId, String subject, int hours) {
        this.id = id;
        this.teacherId = teacherId;
        this.groupId = groupId;
        this.subject = subject;
        this.hours = hours;
    }

    public int getId() {
        return id;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public int getGroupId() {
        return groupId;
    }

    public String getSubject() {
        return subject;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public String getHeader() {
        return "id,teacherId,groupId,subject,hours\n";
    }

    @Override
    public String toCSVRow() {
        return id + "," + teacherId + "," + groupId + "," + subject + "," + hours + "\n";
    }

    @Override
    public String toInsertQuery() {
        return "INSERT INTO teaches ($from_id, $to_id, subject, hours) VALUES " +
                "((SELECT $node_id FROM Teacher WHERE id = " + teacherId + "), " +
                "(SELECT $node_id FROM [Group] WHERE id = " + groupId + "), '" + subject + "', " + hours + ");";
    }
}
