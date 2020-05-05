package job.fashion.entry.search.top;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import job.fashion.entry.search.model.WordFinding;

/***
 * Recursive word finding, this uses the divide and conquer technique to find the word rank listing, it however could be enriched by using multi-threading
 * I know of using ExecutorService from Java 8 however this introduces state in terms of Future<T> and Runnable, a better solution might be to use
 * RecursiveAction
 * 
 * Essentially this is a none distributed MapReduce.
 * @author w
 *
 */
public class RankWordsImpl implements IRankWords {

	private Integer THRESHOLD = 40;
	public List<WordFinding> rankWords(String[] tokenise) {

		Integer tokeniseCount = tokenise.length;
		if (tokeniseCount <= THRESHOLD) {
			Map<String, Long> findCommonWords = findCommonWords(tokenise);
			return findCommonWords.entrySet().stream().map(entry -> new WordFinding(entry.getKey(), entry.getValue()))
					.sorted().collect(Collectors.toList());
		} else {
			String[] firstHalf = Arrays.copyOfRange(tokenise, 0, tokeniseCount / 2);
			String[] secondHalf = Arrays.copyOfRange(tokenise, tokeniseCount / 2, tokeniseCount);

			Map<String, Long> findCommonWordsFirstHalf = findCommonWords(firstHalf);
			Map<String, Long> findCommonWordsSecondHalf = findCommonWords(secondHalf);

			return combine(findCommonWordsFirstHalf, findCommonWordsSecondHalf);
		}
	}

	private List<WordFinding> combine(Map<String, Long> findCommonWordsFirstHalf,
			Map<String, Long> findCommonWordsSecondHalf) {
		findCommonWordsSecondHalf.entrySet().stream().forEach(secondhalfEntry -> {
			findCommonWordsFirstHalf.computeIfPresent(secondhalfEntry.getKey(),
					(key, val) -> val + secondhalfEntry.getValue());
			findCommonWordsFirstHalf.computeIfAbsent(secondhalfEntry.getKey(), key -> secondhalfEntry.getValue());
		});

		return findCommonWordsFirstHalf.entrySet().stream()
				.map(entry -> new WordFinding(entry.getKey(), entry.getValue())).sorted().collect(Collectors.toList());
	}

	private Map<String, Long> findCommonWords(String[] tokenise) {
		return Arrays.asList(tokenise).parallelStream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

	}


}
