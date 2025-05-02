package aufgabe6;

import java.util.LinkedList;
import java.util.List;

public class Person {
    final String name;
    private final List<Buch> ausgelieheneBuecher = new LinkedList<>();

    public Person(String name){
        this.name = name;
    }

    public void print(){
        System.out.println(name + " hat ausgeliehen: " + ausgelieheneBuecher);
    }

    public int getAnzahlAusgelieheneBuecher(){
        return ausgelieheneBuecher.size();
    }

    public boolean leihtAus(Buch b){
        if((b.getEntleiher() != null && b.getEntleiher() != this) || ausgelieheneBuecher.contains(b)){
            return false;
        }
        ausgelieheneBuecher.add(b);
        b.wirdAusgeliehen(this);
        return true;
    }

    public boolean gibtZurueck(Buch b){
        if(!ausgelieheneBuecher.contains(b)){
            return false;
        }
        ausgelieheneBuecher.remove(b);
        b.wirdZurueckGegeben();
        return true;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name;
    }
}
