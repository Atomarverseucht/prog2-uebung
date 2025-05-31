package aufgabe06.p1;

public class SerielleTaetigkeit extends ZusammengesetzteTaetigkeit {
    @Override
    public double getTime(){
        double out = 0;
        for(Taetigkeit t : meineTaetigkeiten){
            out += t.getTime();
        }
        return out;
    }

    @Override
    public String toString(){
        return "Serielle Tätigkeit: " + super.toString();
    }
}
