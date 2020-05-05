package job.fashion.entry.search;

import job.fashion.entry.search.tokenise.tokenisers.StringTokeniser;
import job.fashion.entry.search.tokenise.tokenisers.TokeniserOptions;
import job.fashion.entry.search.top.RankWords;
/***
 * A convenience class to get the only word search, this is a basic builder pattern, 
 * This class could be enriched to return basic IWordSearches implementation, 
 * This follows a Scalaish way for an Object companion class.
 * @author w
 *
 */
public class WordSearch {
	public static IWordSearch<String> getStringWordSearch() {
		return new WordSearchImpl(new StringTokeniser(TokeniserOptions.BASIC_TOKEN_ESCAPES()), RankWords.getRankWords() );
	}
}
