package pl.edu.wat.wcy.model.relation;

import pl.edu.wat.wcy.model.CSVRow;
import pl.edu.wat.wcy.model.InsertQuery;

public class LivesStudent implements CSVRow, InsertQuery {

    private int id;

    private int studentId;

    private int addressId;

    public LivesStudent(int id, int studentId, int addressId) {
        this.id = id;
        this.studentId = studentId;
        this.addressId = addressId;
    }

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getAddressId() {
        return addressId;
    }

    @Override
    public String getHeader() {
        return "id,studentId,addressId\n";
    }

    @Override
    public String toCSVRow() {
        return id + "," + studentId + "," + addressId + "\n";
    }

    @Override
    public String toInsertQuery() {
        return "INSERT INTO lives_student ($from_id, $to_id) VALUES " +
                "((SELECT $node_id FROM Student WHERE id = " + studentId + "), " +
                "(SELECT $node_id FROM Address WHERE id = " + addressId + "));";
    }
}
