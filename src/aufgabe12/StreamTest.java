package aufgabe12;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        IntStream s = IntStream.range(1,11);
        System.out.println("Aufgabe1: " + s.filter(x->x%2 == 0).sum());

        List<Person> pers = Person.getPersonList();
        pers.stream().filter(x -> x.gebJahr() > 2000).forEach(x -> System.out.println(x.name().toUpperCase()));

        pers = Person.getPersonList();
        pers = pers.stream().filter(x -> x.gebJahr() > 2000).toList();
        System.out.println(pers);

        new Random().ints().map(n -> Math.abs(n) % 1000).peek(System.out::println).anyMatch(n -> n % 10 == 0);

        List<Person> p = Person.getPersonList();
        System.out.println(p.stream().map(Person::name).reduce("", ( x, y) -> x + ", " + y));

    }
}
