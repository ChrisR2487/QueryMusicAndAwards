/*
Author: Christopher Roberts
E-mail: cmr663@psu.edu
Course: CMPSC 221
Assigment: Final Programming Assigment
Due Date: 5/6/2020
File: QueryMusicAndAwards.java
Purpose: Java app that connects to a mySQL database and queries it
Compiler/IDE: IntelliJ IDEA
Operating System: MS Windows 10
References: https://www.geeksforgeeks.org/sql-group-by/, https://www.w3schools.com/sql/sql_where.asp, https://www.geeksforgeeks.org/sql-order-by/,
 */
import java.sql.*;
public class Music {
    //Database URL
    static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/musicdata";

    public static void main(String[] args) {

        try{
            // establish connection to database
            Connection connection = DriverManager.getConnection(DATABASE_URL, "root", "Biomega2487!");

            // process query results
            try{
                // process 1st query result
                // create Statement for querying database
                Statement statement = connection.createStatement();
                // query database
                ResultSet resultSet = statement.executeQuery("select * from musictitles order by artist asc ");
                ResultSetMetaData metaData = resultSet.getMetaData();
                int numOfColumns =  metaData.getColumnCount();

                System.out.println("\"musicTitles\" Table Of Music Database: " );
                System.out.println("--------------------------------------" );
                printColumns(resultSet, metaData, numOfColumns);

                statement.close();
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            System.out.println();

            try{
                // process 2nd query result
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from musicawards order by awardYear desc ");
                ResultSetMetaData metaData = resultSet.getMetaData();

                int numOfColumns =  metaData.getColumnCount();
                System.out.println("\"musicAwards\" Table Of Music Database: " );
                System.out.println("--------------------------------------" );
                printColumns(resultSet, metaData, numOfColumns);
                System.out.println();

                statement.close();
                resultSet.close();

            }catch (SQLException e){
                e.printStackTrace();
            }

            try{
                // process 3rd query result
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select genre, artist, award, awardYear from musictitles join musicawards m on musictitles.musicID = m.musicID ");
                ResultSetMetaData metaData = resultSet.getMetaData();
                int numOfColumns1 =  metaData.getColumnCount();

                System.out.println("Musical Artists Who Have Received Awards: " );
                System.out.println("----------------------------------------" );
                printColumns(resultSet, metaData, numOfColumns1);
                System.out.println();

                statement.close();
                resultSet.close();

            }catch (SQLException e){
                e.printStackTrace();
            }

            try{
                // process 4th query result
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from musictitles where genre = 'R&B' ");
                ResultSetMetaData metaData = resultSet.getMetaData();
                int numOfColumns =  metaData.getColumnCount();

                System.out.println("Musical Listings Where The Genre Is \"R&B\": ");
                System.out.println("----------------------------------------" );
                printColumns(resultSet, metaData, numOfColumns);

                statement.close();
                resultSet.close();

            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static void printColumns(ResultSet resultSet, ResultSetMetaData metaData, int numOfColumns) throws SQLException {
        for (int i = 1; i <= numOfColumns; i++) {
            System.out.printf("%-50s\t", metaData.getColumnName(i));
        }

        System.out.println();
        while (resultSet.next()) {
            for (int i = 1; i <= numOfColumns; i++) {
                System.out.printf("%-50s\t", resultSet.getObject(i));
            }
            System.out.println();
        }
    }

}
