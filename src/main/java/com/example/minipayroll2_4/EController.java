package com.example.minipayroll2_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EController implements Initializable {

    String[] positions={"Manager","Team Leader","Team Member"};
    String[] choices={"ID","Name","Age","Working Hours","Position"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        positionAdd.getItems().addAll(positions);
        positionEdit.getItems().addAll(positions);
        editChoiceBox.getItems().addAll(choices);
    }
    @FXML
    AnchorPane mainDisplayPane;
    @FXML
    private TableView<Engineer> engineersTable;
    @FXML
    private TableColumn<Engineer, Integer> ageColumn;
    @FXML
    private TableColumn<Engineer, Double> hoursColumn;
    @FXML
    private TableColumn<Engineer, String> idColumn;
    @FXML
    private TableColumn<Engineer, String> nameColumn;
    @FXML
    private TableColumn<Engineer, String> positionColumn;
    @FXML
    private TableColumn<Engineer, Double> salaryColumn;
    @FXML
    void displayGoBack(ActionEvent event) {
        mainDisplayPane.setVisible(false);
        mainEngineerPane.setVisible(true);
        engineersTable.getItems().clear();
    }
    @FXML
    void displayEngineers(ActionEvent event) {
        mainEngineerPane.setVisible(false);
        mainDisplayPane.setVisible(true);
        ageColumn.setCellValueFactory(new PropertyValueFactory<Engineer,Integer>("age"));
        hoursColumn.setCellValueFactory(new PropertyValueFactory<Engineer,Double>("working_hours"));
        idColumn.setCellValueFactory(new PropertyValueFactory<Engineer,String>("ID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Engineer,String>("name"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<Engineer,String>("position"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<Engineer,Double>("salary"));
        salaryColumn.setCellFactory(c -> new TableCell<>() {
            @Override
            protected void updateItem(Double balance, boolean empty) {
                super.updateItem(balance, empty);
                if (balance == null || empty) {
                    setText(null);
                } else {
                    setText(String.format("%.2f", balance.doubleValue()));
                }
            }
        });
        ArrayList<Employee>list=admin.printEngineers(Main.employees);
        for (Employee employee:list){
            engineersTable.getItems().add((Engineer) employee);
        }

    }
    @FXML
    private Button addButton;

    @FXML
    private AnchorPane addPane;

    @FXML
    private TextField ageAdd;

    @FXML
    private Button displayButton;

    @FXML
    private Button editButton;

    @FXML
    private Label editChoice;

    @FXML
    private AnchorPane editPane;

    @FXML
    private AnchorPane editPane1;

    @FXML
    private AnchorPane editPane2;

    @FXML
    private AnchorPane editPane3;

    @FXML
    private AnchorPane engSalaryPane;

    @FXML
    private Button gobackButton1;

    @FXML
    private Button gobackButton11;

    @FXML
    private Button gobackButton12;

    @FXML
    private Button gobackButton121;

    @FXML
    private TextField hoursAdd;

    @FXML
    private TextField idAdd;

    @FXML
    private TextField idEdit;

    @FXML
    private TextField idRemove;

    @FXML
    private TextField idSalary;

    @FXML
    private Button logoutButton;

    @FXML
    private AnchorPane mainEngineerPane;

    @FXML
    private ChoiceBox<String> positionAdd;

    @FXML
    private ChoiceBox<String> positionEdit;
    @FXML
    private ChoiceBox<String> editChoiceBox;
    @FXML
    private AnchorPane positionEditPane;

    @FXML
    private AnchorPane redPane;

    @FXML
    private Button removeButton;

    @FXML
    private AnchorPane removePane;

    @FXML
    private Button salaryButton;

    @FXML
    private Button submitEdit;

    @FXML
    private Button submitEdit1;

    @FXML
    private TextField usernameAdd;

    @FXML
    private Button viewSalaryButton;

    @FXML
    void addEngineer(ActionEvent event) {
        mainEngineerPane.setVisible(false);
        addPane.setVisible(true);
    }

    @FXML
    void addGoBack(ActionEvent event) {
        addPane.setVisible(false);
        mainEngineerPane.setVisible(true);
        ageAdd.clear();
        hoursAdd.clear();
        positionAdd.getSelectionModel().clearSelection();
        usernameAdd.clear();
        idAdd.clear();
    }

    @FXML
    void calcSalary(ActionEvent event) {
        mainEngineerPane.setVisible(false);
        engSalaryPane.setVisible(true);
    }
    @FXML
    TextField edited;
    String select=null;
    String id=null;
    @FXML
    void edit(ActionEvent event)throws Exception {
        try {
            if (idEdit.getText().equals("") || editChoiceBox.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Missing Information");
                alert.setHeaderText("Missing Data");
                alert.setContentText("Please make sure to fill all fields.");
                alert.show();
            } else {
                id = idEdit.getText();
                select = editChoiceBox.getValue();
                if (!admin.checkEngineer(Main.employees, id)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Missing Information");
                    alert.setHeaderText("ID not found");
                    alert.setContentText("Please try again.");
                    alert.show();
                    idEdit.clear();
                } else {
                    idEdit.clear();
                    if (select.equals("Position")) {
                        editPane2.setVisible(false);
                        positionEditPane.setVisible(true);
                    } else {
                        editPane2.setVisible(false);
                        editPane3.setVisible(true);
                        editChoice.setText(select);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void editEngineer(ActionEvent event) {
        mainEngineerPane.setVisible(false);
        editPane.setVisible(true);
    }

    @FXML
    void editGoBack(ActionEvent event) {
        editPane3.setVisible(false);
        editPane2.setVisible(true);
        editPane1.setVisible(true);
        editPane.setVisible(false);
        mainEngineerPane.setVisible(true);
        editChoiceBox.getSelectionModel().clearSelection();
        idEdit.clear();

    }

    @FXML
    void logout(ActionEvent event)throws IOException {
        try {
            Main main=new Main();
            main.logout(event);
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    @FXML
    void remove(ActionEvent event) {
        try {
            if (idRemove.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Missing Information");
                alert.setHeaderText("Missing Data");
                alert.setContentText("Please make sure to fill all fields.");
                alert.show();
            } else {
                String idselection = idRemove.getText();
                if (admin.removeEngineer(Main.employees, idselection)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Successful ");
                    alert.setHeaderText("Successful Operation");
                    alert.setContentText("Engineer Removed Successfully");
                    alert.show();
                    removePane.setVisible(false);
                    mainEngineerPane.setVisible(true);
                    idRemove.clear();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Unsuccessful Operation");
                    alert.setHeaderText("Unsuccessful");
                    alert.setContentText("Please try again.");
                    alert.show();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    Admin admin=new Admin();
    @FXML
    void add(ActionEvent event) {
        try {
            if (usernameAdd.getText().equals("") || idAdd.getText().equals("")
                    || ageAdd.getText().equals("") || hoursAdd.getText().equals("")
                    || positionAdd.getValue().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Missing Information");
                alert.setHeaderText("Missing Data");
                alert.setContentText("Please make sure to fill all fields.");
                alert.show();
            } else {
                String username = usernameAdd.getText();
                String id = idAdd.getText();
                int age = Integer.parseInt(ageAdd.getText());
                if (age<=0){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Invalid Information");
                    alert.setHeaderText("Invalid Age");
                    alert.setContentText("Please try again.");
                    alert.show();
                    ageAdd.clear();
                    throw new OutOfRangeException("Invalid Age");
                }
                else{
                    double working_hours = Double.parseDouble(hoursAdd.getText());
                    if (working_hours<0||working_hours>24){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Invalid Information");
                        alert.setHeaderText("Invalid Working Hours");
                        alert.setContentText("Please try again.");
                        alert.show();
                        hoursAdd.clear();
                        throw new OutOfRangeException("Invalid Working Hours");
                    }else{
                        String position = positionAdd.getValue();
                        if (admin.AddEngineer(Main.employees, username, id, position, working_hours, age)) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Successful ");
                            alert.setHeaderText("Successful Operation");
                            alert.setContentText("Engineer " + username + " Added Successfully");
                            alert.show();
                            addPane.setVisible(false);
                            mainEngineerPane.setVisible(true);
                            usernameAdd.clear();
                            idAdd.clear();
                            ageAdd.clear();
                            hoursAdd.clear();
                            positionAdd.getSelectionModel().clearSelection();
                            positionEdit.getSelectionModel().clearSelection();
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Duplicate Information");
                            alert.setHeaderText("ID already exists");
                            alert.setContentText("Please try again.");
                            alert.show();
                        }
                    }

                }
            }
        }catch (OutOfRangeException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Information");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Please try again.");
            alert.show();
        }
    }

    @FXML
    void removeEngineer(ActionEvent event) {
        mainEngineerPane.setVisible(false);
        removePane.setVisible(true);
    }

    @FXML
    void removeGoBack(ActionEvent event) {
        removePane.setVisible(false);
        mainEngineerPane.setVisible(true);
        idRemove.clear();

    }

    @FXML
    void salaryGoBack(ActionEvent event) {
        engSalaryPane.setVisible(false);
        mainEngineerPane.setVisible(true);
        idSalary.clear();
    }

    @FXML
    void submitEdit(ActionEvent event) {
        try {
            if (edited.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Missing Information");
                alert.setHeaderText("Missing Data");
                alert.setContentText("Please make sure to fill all fields.");
                alert.show();
            } else {
                String edited2 = edited.getText();
                int selected = 0;
                if (select.equals("ID")) selected = 1;
                if (select.equals("Name")) selected = 2;
                if (select.equals("Age")) {
                    selected = 3;
                    if (Integer.parseInt(edited2)<=0){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Invalid Information");
                        alert.setHeaderText("Invalid Age");
                        alert.setContentText("Please try again.");
                        alert.show();
                        edited.clear();
                        throw new OutOfRangeException("Invalid Age");
                    }
                }
                if (select.equals("Working Hours")){
                    selected = 5;
                    if (Double.parseDouble(edited2)<0||Double.parseDouble(edited2)>24){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Invalid Information");
                        alert.setHeaderText("Invalid Working Hours");
                        alert.setContentText("Please try again.");
                        alert.show();
                        edited.clear();
                        throw new OutOfRangeException("Invalid Working Hours");
                    }
                }
                if (admin.editEngineer(Main.employees, id, selected, edited2)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Successful ");
                    alert.setHeaderText("Successful Operation");
                    alert.setContentText("Engineer Edited Successfully");
                    alert.show();
                    editPane.setVisible(false);
                    editPane1.setVisible(true);
                    editPane3.setVisible(false);
                    editPane2.setVisible(true);
                    mainEngineerPane.setVisible(true);
                    editChoiceBox.getSelectionModel().clearSelection();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Unsuccessful Operation");
                    alert.setHeaderText("Unsuccessful");
                    alert.setContentText("Please try again.");
                    alert.show();
                }
            }

        }catch (OutOfRangeException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Information");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Please try again.");
            alert.show();
            edited.clear();
        }
    }

    @FXML
    void submitEdit2(ActionEvent event) {
        try {
            String edited2 = positionEdit.getValue();
            if (admin.editEngineer(Main.employees, id, 4, edited2)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Successful ");
                alert.setHeaderText("Successful Operation");
                alert.setContentText("Engineer Edited Successfully");
                alert.show();
                editPane.setVisible(false);
                editPane1.setVisible(true);
                editPane2.setVisible(true);
                positionEditPane.setVisible(false);
                mainEngineerPane.setVisible(true);
                positionEdit.getSelectionModel().clearSelection();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Unsuccessful Operation");
                alert.setHeaderText("Unsuccessful");
                alert.setContentText("Please try again.");
                alert.show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void viewSalary(ActionEvent event) {
        try {
            if (idSalary.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Missing Information");
                alert.setHeaderText("Missing Data");
                alert.setContentText("Please make sure to fill all fields.");
                alert.show();
            } else {
                String idselection = idSalary.getText();
                if (admin.checkEngineer(Main.employees, idselection)) {
                    String salary = admin.calcSalary(Main.employees, idselection);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Successful ");
                    alert.setHeaderText("Successful Operation");
                    alert.setContentText("Salary of Engineer with ID " + idselection + " is: " + salary + " $");
                    alert.show();
                    engSalaryPane.setVisible(false);
                    mainEngineerPane.setVisible(true);
                    idSalary.clear();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Missing Engineer");
                    alert.setHeaderText("Engineer Not Found");
                    alert.setContentText("Please try again.");
                    alert.show();
                    idSalary.clear();
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
