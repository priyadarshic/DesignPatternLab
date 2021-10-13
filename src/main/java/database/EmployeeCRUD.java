package database;

import java.sql.*;


public class EmployeeCRUD {

    static final String QUERY = "SELECT id, firstname, lastname, age, salary FROM EMPLOYEE";


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection conn = MySQLConnect.getConnection();
        //createTable(conn);
        //insertTable(conn);

        readTable(conn);
        //updateTable(conn);
        //deleteTable(conn);

    }

    private static void createTable(Connection conn){

        try(Statement stmt = conn.createStatement();) {
            String sql = "CREATE TABLE EMPLOYEE " +
                    "(id INTEGER not NULL, " +
                    " firstname VARCHAR(255), " +
                    " lastname VARCHAR(255), " +
                    " age INTEGER, " +
                    " salary INTEGER, " +
                    " PRIMARY KEY ( id ))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void insertTable(Connection conn){

        try(Statement stmt = conn.createStatement();) {
            // Execute a query
            System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO EMPLOYEE VALUES (1001, 'Prabhat', 'Sharma', 31, 21000)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO EMPLOYEE VALUES (1002, 'Rajesh', 'Reddy', 28, 24000)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO EMPLOYEE VALUES (1003, 'Brijesh', 'Mishra', 30, 27000)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO EMPLOYEE VALUES(1004, 'Rohan', 'Mittal', 29, 25000)";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private  static void readTable(Connection conn){

        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
        ){
            while(rs.next()){
                System.out.println(" ");
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", FirstName: " + rs.getString("firstname"));
                System.out.println(", LastName: " + rs.getString("lastname"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.print(", Salary: " + rs.getInt("salary"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteTable(Connection conn){
      /*  Create procedure deleteProcedure (IN empid INT)
   -> BEGIN
                -> "DELETE FROM EMPLOYEE WHERE id = empid";
   -> END //*/

        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            CallableStatement call = conn.prepareCall("{call deleteProcedure(?)}");
        ){

            call.setInt(1, 1001);

            while(rs.next()){
                System.out.println(" ");
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", FirstName: " + rs.getString("firstname"));
                System.out.println(", LastName: " + rs.getString("lastname"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.print(", Salary: " + rs.getInt("salary"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static void updateTable(Connection conn){
      /*  Create procedure updateProcedure (IN empid INT)
   ->   BEGIN

                "UPDATE EMPLOYEE " +
            "SET age = 30 WHERE id =empid)";
        END

   //*/

        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            CallableStatement call = conn.prepareCall("{call updateProcedure(?)}");
        ){

            call.setInt(1, 1002);

            while(rs.next()){
                System.out.println(" ");
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", FirstName: " + rs.getString("firstname"));
                System.out.println(", LastName: " + rs.getString("lastname"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.print(", Salary: " + rs.getInt("salary"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
