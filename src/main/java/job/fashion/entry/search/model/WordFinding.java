package job.fashion.entry.search.model;

/***
 * A model class that holds word findings, implements Comparable to use the collections framework to sort.
 * This is also immutable, ie no setters to avoid mutation
 * @author w
 *
 */

public class WordFinding implements Comparable<WordFinding>{

	private String word;
	private Long count;
	public WordFinding(String word, Long count) {
		super();
		this.word = word;
		this.count = count;
	}
	public String getWord() {
		return word;
	}
	public Long getCount() {
		return count;
	}
	
	@Override
	public int compareTo(WordFinding other) {
		if(this.count > other.count) {
			return -1;
		}
		if(this.count< other.count) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordFinding other = (WordFinding) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "WordFinding [word=" + word + ", count=" + count + "]";
	}
	
	
	
}
