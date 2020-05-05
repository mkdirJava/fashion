package job.fashion.entry.search.tokenise;

/***
 * An action for a tokeniser taking a Generic argument so the implementation class can take in a File, String etc
 * @author w
 *
 * @param <T>
 */
public interface ITokeniser<T> {
	String[] tokenise(T words);
}
