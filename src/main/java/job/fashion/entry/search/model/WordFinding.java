package job.fashion.entry.search.model;

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
	public void setWord(String word) {
		this.word = word;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
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
	public String toString() {
		return "WordFinding [word=" + word + ", count=" + count + "]";
	}
	
	
	
}
