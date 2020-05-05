package job.fashion.entry.search.top;

import java.util.List;

import job.fashion.entry.search.model.WordFinding;
/***
 * The front generic rank words that allows for selecting the top n words
 * @author w
 *
 */

public interface IRankWords {
	List<WordFinding> rankWords(String[] tokenise);
}
