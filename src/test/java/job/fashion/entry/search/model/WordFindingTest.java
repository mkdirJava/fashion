package job.fashion.entry.search.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/***
 * Testing interaction between the model and the collections sort framework
 * @author w
 *
 */
class WordFindingTest {

	private final static List<WordFinding> TEST_LIST = Arrays.asList(
			new WordFinding("ate",3L),
			new WordFinding("one",100L),
			new WordFinding("chocolates",1L),
			new WordFinding("time",40L),
			new WordFinding("i",39L),
			new WordFinding("happy",41L)
			);
	
	@Test
	@DisplayName("WordFinding should be subject to the collections sort framework")
	void wordFindingShouldUseTheCollectionsSort() {
		Collections.sort(TEST_LIST);
		assertAll(
				()-> assertEquals(new WordFinding("one",100L), TEST_LIST.get(0),"1st element should be one"),
				()-> assertEquals(new WordFinding("happy",41L), TEST_LIST.get(1),"2nd element should be happy"),
				()-> assertEquals(new WordFinding("time",40L), TEST_LIST.get(2),"3rd element should be time"),
				()-> assertEquals(new WordFinding("i",39L), TEST_LIST.get(3),"4th first element should be i"),
				()-> assertEquals(new WordFinding("ate",3L), TEST_LIST.get(4),"5th first element should be ate"),
				()-> assertEquals(new WordFinding("chocolates",1L), TEST_LIST.get(5),"6th first element should be chocolates")
				);
	}

}
