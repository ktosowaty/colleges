package pl.edu.wat.wcy.model.relation;

import pl.edu.wat.wcy.model.CSVRow;
import pl.edu.wat.wcy.model.InsertQuery;

public class IsEstablished implements CSVRow, InsertQuery {

    private int id;

    private int collegeId;

    private int addressId;

    public IsEstablished(int id, int collegeId, int addressId) {
        this.id = id;
        this.collegeId = collegeId;
        this.addressId = addressId;
    }

    public int getId() {
        return id;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public int getAddressId() {
        return addressId;
    }

    @Override
    public String getHeader() {
        return "id,collegeId,addressId\n";
    }

    @Override
    public String toCSVRow() {
        return id + "," + collegeId + "," + addressId + "\n";
    }

    @Override
    public String toInsertQuery() {
        return "INSERT INTO is_established ($from_id, $to_id) VALUES " +
                "((SELECT $node_id FROM College WHERE id = " + collegeId + "), " +
                "(SELECT $node_id FROM Address WHERE id = " + addressId + "));";
    }
}
