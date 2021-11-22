package View;

import IMODELS.IView;
import IMODELS.IViewModel;
import Log4j.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
/**
 * this class is a view of small frame which text field To write a deletion course name.
 */


public class ViewDeleteCours implements IView {
   private IViewModel iViewModel;
    private JLabel message;
    private JTextField coursNameFild;
    private JFrame frame;
    private  Log log;

    private JButton button;
    /**
     * Constructor empty that initializes all the components
     */


    public ViewDeleteCours() {
        log=new Log(this.getClass().getName());

        frame=new JFrame("Delete Course");
        message=new JLabel("Enter cours name you want to delete ");
        button=new JButton("ok");
        coursNameFild=new JTextField();


        frame.setLocation(515,180);
        frame.setMinimumSize(new Dimension(300,130));


    }

    /**
     * this method add to frame all the components and operate actionListener to the buttons.
     * @throws SQLException this method may throws SQLException
     */

    @Override
    public void start() throws SQLException {
        log.addLogerInfo("ViewDeleteCours frame is open");
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        message.setAlignmentX(Component.CENTER_ALIGNMENT);
        frame.getContentPane().add(message);
        ///////////////////////////////////
        coursNameFild.setAlignmentX(Component.CENTER_ALIGNMENT);
        frame.getContentPane().add(coursNameFild);
        /////////////////////////////////
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
       frame.getContentPane().add(button);

        frame.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    iViewModel.deliteCourseName(iViewModel.getName(),coursNameFild.getText());
                } catch (SQLException ex) {
                    log.addLogerEror("SQLException is  catch");
                    ex.printStackTrace();
                }
                frame.setVisible(false); //you can't see me!
               frame.dispose();
                iViewModel.updatePanelsAndMenu(iViewModel);

            }
        });

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
