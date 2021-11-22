package View;
import IMODELS.*;
import Log4j.Log;
import Model.ModelDerbyDb;
import View.AlrmMassages.MsgUserNotExist;
import ViewModel.ViewModelMainFrame;
import ViewModel.ViewModelRegisterFrame;
import Log4j.Log;
import org.apache.log4j.Logger;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * this class is view for login frame.
 */


public class ViewWelcomeFrame implements IView {
    private JFrame frame;
    private GridBagConstraints gbc ;
    private JLabel userName;
    private JLabel password;
    private JButton okBtn;
    private JPasswordField passwordField;
    private JTextField userNameField;
    private JButton newBtn;
    private IViewModel iViewModel;

   private Log log;

    /**
     * Constructor empty that initializes all the components
     */

    public ViewWelcomeFrame() {
        log=new Log(this.getClass().getName());


        gbc = new GridBagConstraints();
        frame=new JFrame("Login");
        userName=new JLabel("Name:  ");
        password=new JLabel("Password:  ");
        okBtn=new JButton("OK");
        newBtn=new JButton("NEW");
        passwordField=new JPasswordField(10);
        passwordField.setSize(2,5);
        userNameField=new JTextField(10);
        userNameField.setSize(2,5);
        frame.setLayout(new GridBagLayout());
        frame.setSize(new Dimension(300,300));


    }

    /**
     * this method add to frame all the components and operate actionListener to the buttons.
     */

    @Override
    public void start() {
        log.addLogerInfo("ViewWelcomeFrame is open ");

        gbc.gridx = 0;
        gbc.gridy = 0;

       frame.add(userName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(password, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        frame.add(userNameField, gbc);


        gbc.gridx = 2;
        gbc.gridy = 1;
       frame.add(passwordField, gbc);

        gbc.gridx = 2;
        gbc.gridy = 10;
        frame.add(okBtn, gbc);

        gbc.gridx = 3;
        gbc.gridy = 10;
        frame.add(newBtn, gbc);
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    log.addLogerInfo("OK button pressed ");



                    if( iViewModel.checkUsernameInTheTable(userNameField.getText(),passwordField.getText())){
                        frame.setVisible(false); //you can't see m
                        frame.dispose();
                        IModel model=new ModelDerbyDb();
                        IViewModel iViewModel=new ViewModelMainFrame();
                        iViewModel.setModel(model);
                        IView view=new ViewMainFrame();
                        iViewModel.setView(view);

                        view.setViewModel(iViewModel);
                        iViewModel.setName(userNameField.getText());
                      //  iViewModel.addValuesToTableUsers(userField.getText(),passField.getText());
                        view.start();

                    }else {
                        log.addLogerEror("this user not exits in the table users");
                        IView view=new MsgUserNotExist();

                        view.start();
                    }
                } catch (SQLException ex) {


                }
            }
        });
        newBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.addLogerInfo("New button pressed ");

                        frame.setVisible(false); //you can't see m
                        frame.dispose();
                        IModel model=new ModelDerbyDb();
                        IView view=new ViewRegisterFrame();
                        IViewModel viewModel=new ViewModelRegisterFrame();
                        view.setViewModel(viewModel);
                        viewModel.setView(view);
                        viewModel.setModel(model);
                try {
                    view.start();
                } catch (SQLException ex) {
                    log.addLogerEror("sql excption is catch");
                    ex.printStackTrace();
                }


            }
        });


        frame.setVisible(true);
        frame.setLocation(500,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setMinimumSize(new Dimension(320,320));

    }

    /**
     * this method define is ViewModel of this view.
     * @param ob the ViewModel to define.
     */
    @Override
    public void setViewModel(IViewModel ob) {
        this.iViewModel = ob;

    }


}

