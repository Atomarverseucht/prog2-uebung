package aufgabe6.p1;

import java.util.LinkedList;
import java.util.List;

public abstract class ZusammengesetzteTaetigkeit implements Taetigkeit {
    protected List<Taetigkeit> meineTaetigkeiten = new LinkedList<>();

    @Override
    public void add(Taetigkeit t){
        meineTaetigkeiten.add(t);
    }

    @Override
    public void remove(Taetigkeit t){
        meineTaetigkeiten.remove(t);
    }

    @Override
    public int getAnzahl(){
        int out = 0;
        for(Taetigkeit t: meineTaetigkeiten){
            out += t.getAnzahl();
        }
        return out;
    }

    @Override
    public String toString(){
        return meineTaetigkeiten.toString() + "\n";
    }
}
