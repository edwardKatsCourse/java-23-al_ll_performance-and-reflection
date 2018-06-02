package com.company.performance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GetPerson {

    static List<Person> arrayList;
    static List<Person> linkedList;

    public static void main(String[] args) {
        /**
         * RESULTS:
         * getBeginning()
         * AL 0
         * LL 0
         *
         * getMiddle()
         * AL 0
         * LL
         *
         * getEnd()
         * AL 0
         * LL 0
         *
         * ArrayList is better for getting from the middle, the start and the end
         * LinkedList is better for getting from the start and the end
         */
        init();
        beginningTest();
        endTest();
    }


    private static void beginningTest() {

        long start = System.nanoTime();
        System.out.println("ArrayList: getBeginning()");
        getBeginning(arrayList);
        long end = System.nanoTime();
        System.out.printf("ArrayList: getBeginning() - %s\n", (end - start) / 1_000_000_000);

        start = System.nanoTime();
        System.out.println("LinkedList: getBeginning()");
        getBeginning(linkedList);
        end = System.nanoTime();
        System.out.printf("LinkedList: getBeginning() - %s\n", (end - start) / 1_000_000_000);
    }
    private static void middleTest() {
        long start = System.nanoTime();
        System.out.println("ArrayList: getMiddle()");
        getMiddle(arrayList);
        long end = System.nanoTime();
        System.out.printf("ArrayList: getMiddle() - %s\n", (end - start) / 1_000_000_000);

        start = System.nanoTime();
        System.out.println("LinkedList: getMiddle()");
        getMiddle(linkedList);
        end = System.nanoTime();
        System.out.printf("LinkedList: getMiddle() - %s\n", (end - start) / 1_000_000_000);
    }
    private static void endTest() {
        long start = System.nanoTime();
        System.out.println("ArrayList: getEnd()");
        getEnd(arrayList);
        long end = System.nanoTime();
        System.out.printf("ArrayList: getEnd() - %s\n", (end - start) / 1_000_000_000);

        start = System.nanoTime();
        System.out.println("LinkedList: getEnd()");
        getEnd(linkedList);
        end = System.nanoTime();
        System.out.printf("LinkedList: getEnd() - %s\n", (end - start) / 1_000_000_000);
    }

    private static void getBeginning(List<Person> personList) {
        for (int i = 0; i < 1_000_000; i++) {
            personList.get(0);
        }
    }
    private static void getMiddle(List<Person> personList) {
        for (int i = 0; i < 1_000_000; i++) {

            int middleIndex = personList.size() / 2;
            personList.get(middleIndex);
        }
    }
    private static void getEnd(List<Person> personList) {
        for (int i = 0; i < 1_000_000; i++) {
            personList.get(personList.size() -1);
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
