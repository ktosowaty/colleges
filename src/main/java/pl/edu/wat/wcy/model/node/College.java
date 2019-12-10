package pl.edu.wat.wcy.model.node;

import pl.edu.wat.wcy.model.CSVRow;
import pl.edu.wat.wcy.model.InsertQuery;

public class College implements CSVRow, InsertQuery {

    private int id;

    private String name;

    private String type;

    public College(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "College{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public String getHeader() {
        return "id,name,type\n";
    }

    @Override
    public String toCSVRow() {
        return id + "," + name + "," + type + "\n";
    }

    @Override
    public String toInsertQuery() {
        return "INSERT INTO College(id,name,type) " +
                "VALUES (" + id + ",'" + name + "','" + type + "');";
    }
}
