package com.gb.adudarev.level2.lesson3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PhoneBook {

    private final HashMap<String, Set<Long>> phoneBook = new HashMap<>();

    public void addElement(String name, Long... phone) {
        Set<Long> phones = phoneBook.getOrDefault(name, new HashSet<>());
        phones.addAll(Arrays.asList(phone));
        phoneBook.put(name, phones);
    }

    public Set<Long> getPhones(String name) {
        return phoneBook.get(name);
    }

    public HashMap<String, Set<Long>> getPhoneBook() {
        return phoneBook;
    }
}
