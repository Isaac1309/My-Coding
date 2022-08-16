import java.sql.*;

public class Main {
    public static final String DB_NAME="testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\isaac\\OneDrive\\Escritorio\\Trabajos Udemy\\TestSQLite\\"+DB_NAME;

    public static final String TABLE_CONTACTS="contacts";
    public static final String COLUMN_NAME="name";
    public static final String COLUMN_PHONE="phone";
    public static final String COLUMN_EMAIL="email";

    public static void main(String[] args) {
        /**try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
             Statement statement = conn.createStatement()) {
                statement.execute("CREATE TABLE IF NOT EXISTS "+TABLE_CONTACTS+" ("+COLUMN_NAME+" TEXT, "+COLUMN_PHONE+" INTEGER, "+COLUMN_EMAIL+" TEXT);");*/
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            //conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
            statement.execute("DROP TABLE IF EXISTS "+ TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS "+TABLE_CONTACTS+" ("+COLUMN_NAME+" TEXT, "+COLUMN_PHONE+" INTEGER, "+COLUMN_EMAIL+" TEXT);");

            insertContact(statement,"Tim",6545678,"tim@gmail.com");
            insertContact(statement,"Joe",45632,"joe@gmail.com");
            insertContact(statement,"Jane",4829484,"jane@gmail.com");
            insertContact(statement,"Fido",9038,"dog@gmail.com");

            statement.execute("UPDATE "+TABLE_CONTACTS+" SET "+COLUMN_PHONE+"=5566789 WHERE "+COLUMN_NAME+"='Jane';");
            statement.execute("DELETE FROM "+TABLE_CONTACTS+" WHERE "+COLUMN_NAME+"='Joe' ;");

            /**statement.execute("SELECT * FROM "+TABLE_CONTACTS);
            ResultSet resultS = statement.getResultSet();*/
            ResultSet resultS = statement.executeQuery("SELECT * FROM "+TABLE_CONTACTS);
            while (resultS.next())
                System.out.println( resultS.getString(COLUMN_NAME)+" "+
                    resultS.getString(COLUMN_PHONE)+" "+resultS.getString(COLUMN_EMAIL));
            resultS.close();

            statement.close();
            conn.close();
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void insertContact(Statement statement,String name, int phone, String email) throws SQLException{
        statement.execute("INSERT INTO "+TABLE_CONTACTS+" ("+COLUMN_NAME+", "+COLUMN_PHONE+", "+COLUMN_EMAIL+") VALUES ('"+name+"',"+phone+",'"+email+"');");
    }
}
