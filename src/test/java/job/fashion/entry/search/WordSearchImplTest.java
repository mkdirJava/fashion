package job.fashion.entry.search;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
	

public class WordSearchImplTest {
	
	private final IWordSearch<String> wordSearch = WordSearch.getStringWordSearch();

	private static final String TEST_1_STRING = readFromClassPath("TestString1.txt");
	private static final String TEST_2_STRING = readFromClassPath("TestString2.txt");
	private static final String TEST_3_STRING = readFromClassPath("TestString3.txt");
	private static final String TEST_4_EMPTY_STRING = "";
	
	private static String readFromClassPath(String testFileName) {
		InputStream resourceAsStream = WordSearchImplTest.class.getClassLoader().getResourceAsStream("testTexts/"+ testFileName);
		return new BufferedReader(new InputStreamReader(resourceAsStream)).lines().collect(Collectors.joining("\n"));
	}
	
	@Test
	@DisplayName("Test 1 as suggested in the spec")
	void test1() {
		String[] top_3_words = wordSearch.top_3_words(TEST_1_STRING);
		assertArrayEquals(top_3_words,new String[] {"a","of","on"});
	}
	
	@Test
	@DisplayName("Test 2 as suggested in the spec")
	void test2() {
		String[] top_3_words = wordSearch.top_3_words(TEST_2_STRING);
		assertArrayEquals(top_3_words,new String[] {"e","ddd","aa"});
	}
	
	@Test
	@DisplayName("Test 3 as suggested in the spec")
	void test3() {
		String[] top_3_words = wordSearch.top_3_words(TEST_3_STRING);
		assertArrayEquals(top_3_words,new String[] {"won't","wont"});
	}
	
	@Test
	@DisplayName("Test 4 empty String will give an empty array")
	void test4_emptyStringTest() {
		String[] top_3_words = wordSearch.top_3_words(TEST_4_EMPTY_STRING);
		assertArrayEquals(top_3_words,new String[] {});
	}
	

}
