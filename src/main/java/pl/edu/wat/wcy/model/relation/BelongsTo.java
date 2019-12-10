package pl.edu.wat.wcy.model.relation;

import pl.edu.wat.wcy.model.CSVRow;
import pl.edu.wat.wcy.model.InsertQuery;

public class BelongsTo implements CSVRow, InsertQuery {

    private int id;

    private int collegeId;

    private int groupId;

    public BelongsTo(int id, int collegeId, int groupId) {
        this.id = id;
        this.collegeId = collegeId;
        this.groupId = groupId;
    }

    public int getId() {
        return id;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public int getGroupId() {
        return groupId;
    }

    @Override
    public String getHeader() {
        return "id,collegeId,groupId\n";
    }

    @Override
    public String toCSVRow() {
        return id + "," + collegeId + "," + groupId + "\n";
    }

    @Override
    public String toInsertQuery() {
        return "INSERT INTO belongs_to ($from_id, $to_id) VALUES " +
                "((SELECT $node_id FROM College WHERE id = " + collegeId + "), " +
                "(SELECT $node_id FROM [Group] WHERE id = " + groupId + "));";
    }

}
