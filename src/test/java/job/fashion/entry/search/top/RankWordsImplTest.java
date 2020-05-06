package job.fashion.entry.search.top;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import job.fashion.entry.search.model.WordFinding;
/***
 * Test for the concern of ranking words
 * @author w
 *
 */
class RankWordsImplTest {
	
	private RankWordsImpl rankWordsImpl = new RankWordsImpl();
	private final static String[] RANKING_WORDS = new String[] {"one","one","one","two","two","three","hi","how","are","you"}; 

	@Test
	@DisplayName("Ranking words should return a sorted list of WordFinding, primary by the count and then by word String")
	void rankingStrings() {
		List<WordFinding> rankingResult = rankWordsImpl.rankWords(RANKING_WORDS);
		assertAll(
				() -> assertEquals(7, rankingResult.size(), "There should be 7 enteries in the result"),
				() -> assertEquals(new WordFinding("one", 3L), rankingResult.get(0), "The first entry in the result should be <one> with a count of 3"),
				() -> assertEquals(new WordFinding("two", 2L), rankingResult.get(1), "The first entry in the result should be <two> with a count of 2"),
				() -> assertEquals(new WordFinding("are", 1L), rankingResult.get(2), "The first entry in the result should be <are> with a count of 1"),
				() -> assertEquals(new WordFinding("hi", 1L), rankingResult.get(3), "The first entry in the result should be <hi> with a count of 1"),
				() -> assertEquals(new WordFinding("how", 1L), rankingResult.get(4), "The first entry in the result should be <how> with a count of 1"),
				() -> assertEquals(new WordFinding("three", 1L), rankingResult.get(5), "The first entry in the result should be <three> with a count of 1"),
				() -> assertEquals(new WordFinding("you", 1L), rankingResult.get(6), "The first entry in the result should be <you> with a count of 1")
				);
	}

}
