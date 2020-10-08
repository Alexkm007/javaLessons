package com.javarush.task.task37.task3707;

import java.io.Serializable;
import java.util.*;

public class AmigoSet <E> extends AbstractSet implements Serializable, Cloneable, Set {
    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection){
        int capacity = 16 > (int) Math.ceil(collection.size()/.75f) ? 16: (int) Math.ceil(collection.size() / .75f);
        map = new HashMap<>(capacity);
        for(E field:collection){
          add(field);
        }
    }

    public boolean add(Object e){
        try {
            return null==map.put((E) e,PRESENT);
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
