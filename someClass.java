import java.util.*;
/**
 * Write a description of class someClass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class someClass
{
    private ArrayList<String> example;

    /**
     * initializing names
     */
    public someClass()
    {
        example = new ArrayList<String>();
        example.add("bob");
        example.add("jim");
        example.add("clark");
        example.add("maria");
        example.add("sydney");
        example.add("zach");
        example.add("noa");
        example.add("olivia");
        example.add("alex");
    }

    public void sortStrings(ArrayList<String> names){
        for(int i = 0; i < names.size(); i++){
            int index = i;
            for(int j = i; j < names.size(); j++){
                if(names.get(j).compareTo(names.get(index))<=0){
                    index = j;
                }
                String lowerName = names.get(index);
                names.set(index, names.get(i));
                names.set(i, lowerName);
            }
        }
    }
    
    public void shuffleStrings(ArrayList<String> names){
        ArrayList<String> shuffled = new ArrayList<String>(names.size());
        int k = 0;
        for(int j = 0; j < names.size()/2; j++){
            shuffled.set(k, names.get(j));
            k = k+2;
        }
        k = 1;
        for(int j = names.size()/2; j <names.size(); j++){
            shuffled.set(k, names.get(j));
            k = k+2;
        }
    }
    
    public void insertString(String word){
        for(int i = 0; i < example.size(); i++){
            int index = i;
            for(int j = i; j < example.size(); j++){
                if(example.get(j).compareTo(example.get(index))<=0){
                    index = j;
                }
                String lowerName = example.get(index);
                example.set(index, example.get(i));
                example.set(i, lowerName);
            }
        }
        for(int i= 0; i < example.size(); i++){
            if(example.get(i).compareTo("word") < 0){
                example.add(i, "word");
                i = example.size();
            }
        }
    } 
}