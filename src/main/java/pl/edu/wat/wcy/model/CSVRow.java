package pl.edu.wat.wcy.model;

import java.lang.reflect.Field;

public interface CSVRow {

    String toCSVRow();

    default String getHeader() {
        StringBuilder toReturn = new StringBuilder();
        for (Field field : this.getClass().getFields()) {
            toReturn.append(field.getName()).append(",");
        }
        return toReturn.substring(0, toReturn.length() - 1) + "\n";
    }

}
