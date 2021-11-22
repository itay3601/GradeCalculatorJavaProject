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
 * this class is communicate between the model  and the view of ViewMainFrame class.
 */

public class ViewModelMainFrame implements IViewModel {
    private IModel iModel;
    private IView iView;
    private MainPanelTop mainPanelTop;
    private MainPanelCenter mainPanelCenter;
    private MainPanelButtom mainPanelButtom;
    private MenuMainFrame menuMainFrame;



    @Override
    public void setModel(IModel m) {
      this.iModel=m;
    }

    @Override
    public void setView(IView v) {
        this.iView=v;

    }

    @Override
    public IModel getModel() {
        return this.iModel;
    }

    @Override
    public void setMenuMainFrame(MenuMainFrame menuMainFrame) {
        this.menuMainFrame = menuMainFrame;
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
        mainPanelButtom.setViewModel(iViewModel);
        mainPanelCenter.setViewModel(iViewModel);
        mainPanelTop.setViewModel(iViewModel);
        menuMainFrame.setViewModel(iViewModel);
        mainPanelButtom.updateAvgValu();


    }

    @Override
    public void setMainPanelTop(MainPanelTop mainPanelTop) {
        this.mainPanelTop=mainPanelTop;

    }

    @Override
    public void setMainPanelCenter(MainPanelCenter mainPanelCenter) {
        this.mainPanelCenter=mainPanelCenter;

    }

    @Override
    public void setMainPanelButtom(MainPanelButtom mainPanelButtom) {
        this.mainPanelButtom=mainPanelButtom;

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
    public String getName() {
        return iModel.getName();
    }

    @Override
    public void setName(String name) {

        iModel.setName(name);

    }



    @Override
    public void addValuesToTableUsers(String name, String password) throws SQLException, ClassNotFoundException {
        iModel.addValuesToTableUsers(name,password);


    }

    @Override
    public void addValuesToTableCourses(String userName, String nameCours, String year, String semster, String craditPoint, String grade) throws SQLException, ClassNotFoundException {

        iModel.addValuesToTableCourses(userName,nameCours,year,semster,craditPoint,grade);

    }

    @Override
    public boolean checkUsernameInTheTable(String name, String pass) throws SQLException {
        return false;
    }

    @Override
    public void printtable() throws SQLException {

    }

    @Override
    public boolean checknameInTheTable(String name) throws SQLException {
        return iModel.checknameInTheTable(name);
    }

    @Override
    public Float CaceleterAvg(String userName) throws SQLException {

        return  iModel.CaceleterAvg(userName);
    }

    @Override
    public void deleteTableCours(String userName) throws SQLException {
        iModel.deleteTableCours(userName);

    }

    @Override
    public void deliteCourseName(String userName, String cours_name) throws SQLException {
        iModel.deliteCourseName(userName,cours_name);

    }

    @Override
    public void createUserNamesTable() {

    }

    @Override
    public void createTableCoursUser(String name) {
        iModel.createTableCoursUser(name);

    }

    @Override
    public Object[][] printTableShowGrades(String sql,int row) throws SQLException {
        return new Object[0][];
    }

    @Override
    public int numbersOfRows(String nameTable) throws SQLException {
        return 0;
    }


}
