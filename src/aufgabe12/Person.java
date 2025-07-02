package aufgabe12;

import java.util.List;

public record Person(String name, int gebJahr) {
    static List<Person> getPersonList() {
        return List.of(
                new Person("Alice", 2001),
                new Person("Bob", 2003),
                new Person("Charlie", 2005),
                new Person("Diana", 1995));
    }
}
