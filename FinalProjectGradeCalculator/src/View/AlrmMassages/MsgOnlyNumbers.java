package View.AlrmMassages;

import IMODELS.IView;
import IMODELS.IViewModel;
import Log4j.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class is a view of message "Cerdit point and Grade field must to by numbers".
 */

public class MsgOnlyNumbers implements IView {
    private JFrame frame;
    private JLabel message;
    private Log log;

    private JButton button;

    public MsgOnlyNumbers() {
        log=new Log(this.getClass().getName());
        frame=new JFrame();
        message=new JLabel("Cerdit point and Grade field must to by numbers");
        button=new JButton("ok");
        frame.setSize(300,100);
        frame.setLocation(515,180);
        frame.setMinimumSize(new Dimension(300,100));
    }
    /**
     * this method add to frame all the components and operate actionListener to the buttons.
     */
    @Override
    public void start() {
        log.addLogerInfo("MsgOnlyNumbers frame is open");
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        message.setSize(20,20);
        message.setAlignmentX(Component.CENTER_ALIGNMENT);

        frame.getContentPane().add(message);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        frame.getContentPane().add(button);

        frame.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false); //you can't see me!
                frame.dispose();
            }
        });

    }

    /**
     * this method define is ViewModel of this view.
     * @param ob the ViewModel to define.
     */
    @Override
    public void setViewModel(IViewModel ob) {

    }
}