package IMODELS;

import Menus.MenuMainFrame;
import View.PenelsMainFrame.MainPanelButtom;
import View.PenelsMainFrame.MainPanelCenter;
import View.PenelsMainFrame.MainPanelTop;

import javax.swing.*;
import java.sql.SQLException;

/**
 * this is interface Helps communicate between the models and the views and opposite.
 */

public interface IViewModel {
    /**
     * this method display the model to communicate.
     * @param m model to set to communicate.
     */
    public void setModel(IModel m);

    /**
     * this method display the view to communicate.
     * @param v view to set to communicate.
     */
    public  void setView(IView v);

    /**
     * this method return the model how set in the set method.
     * @return model how set in the set method.
     */
    public  IModel getModel();

    /**
     * this method set to frame menu .
     * @param menuMainFrame menu to add.
     */
    public void setMenuMainFrame(MenuMainFrame menuMainFrame);
    /**
     *this method Saves the user selection to arrange the courses table
     * @param whatOrder string option is grade,course name,credit points,semester,year.
     */
    public void setWhatOrder(String whatOrder);
    /**
     *this method return user selection to arrange the courses table
     * @return return A selected string
     */
    public String getWhatOrder();

    /**
     * this method  set IViewModel to panels.
     * @param iViewModel IViewModel to set.
     */
    public  void updatePanelsAndMenu(IViewModel iViewModel);

    /**
     * method to set a panel of mainframe
     * @param mainPanelTop panel top
     */
    public void setMainPanelTop(MainPanelTop mainPanelTop);

    /**
     * method to set a panel of mainframe
     * @param mainPanelCenter panel center
     */
    public void setMainPanelCenter(MainPanelCenter mainPanelCenter);

    /**
     * method to set a panel of mainframe
     * @param mainPanelButtom panel bottom
     */
    public void setMainPanelButtom(MainPanelButtom mainPanelButtom);
    /**
     *this method return JComboBox semester how save in the set method
     * @param semester JComboBox to save
     */
    public void setSemester(JComboBox semester);
    /**
     * * this method save JComboBox semester.
     * @return  JComboBox semester.
     */
    public JComboBox getSemester();
    /**
     * this method save JComboBox year.
     * @param year JComboBox to save
     */
    public void setYear(JComboBox year);
    /**
     * this method return JComboBox year how save in the set method
     * @return JComboBox year
     */
    public JComboBox getYear();
    /**
     *this method Returns the name of the user who is logged
     * @return user name that is currently logged on
     */
    public  String getName();
    /**
     * this method saves the user name that connects
     * @param name set a new user name
     */
    public  void setName(String name);
    /**
     *
     * @param name  user name that is currently logged on
     * @param password password of the user name that is currently logged on
     * @throws SQLException The function can throw SQLException
     * @throws ClassNotFoundException  The function can throw ClassNotFoundException
     */
    public  void addValuesToTableUsers(String name, String password) throws SQLException, ClassNotFoundException ;
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
    public  void addValuesToTableCourses(String userName, String nameCours, String year, String semster, String craditPoint, String grade) throws SQLException, ClassNotFoundException ;
    /**
     *this method Check whether the username and password exist in memory(on user name table)
     * @param name User name for review
     * @param pass password  for review
     * @return return true if the username and password exist in memory else return false
     * @throws SQLException The function can throw SQLException
     */
    public boolean checkUsernameInTheTable(String name, String pass) throws SQLException;

    /**
     * print table users
     * @throws SQLException may throws SQLException
     */
    public void printtable() throws SQLException;
    /**
     * this method Check whether the username  exist in memory(on user name table)
     * @param name User name for review
     * @return return true if the username exist in memory else return false
     * @throws SQLException The function can throw SQLException
     */
    public  boolean checknameInTheTable(String name) throws SQLException ;
    /**
     *  this method Average computer by credit point and grade of all courses of this username
     * @param userName user name that is currently logged on
     * @return  return  float of the result of the average calculation.
     * @throws SQLException The function can throw SQLException
     */
    public  Float CaceleterAvg(String userName) throws SQLException;
    /**
     * this method delete all the values of course table of this user name.
     * @param userName user name that is currently logged on.
     * @throws SQLException The function can throw SQLException.
     */
    public void deleteTableCours (String userName) throws SQLException ;
    /**
     *
     * @param userName user name that is currently logged on.
     * @param cours_name Name of the course you want to delete from the courses table
     * @throws SQLException The function can throw SQLException.
     */

    public void deliteCourseName(String userName,String cours_name) throws SQLException;
    /**
     * this method Create a table course for a user created
     * @param name user name that is currently logged on.
     */

    public  void createTableCoursUser(String name);
    /**
     *this method Inserting the course table entries into the matrix of objects
     * @param sql sql statment  for choose result.
     * @param row number of row of the metrix to create.
     * @return Returns the matrix object after the entry of the values.
     * @throws SQLException The function can throw SQLException.
     */
    public  Object[][] printTableShowGrades(String sql,int row) throws SQLException;
    /**
     * this method Checking the number of table row and return.
     * @param nameTable The name of the table for reviewץ
     * @return number of row in the table.
     * @throws SQLException The function can throw SQLException.
     */
    public int numbersOfRows(String nameTable) throws SQLException;
    /**
     * this method Create a User Name table.
     */
    public void createUserNamesTable();
}

