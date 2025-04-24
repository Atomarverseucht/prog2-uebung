package aufgabe1;

import java.util.Iterator;

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
		for(Word<? extends T> w : fq){
			this.add(w.getWord(), w.getFrequency());
		}
	}

	@Override
	public void collectNMostFrequent(int n, FrequencyTable<? super T> fq) {
		fq.clear();
		for(Word<? extends T> w : this){
			fq.add(w.getWord(), w.getFrequency());
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

	@Override
	public Iterator<Word<T>> iterator(){
		return new Iterator<>() {
			private int index = 0;
			@Override
			public boolean hasNext() {
				return (index + 1 < size() && get(index +1) != null);
			}

			@Override
			public Word<T> next() {
				index++;
				return get(index);
			}
		};
	}
}
