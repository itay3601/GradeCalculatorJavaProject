package Model;

import IMODELS.IModel;

import javax.swing.*;
import java.sql.*;

/**
 * model derby db embedded driver
 */

public class ModelDerbyDb implements IModel {
    /**
     * this class is a model derby db to estoreg data
     */
    private String whatOrder;
    private  String  userName;
    private JComboBox year;
    private  JComboBox semester;
    private  String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private    String protocol = "jdbc:derby:zadb;create=true";
    private   String SQL_STATMENT = "select * from UserNames";

   /**
     * this method return JComboBox year how save in the set method
     * @return JComboBox year
     */


    public JComboBox getYear() {
        return year;
    }
 /**
     * this method save JComboBox year.
     * @param year JComboBox to save
     */





    public void setYear(JComboBox year) {
        this.year = year;
    }



/**
     * * this method save JComboBox semester.
     * @return  JComboBox semester.
     */


    public JComboBox getSemester() {
        return semester;
    }

    /**
     *this method Saves the user selection to arrange the courses table
     * @param whatOrder string option is grade,course name,credit points,semester,year.
     */


    @Override
    public void setWhatOrder(String whatOrder) {
        this.whatOrder=whatOrder;
    }


/**
     *this method return user selection to arrange the courses table
     * @return return A selected string
     */

    @Override
    public String getWhatOrder() {
        return this.whatOrder;
    }
 /**
     *this method return JComboBox semester how save in the set method
     * @param semester JComboBox to save
     */



    public void setSemester(JComboBox semester) {
        this.semester = semester;
    }

    /**
     * Constructor empty
     */


    public ModelDerbyDb() {
    }


  /**
     *this method Returns the name of the user who is logged
     * @return user name that is currently logged on
     */

    @Override
    public String getName() {
        return userName;
    }
    /**
     * this method saves the user name that connects
     * @param name set a new user name
     */



    @Override
    public void setName(String name) {
        this.userName=name;

    }
    /**
     *
     * @param name  user name that is currently logged on
     * @param password password of the user name that is currently logged on
     * @throws SQLException The function can throw SQLException
     * @throws ClassNotFoundException  The function can throw ClassNotFoundException
     */


          ////////////////Add a user name to the user table/////////////////////////
    @Override
    public void addValuesToTableUsers(String name, String password) throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(protocol);
        connection.createStatement().execute("INSERT INTO UserNames values " +
                "('" + name + "','" + password + "')");


    }
 /**
     *this method is Add course entries to the name table used to connect
     * @param userName user name that is currently logged on
     * @param nameCours The name of the course that you want to enter the courses table
     * @param year  The year in which the course will take place
     * @param semster  The semester in which the course will take place
     * @param craditPoint Course Number of Credits
     * @param grade Final grade of the course
     * @throws SQLException The function can throw SQLException
     * @throws ClassNotFoundException The function can throw ClassNotFoundException
     */


////////////////////////////////////Add course entries to the name table used to connect//////////////////////////
    @Override
    public void addValuesToTableCourses(String userName, String nameCours, String year, String semster, String craditPoint, String grade) throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(protocol);
        connection.createStatement().execute("INSERT INTO "+userName+" values " +
                "('" + userName + "','" + nameCours + "','" + year + "','" + semster + "','" + craditPoint + "','" + grade + "')");




    }
 /**
     *this method Check whether the username and password exist in memory(on user name table)
     * @param name User name for review
     * @param pass password  for review
     * @return return true if the username and password exist in memory else return false
     * @throws SQLException The function can throw SQLException
     */


    ////////Check whether the username and password exist in memory(on user name table)////////////////////

    @Override
    public boolean checkUsernameInTheTable(String name, String pass) throws SQLException {

        Connection connection = DriverManager.getConnection(protocol);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_STATMENT);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columcount = resultSetMetaData.getColumnCount();

        for(int i=0;resultSet.next();i++){
            for(int x=1;x<=columcount;x++){
                if (resultSet.getString(x).equals(name)&&resultSet.getString(x+1).equals(pass) ) {
                    if (statement != null) statement.close();
                    if (connection != null) connection.close();

                    return true;
                }
            }
        }



        if (statement != null) statement.close();
        if (connection != null) connection.close();

        return false;


    }
/**
     * print table users

     */


    /////////print user name table//////////////////

    @Override
    public void printtable()  {
        try {
            Connection connection = DriverManager.getConnection(protocol);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_STATMENT);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columcount = resultSetMetaData.getColumnCount();
            for (int x = 1; x <= columcount; x++)
                System.out.format("%20s", resultSetMetaData.getCatalogName(x) + " | ");
            while (resultSet.next()) {
                System.out.println("");
                for (int x = 1; x <= columcount; x++)
                    System.out.format("%20s", resultSet.getString(x) + " | ");
            }
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }catch (SQLException e){

        }

    }
 /**
     * this method Check whether the username  exist in memory(on user name table)
     * @param name User name for review
     * @return return true if the username exist in memory else return false
     * @throws SQLException The function can throw SQLException
     */



    ////////Check whether the username  exist in memory(on user name table)////////////////////

    @Override
    public boolean checknameInTheTable(String name) throws SQLException {

        Connection connection = DriverManager.getConnection(protocol);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_STATMENT);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columcount = resultSetMetaData.getColumnCount();

        for(int i=0;resultSet.next();i++){
            for(int x=1;x<=columcount;x++){
                if (resultSet.getString(x).equals(name) ) {
                    if (statement != null) statement.close();
                    if (connection != null) connection.close();

                    return true;
                }
            }
        }


        if (statement != null) statement.close();
        if (connection != null) connection.close();
        return false;

    }
 /**
     *  this method Average computer by credit point and grade of all courses of this username
     * @param userName user name that is currently logged on
     * @return  return  float of the result of the average calculation.
     * @throws SQLException The function can throw SQLException
     */


