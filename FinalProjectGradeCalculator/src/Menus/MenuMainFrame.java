package Menus;

import IMODELS.IModel;
import IMODELS.IView;
import IMODELS.IViewModel;
import Log4j.Log;
import Model.ModelDerbyDb;
import View.ViewDeleteCours;
import View.ViewWelcomeFrame;
import ViewModel.ViewModelWelcomFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MenuMainFrame {
    private IViewModel iViewModel;
    private  Log log;

    /**
     * this class is a menu to add to frame.
     */
    public MenuMainFrame() {
        log=new Log(this.getClass().getName());

    }

    /**
     * this method create menu and return.
     * @param frame frame we want to add this menu
     * @return this menu
     */

    public JMenuBar createMenuBar(JFrame frame) {



        JMenuBar menuBar;
        JMenu menu, exit,sortCorses;
        JMenuItem semeter,coursName,year,creditPoinst,grade,sineOut,close;
        JMenuItem clear;
        JMenuItem daleteCors;



        ///////////////////////////////////// //Create the menu bar.add A Menu
        menuBar = new JMenuBar();

        //Build the first menu.
        menu = new JMenu("A Menu");

        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);
        /////////////////////////////////////////////////////////////////////////////






//////////////////////////////Delite///////////////////////
        daleteCors=new JMenuItem("Dlete corse");
        daleteCors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.addLogerInfo("Delete Course Menu Button pressed");
                IView view=new ViewDeleteCours();
                view.setViewModel(iViewModel);
                try {
                    view.start();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        menu.add(daleteCors);


        /////////////////////////////Clear///////////////////////////////////////////////
        clear=new JMenuItem("Clear all the table grads");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.addLogerInfo("Clear Menu Button pressed");

                try {

                    iViewModel.deleteTableCours(iViewModel.getName());
                    iViewModel.updatePanelsAndMenu(iViewModel);


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }


            }
        });

        menu.add(clear);







        ////////////////////////////Sort BY//////////////////////////////////////////////////
        menu.addSeparator();
        sortCorses = new JMenu("Sort by");
//////////////////////////
        coursName = new JMenuItem("Course name");
        coursName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.addLogerInfo("Sort course  Menu Button pressed on Course name sort ");

                iViewModel.setWhatOrder("cours_name");
                iViewModel.updatePanelsAndMenu(iViewModel);




            }
        });


        sortCorses.add(coursName);
///////////////////////////
        semeter = new JMenuItem("Semester");
        semeter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.addLogerInfo("Sort course  Menu Button pressed on Semester sort ");



                iViewModel.setWhatOrder("semester");
                iViewModel.updatePanelsAndMenu(iViewModel);



            }
        });
        sortCorses.add(semeter);
/////////////////////////
        grade = new JMenuItem("Grade");
        grade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.addLogerInfo("Sort course  Menu Button pressed on Grade sort ");



                iViewModel.setWhatOrder("grade");
                iViewModel.updatePanelsAndMenu(iViewModel);



            }
        });

        sortCorses.add(grade);
///////////////////////////
        creditPoinst = new JMenuItem("Cradit Point");
        creditPoinst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.addLogerInfo("Sort course  Menu Button pressed on Cradit point sort ");

                iViewModel.setWhatOrder("credit_point");

                iViewModel.updatePanelsAndMenu(iViewModel);



            }
        });
        sortCorses.add(creditPoinst);
//////////////////////////
        year = new JMenuItem("Year");
        year.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.addLogerInfo("Sort course  Menu Button pressed on year sort ");

                iViewModel.setWhatOrder("year");

                iViewModel.updatePanelsAndMenu(iViewModel);



            }
        });
        sortCorses.add(year);
////////////////////////////


        menu.add(sortCorses);
        ///////////////////////////////////////////////////////////////////////////////



        //a Exit
        menu.addSeparator();
        exit = new JMenu("Exit");
        sineOut = new JMenuItem("Sint out");
        sineOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.addLogerInfo("Sine out Menu Button pressed");

                frame.setVisible(false); //you can't see me!
                frame.dispose();
                IView view= new ViewWelcomeFrame();
                IModel model=new ModelDerbyDb();
                IViewModel iViewModelWelcome=new ViewModelWelcomFrame();
                view.setViewModel(iViewModelWelcome);
                iViewModelWelcome.setView(view);
                iViewModelWelcome.setModel(model);
                try {
                    view.start();
                } catch (SQLException ex) {
                    log.addLogerEror("SQLException catch");
                    ex.printStackTrace();
                }

            }
        });
        exit.add(sineOut);
        close = new JMenuItem("Close");
        exit.add(close);
        close.addActionListener(new exitAction());
        menu.add(exit);
///////////////////////////////////////////////////////////////////////////////////////////

        return menuBar;
    }

    /**
     * class action event system exit
     */

    public class  exitAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            log.addLogerInfo("Exit Menu Button pressed");

            System.exit(0);
        }
    }


    /**
     * this method define is ViewModel of this view.
     * @param ob the ViewModel to define.
     */

    public void setViewModel(IViewModel ob) {
        this.iViewModel=ob;

    }

}

