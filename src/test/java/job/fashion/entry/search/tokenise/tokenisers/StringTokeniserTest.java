package job.fashion.entry.search.tokenise.tokenisers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;

/***
 * Test for the concrete concern of tokenising a string  
 */

import org.junit.jupiter.api.Test;

class StringTokeniserTest {
	
	private StringTokeniser stringTokeniser = new StringTokeniser(TokeniserOptions.BASIC_TOKEN_ESCAPES());
	private static final String TEST_STRING = " //one, //two, //three, //how //are //you //today? // \n I'm \n ok, ";
	private static final String EMPTY_STRING = " //, //, //, // \n \n , ";
	
	@Test
	@DisplayName("StringTokeniser should be able to tokenise a string with configured replacement , <\n> <//> ,<,>, <.>")
	void givenAnEmptyStringBasicTokeniseStringShouldEmptyArrayTest() {
		String[] tokeniseResult = stringTokeniser.tokenise(EMPTY_STRING);
		assertArrayEquals(new String[] {}, tokeniseResult);
	}

	@Test
	@DisplayName("StringTokeniser should be able to tokenise a string with configured replacement , <\n> <//> ,<,>, <.>")
	void basicTokeniseStringTest() {
		String[] tokeniseResult = stringTokeniser.tokenise(TEST_STRING);
		assertArrayEquals(new String[] {"one","two","three","how","are","you","today?","i'm","ok"}, tokeniseResult);
	}

}
