package dp;

/**
 * @author potato
 * @Date 2019/7/30 9:41
 */
public class EditDistance {
    /**
     * 1. specify sub problems.
     *  The key problem is how to align the two Strings.After that it's easy to change one to the other.
     *
     *  a1 a2 a3 ... am
     *  b1 b2    ... bn
     *
     *  Supposing this is the best alignment.So if we cut the last column,the prefixes will still be the
     *  shortest edit distance.And it's obvious that the edit distance is only about prefixes.
     * @param source
     * @param des
     * @return
     */
    public int getEditDistance(String source,String des){

    }
}
