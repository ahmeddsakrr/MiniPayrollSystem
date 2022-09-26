package com.example.minipayroll2_4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
    Admin admin=new Admin();
    public static ArrayList<Admin> admins =new ArrayList<>();
    public  static ArrayList<Employee> employees =new ArrayList<>();

    @FXML
    Stage primaryStage=new Stage();
    @FXML
    private Button loginButton;

    @FXML
    private AnchorPane loginPane;

    @FXML
    private PasswordField passwordRegister;

    @FXML
    private PasswordField passwordText;

    @FXML
    private AnchorPane redpane2;

    @FXML
    private Button registerButton;

    @FXML
    private AnchorPane registerPane;
    @FXML
    private Button gobackButton;


    @FXML
    private Button signUpButton;

    @FXML
    private TextField usernameRegister;

    @FXML
    private TextField usernameText;
    @FXML
    private AnchorPane adminPane;

    @FXML
    private Button engineerButton;
    @FXML
    private Button traineeButton;
    @FXML
    void loadEngineer(ActionEvent event) throws IOException {
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Engineer.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            System.out.println(e.getCause());
            e.printStackTrace();
        }

    }
    @FXML
    void loginenter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)){
            try {
                loginButton.fire();
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(e.getCause());
            }
        }
    }
    @FXML
    void registerenter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)){
            try {
                registerButton.fire();
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(e.getCause());
            }
        }
    }

    @FXML
    void loadTrainee(ActionEvent event)  throws IOException{
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Trainee.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            System.out.println(e.getCause());
        }
    }
    @FXML
    void goback(ActionEvent event) {
        registerPane.setVisible(false);
        loginPane.setVisible(true);
    }
    @FXML
    void login(ActionEvent event) {
        try {
            if (usernameText.getText().equals("") || passwordText.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Missing Information");
                alert.setHeaderText("Username or Password Missing");
                alert.setContentText("Please make sure to fill all fields.");
                alert.show();
            } else {
                String username = usernameText.getText();
                String password = passwordText.getText();
                if (check_login(username, password)) {
                    loginPane.setVisible(false);
                    adminPane.setVisible(true);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Incorrect Information");
                    alert.setHeaderText("Incorrect Username or Password ");
                    alert.setContentText("Please try again.");
                    alert.show();
                    usernameText.clear();
                    passwordText.clear();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void register(ActionEvent event) {
        try {
            if (usernameRegister.getText().equals("") || passwordRegister.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Missing Information");
                alert.setHeaderText("Username or Password Missing");
                alert.setContentText("Please make sure to fill all fields.");
                alert.show();
            } else {
                String username = usernameRegister.getText();
                String password = passwordRegister.getText();
                if (check_signup(username)) {
                    admins.add(new Admin(username, password));
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Successful Sign UP");
                    alert.setHeaderText("Successful Operation");
                    alert.setContentText("User " + username + " Added Successfully");
                    alert.show();
                    registerPane.setVisible(false);
                    loginPane.setVisible(true);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Duplicate Information");
                    alert.setHeaderText("Username already exists");
                    alert.setContentText("Please try again.");
                    alert.show();
                    usernameRegister.clear();
                    passwordRegister.clear();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void signUP(ActionEvent event) {
        loginPane.setVisible(false);
        registerPane.setVisible(true);
    }
    @Override
    public void start(Stage stage) throws IOException {
        try{
            Parent root= FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.setTitle("Payroll");
            Image image=new Image("image (1).png");
            stage.getIcons().add(image);
        }catch (Exception exception){
            System.out.println(exception.getCause());
            exception.printStackTrace();
        }

    }
    @FXML
    void logout(ActionEvent event) throws IOException {
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (Exception exception){
            System.out.println(exception.getCause());
        }
    }

    public static void main(String[] args) {
        admins.add(new Admin("admin","admin"));
        employees.add(new Engineer("123","Ahmed",20,10,"Manager"));
        employees.add(new Engineer("1245","Mohamed",20,10,"Team Leader"));
        employees.add(new Engineer("1258","Adham",20,10,"Team Member"));

        employees.add(new Trainee("123","Ahmed",20,"ASU",3.5,"Second"));
        employees.add(new Trainee("1245","Mohamed",20,"ASU",3.5,"Second"));
        employees.add(new Trainee("1258","Adham",20,"ASU",3.5,"Second"));


        launch();
    }
    public boolean check_login(String username,String password){
        for (int i = 0; i < admins.size(); i++) {
            if (admins.get(i).getUsername().equals(username)){
                if (admins.get(i).getPassword().equals(password)){
                    return true;
                }
            }
        }
       return false;
    }
    public boolean check_signup(String username){
        for( Admin admin: admins){
            if (admin.getUsername().equals(username)){
                return false;
            }
        }
        return true;
    }
}