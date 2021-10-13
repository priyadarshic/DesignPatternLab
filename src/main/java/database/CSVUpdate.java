package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CSVUpdate {
    private static String pathToCsv = "D:\\JavaCollectionsLab\\new.csv";
    static final String QUERY = "SELECT * FROM PRODUCT WHERE expiryDt > '01/03/2021' ";
    static final String DELETE = "DELETE FROM PRODUCT WHERE expiryDt > '01/03/2021' ";

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        String row;
        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            // do something with the data
        }
        csvReader.close();

        Connection conn = MySQLConnect.getConnection();
        createTable(conn);
        insertTable(conn);
        updateCSV(conn);
        deleteRows(conn);
    }



    private static void createTable(Connection conn){

        try(Statement stmt = conn.createStatement();) {
            String sql = "CREATE TABLE PRODUCT " +
                    "(id INTEGER not NULL, " +
                    " productName VARCHAR(255), " +
                    " productDesc VARCHAR(255), " +
                    " mfgDate DATE, " +
                    " expiryDt DATE, " +
                    " PRIMARY KEY ( id ))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertTable(Connection conn){

        try(Statement stmt = conn.createStatement();) {


            String sql = "INSERT INTO PRODUCT VALUES (1001, 'Biscuit', 'Star', '01/04/2020', '01/04/2021')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO PRODUCT VALUES (1002, 'Noodles', 'Maggi', '01/04/2020', '01/04/2021')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO PRODUCT VALUES (1003, 'Chocolate', 'Cadbury', '01/04/2020', '01/03/2021')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO PRODUCT VALUES(1004, 'Curd', 'DanOne', '01/04/2020', '01/03/2021')";
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private static void deleteRows(Connection conn) throws SQLException {
        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(DELETE);
        ){}


    }

    private  static void updateCSV(Connection conn) throws IOException {

        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
        ){
            List<String> row = new ArrayList<>();
            List<List<String>> rows = new ArrayList<>();
            Integer id;
            Date date;
            while(rs.next()){
                System.out.println(" ");
                id = rs.getInt("id");
                date = rs.getDate("mfgDate");
                row.add(id.toString());
                row.add(rs.getString("productName"));
                row.add(rs.getString("productDesc"));
                row.add(date.toString());
                date = rs.getDate("expiryDt");
                row.add(date.toString());

                rows.add(row);
            }

            FileWriter csvWriter = new FileWriter(pathToCsv);
            csvWriter.append("ID");
            csvWriter.append(",");
            csvWriter.append("ProductName");
            csvWriter.append(",");
            csvWriter.append("ProductDesc");
            csvWriter.append(",");
            csvWriter.append("Mfg Date");
            csvWriter.append(",");
            csvWriter.append("Expiry Dt");
            csvWriter.append("\n");

            for (List<String> rowData : rows) {
                csvWriter.append(String.join(",", rowData));
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
