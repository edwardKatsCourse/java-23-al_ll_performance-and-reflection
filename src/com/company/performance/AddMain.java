package com.company.performance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddMain {

    static List<Person> arrayList = new ArrayList<>();
    static List<Person> linkedList = new LinkedList<>();

    public static void main(String[] args) {
	    //add by index          = insert (size + 1)
        //substitute by index   = set (same size)

        /**
         * ArrayList
         * (native) access by index - random access (arr[16])
         * based on a regular array
         *
         * LinkedList
         * sequential access (one by one)
         * Node -> Node -> Node
         *   0      1       2
         */

        /**
         * RESULTS
         * AL 5
         * LL 20
         *
         * AL is better for adding
         */

//        allLL();
        addAL();
    }

    private static void addAL() {
        long start = System.nanoTime();
        add(new ArrayList<>());
        long end = System.nanoTime();
        System.out.printf("ArrayList - add() 10M - %s%n", (end - start) / 1_000_000_000);
    }

    private static void allLL() {
        long start = System.nanoTime();
        add(new LinkedList<>());
        long end = System.nanoTime();
        System.out.printf("LinkedList - add() 10M - %s%n", (end - start) / 1_000_000_000);
    }

    private static void add(List<Person> personList) {
        for (int i = 0; i < 10_000_000; i++) {

            personList.add(new Person("abcdef", 1444));
        }
    }

}
