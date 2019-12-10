package pl.edu.wat.wcy.model.relation;

import pl.edu.wat.wcy.model.CSVRow;
import pl.edu.wat.wcy.model.InsertQuery;

public class LivesTeacher implements CSVRow, InsertQuery {

    private int id;

    private int teacherId;

    private int addressId;

    public LivesTeacher(int id, int teacherId, int addressId) {
        this.id = id;
        this.teacherId = teacherId;
        this.addressId = addressId;
    }

    public int getId() {
        return id;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public int getAddressId() {
        return addressId;
    }

    @Override
    public String getHeader() {
        return "id,teacherId,addressId\n";
    }

    @Override
    public String toCSVRow() {
        return id + "," + teacherId + "," + addressId + "\n";
    }

    @Override
    public String toInsertQuery() {
        return "INSERT INTO lives_teacher ($from_id, $to_id) VALUES " +
                "((SELECT $node_id FROM Teacher WHERE id = " + teacherId + "), " +
                "(SELECT $node_id FROM Address WHERE id = " + addressId + "));";
    }
}
