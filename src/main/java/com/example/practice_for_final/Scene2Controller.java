package com.example.practice_for_final;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;

public class Scene2Controller
{
    @javafx.fxml.FXML
    private TableColumn<Manager,Float> employeeSalaryTC;
    @javafx.fxml.FXML
    private TableColumn<Manager,String> employeeDepartmentTC;
    @javafx.fxml.FXML
    private TableView<Manager> employeeTableView;
    @javafx.fxml.FXML
    private TableColumn<Manager,String> employeeNameTC;
    @javafx.fxml.FXML
    private Label msgLable;
    @javafx.fxml.FXML
    private TableColumn<Manager, LocalDate> employeeDOJTC;
    @javafx.fxml.FXML
    private TableColumn<Manager,Integer> employeeIdTC;
    @javafx.fxml.FXML
    private TableColumn<Manager,String> postTC;

    @javafx.fxml.FXML
    public void initialize() {
        employeeDepartmentTC.setCellValueFactory(new PropertyValueFactory<Manager,String>("employeeDepartment"));
        employeeDOJTC.setCellValueFactory(new PropertyValueFactory<Manager,LocalDate>("DOJ"));
        employeeIdTC.setCellValueFactory(new PropertyValueFactory<Manager,Integer>("employeeId"));
        employeeNameTC.setCellValueFactory(new PropertyValueFactory<Manager,String>("employeeName"));
        employeeSalaryTC.setCellValueFactory(new PropertyValueFactory<Manager,Float>("employeeSalary"));
        postTC.setCellValueFactory(new PropertyValueFactory<Manager,String>("post"));
    }

    @javafx.fxml.FXML
    public void loadBTOnAction(ActionEvent actionEvent) throws IOException {
        FileInputStream fis=null;
        ObjectInputStream ois=null;

        try{
            File file=new File("Employee.bin");
            if(!file.exists()){
                msgLable.setText("Pleas Add Employee First");
                return;

            }

            fis=new FileInputStream(file);
            ois= new ObjectInputStream(fis);

            while(true){
                try{
                    Employee employee=(Employee) ois.readObject();
                    Manager manager=new Manager(employee.getEmployeeName(),employee.getEmployeeId(),employee.getPost(),employee.getEmployeeDepartment(),employee.getDOJ(),employee.getEmployeeSalary());
                    employeeTableView.getItems().add(manager);

                }catch (EOFException e){ //When the file ends, readObject() will throw an EOFException (End of File)
                    break;

                }
            }
            ois.close();//close the file read


        }catch (Exception e){
            if(ois!=null){ //if file reading is open ,close the file and throw the error
                try{


                    ois.close();
                }catch (IOException ex){
                    throw new RuntimeException(ex);
                }
            }
            throw new RuntimeException(e);

        }



    }


    @javafx.fxml.FXML
    public void backBTOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Event Manager Dashboard!");
        stage.setScene(scene);
        stage.show();
    }
}