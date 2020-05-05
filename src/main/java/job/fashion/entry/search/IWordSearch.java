package job.fashion.entry.search;

/***
 * Entry method to a facade, the generic is to allow for a range of inputs ie, a file or a String or a stream
 * @author w
 *
 * @param <T>
 */
public interface IWordSearch<T> {
	String[] top_3_words(T words);
}
