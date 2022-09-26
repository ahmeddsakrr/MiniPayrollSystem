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

public class TController implements Initializable {
    String [] edits={"Name","ID","Age","GPA","University","Academic Year"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        editChoiceBox.getItems().addAll(edits);
    }
    Admin admin=new Admin();
    @FXML
    private TableColumn<Trainee, Double> GPAColumn;

    @FXML
    private TableColumn<Trainee, String> UniversityColumn;

    @FXML
    private TableColumn<Trainee, String> YearColumn;

    @FXML
    private Button addButton;

    @FXML
    private Button addInfo;

    @FXML
    private AnchorPane addPane;

    @FXML
    private TextField ageAdd;

    @FXML
    private TableColumn<Trainee, Integer> ageColumn;

    @FXML
    private Button displayButton;

    @FXML
    private AnchorPane displayPane1;

    @FXML
    private Button editButton;

    @FXML
    private Label editChoice;

    @FXML
    private ChoiceBox<String> editChoiceBox;

    @FXML
    private AnchorPane editPane1;

    @FXML
    private AnchorPane editPane2;

    @FXML
    private TextField edited;

    @FXML
    private TableView<Trainee> engineersTable;

    @FXML
    private Button gobackButton1;

    @FXML
    private Button gobackButton11;

    @FXML
    private Button gobackButton12;

    @FXML
    private Button gobackButton1211;

    @FXML
    private TextField gpaAdd;

    @FXML
    private TextField idAdd;

    @FXML
    private TableColumn<Trainee, String> idColumn;

    @FXML
    private TextField idEdit;

    @FXML
    private TextField idRemove;

    @FXML
    private Button logoutButton;

    @FXML
    private AnchorPane mainDisplayPane;

    @FXML
    private AnchorPane mainEditPane;

    @FXML
    private AnchorPane mainTraineePane;

    @FXML
    private TableColumn<Trainee, String> nameColumn;

    @FXML
    private Button removeButton;

    @FXML
    private AnchorPane removePane;

    @FXML
    private Button removeTr;

    @FXML
    private Button salaryButton;

    @FXML
    private TableColumn<Trainee, Double> salaryColumn;

    @FXML
    private Button submitEdit;

    @FXML
    private TextField universityAdd;

    @FXML
    private TextField usernameAdd;

    @FXML
    private TextField yearAdd;

