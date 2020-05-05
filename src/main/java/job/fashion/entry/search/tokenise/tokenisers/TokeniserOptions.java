package job.fashion.entry.search.tokenise.tokenisers;

import java.util.ArrayList;
import java.util.List;
/**
 * List of tokens to be escaped.
 * @author w
 *
 */
public class TokeniserOptions {
	
	private static final List<String> _BASIC_TOKEN_ESCAPES = List.of("\n", ",", "\\.", " ", "//");
	
	public static final List<String> BASIC_TOKEN_ESCAPES (){
		return new ArrayList<String>(_BASIC_TOKEN_ESCAPES);
	}
}
	


