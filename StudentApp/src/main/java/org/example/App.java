package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static String LOAD_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String URL="jdbc:mysql://localhost:3306/studentdb";
    public static String PASSWORD="Liladhar@123";
    public static String USERNAME="root";
    public static void main( String[] args )
    {
        try{
        //load driver
        Class.forName(LOAD_DRIVER);//

            //makin connection
          Connection connection =  DriverManager.getConnection(URL,USERNAME,PASSWORD);

          //create statement
            Statement statement = connection.createStatement();

            // create queru
//            String Query = "select * from students";
//            ResultSet resultSet = statement.executeQuery(Query);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student1");
            while(resultSet.next())
            {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String course = resultSet.getString("course");
                System.out.println("ID: "+id+" name: "+name+" course "+course);
            }
            connection.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
//        finally {
//            connection.close();
//        }
//        finally me krunga to i need to make it instance variable

    }
}
