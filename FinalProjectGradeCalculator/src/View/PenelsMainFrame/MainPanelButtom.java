package View.PenelsMainFrame;

import IMODELS.IModel;
import IMODELS.IView;
import IMODELS.IViewModel;
import Log4j.Log;
import View.ViewShowGrade;
import ViewModel.ViewModelMainFrame;
import ViewModel.ViewModelShowGrade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * This class represents panel bottom of view class ViewMainFrame.
 */

public class MainPanelButtom extends JPanel {
    private JButton grads;
    private JLabel avg;
    private  JLabel avgValue;
    private GridBagConstraints gbc;
    private IViewModel iViewModel;
    private Log log;

    /**
     * Constructor  that initializes all the components and add to the frame of ViewMainFrame.
     * @param model model from frame we want to add this panel.
     */




    public MainPanelButtom(IModel model) {
        log=new Log(this.getClass().getName());



        gbc = new GridBagConstraints();
        grads = new JButton("Show Grade");
        avg = new JLabel("Avg");
        avgValue = new JLabel("");
        setLayout(new FlowLayout());

        add(grads);

        add(avg);


        add(avgValue);
        try {
            grads.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    log.addLogerInfo("Grade button pressed");
                    IViewModel iViewModel=new ViewModelShowGrade();
                    iViewModel.setModel(model);
                    IView view=new ViewShowGrade(model);
                    view.setViewModel(iViewModel);
                    iViewModel.setView(view);
                    try {
                        view.start();
                    } catch (SQLException ex) {
                        log.addLogerEror("SQLException catch");
                        ex.printStackTrace();
                    }


                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    /**
     * this method define is ViewModel of this view.
     * @param ob the ViewModel to define.
     */
    public void setViewModel(IViewModel ob) {
        this.iViewModel=ob;

    }

    /**
     * this method is update avg view after event.
     */
    public void updateAvgValu(){
        try {
            this.avgValue.setText(iViewModel.CaceleterAvg(iViewModel.getName()).toString());
        } catch (SQLException e) {

        }catch (Exception e){
            System.out.println(iViewModel.getName());

        }
    }
}



