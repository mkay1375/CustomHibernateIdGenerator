package ir.mkay.customidgenerator;

import java.io.Serializable;

public interface Identifiable<T extends Serializable> {

    T getId();

}
