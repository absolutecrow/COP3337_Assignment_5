import java.util.ArrayList;

class WordMeaning
{
    private final String word;
    private ArrayList<String> def;
    
    WordMeaning(String w, ArrayList d)
    {
        word = w;
        def = d;
    }
    
    String getWord()
    {
        return word;
    }
    
    ArrayList getDefinitions()
    {
        return def;
    }    
    void addDefinition(String definition)
    {
        def.add(" - " + definition);
    }  
}