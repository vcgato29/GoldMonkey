package com.pesegato.goldmonkey;

import model.builders.Builder;
import model.builders.definitions.DefElement;
import model.builders.definitions.Definition;

public class StringBuilder extends Builder {

    private static final String STRING = "String";

    String value;

    public StringBuilder(Definition def) {
        super(def);
        for (DefElement de : def.getElements()) {
            switch (de.name) {
                case STRING:
                    value = de.getVal();
                    break;
            }
        }
    }

    public String buildString() {
        return value;
    }

    @Override
    public void readFinalizedLibrary() {
    }

}
