package View;

import IMODELS.IModel;
import IMODELS.IView;
import IMODELS.IViewModel;
import Log4j.Log;
import ViewModel.ViewModelMainFrame;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

/**
 * this class is view for show grade button.
 */

public class ViewShowGrade implements IView {
    private JFrame frame;
    private IViewModel iViewModel;
    private String SqlStatment;
    private Log log;


    /**
     * Constructor empty that initializes all the components
     * @param model get the model from last frame.
     */
    public ViewShowGrade(IModel model) {
        log=new Log(this.getClass().getName());

        IViewModel iViewModel=new ViewModelMainFrame();
        iViewModel.setModel(model);
        SqlStatment="select * from"+" "+iViewModel.getName()+" ORDER by coursName";

        frame=new JFrame("Grades");
        frame.setSize(400,400);
        frame.setLocation(500,100);
        frame.setMinimumSize(new Dimension(200,200));

        frame.setVisible(true);

    }

    @Override
    public void start() throws SQLException {
        log.addLogerInfo("ViewShowGrade frame is open");
          howToOrder();
        String[] columnNames = {"usename","Course Name", "Year", "Semester", "Cradit Points", "Grade"};

///////////////////////////////////////////////////////////////////////////////////////
        JTable table = new JTable(iViewModel.printTableShowGrades(SqlStatment, iViewModel.numbersOfRows(iViewModel.getName())), columnNames);
        JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        table.setFillsViewportHeight(true);
        frame.setLayout(new BorderLayout());
        frame.add(table.getTableHeader(), BorderLayout.PAGE_START);
        frame.add(scrollPane);






    }
    /**
     * this method define is ViewModel of this view.
     * @param ob the ViewModel to define.
     */

    @Override
    public void setViewModel(IViewModel ob) {
        iViewModel=ob;

    }

    /**
     * this method Checks the value of whatOrder, and therefore returns sql statment that determines the order.
     */
    public void howToOrder(){
        try {

            if (iViewModel.getWhatOrder().equals("cours name")) {
                SqlStatment = "select * from" + " " + iViewModel.getName() + " ORDER by coursName";
            } else if (iViewModel.getWhatOrder().equals("year")) {
                SqlStatment = "select * from" + " " + iViewModel.getName() + " ORDER by year1";
            } else if (iViewModel.getWhatOrder().equals("grade")) {
                SqlStatment = "select * from" + " " + iViewModel.getName() + " ORDER by grade DESC";
            } else if (iViewModel.getWhatOrder().equals("credit_point")) {
                SqlStatment = "select * from" + " " + iViewModel.getName() + " ORDER by creditPoint DESC";
            } else if (iViewModel.getWhatOrder().equals("semester")) {
                SqlStatment = "select * from" + " " + iViewModel.getName() + " ORDER by semester";
            }
        }catch (NullPointerException e){
        }
    }

}
