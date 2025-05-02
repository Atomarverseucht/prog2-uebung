package aufgabe6.p1;

import java.util.List;

public class ZusammengesetzteTaetigkeit implements Taetigkeit {
    private List<? extends Taetigkeit> meineTaetigkeiten;

    @Override
    public void add(Taetigkeit t){

    }

    @Override
    public void remove(Taetigkeit t){

    }

    @Override
    public int getAnzahl(){
        return meineTaetigkeiten.size();
    }
}
