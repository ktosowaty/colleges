package pl.edu.wat.wcy.generator.relation;

import pl.edu.wat.wcy.model.node.Address;
import pl.edu.wat.wcy.model.node.College;
import pl.edu.wat.wcy.model.relation.IsEstablished;

import java.util.ArrayList;
import java.util.List;

public class IsEstablishedGenerator {

    public List<IsEstablished> generate(List<College> colleges, List<Address> addresses) {
        List<IsEstablished> isEstablishedList = new ArrayList<>();
        int id = 1;
        for (College college : colleges) {
            int collegeId = college.getId();
            int addressId = addresses.get(id - 1).getId();
            IsEstablished isEstablished = new IsEstablished(id, collegeId, addressId);
            isEstablishedList.add(isEstablished);
            id++;
        }
        return isEstablishedList;
    }

}
