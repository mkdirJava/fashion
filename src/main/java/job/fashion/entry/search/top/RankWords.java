package job.fashion.entry.search.top;
/***
 * Basic builder pattern
 * @author w
 *
 */
public class RankWords {
	
	public static IRankWords getRankWords() {
		return new RankWordsImpl();
	}

}
