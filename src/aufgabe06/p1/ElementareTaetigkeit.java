package aufgabe06.p1;

public class ElementareTaetigkeit implements Taetigkeit {
    private final double time;
    private final String beschr;

    public ElementareTaetigkeit(String beschreibung, double time){
        if(time <= 0 || beschreibung == null){
            throw new IllegalArgumentException();
        }
        this.beschr = beschreibung;
        this.time = time;
    }

    @Override
    public double getTime(){
        return time;
    }

    @Override
    public int getAnzahl(){
        return 1;
    }

    @Override
    public void add(Taetigkeit t){
        throw new IllegalArgumentException();
    }

    @Override
    public void remove(Taetigkeit t){
        throw new IllegalArgumentException();
    }

    @Override
    public String toString(){
        return getBeschreibung() + ": " + getTime();
    }

    public String getBeschreibung(){
        return beschr;
    }
}
