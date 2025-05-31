package aufgabe06.p1;

public class ParalleleTaetigkeit extends ZusammengesetzteTaetigkeit {

    @Override
    public double getTime(){
        double out = 0;
        for(Taetigkeit t : meineTaetigkeiten){
            double neu = t.getTime();
            out = Double.max(neu, out);
        }
        return out;
    }

    @Override
    public String toString(){
        return "Parallele Tätigkeit: " + super.toString();
    }
}
