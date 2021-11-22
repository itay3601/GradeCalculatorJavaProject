package IMODELS;

import java.awt.*;
import java.sql.SQLException;

/**
 *  this is interface communicates with views.
 */

public interface IView {
    /**
     * this interface method to start show this view.
     * @throws SQLException may throws SQLException
     */
    public void start() throws SQLException;

    /**
     * this interface method define is ViewModel of this view.
     * @param ob IViewModel to display.
     */
    public void setViewModel(IViewModel ob);



}
