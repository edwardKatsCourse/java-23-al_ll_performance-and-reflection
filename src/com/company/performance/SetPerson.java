package com.company.performance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SetPerson {

    static List<Person> arrayList;
    static List<Person> linkedList;

    public static void main(String[] args) {
        /**
         * RESULTS
         *
         * setBeginning()
         * AL 5
         * LL 5
         *
         * setMiddle()
         * AL 0
         * LL 2m 12s
         *
         * setEnd()
         * AL 5
         * LL 5
         *
         * AL is good for setting to the middle
         * LL is good for setting to the beginning and the end
         */

        beginningTest();
    }

    private static void beginningTest() {
        init();
        long start = System.nanoTime();
        System.out.println("ArrayList: setBeginning()");
        setBeginning(arrayList);
        long end = System.nanoTime();
        System.out.printf("ArrayList: setBeginning() - 1M - %s\n",
                (end - start) / 1_000_000_000);




//        System.out.println("LinkedList: setBeginning()");
//        long start = System.nanoTime();
//        setBeginning(linkedList);
//        long end = System.nanoTime();
//        System.out.printf("LinkedList: setBeginning() - 1M - %s\n",
//                (end - start) / 1_000_000_000);

    }

    private static void middleTest() {
        init();


        long start = System.nanoTime();
        System.out.println("ArrayList: setMiddle()");
        setMiddle(arrayList);
        long end = System.nanoTime();
        System.out.printf("ArrayList: setMiddle() - 10K - %s\n",
                (end - start) / 1_000_000_000);




        System.out.println("LinkedList: setMiddle()");
        start = System.nanoTime();
        setMiddle(linkedList);
        end = System.nanoTime();
        System.out.printf("LinkedList: setMiddle() - 10K - %s\n",
                (end - start) / 1_000_000_000);
    }

    private static void endTest() {
        init();
        long start = System.nanoTime();
        System.out.println("ArrayList: setEnd()");
        setEnd(arrayList);
        long end = System.nanoTime();
        System.out.printf("ArrayList: setEnd() - 10M - %s\n",
                (end - start) / 1_000_000_000);




//        System.out.println("LinkedList: setEnd()");
//        long start = System.nanoTime();
//
//        setEnd(linkedList);
//        long end = System.nanoTime();
//        System.out.printf("LinkedList: setEnd() - 10M - %s\n",
//                (end - start) / 1_000_000_000);
    }

    private static void setEnd(List<Person> personList) {
        for (int i = 0; i < 10_000_000; i++) {
            int endIndex = personList.size() - 1;
            personList.set(endIndex, new Person("asdasd", 13123));
        }
    }

    private static void setMiddle(List<Person> personList) {
        for (int i = 0; i < 10_000; i++) {
            int middleIndex = personList.size() / 2;
            personList.set(middleIndex, new Person("asdasd", 14121));
        }
    }

    private static void setBeginning(List<Person> personList) {
        for (int i = 0; i < 1_000_000; i++) {
            personList.set(0, new Person("asdasd", 1213));
        }
    }


    private static void init() {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();

        for (int i = 0; i < 3_000_000; i++) {
            Person person = new Person("1knasjkd", 14124);
            arrayList.add(person);
            linkedList.add(person);
        }
    }
}
