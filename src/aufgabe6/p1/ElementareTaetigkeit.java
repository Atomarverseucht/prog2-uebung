package aufgabe6.p1;

public class ElementareTaetigkeit implements Taetigkeit {
    private final double time;
    private final String beschr;

    public ElementareTaetigkeit(String beschreibung, double time){
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

    }

    @Override
    public void remove(Taetigkeit t){

    }
}
