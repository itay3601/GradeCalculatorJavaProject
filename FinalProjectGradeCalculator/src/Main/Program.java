package Main;

import IMODELS.IModel;
import IMODELS.IView;
import IMODELS.IViewModel;
import Log4j.Log;
import Model.ModelDerbyDb;
import View.ViewWelcomeFrame;
import ViewModel.ViewModelWelcomFrame;

import javax.swing.*;
import java.sql.SQLException;

/**
 * This class contains the main method
 */

public class Program {
    private static Log log;
    /**
     * The main method
     * @param args this is the main method
     */
    public static void main(String[] args) {
        log=new Log("Program");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                IModel m =new ModelDerbyDb();
                IView v = new ViewWelcomeFrame();
                m.createUserNamesTable();


                IViewModel vm =new  ViewModelWelcomFrame();
                v.setViewModel(vm);
                vm.setModel(m);
                vm.setView(v);
                try {
                    v.start();
                } catch (SQLException e) {
                    log.addLogerEror("SQLException catch");
                    e.printStackTrace();
                }


            }
        });

    }
}
