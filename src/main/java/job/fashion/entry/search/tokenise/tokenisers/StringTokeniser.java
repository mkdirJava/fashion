package job.fashion.entry.search.tokenise.tokenisers;

import java.util.Arrays;
import java.util.List;

import job.fashion.entry.search.tokenise.ITokeniser;

/***
 * String Tokeniser that supplied regex to replace and deliminate,
 * 
 * What would be useful is to have a file Tokeniser, 
 * acts like the iterable interface to return a section of the file whilst holding the index, 
 * this would be trouble should multiple jvms / host locks come into play
 * 
 * Also Line 30 tokenises the whole string in one go, would be better to take a chunk as it could be a significant size
 * 
 * @author W
 *
 */
public class StringTokeniser implements ITokeniser<String> {

	private String regexDelimiter = " |\\n";
	private List<String> regexToReplace;

	public StringTokeniser(List<String> escapeToken) {
		this.regexToReplace = escapeToken;
	}

	public String[] tokenise(String words) {
		String[] tokens = words.split(regexDelimiter);
		String[] array = Arrays.asList(tokens).parallelStream().map(token -> {
			for (String replaceRegex : regexToReplace) {
				token = token.replaceAll(replaceRegex, "");
			}
			return token;
		}).map(String::toLowerCase).filter(token -> !token.isBlank()).toArray(String[]::new);
		return array;
	}
}
