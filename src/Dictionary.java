import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.util.ArrayList;

class Dictionary
{
    public static void main(String arg[])
    {
        WordList list = new WordList();
        WordList removedWords = new WordList();
          
        String selectionOptions = "1. Add Word\n"
                                + "2. Remove Word\n"
                                + "3. Display List\n"
                                + "4. Display Removed List";  
        
        while(true)
        {
            String s = JOptionPane.showInputDialog(null,selectionOptions);           
            int i = Integer.parseInt(s);
            
            switch(i)
            {
                case 1:
                    String wordString = list.setWord("Word to add");
                    String defString = list.setDef("Word definition");
                    ArrayList definition = new ArrayList();
                    WordMeaning word = new WordMeaning(wordString, definition);
                    word.addDefinition(defString);
                    list.addWord(word);
                    break;
                case 2:
                    String wordremoved = list.setWord("Word to Remove");
                    list.removeWord(wordremoved);
                    try
                    {
                        removedWords.addWord(new WordMeaning(list.getList().wordmeaning.getWord(), list.getList().wordmeaning.getDefinitions()));
                    }
                    catch(NullPointerException e)
                    {
                        JOptionPane.showMessageDialog(null, "Word does not exist");
                    }
                    break;
                case 3:
                    display(list.toString(), "Dictionary");                  
                    break;
                case 4:
                    display(removedWords.toString(), "Removed Words");                  
                    break;
            }
        }
    }
    
    private static void display(String message, String title)
    {
        JTextArea text = new JTextArea(message,30,50);
        JScrollPane pane = new JScrollPane(text);
        JOptionPane.showMessageDialog(null, pane, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