    @FXML
    void add(ActionEvent event) {
        try {
            if (usernameAdd.getText().equals("") || ageAdd.getText().equals("") ||
                    idAdd.getText().equals("") || universityAdd.getText().equals("") ||
                    gpaAdd.getText().equals("") || yearAdd.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Missing Information");
                alert.setHeaderText("Missing Data");
                alert.setContentText("Please make sure to fill all fields.");
                alert.show();
            } else {
                String name = usernameAdd.getText();
                int age = Integer.parseInt(ageAdd.getText());
                String id = idAdd.getText();
                String uni = universityAdd.getText();
                double gpa = Double.parseDouble(gpaAdd.getText());
                String year = yearAdd.getText();
                if (age<=0){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Invalid Information");
                    alert.setHeaderText("Invalid Age");
                    alert.setContentText("Please try again.");
                    alert.show();
                    ageAdd.clear();
                    throw new OutOfRangeException("Invalid Age");
                }else{
                    if (gpa<0||gpa>4){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Invalid Information");
                        alert.setHeaderText("Invalid GPA");
                        alert.setContentText("Please try again.");
                        alert.show();
                        gpaAdd.clear();
                        throw new OutOfRangeException("Invalid GPA");
                    }else{
                        if (admin.AddTrainee(Main.employees, name, id, uni, gpa, age, year)) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Successful ");
                            alert.setHeaderText("Successful Operation");
                            alert.setContentText("Trainee " + name + " Added Successfully");
                            alert.show();
                            addPane.setVisible(false);
                            mainTraineePane.setVisible(true);
                            usernameAdd.clear();
                            ageAdd.clear();
                            idAdd.clear();
                            universityAdd.clear();
                            gpaAdd.clear();
                            yearAdd.clear();
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

        }catch(OutOfRangeException e){
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
    void addGoBack(ActionEvent event) {
        addPane.setVisible(false);
        mainTraineePane.setVisible(true);
        ageAdd.clear();
        gpaAdd.clear();
        yearAdd.clear();
        universityAdd.clear();
        idAdd.clear();
        usernameAdd.clear();
    }

    @FXML
    void addTrainee(ActionEvent event) {
        mainTraineePane.setVisible(false);
        addPane.setVisible(true);
    }

    @FXML
    void calcSalary(ActionEvent event) {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Salary");
        alert.setHeaderText("Trainee Salary");
        alert.setContentText("All trainees have salary of 3000.00 $");
        alert.show();
    }

    @FXML
    void displayGoBack(ActionEvent event) {
        mainDisplayPane.setVisible(false);
        mainTraineePane.setVisible(true);
        engineersTable.getItems().clear();
    }

    @FXML
    void displayTrainees(ActionEvent event) {
        try {
            mainTraineePane.setVisible(false);
            mainDisplayPane.setVisible(true);
            ageColumn.setCellValueFactory(new PropertyValueFactory<Trainee, Integer>("age"));
            idColumn.setCellValueFactory(new PropertyValueFactory<Trainee, String>("ID"));
            nameColumn.setCellValueFactory(new PropertyValueFactory<Trainee, String>("name"));
            salaryColumn.setCellValueFactory(new PropertyValueFactory<Trainee, Double>("salary"));
            GPAColumn.setCellValueFactory(new PropertyValueFactory<Trainee, Double>("GPA"));
            YearColumn.setCellValueFactory(new PropertyValueFactory<Trainee, String>("academicYear"));
            UniversityColumn.setCellValueFactory(new PropertyValueFactory<Trainee, String>("universityName"));
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
            ArrayList<Employee> list = admin.printTrainees(Main.employees);
            for (Employee employee : list) {
                engineersTable.getItems().add((Trainee) employee);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    String id=null;
    String select=null;
    @FXML
    void edit(ActionEvent event) {
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
                if (!admin.checkTrainee(Main.employees, id)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Missing Information");
                    alert.setHeaderText("ID not found");
                    alert.setContentText("Please try again.");
                    alert.show();
                    idEdit.clear();
                } else {
                    idEdit.clear();
                    editPane1.setVisible(false);
                    editPane2.setVisible(true);
                    editChoice.setText(select);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void editGoBack(ActionEvent event) {
        mainEditPane.setVisible(false);
        editPane2.setVisible(false);
        editPane1.setVisible(true);
        mainTraineePane.setVisible(true);
        editChoiceBox.getSelectionModel().clearSelection();
        idEdit.clear();
        edited.clear();
    }

    @FXML
    void edittrainee(ActionEvent event) {
        mainTraineePane.setVisible(false);
        mainEditPane.setVisible(true);
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
                if (admin.removeTrainee(Main.employees, idselection)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Successful ");
                    alert.setHeaderText("Successful Operation");
                    alert.setContentText("Trainee Removed Successfully");
                    alert.show();
                    removePane.setVisible(false);
                    mainTraineePane.setVisible(true);
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

    @FXML
    void removeGoBack(ActionEvent event) {
        removePane.setVisible(false);
        mainTraineePane.setVisible(true);
        idRemove.clear();
    }

    @FXML
    void removeTrainee(ActionEvent event) {
        mainTraineePane.setVisible(false);
        removePane.setVisible(true);
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
                if (select.equals("GPA")){
                    selected = 5;
                    if (Double.parseDouble(edited2)<0||Double.parseDouble(edited2)>4){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Invalid Information");
                        alert.setHeaderText("Invalid GPA");
                        alert.setContentText("Please try again.");
                        alert.show();
                        edited.clear();
                        throw new OutOfRangeException("Invalid GPA");
                    }
                }
                if (select.equals("University")) selected = 4;
                if (select.equals("Academic Year")) selected = 6;
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
                if (admin.editTrainee(Main.employees, id, selected, edited2)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Successful ");
                    alert.setHeaderText("Successful Operation");
                    alert.setContentText("Trainee Edited Successfully");
                    alert.show();
                    editPane2.setVisible(false);
                    editPane1.setVisible(true);
                    mainEditPane.setVisible(false);
                    mainTraineePane.setVisible(true);
                    editChoiceBox.getSelectionModel().clearSelection();
                    edited.clear();
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

}


