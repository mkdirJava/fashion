package job.fashion.entry.search;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import job.fashion.entry.search.model.WordFinding;
import job.fashion.entry.search.tokenise.ITokeniser;

public class WordSearchImpl implements IWordSearch {

	private ITokeniser iTokeniser;
	private static final Integer THRESHOLD = 40;

	public WordSearchImpl(ITokeniser iTokeniser) {
		this.iTokeniser = iTokeniser;
	}

	public String[] top_3_words(String words) {
		String[] tokenise = iTokeniser.tokenise(words);
		List<WordFinding> rankWords = rankWords(tokenise);
		return findIndexToThree(rankWords);
	}
	
	private String[] findIndexToThree(List<WordFinding> finding) {
		Integer endIndex = 0;
		if(finding.size()>=3) {
			endIndex=3;
		}else {
			endIndex = finding.size();
		}
		return finding.subList(0, endIndex).stream()
				.map(wordFinding->wordFinding.getWord())
				.toArray(String[]::new);
	}
	
	private List<WordFinding> rankWords(String[] tokenise) {
		if (tokenise.length <= THRESHOLD) {
			Map<String, Long> findCommonWords = findCommonWords(tokenise);
			return findCommonWords.entrySet().stream()
			.map(entry-> new WordFinding(entry.getKey(), entry.getValue()))
			.sorted().collect(Collectors.toList());
		} else {
			String[] firstHalf  = Arrays.copyOfRange(tokenise, 0, tokenise.length/2);
			String[] secondHalf = Arrays.copyOfRange(tokenise, tokenise.length/2, tokenise.length);
			
			Map<String, Long> findCommonWordsFirstHalf = findCommonWords(firstHalf);
			Map<String, Long> findCommonWordsSecondHalf = findCommonWords(secondHalf);
			
			return combine(findCommonWordsFirstHalf, findCommonWordsSecondHalf);
		}
	}

	private List<WordFinding> combine(Map<String, Long> findCommonWordsFirstHalf,
			Map<String, Long> findCommonWordsSecondHalf) {
		findCommonWordsSecondHalf.entrySet().stream().forEach(secondhalfEntry->{
			findCommonWordsFirstHalf.computeIfPresent(secondhalfEntry.getKey(), (key,val)-> val + secondhalfEntry.getValue());
			findCommonWordsFirstHalf.computeIfAbsent(secondhalfEntry.getKey(),key-> secondhalfEntry.getValue() );	
		});
		
		return findCommonWordsFirstHalf.entrySet().stream()
		.map(entry-> new WordFinding(entry.getKey(), entry.getValue()))
		.sorted().collect(Collectors.toList());
	}

	private Map<String,Long> findCommonWords(String[] tokenise) {
		return Arrays.asList(tokenise).stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

	}
	

}
