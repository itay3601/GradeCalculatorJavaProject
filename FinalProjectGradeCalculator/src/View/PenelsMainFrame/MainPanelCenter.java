package View.PenelsMainFrame;

import IMODELS.IModel;
import IMODELS.IView;
import IMODELS.IViewModel;
import Log4j.Log;
import Model.ModelDerbyDb;
import View.AlrmMassages.MsgCompleteAllTheFild;
import View.AlrmMassages.MsgOnlyNumbers;
import View.ViewMainFrame;
import ViewModel.ViewModelMainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * This class represents panel center of view class ViewMainFrame.
 */

public class MainPanelCenter extends JPanel {
    private GridBagConstraints gbc = new GridBagConstraints();
    private JLabel coursName;
    private JTextField coursNameFild;
    private JLabel point;
    private JTextField pointField;
    private JLabel grade;
    private JTextField gradeField;
    private JButton addCourse;
    private IViewModel iViewModel;
    private Log log;

    /**
     * Constructor  that initializes all the components and add to the frame of ViewMainFrame.
     * @param model model from the frame
     * @param frame frame to add panel.
     */


    public MainPanelCenter(IModel model,JFrame frame) {
        log=new Log(this.getClass().getName());


        setLayout(new GridBagLayout());
        setSize(10,10);
        coursName=new JLabel("Cours Name");
        coursNameFild=new JTextField(10);
        point=new JLabel("Point");
        pointField=new JTextField(10);
        grade=new JLabel("Grade");
        gradeField=new JTextField(10);
        addCourse=new JButton("Add Cours");
        coursName.setSize(2,5);
        coursName.setSize(2,5);
        point.setSize(2,5);
        pointField.setSize(2,5);
        grade.setSize(2,5);
        gradeField.setSize(2,5);
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.gridx=0;
        gbc.gridy=0;
        add(coursName,gbc);
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.gridx=5;
        gbc.gridy=0;
        add(coursNameFild,gbc);
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.gridx=10;
        gbc.gridy=0;
        add(point,gbc);
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.gridx=15;
        gbc.gridy=0;
        add(pointField,gbc);
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.gridx=20;
        gbc.gridy=0;
        add(grade,gbc);
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.gridx=25;
        gbc.gridy=0;
        add(gradeField,gbc);
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.gridx=30;
        gbc.gridy=0;
        add(addCourse,gbc);
        addCourse.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             try {
                 log.addLogerInfo("AddCourse button pressed");
                 if (checkOnEmtyFild()) {
                     log.addLogerEror("one of the filed is empty");
                     IView view=new MsgCompleteAllTheFild();
                         view.start();

                 }  else {
                 float pointCheck=Float.parseFloat(pointField.getText());
                 float gradeChaeck=Float.parseFloat(gradeField.getText());



                 iViewModel.addValuesToTableCourses(iViewModel.getName(),coursNameFild.getText(),iViewModel.getYear().getSelectedItem().toString(),iViewModel.getSemester().getSelectedItem().toString(),pointField.getText(),gradeField.getText());
                     iViewModel.updatePanelsAndMenu(iViewModel);
                     log.addLogerInfo("add course is successfully ");
                     }
             } catch (SQLException ex) {
                 log.addLogerEror("SQLException catch");
                 ex.printStackTrace();
             } catch (ClassNotFoundException ex) {
                 log.addLogerEror("ClassNotFoundException catch");
                 ex.printStackTrace();
             }
         catch(NumberFormatException ex) {
                 log.addLogerEror("NumberFormatException catch");
                 log.addLogerEror("cradit point or garde fileds is not a number");
             IView view=new MsgOnlyNumbers();
             try {
                 view.start();
             } catch (SQLException exc) {
                 log.addLogerEror("SQLException catch");
                 exc.printStackTrace();
             }
         }
         }
     });
    }

    /**
     * this method return true if one of the filed is empty
     * @return boleean (true or false)
     */
    public boolean checkOnEmtyFild(){
        if(coursNameFild.getText().equals("")||pointField.getText().equals("")||gradeField.getText().equals("")){
            return true;
        }
        return false;
    }
    /**
     * this method define is ViewModel of this view.
     * @param ob the ViewModel to define.
     */
    public void setViewModel(IViewModel ob) {
        this.iViewModel=ob;

    }
}