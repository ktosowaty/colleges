package pl.edu.wat.wcy.generator.node;

import pl.edu.wat.wcy.model.node.College;

import java.util.ArrayList;
import java.util.List;

public class CollegeNodeGenerator implements NodeGenerator<College> {

    private List<String> names;
    private List<String> types;

    public CollegeNodeGenerator() {
        this.names = getNames();
        this.types = getTypes();
    }

    private List<String> getNames() {
        List<String> names = new ArrayList<>();
        names.add("Politechnika Warszawska");
        names.add("Uniwersytet Warszawski");
        names.add("Szkoła Główna Handlowa");
        return names;
    }

    private List<String> getTypes() {
        List<String> names = new ArrayList<>();
        names.add("techniczna");
        names.add("uniwersytet");
        names.add("ekonomiczna");
        return names;
    }

    @Override
    public List<College> generate() {
        List<College> colleges = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            College college = new College(i + 1, names.get(i), types.get(i));
            colleges.add(college);
        }
        return colleges;
    }

}
