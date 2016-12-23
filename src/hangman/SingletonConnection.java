package hangman;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

class SingletonConnection {

    private static SingletonConnection instance = null;
    String ConnectionURL = "jdbc:mysql://127.0.0.1/wisielec?user=root&password=Argentyna";
    Connection connection;
    Statement statement;

    private SingletonConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(ConnectionURL);
            statement = connection.createStatement();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public static SingletonConnection getInstance() {
        if (instance == null) {
            instance = new SingletonConnection();
        }
        return instance;
    }
    
    public int getWordIndex(){
        int wordIndex = 0;
        int wordCount = 0;
        
        try {
            ResultSet result = statement.executeQuery("select count(*) from wisielec.hasla;");
            result.next();
            wordCount = result.getInt(1);
            Random r = new Random();
            wordIndex = r.nextInt(wordCount) + 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return wordIndex;
    }
    
    public String getWord(int dbIndex){
        String word = null;
        try {
            ResultSet result = statement.executeQuery("select Haslo from wisielec.hasla where ID = " + dbIndex);
            result.next();
            word = result.getString(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return word;
    }
    
    public String getCategory(int dbIndex){
        String category = null;
        try {
            ResultSet result = statement.executeQuery("select Kategoria from wisielec.hasla where ID = " + dbIndex);
            result.next();
            category = result.getString(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return category;
    }
    
}
