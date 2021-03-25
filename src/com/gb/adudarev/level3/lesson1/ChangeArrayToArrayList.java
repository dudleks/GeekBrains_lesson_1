package com.gb.adudarev.level3.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class ChangeArrayToArrayList<T> {

    public ArrayList<T> changeArray(T[] o) {
        return new ArrayList<T>(Arrays.asList(o));

    }
}
