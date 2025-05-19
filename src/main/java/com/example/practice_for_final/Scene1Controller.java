package com.example.practice_for_final;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class Scene1Controller
{
    @javafx.fxml.FXML
    private TableColumn<Employee,String> employeeDepartmentTC;
    @javafx.fxml.FXML
    private TableView<Employee> employeeTableView;
    @javafx.fxml.FXML
    private DatePicker dojDatePicker;
    @javafx.fxml.FXML
    private TableColumn<Employee,String> employeeNameTC;
    @javafx.fxml.FXML
    private ComboBox<String> departComboBox;
    @javafx.fxml.FXML
    private TextField employeeNameTextField;
    @javafx.fxml.FXML
    private Label massageLable;
    @javafx.fxml.FXML
    private TableColumn<Employee, LocalDate> employeeDOJTC;
    @javafx.fxml.FXML
    private TableColumn<Employee,Integer> employeeIdTC;
    @javafx.fxml.FXML
    private TextField employeeIdTextField;
    @javafx.fxml.FXML
    private ComboBox<String> postCB;

    @javafx.fxml.FXML
    public void initialize() {
        employeeDepartmentTC.setCellValueFactory(new PropertyValueFactory<Employee,String>("employeeDepartment"));
        employeeDOJTC.setCellValueFactory(new PropertyValueFactory<Employee,LocalDate>("DOJ"));
        employeeIdTC.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("employeeId"));
        employeeNameTC.setCellValueFactory(new PropertyValueFactory<Employee,String>("employeeName"));


        departComboBox.getItems().addAll("Engineering","Logistics","PR");
        postCB.getItems().addAll("Manager","GM");


    }

    @javafx.fxml.FXML
    public void swichBTOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Event Manager Dashboard!");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void saveToBinBTOnAction(ActionEvent actionEvent) {
        for(Employee employee:employeeTableView.getItems()){

            try{
                File file=new File("Employee.bin"); //save each employee to the bin file
                FileOutputStream fos=null;
                ObjectOutputStream oos=null;

                if(!file.exists()){
                    fos=new FileOutputStream(file);
                    oos=new ObjectOutputStream(fos);

                }else{
                    fos=new FileOutputStream(file,true);
                    oos=new AppendableObjectOutputStream(fos);
                }
                oos.writeObject(employee);
                oos.close();


            }catch (Exception e ){
                throw new RuntimeException(e);

            }

        }
    }

    @javafx.fxml.FXML
    public void addBTOnAction(ActionEvent actionEvent) {
        String employeeName=employeeNameTextField.getText();
        String employeeDepartment=departComboBox.getValue();
        LocalDate DOJ=dojDatePicker.getValue();
        String post=postCB.getValue();


        if(employeeDepartment==null
                ||employeeIdTextField.getText().isEmpty()
                || employeeName.isEmpty()
                ||post==null
                || dojDatePicker.getValue()==null){
            massageLable.setText("Please fill all the fields");
            return;
        }

        int employeeId=Integer.parseInt(employeeIdTextField.getText());


        Employee employee=new Employee(employeeName,employeeId,post,employeeDepartment,DOJ);
        employeeTableView.getItems().add(employee);
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("You successfully added the employee");
        alert.showAndWait();


    }
}