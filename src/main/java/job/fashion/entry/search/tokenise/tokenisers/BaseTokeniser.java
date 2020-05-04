package job.fashion.entry.search.tokenise.tokenisers;

import java.util.Arrays;
import java.util.List;

import job.fashion.entry.search.tokenise.ITokeniser;

public abstract class BaseTokeniser implements ITokeniser {
	String regexDelimiter;
	List<String> regexToReplaceWith;

	@Override
	public String[] tokenise(String words) {
		String[] tokens = words.split(regexDelimiter);
		String[] array = Arrays.asList(tokens).parallelStream()
				.map(token -> token.replaceAll(",", ""))
				.map(token -> token.replaceAll("//", ""))
				.map(token -> token.toLowerCase())
				.toArray(String[]::new);
		return array;
	}
}
