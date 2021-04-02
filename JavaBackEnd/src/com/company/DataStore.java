package com.company;
import java.util.HashMap;
import java.util.Map;

/*
   https://happycoding.io/tutorials/java-server/rest-api
   example used to create this test api

   Example DataStore class that provides access to the user data
   Lets pretend this DataStore class access the database
 */

public class DataStore {

    //Map op person names instances
    private Map<String, Person> personMap = new HashMap<>();

    /*
    this class is designed as a singleton and should not be instantiated directly
    more info about a singleton: https://en.wikipedia.org/wiki/Singleton_pattern
     */
    private static final DataStore instance = new DataStore();
    public static DataStore getInstance() {
        return instance;
    }

    //Making a private Constructor so people know to use the getInstance function instead
    private  DataStore() {
        //dummy data
        personMap.put("Justin", new Person("Justin", "Owner of the program.", 22));
        personMap.put("Miku", new Person("Hatsune Miku", "Singer from nature", 13));
        personMap.put("Klaas", new Person("Klaas", "A unknown person.", 22));
    }

    public Person getPerson(String name) {
        return personMap.get(name);
    }

    public void putPerson(Person person) {
        personMap.put(person.getName(), person);
    }
}
