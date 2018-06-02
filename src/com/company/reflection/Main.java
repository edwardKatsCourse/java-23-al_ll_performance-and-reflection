package com.company.reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        /**
         * HUMAN
         *
         * LEG
         * ARM -> HAND
         * HEAD
         * NECK
         * ...
         *
         *
         * Person (any class)
         * Class
         * Method
         * Field
         */

        //Person.class -> Class<Person>

        Class<?> personClass = Class.forName("com.company.reflection.Person");
        Method setAge = personClass.getMethod("myCustomMethod",
                Integer.class,
                String.class,
                Person.class);


//        System.out.println(Arrays.toString(setAge.getParameterTypes()));

        for (Method m : personClass.getMethods()) {
            if (m.getName().equals("myCustomMethod")) {

                System.out.println(m.getName());
                System.out.println(Arrays.toString(m.getParameterTypes()));

                System.out.println();
            }
        }

        System.out.println("Fieldsss!");

        for (Field field : personClass.getDeclaredFields()) {
            String modifier = Modifier.toString(field.getModifiers());
            String typeName = field.getType().getSimpleName();
            String variableName = field.getName();
            System.out.printf("%s %s %s%n", modifier, typeName, variableName);
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        printPersonClassWithReflection();


        //Person person = new Person();
        //personClass.newInstance() -> default constructor

        //Person person = new Person("David", 46);
        Object person = personClass
                .getConstructor(String.class, Integer.class)
                .newInstance("David", 46);

        //Before involving in methods with reflection
        System.out.println(person.toString());

        //person.setAge(33)
        //person.setName("Anna");

        //perverted setName and setAge
        for (Method method : personClass.getMethods()) {
            //if method starts with "set" and
            //parameter is String - pass in the new name

            //if method starts with "set" and
            //parameter is Integer - pass in the new age

            if (method.getName().startsWith("set")) {
                Parameter [] parameters = method.getParameters();
                if (parameters[0].getType().equals(String.class)) {
                    //invoke = run
                    //param 1 - на какой объект (person)
                    //param 2 - какие parameters передать
                    method.invoke(person, "Anna");
                }

                if (parameters[0].getType().equals(Integer.class)) {
                    method.invoke(person, 33);
                }
            }


            //changing fields values directly!!

            //person.name = "Ivan"
            //person.age = 100

            //regardless of access modifier type: private or protected or any other
            for (Field field : personClass.getDeclaredFields()) {
                if (field.getType().equals(String.class) && field.getName().equals("name")) {
                    //hack for modifying private fields
                    field.setAccessible(true);
                    field.set(person, "Ivan");
                }

                if (field.getType().equals(Integer.class) && field.getName().equals("age")) {
                    //hack for modifying private fields
                    field.setAccessible(true);
                    field.set(person, 1000);
                }
            }
        }
        System.out.println(person.toString());



        Class<?> personRepository = Class.forName("com.company.reflection.PersonRepository");

        //PersonRepository personRepository = new PersonRepository();
        Object personRepositoryObject = personRepository.newInstance();

        //personRepository.add(Person) -> find
        Method add = personRepository.getMethod("add", Person.class);

        //personRepository.add(Person) -> run
        add.invoke(personRepositoryObject, person);
        add.invoke(personRepositoryObject, new Person("Dana", 21));
        add.invoke(personRepositoryObject, new Person("Peter", 55));
        add.invoke(personRepositoryObject, new Person("Samuel", 98));

        //personRepository.getPersons() -> find
        Method getPersons = personRepository.getMethod("getPersons");

        //personRepository.getPersons() -> run and collect result
        Object result = getPersons.invoke(personRepositoryObject);
        //result contains List<Person> - what "getPersons()" returned


        System.out.println("List of out results");
        System.out.println(result);
    }

    private static void printPersonClassWithReflection() throws Exception {
        Class<?> personClass = Class.forName("com.company.reflection.Person");
        String classAccessModifier = Modifier.toString(personClass.getModifiers());
        String className = personClass.getSimpleName();
        System.out.printf("%s class %s {%n", classAccessModifier, className);

        printPersonClassFields(personClass);
        printConstructors(personClass);

        System.out.println("}");
    }

    private static void printConstructors(Class<?> personClass) {
        for (Constructor constructor : personClass.getConstructors()) {
            String ctorModifier = Modifier.toString(constructor.getModifiers());

            StringBuilder builder = new StringBuilder();
            for (Parameter parameter : constructor.getParameters()) {

                String type = parameter.getType().getSimpleName();
                String parameterName = parameter.getName();

                builder.append(type)
                        .append(" ")
                        .append(parameterName)
                        .append(", ");
            }


            String parameters = builder.toString();

            if (parameters.length() > 0) {

                parameters = parameters.substring(
                        0,
                        parameters.length() - 2);
            }

            System.out.printf("\t%s %s(%s) { %n",
                    ctorModifier,
                    personClass.getSimpleName(),
                    parameters);
            System.out.println("\t}");
        }

        System.out.println();
    }

    private static void printPersonClassFields(Class<?> personClass) {
        for (Field field : personClass.getDeclaredFields()) {
            String modifier = Modifier.toString(field.getModifiers());
            String typeName = field.getType().getSimpleName();
            String variableName = field.getName();
            System.out.printf("\t%s %s %s;%n", modifier, typeName, variableName);
        }

        System.out.println();
    }
}
