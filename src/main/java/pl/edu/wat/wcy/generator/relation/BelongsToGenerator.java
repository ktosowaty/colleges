package pl.edu.wat.wcy.generator.relation;

import pl.edu.wat.wcy.model.node.College;
import pl.edu.wat.wcy.model.node.Group;
import pl.edu.wat.wcy.model.relation.BelongsTo;

import java.util.ArrayList;
import java.util.List;

public class BelongsToGenerator {

    public List<BelongsTo> generate(List<College> colleges, List<Group> groups) {
        List<BelongsTo> belongsToList = new ArrayList<>();
        int id = 1;
        for (College college : colleges) {
            int collegeId = college.getId();
            for (int i = (collegeId - 1) * 12; i < collegeId * 12; i++) {
                int groupId = groups.get(i).getId();
                BelongsTo belongsTo = new BelongsTo(id, collegeId, groupId);
                belongsToList.add(belongsTo);
                id++;
            }
        }
        return belongsToList;
    }

}
