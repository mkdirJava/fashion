package job.fashion.entry.search;

import job.fashion.entry.search.tokenise.tokenisers.BasicTokeniser;

public class WordSearch {
	public static IWordSearch getWordSearch() {
		return new WordSearchImpl(new BasicTokeniser());
	}
}