///////////////////////Average computer by credit point and grade of all courses/////////////
    @Override
    public Float CaceleterAvg(String userName) throws SQLException {
        Connection connection = DriverManager.getConnection(protocol);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select creditPoint,grade from "+userName);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columcount = resultSetMetaData.getColumnCount();
        float grade=0;
        float point=0;
        float sumPoint=0;
        float avg=0;

        for(int i=1;resultSet.next();i++){
            grade = (Float.parseFloat(resultSet.getString(columcount)));
            point = (Float.parseFloat(resultSet.getString(columcount-1)));
            sumPoint+=(Float.parseFloat(resultSet.getString(columcount-1)));
            avg+=(grade*point);


        }

        if (statement != null) statement.close();
        if (connection != null) connection.close();
        avg=avg/sumPoint;

        return avg;

    }
 /**
     * this method delete all the values of course table of this user name.
     * @param userName user name that is currently logged on.
     * @throws SQLException The function can throw SQLException.
     */


    ////////////////////////Delete the entire course display table///////////////

    @Override
    public void deleteTableCours(String userName) throws SQLException {
        Connection connection = DriverManager.getConnection(protocol);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from "+userName);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columcount = resultSetMetaData.getColumnCount();
        connection.createStatement().executeUpdate("DELETE FROM  "+userName+" WHERE username= "+"'"+userName+"'"+"");
        if (statement != null) statement.close();
        if (connection != null) connection.close();

    }
 /**
     *
     * @param userName user name that is currently logged on.
     * @param cours_name Name of the course you want to delete from the courses table
     * @throws SQLException The function can throw SQLException.
     */


    @Override
    public void deliteCourseName(String userName, String cours_name) throws SQLException {
        Connection connection = DriverManager.getConnection(protocol);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from "+userName);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columcount = resultSetMetaData.getColumnCount();
        connection.createStatement().executeUpdate("DELETE FROM  "+userName+" WHERE coursName= "+"'"+cours_name+"'"+"");
        if (statement != null) statement.close();
        if (connection != null) connection.close();

    }
 /**
     * this method Create a User Name table.
     */

    //////////////////Create a User Name table///////////////////

    @Override
    public void createUserNamesTable() {
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(protocol);

            connection.createStatement().execute("create table UserNames (username varchar(20), password varchar(20))");
        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        }
    }
  /**
     * this method Create a table course for a user created
     * @param name user name that is currently logged on.
     */

        /////////////////////////////////Create a table for a user created/////////////////////////
    @Override
    public void createTableCoursUser(String name) {
        try {
            Class.forName(driver);
            Connection connection = null;
            connection = DriverManager.getConnection(protocol);
            connection.createStatement().execute("create table " + name + " (username varchar(20), coursName varchar(20),year1 varchar(20),semester varchar(20),creditPoint varchar(20),grade varchar(20))");

        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        }
    }
    /////////////////////Inserting the course table entries into the matrix of objects////////////
 /**
     *this method Inserting the course table entries into the matrix of objects
     * @param sql sql statment  for choose result.
     * @param row number of row of the metrix to create.
     * @return Returns the matrix object after the entry of the values.
     * @throws SQLException The function can throw SQLException.
     */

    @Override
    public Object[][] printTableShowGrades(String sql,int row) throws SQLException {

        Connection connection= DriverManager.getConnection(protocol);
        Statement statement =connection.createStatement();
        ResultSet resultSet =statement.executeQuery(sql);
        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
        int columCount=resultSetMetaData.getColumnCount();

        Object[][] data1=new Object[row][6] ;



        for(int i=0;resultSet.next();i++){
            for(int x=1;x<=columCount;x++){
                data1[i][x-1]=resultSet.getString(x);
            }
        }

        if (statement != null) statement.close();
        if (connection != null) connection.close();
        return data1;
    }

/**
     * this method Checking the number of table row and return.
     * @param nameTable The name of the table for reviewץ
     * @return number of row in the table.
     * @throws SQLException The function can throw SQLException.
     */

    ////////returns the number of rows that are present in the courses table/////////
    public int numbersOfRows(String nameTable) throws SQLException {
        Connection connection= DriverManager.getConnection(protocol);
        Statement statement =connection.createStatement();
        ResultSet resultSet =statement.executeQuery("SELECT COUNT(*) FROM "+nameTable);

        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
        resultSet.next();
        int row=resultSet.getInt(1);

        return row;

    }


}
