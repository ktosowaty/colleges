package pl.edu.wat.wcy.generator.node;

import java.util.List;

public interface NodeGenerator<T> {

    List<T> generate();

}
