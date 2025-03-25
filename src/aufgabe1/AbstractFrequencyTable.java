package aufgabe1;

/**
 *
 * @author oliverbittel
 * @author Oliver Haase
 */
public abstract class AbstractFrequencyTable implements FrequencyTable {
	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	@Override
    public void add(String w) {
		add(w, 1);
    }

	@Override
	public void addAll(FrequencyTable fq) {
		for (int i = 0; i < fq.size(); i++) {
			this.add(this.get(i).getWord(), this.get(i).getFrequency());
		}
	}

	@Override
	public void collectNMostFrequent(int n, FrequencyTable fq) {
		for (int i = 0; i < fq.size() && i < n; i++) {
			this.add(this.get(i).getWord(), this.get(i).getFrequency());
		}
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("{");
		// Ihr Code:
		for (int i = 0; i < this.size(); i++) {
			String w = get(i).getWord();
			int f = get(i).getFrequency();
			s.append(w).append(":").append(f).append(", ");
		}
		s.append("}").append("size = ").append(this.size());
		return s.toString();
	}
}
