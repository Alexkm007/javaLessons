package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
        return this.map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }
    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return this.map.remove(o) == PRESENT;
    }

    @Override
    public Object clone() throws InternalError {
        try {
            AmigoSet copy = (AmigoSet)super.clone();
            copy.map = (HashMap) map.clone();
            return copy;
        } catch (Exception e) {
            throw new InternalError(e);
        }
    }

    private void writeObject(ObjectOutputStream oos) throws Exception {
        oos.defaultWriteObject();

        oos.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        oos.writeFloat(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));
        oos.writeInt(map.size());

        for (E e : map.keySet()) oos.writeObject(e);



    }
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();

        int capacity = ois.readInt();
        float loadFactor = ois.readFloat();
        int size = ois.readInt();

        map = new HashMap<>(capacity,loadFactor);

        for (int i = 0; i < size; i++)
        {
            E e = (E) ois.readObject();
            map.put(e,PRESENT);
        }

    }

    @Override
    public boolean equals(Object o) {

        if ((o == null)||!(o instanceof AmigoSet )) return false;

        if (this.hashCode()!= ((AmigoSet)o).hashCode()) return false;
        AmigoSet<E> compare = (AmigoSet)o;
        if (this.map.size()!= compare.map.size()) return false;
        for (E e: map.keySet()){
            if (!compare.contains(e)) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return this.map.hashCode()*31+PRESENT.hashCode();
    }

    @Override
    public Object[] toArray() {
        return this.map.keySet().toArray();
    }


}
