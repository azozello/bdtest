import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class Executor {
    public static void execute(Query query){
        try {
            Connector connector = Connector.getValue();
            Statement statement = connector.getConnection().createStatement();
            String login, password, SQLQuery;
            switch (query.getAction()){
                case DELETE:
                    login = query.getLogin();
                    SQLQuery = "DELETE FROM users WHERE LOGIN = '"+login+"';";
                    statement.execute(SQLQuery);
                    System.out.println("SUCCESS");
                    break;
                case INSERT:
                    login = query.getLogin();
                    password = query.getPassword();
                    SQLQuery = "INSERT INTO users(LOGIN, PASSWORD) VALUES ('"+login+"', '"+password+"');";
                    statement.execute(SQLQuery);
                    System.out.println("SUCCESS");
                    break;
                case RESULT:
                    SQLQuery = "SELECT * FROM users;";
                    ResultSet resultSet = statement.executeQuery(SQLQuery);
                    while (resultSet.next()){
                        System.out.println("ID: "+resultSet.getInt(1)+
                        "  |  LOGIN: "+resultSet.getString(2)+
                        "  |  PASSWORD: "+resultSet.getString(3));
                    }
                    System.out.println();
                    break;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
