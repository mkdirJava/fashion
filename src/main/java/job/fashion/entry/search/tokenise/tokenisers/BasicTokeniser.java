package job.fashion.entry.search.tokenise.tokenisers;

import java.util.List;

public class BasicTokeniser extends BaseTokeniser{
	public BasicTokeniser() {
		super.regexDelimiter=" |\\n";
		super.regexToReplaceWith = List.of("\n",",","\\."," ","//");
	}
}
