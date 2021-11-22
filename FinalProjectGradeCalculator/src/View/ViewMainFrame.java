package View;

import IMODELS.IModel;
import IMODELS.IView;
import IMODELS.IViewModel;
import Menus.MenuMainFrame;
import View.PenelsMainFrame.MainPanelButtom;
import View.PenelsMainFrame.MainPanelCenter;
import View.PenelsMainFrame.MainPanelTop;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

/**
 * this class is a view for main frame.
 */

public class ViewMainFrame implements IView {
    private JFrame frame;
    private MainPanelTop mainPanelTop;
    private MainPanelButtom mainPanelButtom;
    private MainPanelCenter mainPanelCenter;
   private IViewModel iViewModel;
    /**
     * Constructor empty that initializes all the panels and add to the frame.
     */


    public ViewMainFrame() {

        frame = new JFrame();

    }
    /**
     * this method add to frame all the panels and menus
     */

    @Override
    public void start() {
        frame.setTitle("Grades Calculator - " + iViewModel.getName());
        iViewModel.createTableCoursUser(iViewModel.getName());

        MenuMainFrame menuMainFrame = new MenuMainFrame();
        menuMainFrame.setViewModel(iViewModel);
        iViewModel.setMenuMainFrame(menuMainFrame);


        ////////////////////////////////////////////////////////////
        mainPanelButtom = new MainPanelButtom(iViewModel.getModel());
        mainPanelButtom.setViewModel(iViewModel);

        mainPanelButtom.updateAvgValu();
        iViewModel.setMainPanelButtom(mainPanelButtom);
        ///////////////////////////////////////////////////////////

        mainPanelCenter = new MainPanelCenter(iViewModel.getModel(), frame);
        mainPanelCenter.setViewModel(iViewModel);
        iViewModel.setMainPanelCenter(mainPanelCenter);
        ///////////////////////////////////////////////////////////
        mainPanelTop = new MainPanelTop(iViewModel.getModel());
        mainPanelTop.setViewModel(iViewModel);


        iViewModel.setMainPanelTop(mainPanelTop);
        ////////////////////////////////////////////////


        frame.setJMenuBar(menuMainFrame.createMenuBar(frame));

        frame.add(mainPanelTop, new BorderLayout().NORTH);
        frame.add(mainPanelCenter, new BorderLayout().CENTER);
        frame.add(mainPanelButtom, new BorderLayout().SOUTH);

        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocation(500,100);
        frame.setMinimumSize(new Dimension(700,700));

    }




    /**
     * this method define is ViewModel of this view.
     * @param ob the ViewModel to define.
     */

    @Override
    public void setViewModel(IViewModel ob) {
        this.iViewModel=ob;

    }



}
