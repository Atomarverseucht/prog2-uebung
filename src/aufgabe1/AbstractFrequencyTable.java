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
		int n = fq.size();
		for (int i = 0; i < n; i++) {
			this.add(fq.get(i).getWord(), fq.get(i).getFrequency());
		}
	}

	@Override
	public void collectNMostFrequent(int n, FrequencyTable fq) {
		fq.clear();
		for (int i = 0; i < this.size() && i < n; i++) {
			fq.add(this.get(i).getWord(), this.get(i).getFrequency());
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
		s.append("}").append(" size = ").append(this.size());
		return s.toString();
	}
}
