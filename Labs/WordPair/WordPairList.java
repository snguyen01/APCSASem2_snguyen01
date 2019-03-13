
/**
 * Write a description of class WordPairList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordPairList{
    public WordPairList(String[] words)
    {
        allPairs = new ArrayList<WordPair>();
        for (int i = 0; i < words.length-1; i++)
        {
            for (int j = i+1; j < words.length; j++)
            {
                allPairs.add(new WordPair(words[i], words[j]));
            }
        }
    }

    public int numMatches()
    {
        int count = 0;
        for (WordPair pair: allPairs)
        {
            if (pair.getFirst().equals(pair.getSecond()))
            {
                count++;
            }
        }
        return count;
    }
}