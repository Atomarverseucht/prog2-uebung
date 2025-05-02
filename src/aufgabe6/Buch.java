package aufgabe6;

public class Buch {
    final String name;
    private Person entleiher;

    public Buch(String name){
        this.name = name;
    }

    public void print(){
        System.out.println(name + (entleiher == null ? ": nicht ausgeliehen" : ": ausgeliehen von " + entleiher));
    }
    public String getName(){
        return name;
    }

    public Person getEntleiher(){
        return entleiher;
    }

    public boolean wirdAusgeliehen(Person p){
        if(entleiher != null){
            return false;
        }
        entleiher = p;
        p.leihtAus(this);
        return true;
    }

    public boolean wirdZurueckGegeben(){
        if(entleiher == null){
            return false;
        }
        entleiher.gibtZurueck(this);
        entleiher = null;
        return true;
    }

    @Override
    public String toString(){
        return name;
    }
}
