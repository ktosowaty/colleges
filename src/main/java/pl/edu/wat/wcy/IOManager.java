package pl.edu.wat.wcy;

import pl.edu.wat.wcy.model.CSVRow;
import pl.edu.wat.wcy.model.InsertQuery;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class IOManager {

    public <T extends CSVRow> void saveToCsv(String filename, List<T> toSave) {
        try {
            FileWriter csvWriter = new FileWriter(filename);
            csvWriter.append(toSave.get(0).getHeader());
            for (T data : toSave) {
                csvWriter.append(data.toCSVRow());
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <T extends InsertQuery> void saveNodeToSql(String filename, String table, List<T> toSave) {
        try {
            FileWriter sqlWriter = new FileWriter(filename);
            sqlWriter.append("SET IDENTITY_INSERT ").append(table).append(" ON;\n");
            for (T data : toSave) {
                sqlWriter.append(data.toInsertQuery()).append("\n");
            }
            sqlWriter.append("SET IDENTITY_INSERT ").append(table).append(" OFF;\n");
            sqlWriter.flush();
            sqlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <T extends InsertQuery> void saveRelationToSql(String filename, List<T> toSave) {
        try {
            FileWriter sqlWriter = new FileWriter(filename);
            for (T data : toSave) {
                sqlWriter.append(data.toInsertQuery()).append("\n");
            }
            sqlWriter.flush();
            sqlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
