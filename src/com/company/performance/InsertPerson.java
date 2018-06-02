package com.company.performance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InsertPerson {

    static List<Person> arrayList;
    static List<Person> linkedList;

    public static void main(String[] args) {

        /**
         * Results
         *
         * INSERT BEGINNING:
         * AL 2s
         * LL 0s
         *
         * INSERT MIDDLE:
         * AL - 1s
         * LL - 33s
         *
         * INSERT END:
         * AL 12s
         * LL 32s
         *
         * AL is better for insert to the middle and to the end
         * LL is better for insert to the beginning
         */

        insertEndTestAL();

    }

    private static void insertBeginningTestAL() {
        init();
        long start = System.nanoTime();
        System.out.println("ArrayList: insertListBeginning()");
        insertListBeginning(arrayList);
        long end = System.nanoTime();
        System.out.printf("ArrayList: insertListBeginning() - 1K - %s\n",
                (end - start) / 1_000_000_000);

    }

    private static void insertBeginningTestLL() {
        init();
        long start = System.nanoTime();
        System.out.println("LinkedList: insertListBeginning()");
        insertListBeginning(linkedList);
        long end = System.nanoTime();
        System.out.printf("LinkedList: insertListBeginning() - 1K - %s\n",
                (end - start) / 1_000_000_000);

    }

    private static void insertEndTestAL() {
        init();
        long start = System.nanoTime();
        System.out.println("ArrayList: insertListEnd()");
        insertListEnd(arrayList);
        long end = System.nanoTime();
        System.out.printf("ArrayList: insertListEnd() - 20M - %s\n",
                (end - start) / 1_000_000_000);


    }

    private static void insertEndTestLL() {
        init();
        long start = System.nanoTime();
        System.out.println("LinkedList: insertListEnd()");
        insertListEnd(linkedList);
        long end = System.nanoTime();
        System.out.printf("LinkedList: insertListEnd() - 20M - %s\n",
                (end - start) / 1_000_000_000);
    }

    private static void insertMiddleTestAL() {
        init();
        long start = System.nanoTime();
        System.out.println("ArrayList: insertListMiddle()");
        insertListMiddle(arrayList);
        long end = System.nanoTime();
        System.out.printf("ArrayList: insertListMiddle() - 1K - %s\n",
                (end - start) / 1_000_000_000);

    }

    private static void insertMiddleTestLL() {
        init();
        long start = System.nanoTime();
        System.out.println("LinkedList: insertListMiddle()");
        insertListMiddle(linkedList);
        long end = System.nanoTime();
        System.out.printf("LinkedList: insertListMiddle() - 1K - %s\n",
                (end - start) / 1_000_000_000);
    }

    private static void init() {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
        for (int i = 0; i < 3_000_000; i++) {
            arrayList.add(new Person("asdasdasd", 12312412));
            linkedList.add(new Person("asdasdasd", 12312412));
        }
    }

    private static void insertListBeginning(List<Person> personList) {
        for (int i = 0; i < 1000; i++) {
            personList.add(0, new Person("kjahsdjk", 14124));
        }
    }

    private static void insertListMiddle(List<Person> personList) {

        for (int i = 0; i < 1000; i++) {

            int middleIndex = personList.size() / 2;
            personList.add(middleIndex, new Person("asdasd", 9878));
        }
    }

    private static void insertListEnd(List<Person> personList) {
        for (int i = 0; i < 20_000_000; i++) {

            int endIndex = personList.size() - 1;
            personList.add(endIndex, new Person("kjhjkashd", 1312));
        }
    }
}
