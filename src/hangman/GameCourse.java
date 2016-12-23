package hangman;

public class GameCourse {
    int dbIndex;
    String word;
    String category;

    SingletonConnection connection;
    
    public GameCourse() {
        connection = SingletonConnection.getInstance();
        
    }
    
    public void setWords(){
        dbIndex = connection.getWordIndex();
        System.out.println(connection.getWordIndex() + "     " + connection.getWord(dbIndex) + "     " + connection.getCategory(dbIndex));
        word = connection.getWord(dbIndex);
        category = connection.getCategory(dbIndex);
    }

    public String getWord() {
        return word;
    }

    public String getCategory() {
        return category;
    }
    
            
}
