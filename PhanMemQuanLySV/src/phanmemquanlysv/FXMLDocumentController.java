/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package phanmemquanlysv;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ADMIN
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button dangnhap;

    @FXML
    private AnchorPane mainform;

    @FXML
    private PasswordField pass;

    @FXML
    private Button thoat;

    @FXML
    private TextField user;
    
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    
    private double x= 0 ;
    private double y= 0;
    
    /**
     *
     */
    public void DangNhap() throws SQLException{
        
        String sql = "SELECT * FROM admin WHERE username = ? and password = ?";
        
        connect = database.connectDb();
        
        try{ 
            Alert alert;
         
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, user.getText());
            prepare.setString(2, pass.getText());
            
            result = prepare.executeQuery();

            if(user.getText().isEmpty() || pass.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else{
                if(result.next()){

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Đăng nhập thành công!");
                    alert.showAndWait();
                    
                    dangnhap.getScene().getWindow().hide();

                    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
                    
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    
                    root.setOnMousePressed((MouseEvent event) ->{
                        x = event.getSceneX();
                        y = event.getSceneY();
                    });
                    
                    root.setOnMouseDragged((MouseEvent event) ->{
                        stage.setX(event.getScreenX() - x);
                        stage.setY(event.getScreenY() - y);
                    });
                    
                    stage.initStyle(StageStyle.TRANSPARENT);
                    
                    stage.setScene(scene);
                    stage.show();
                    
                }else{
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Sai tên đăng nhập/mật khẩu");
                    alert.showAndWait();
                }
            }
        }catch(Exception e){e.printStackTrace();}
    }
    
    public void thoat(){
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        user.setText("nhom4");
        pass.setText("123456789");
    }    
    
}
