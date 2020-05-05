package job.fashion.entry.search;

import java.util.List;

import job.fashion.entry.search.model.WordFinding;
import job.fashion.entry.search.tokenise.ITokeniser;
import job.fashion.entry.search.top.IRankWords;

/***
 * Implementation for the IWordSearch of String, trying to promote SOLID for re-usability
 * @author w
 *
 */
public class WordSearchImpl implements IWordSearch<String> {

	private ITokeniser<String> iTokeniser;
	private IRankWords iRankWords;
	

	public WordSearchImpl(ITokeniser<String> iTokeniser, IRankWords iRankWords) {
		this.iTokeniser = iTokeniser;
		this.iRankWords = iRankWords;
	}

	public String[] top_3_words(String words) {
		String[] tokenise = iTokeniser.tokenise(words);
		List<WordFinding> rankWords = this.iRankWords.rankWords(tokenise);
		return findIndexToThree(rankWords);
	}
	
	private String[] findIndexToThree(List<WordFinding> finding) {
		Integer endIndex;
		if(finding.size()>=3) {
			endIndex=3;
		}else {
			endIndex = finding.size();
		}
		return finding.subList(0, endIndex).stream()
				.map(wordFinding->wordFinding.getWord())
				.toArray(String[]::new);
	}
	
	
	

}
