package com.gb.adudarev.level3.lesson1;

import java.util.Collection;

public class ChangeArrayItems<T extends Collection> {

    private final T obj;

    public Object[] changeItem(int i, int j) {
        Object[] t = obj.toArray();
        Object k = t[i];
        t[i] = t[j];
        t[j] = k;
        return t;
    }

    public ChangeArrayItems(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }


}
