import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class Main {
    private static Connector connector = Connector.getValue();
    static BufferedReader r;

    final static String URL = "jdbc:mysql://localhost:3306/lnp";
    final static String USERNAME = "root";
    final static String PASSWORD = "root";

    public static void main(String args[]){
        r = new BufferedReader(new InputStreamReader(System.in));
        help();
        int toDo = 0;
        while (true){
            try {
                toDo = Integer.parseInt(r.readLine());
                switch (toDo){
                    case 0:
                        return;
                    case 1:
                        Executor.execute(new Query());
                        break;
                    case 2:
                        System.out.println("Enter login");
                        String login = r.readLine();
                        System.out.println("Enter password");
                        String password = r.readLine();
                        Executor.execute(new Query(login, password));
                        break;
                    case 3:
                        System.out.println("Enter login");
                        String logind = r.readLine();
                        Executor.execute(new Query(logind));
                        break;
                    case 4:
                        help();
                        break;
                    case 5 :
                        bitCoins();
                        break;
                }
            } catch (NumberFormatException e){
                System.out.println("Unknown command");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    private static void bitCoins(){
        System.out.println("Enter bitcoin`s values");
        try {
            double bitcoins = Double.parseDouble(r.readLine());
            double dollars = bitcoins*775;
            System.out.println(bitcoins+" bitcoins  =  "+dollars+" dollars");
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void help(){
        System.out.println("Enter 1 to read");
        System.out.println("Enter 2 to insert");
        System.out.println("Enter 3 to delete");
        System.out.println("Enter 4 to help");
        System.out.println("Enter 5 to bitcoins");
        System.out.println("Enter 0 to exit");
        System.out.println();
    }
    /*
        private static void select(){
        String query = "SELECT * FROM users;";
        try {
            Connection connection = connector.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                System.out.println("ID: "+resultSet.getInt(1));
                System.out.println("LOGIN: "+resultSet.getString(2));
                System.out.println("PASSWORD: "+resultSet.getString(3));
                System.out.println("=====================");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void insert(String  login, String password){
        String query = "INSERT INTO users(LOGIN, PASSWORD) VALUES('"
                +login+"', '"+password+"');";
        try {
            Connection connection = connector.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(query);
            System.out.println("SUCCESS");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void delete(String login){
        String query = "DELETE FROM users WHERE LOGIN = '"
                +login+"';";
        try {
            Connection connection = connector.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(query);
            System.out.println("SUCCESS");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void readArticle(String title){
        String query = "select TITLE, TEXT from articles where TITLE = '"+title+"';";
        try {
            Connection connection = connector.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                System.out.println("ID: "+resultSet.getString(1));
                System.out.println("LOGIN: "+resultSet.getString(2));
                System.out.println("=====================");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
     */
}
