package View;

import IMODELS.IModel;
import IMODELS.IView;
import IMODELS.IViewModel;
import Log4j.Log;
import Menus.MenuMainFrame;
import Model.ModelDerbyDb;
import View.AlrmMassages.MsgCompleteAllTheFild;
import View.AlrmMassages.MsgPassAtLeast;
import View.AlrmMassages.MsgPasswordFildDiffrent;
import View.AlrmMassages.MsgUserExistent;
import ViewModel.ViewModelMainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * this class is view for register frame.
 */


public class ViewRegisterFrame implements IView {
   private JFrame frame;
    private GridBagConstraints gbc ;
   private JLabel user;
   private JTextField userField;
    private JLabel pass;
    private JPasswordField passField;
    private JLabel valPass;
   private JPasswordField valpassField;
    private JComboBox major;
    private JButton btnRegister;
   private IViewModel iViewModel;
    private Log log;
    /**
     * Constructor empty that initializes all the components
     */

    public ViewRegisterFrame() {
        log=new Log(this.getClass().getName());
        frame=new JFrame("Register");
        gbc = new GridBagConstraints();
        user=new JLabel("User: ");
        userField=new JTextField(10);
        userField.setSize(2,5);
        pass=new JLabel("Password:");
        passField=new JPasswordField(10);
        passField.setSize(2,5);
        valPass=new JLabel("conferd Password:");
        valpassField=new JPasswordField(10);
        valpassField.setSize(2,5);
        String[] majorStr={"Cumputer Syens","Electronic Enganire","Dezain"};
        major=new JComboBox(majorStr);
        btnRegister=new JButton("Register");
        frame.setSize(300,300);

        frame.setLayout(new GridBagLayout());
    }

    /**
     * this method add to frame all the components and operate actionListener to the buttons.
     */

    @Override
    public void start() {
        log.addLogerInfo("ViewRegisterFrame is open");
        gbc.gridx=0;
        gbc.gridy=0;
        frame.add(user,gbc);
        gbc.gridx=1;
        gbc.gridy=0;
        frame.add(userField,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
       frame. add(pass,gbc);
        gbc.gridx=1;
        gbc.gridy=1;
        frame.add(passField,gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        frame.add(valPass,gbc);
        gbc.gridx=1;
        gbc.gridy=2;
        frame.add(valpassField,gbc);
        gbc.gridx=1;
        gbc.gridy=3;
       frame. add(major,gbc);
        gbc.gridx=1;
        gbc.gridy=4;
        frame.add(btnRegister,gbc);
        frame.setVisible(true);
        frame.setLocation(500,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setMinimumSize(new Dimension(320,320));
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.addLogerInfo("Register button pressed");
                if(userField.getText().equals("")||passField.getText().equals("")||valpassField.getText().equals("")) {
                    log.addLogerEror("one of tfe field text is emty");
                    IView view=new MsgCompleteAllTheFild();
                    try {
                        view.start();
                    } catch (SQLException ex) {
                        log.addLogerEror("SQLException catch");
                        ex.printStackTrace();
                    }

                }  else if(!passField.getText().equals(valpassField.getText())) {
                    log.addLogerEror("password filed is not eqals ");
                    IView view = new MsgPasswordFildDiffrent();
                    try {
                        view.start();
                    } catch (SQLException ex) {
                        log.addLogerEror("SQLException catch");
                        ex.printStackTrace();
                    }

                }else if(passField.getText().length()<8){
                    log.addLogerEror("password must to be at list 8  lirint");
                    IView view=new MsgPassAtLeast();
                    try {
                        view.start();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }else{
                    try{
                        if (iViewModel.checknameInTheTable(userField.getText())) {
                            IView view=new MsgUserExistent();
                            view.start();
                            log.addLogerEror("user exist in the table users");
                        }else{

                            frame.setVisible(false); //you can't see me!
                            frame.dispose();
                            IModel model=new ModelDerbyDb();
                            IViewModel iViewModel=new ViewModelMainFrame();
                            iViewModel.setModel(model);
                            IView view=new ViewMainFrame();
                            iViewModel.setView(view);
                            view.setViewModel(iViewModel);
                            iViewModel.setName(userField.getText());
                            iViewModel.addValuesToTableUsers(userField.getText(),passField.getText());
                            view.start();

                        }
                    }catch (SQLException e1){
                        log.addLogerEror("SQLException catch");

                    } catch (ClassNotFoundException ex) {
                        log.addLogerEror("ClassNotFoundException catch");
                        ex.printStackTrace();
                    }
                }


            }
        });


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
