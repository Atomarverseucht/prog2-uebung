package aufgabe1;

/**
 * Klasse für Wörter mit ihren Häufigkeiten.
 * @author oliverbittel
 * @author Oliver Haase
 */
public class Word<T> implements Comparable<Word>{
	final private T word;
	private int frequency;
	
	/**
	 * Konstruktor.
	 * @param word Wort
	 * @param f H&auml;ufgkeit
	 */
	public Word(T word, int f) {
		this.word = word;
		this.frequency = f;
	}

	/**
	 * Liefert Wort zur&uuml;ck.
	 * @return Wort
	 */
	public T getWord() {
		return word;
	}

	/**
	 * Liefert H&auml;ufgkeit zur&uuml;ck.
	 * @return H&auml;ufgkeit
	 */
	public int getFrequency() {
		return frequency;
	}
	
	/**
	 * Addiert zur H&auml;ufgkeit f dazu.
	 * @param f H&auml;ufgkeits&auml;nderung.
	 */
	public void addFrequency(int f) {
		frequency += f;
	}

	@Override
	public String toString() {
		return word.toString() + ":" + frequency;
	}

	@Override
	public int compareTo(Word word2){
		return this.frequency - word2.frequency;
	}

	public Word copy(){
		return new Word(word, frequency);
	}
}
