import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukasz on 11.11.15.
 */
public class DataHandler {

    List<Person> persons = new ArrayList<Person>();


    public void addPerson(String name, String lastName, int age)
    {
        persons.add(new Person(name,lastName,age));
    }


    public void printPerson(int n)
    {
        System.out.println(persons.get(n));
    }
}
