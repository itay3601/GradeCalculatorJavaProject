package View.PenelsMainFrame;

import IMODELS.IModel;
import IMODELS.IViewModel;
import Log4j.Log;
import ViewModel.ViewModelMainFrame;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents panel top of view class ViewMainFrame.
 */

public class MainPanelTop extends JPanel {
    private IViewModel iViewModel;
    private JLabel choseYear;
   private JLabel year;
     private JComboBox boxYear;
     private Log log;
    private JLabel semester;
    private JComboBox boxSemester;
    private GridBagConstraints gbc = new GridBagConstraints();

    /**
     * Constructor  that initializes all the components and add to the frame of ViewMainFrame.
     * @param model model from the frame.
     */

    public MainPanelTop(IModel model) {
        log=new Log(this.getClass().getName());

        IViewModel iViewModel=new ViewModelMainFrame();
        iViewModel.setModel(model);
        setSize(10, 10);

        year=new JLabel("Year");
        choseYear=new JLabel("Select year and semester",10);
        choseYear.setSize(10,10);


        String[] yearStr={"1","2","3","4"};
        String[] semesterStr={"Semester A","Semester B","Semester Summer"};


        this.boxYear=new JComboBox(yearStr);
        iViewModel.setYear(boxYear);

        semester=new JLabel("Semester");
        boxYear.setSize(2,2);
        this.boxSemester=new JComboBox(semesterStr);
        iViewModel.setSemester(boxSemester);



        setLayout(new GridBagLayout());

        gbc.gridx=0;
        gbc.gridy=0;
        add(choseYear,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        add(year,gbc);
        gbc.gridx=10;
        gbc.gridy=1;
        add(boxYear,gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        add(semester,gbc);
        gbc.gridx=10;
        gbc.gridy=2;
        add(boxSemester,gbc);


    }


    /**
     * this method define is ViewModel of this view.
     * @param ob the ViewModel to define.
     */
    public void setViewModel(IViewModel ob) {
        this.iViewModel=ob;

    }

}
