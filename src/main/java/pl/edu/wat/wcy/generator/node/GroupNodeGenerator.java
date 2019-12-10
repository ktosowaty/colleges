package pl.edu.wat.wcy.generator.node;

import pl.edu.wat.wcy.model.node.Group;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GroupNodeGenerator implements NodeGenerator<Group> {

    private String[] unis = {"P", "U", "S"};

    private String[] fieldsOfStudies = {"Informatyka", "Zarządzanie"};

    @Override
    public List<Group> generate() {
        List<Group> groups = new ArrayList<>();
        int id = 1;
        for (int i = 0; i < unis.length; i++) {
            for (int j = 2017; j <= 2019; j++) {
                LocalDate creationDate = LocalDate.of(j, 10, 1);
                int semester = 2 * (2019 - j) + 1;
                for (int k = 0; k < fieldsOfStudies.length; k++) {
                    String fieldOfStudy = fieldsOfStudies[k];
                    for (int l = 1; l <= 2; l++) {
                        String number = unis[i] + fieldOfStudy.charAt(0) + String.valueOf(j).charAt(3) + "N" + l;
                        Group group = new Group(id, number, fieldOfStudy, creationDate, semester);
                        groups.add(group);
                        id++;
                    }
                }
            }
        }
        return groups;
    }
}
