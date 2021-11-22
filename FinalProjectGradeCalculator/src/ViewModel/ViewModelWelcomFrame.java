package ViewModel;

import IMODELS.IModel;
import IMODELS.IView;
import IMODELS.IViewModel;
import Menus.MenuMainFrame;
import View.PenelsMainFrame.MainPanelButtom;
import View.PenelsMainFrame.MainPanelCenter;
import View.PenelsMainFrame.MainPanelTop;

import javax.swing.*;
import java.sql.SQLException;

/**
 * this class is communicate between the model  and the view of ViewWelcomeFrame class.
 */

public class ViewModelWelcomFrame  implements IViewModel {
    private IModel iModel;
    private IView iView;



    @Override
    public void setModel(IModel m) {
        this.iModel = m;

    }

    @Override
    public void setView(IView v) {
        this.iView = v;

    }
    @Override
    public IModel getModel() {
        return this.iModel;
    }

    @Override
    public void setMenuMainFrame(MenuMainFrame menuMainFrame) {

    }

    @Override
    public String getName() {
       return iModel.getName();
    }
    @Override
    public void setWhatOrder(String whatOrder) {
        iModel.setWhatOrder(whatOrder);
    }

    @Override
    public String getWhatOrder() {
        return iModel.getWhatOrder();
    }

    @Override
    public void updatePanelsAndMenu(IViewModel iViewModel) {

    }

    @Override
    public void setMainPanelTop(MainPanelTop mainPanelTop) {

    }

    @Override
    public void setMainPanelCenter(MainPanelCenter mainPanelCenter) {

    }

    @Override
    public void setMainPanelButtom(MainPanelButtom mainPanelButtom) {

    }

    @Override
    public void setName(String name) {
        iModel.setName(name);

    }
    @Override
    public void setSemester(JComboBox semester) {
        iModel.setSemester(semester);
    }

    @Override
    public JComboBox getSemester() {
        return iModel.getSemester();
    }

    @Override
    public void setYear(JComboBox year) {
        iModel.setYear(year);

    }

    @Override
    public JComboBox getYear() {
        return iModel.getYear();
    }


    @Override
    public void addValuesToTableUsers(String name, String password) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void addValuesToTableCourses(String userName, String nameCours, String year, String semster, String craditPoint, String grade) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void createUserNamesTable() {
        iModel.createUserNamesTable();

    }

    @Override
    public void createTableCoursUser(String name) {

    }

    @Override
    public Object[][] printTableShowGrades(String sql,int row) throws SQLException {
        return new Object[0][];
    }

    @Override
    public int numbersOfRows(String nameTable) {
        return 0;

    }


    @Override
    public boolean checkUsernameInTheTable(String name, String pass) throws SQLException {
       if( iModel.checkUsernameInTheTable(name,pass)){
           return true;
       }
       return false;
    }

    @Override
    public void printtable() throws SQLException {
        iModel.printtable();

    }

    @Override
    public boolean checknameInTheTable(String name) throws SQLException {
        return false;
    }

    @Override
    public Float CaceleterAvg(String userName) throws SQLException {
        return null;
    }

    @Override
    public void deleteTableCours(String userName) throws SQLException {

    }

    @Override
    public void deliteCourseName(String userName, String cours_name) throws SQLException {

    }
}
