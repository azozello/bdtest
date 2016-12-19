public class Query {

    private String login;
    private String password;
    private QE action;

    public enum QE{
        RESULT,
        INSERT,
        DELETE
    }

    public Query(){
        this.action = QE.RESULT;
    }

    public Query(String login){
        this.action = QE.DELETE;
        this.login = login;
    }

    public Query(String login, String password){
        this.action = QE.INSERT;
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public QE getAction() {
        return action;
    }
}
