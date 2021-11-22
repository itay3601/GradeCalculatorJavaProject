package View.AlrmMassages;

import IMODELS.IView;
import IMODELS.IViewModel;
import Log4j.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class is a view of message "This username is already taken try again".
 */

public class MsgUserExistent implements IView {
    private JFrame frame;
    private JLabel message;
    private  Log log;
    private JButton button;

    /**
     * Constructor empty that initializes all the components
     */

    public MsgUserExistent () {
        log=new Log(this.getClass().getName());

        frame=new JFrame();
        message=new JLabel("This username is already taken try again");
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
        log.addLogerInfo("MsgUserExistent is open");
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
