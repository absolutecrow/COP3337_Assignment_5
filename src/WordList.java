import java.util.ArrayList;
import javax.swing.JOptionPane;

class WordList
{
    private WordMeaningNode list;
    private WordMeaningNode removedWords;
    
    WordList()
    {
        list = null;
    }   
    
    void addWord(WordMeaning w)
    {
        WordMeaningNode temp = new WordMeaningNode(w);
        
        if(list == null)
        list = temp;
        
        else
        {
            WordMeaningNode checker = list;
            WordMeaningNode back = null;
            boolean found = false;
            
            if(temp.wordmeaning.getWord().compareTo(checker.wordmeaning.getWord()) == 0)
            {
                list.wordmeaning.addDefinition((String) w.getDefinitions().get(0));
            }
            else
            {
                while(checker != null && !found)
                {
                    if(temp.wordmeaning.getWord().compareTo(checker.wordmeaning.getWord()) < 0)
                    { 
                        found = true;
                    }
                    else
                    {
                        back = checker;
                        checker = checker.next;

                    }
                }           
                temp.next = checker;
                if (back == null)
                {
                    list = temp;
                }
                else
                    back.next = temp;
            }           
        }      
    }
    
    void removeWord(String s)
    {
        
        WordMeaningNode checker = list;
        WordMeaningNode back = null;
        boolean found = false;

        while(checker != null && !found)
          {          
            if(s.compareTo(checker.wordmeaning.getWord()) == 0)
                {
                    if(back == null)
                    {
                        removedWords = checker;
                        list = checker.next;
                    }
                    else
                    {
                        removedWords = checker;
                        back.next = checker.next;
                    }

                    found = true;
                }
            else
                {
                    back = checker;
                    checker = checker.next;  
                }
          }
       }
       
    WordMeaningNode getList()
    {
        return removedWords;
    }
    
    public String toString()
    {
        String result = "";
        String definition = "";
        WordMeaningNode current = list;
        
        while(current != null)
        {            
            ArrayList lst = current.wordmeaning.getDefinitions();
                            for(int i = 0; i < lst.size(); i++)
                            {
                                definition = definition + lst.get(i) + "\n";   
                            }
            result = result + current.wordmeaning.getWord() + definition + "\n";
            current = current.next;
        }
        result = result.replaceAll("-  -", "-");               
        return result;
    }
    
    String setWord(String s)
    {
        return JOptionPane.showInputDialog(s);
    }
    
    String setDef(String s)
    {
        return JOptionPane.showInputDialog(s);
    }
            
}