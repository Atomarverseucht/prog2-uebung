package aufgabe1;

/**
 *
 * @author oliverbittel
 * @author Oliver Haase
 */
public abstract class AbstractFrequencyTable<T> implements FrequencyTable<T> {
	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	@Override
    public void add(T w) {
		add(w, 1);
    }

	@Override
	public void addAll(FrequencyTable<? extends T> fq) {
		int n = fq.size();
		for (int i = 0; i < n; i++) {
			this.add(fq.get(i).getWord(), fq.get(i).getFrequency());
		}
	}

	@Override
	public void collectNMostFrequent(int n, FrequencyTable<? super T> fq) {
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
			String w = this.get(i).getWord().toString();
			s.append(i+1).append(". ").append(w).append(",\n");
		}
		s.append("}").append(" size = ").append(this.size());
		return s.toString();
	}
}
