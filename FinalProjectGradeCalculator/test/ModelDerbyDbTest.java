import IMODELS.IModel;
import Model.ModelDerbyDb;


import javax.swing.*;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ModelDerbyDbTest {
   private IModel model;





    @org.junit.Before
    public void setUp() throws Exception {
         model=new ModelDerbyDb();;




    }

    @org.junit.After
    public void tearDown() throws Exception {
        model=null;
    }
    /////////////////////////////////////////////////////////////////
    @org.junit.Test
    public void createUserNamesTable() {
        model.createUserNamesTable();

    }
    @org.junit.Test
    public void addValuesToTableUsers() {
        try {
            createUserNamesTable();
            model.addValuesToTableUsers("TEST","1234");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @org.junit.Test
    public void checkUsernameInTheTable() {
        try {
            addValuesToTableUsers();
            boolean actual=model.checkUsernameInTheTable("TEST","1234");
            assertTrue(actual);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void addValuesToTableCourses() {
        try {
            model.createTableCoursUser("TEST");


            model.addValuesToTableCourses("TEST","Math","2","1","5","80");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @org.junit.Test
    public void caceleterAvg() {
        float expected=80;
        try {
            float actual =model.CaceleterAvg("TEST");
            assertEquals(expected,actual,0.02);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @org.junit.Test
    public void numbersOfRows() {
        addValuesToTableCourses();
       deleteTableCours();
        float expected=0;
        try {
            float actual=model.numbersOfRows("TEST");
            assertEquals(expected,actual,0);

        } catch (SQLException e) {
            System.out.println("didnt work");
        }


    }


/////////////////////////////////////////////////////////////////////////////




    @org.junit.Test
    public void setYear() {
        String[] strYear={"1","2"};
        JComboBox year=new JComboBox(strYear);
        year.setSelectedItem("1");
        model.setYear(year);

    }

    @org.junit.Test
    public void getYear() {
        setYear();
        String expected="1";
        String actual=model.getYear().getSelectedItem().toString();
        assertEquals("",expected,actual);

    }



    @org.junit.Test
    public void getSemester() {


        setSemester();
        String expected="A";
        String actual=model.getSemester().getSelectedItem().toString();
        assertEquals("",expected,actual);

    }

    @org.junit.Test
    public void setSemester() {
        String[] strSemester={"A","B"};
        JComboBox semester=new JComboBox(strSemester);
        semester.setSelectedItem("A");
        model.setSemester(semester);

    }

    @org.junit.Test
    public void getName() {
        setName();
        String expected="TEST";
        String actual=model.getName();
        assertEquals("",expected,actual);

    }

    @org.junit.Test
    public void setName() {
        model.setName("TEST");
    }




    @org.junit.Test
    public void deleteTableCours() {
        try {
            model.deleteTableCours("TEST");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}