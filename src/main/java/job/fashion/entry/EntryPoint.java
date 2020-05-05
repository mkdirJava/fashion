package job.fashion.entry;

import java.util.Arrays;

import job.fashion.entry.search.IWordSearch;
import job.fashion.entry.search.WordSearch;
/***
 * The main class where the only Wordsearch is taking from the commandlIne
 * @author w
 *
 */

public class EntryPoint {
	// I thought it would be interesting to leave this here, should anyone want to run it 
	public static void main(String[] args) {
		IWordSearch<String> wordSearch = WordSearch.getStringWordSearch();
		String joinArgument = String.join(" ", args);
		String[] top_3_words = wordSearch.top_3_words(joinArgument);
		System.out.println(Arrays.toString(top_3_words));
	}
}
