/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package phanmemquanlysv;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Dialog;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
public class DashboardController implements Initializable {
    
    @FXML
    private Button btn_dangkyhoc;

    @FXML
    private Button btn_dangxuat;

    @FXML
    private Button btn_monhoc;

    @FXML
    private Button btn_nhapdiem;

    @FXML
    private Button btn_thongtin;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button thoat;

    @FXML
    private AnchorPane view1;

    @FXML
    private Button view1_btn_dondep;

    @FXML
    private Button view1_btn_sua;

    @FXML
    private Button view1_btn_them;

    @FXML
    private Button view1_btn_xoa;

    @FXML
    private TextField view1_search;

    @FXML
    private TableView<SinhVien> view1_table;

    @FXML
    private TableColumn<SinhVien, String> view1_table_diem;

    @FXML
    private TableColumn<SinhVien, String> view1_table_gender;

    @FXML
    private TableColumn<SinhVien, String> view1_table_khoa;

    @FXML
    private TableColumn<SinhVien, String> view1_table_mssv;

    @FXML
    private TableColumn<SinhVien, String> view1_table_name;

    @FXML
    private TableColumn<SinhVien, String> view1_table_status;

    @FXML
    private TableColumn<SinhVien, String> view1_table_svnam;

    @FXML
    private DatePicker view1_txt_date;

    @FXML
    private TextField view1_txt_diem;

    @FXML
    private ComboBox<?> view1_txt_gender;

    @FXML
    private TextField view1_txt_khoa;

    @FXML
    private ComboBox<?> view1_txt_svnam;

    @FXML
    private TextField view1_txt_mssv;

    @FXML
    private TextField view1_txt_name;

    @FXML
    private ComboBox<?> view1_txt_status;

    @FXML
    private AnchorPane view2;

    @FXML
    private Button view2_btn_dondep;

    @FXML
    private Button view2_btn_sua;

    @FXML
    private Button view2_btn_them;

    @FXML
    private Button view2_btn_xoa;

    @FXML
    private TableView<MonHoc> view2_table;

    @FXML
    private TableColumn<MonHoc, String> view2_table_mamonhoc;

    @FXML
    private TableColumn<MonHoc, String> view2_table_monhoc;

    @FXML
    private TableColumn<MonHoc, String> view2_table_solop;

    @FXML
    private TableColumn<MonHoc, String> view2_table_mota;

    @FXML
    private TextField view2_txt_monhoc;

    @FXML
    private TextField view2_txt_mamonhoc;

    @FXML
    private TextArea view2_txt_mota;

    @FXML
    private TextField view2_txt_solop;

    @FXML
    private AnchorPane view3;

    @FXML
    private Button view3_btn_dondep;

    @FXML
    private Button view3_btn_sua;

    @FXML
    private Button view3_btn_them;

    @FXML
    private Button view3_btn_xoa;

    @FXML
    private TableView<student_grade> view3_table;

    @FXML
    private TableColumn<student_grade, String> view3_table_diem;

    @FXML
    private TableColumn<student_grade, String> view3_table_monhoc;

    @FXML
    private TableColumn<student_grade, String> view3_table_mssv;

    @FXML
    private TableColumn<student_grade, String> view3_table_name;

    @FXML
    private TextField view3_txt_diem;

    @FXML
    private ComboBox<?> view3_txt_monhoc;

    @FXML
    private ComboBox<?> view3_txt_mssv;

    @FXML
    private AnchorPane view4;

    @FXML
    private Button view4_btn_dangky;

    @FXML
    private Button view4_btn_huy;

    @FXML
    private TableView<student_grade> view4_table;

    @FXML
    private TableColumn<student_grade, String> view4_table_mamonhoc;

    @FXML
    private TableColumn<student_grade, String> view4_table_mssv;

    @FXML
    private TableColumn<student_grade, String> view4_table_name;

    @FXML
    private ComboBox<?> view4_txt_mssv;

    @FXML
    private ComboBox<?> view4_txt_mamonhoc;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    //Sinh vien
    public ObservableList<SinhVien> addStudentsListData() {

        ObservableList<SinhVien> listStudents = FXCollections.observableArrayList();

        String sql = "SELECT * FROM student";

        connect = database.connectDb();

        try {
            SinhVien sinhvienl;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                sinhvienl = new SinhVien(result.getInt("MSSV"),
                        result.getString("name"),
                        result.getString("svnam"),
                        result.getString("gioitinh"),
                        result.getString("khoa"),
                        result.getDate("ngaysinh"),
                        result.getFloat("diem"),
                        result.getString("trangthai"));

                listStudents.add(sinhvienl);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listStudents;
    }

    private ObservableList<SinhVien> addStudentsListD;

    public void addStudentsShowListData() {
        addStudentsListD = addStudentsListData();

        view1_table_mssv.setCellValueFactory(new PropertyValueFactory<>("MSSV"));
        view1_table_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        view1_table_svnam.setCellValueFactory(new PropertyValueFactory<>("svnam"));
        view1_table_gender.setCellValueFactory(new PropertyValueFactory<>("gioitinh"));
        view1_table_khoa.setCellValueFactory(new PropertyValueFactory<>("khoa"));
        view1_table_status.setCellValueFactory(new PropertyValueFactory<>("trangthai"));
        view1_table_diem.setCellValueFactory(new PropertyValueFactory<>("diem"));

        view1_table.setItems(addStudentsListD);
    }

    public void addStudentsSelect() {

        SinhVien sinhvienl = view1_table.getSelectionModel().getSelectedItem();
        int num = view1_table.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        view1_txt_mssv.setText(String.valueOf(sinhvienl.getMSSV()));
        view1_txt_name.setText(sinhvienl.getName());
        view1_txt_khoa.setText(sinhvienl.getKhoa());
        view1_txt_diem.setText(String.valueOf(sinhvienl.getDiem()));
        view1_txt_date.setValue(LocalDate.parse(String.valueOf(sinhvienl.getNgaysinh())));

    }

    private String[] yearList = {"nhất", "hai", "ba", "tư"};

    public void addStudentsYearList() {

        List yearL = new ArrayList<>();

        for (String data : yearList) {
            yearL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(yearL);
        view1_txt_svnam.setItems(ObList);

    }

    private String[] genderList = {"Nam", "Nữ", "khác"};

    public void addStudentsGenderList() {
        List<String> genderL = new ArrayList<>();

        for (String data : genderList) {
            genderL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(genderL);
        view1_txt_gender.setItems(ObList);
    }

    private String[] statusList = {"Bình thường", "cảnh báo!!", "Thôi học"};

    public void addStudentsStatusList() {
        List<String> statusL = new ArrayList<>();

        for (String data : statusList) {
            statusL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(statusL);
        view1_txt_status.setItems(ObList);
    }

    public void addStudentsCourseList() {

        String listCourse = "SELECT * FROM course";

        connect = database.connectDb();

        try {

            ObservableList listC = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listCourse);
            result = prepare.executeQuery();
            
            while (result.next()) {
                listC.add(result.getString("mamonhoc"));
            }
            view3_txt_monhoc.setItems(listC);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void addStudentsCourseList2() {

        String listCourse = "SELECT * FROM course";

        connect = database.connectDb();

        try {

            ObservableList listC = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listCourse);
            result = prepare.executeQuery();
            
            while (result.next()) {
                listC.add(result.getString("mamonhoc"));
            }
            view4_txt_mamonhoc.setItems(listC);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addStudentsMSSVList() {
        String listMSSV = "SELECT * FROM student";

        connect = database.connectDb();

        try {

            ObservableList listM = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listMSSV);
            result = prepare.executeQuery();

            while (result.next()) {
                listM.add(result.getString("MSSV"));
            }
            view3_txt_mssv.setItems(listM);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void addStudentsMSSVList2() {
        String listMSSV = "SELECT * FROM student";

        connect = database.connectDb();

        try {

            ObservableList listM = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listMSSV);
            result = prepare.executeQuery();

            while (result.next()) {
                listM.add(result.getString("MSSV"));
            }
            view4_txt_mssv.setItems(listM);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStudentsAdd() {
        String insertData = "INSERT INTO student "
                + "(MSSV,name,svnam,gioitinh,khoa,ngaysinh,diem,trangthai) "
                + "VALUES(?,?,?,?,?,?,?,?)";

        connect = database.connectDb();

        try {
            Alert alert;

            if (view1_txt_mssv.getText().isEmpty()
                    || view1_txt_name.getText().isEmpty()
                    || view1_txt_svnam.getSelectionModel().getSelectedItem() == null
                    || view1_txt_gender.getSelectionModel().getSelectedItem() == null
                    || view1_txt_khoa.getText().isEmpty()
                    || view1_txt_date.getValue() == null
                    || view1_txt_diem.getText().isEmpty()
                    || view1_txt_status.getSelectionModel().getSelectedItem() == null) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Hãy điền hết ô trống");
                alert.showAndWait();
            } else {

                String checkData = "SELECT MSSV FROM student WHERE MSSV = '"
                        + view1_txt_mssv.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Student #" + view1_txt_mssv.getText() + " was already exist!");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, view1_txt_mssv.getText());
                    prepare.setString(2, view1_txt_name.getText());
                    prepare.setString(3, (String) view1_txt_svnam.getSelectionModel().getSelectedItem());
                    prepare.setString(4, (String) view1_txt_gender.getSelectionModel().getSelectedItem());
                    prepare.setString(5, view1_txt_khoa.getText());
                    prepare.setString(6, String.valueOf(view1_txt_date.getValue()));
                    prepare.setString(7, view1_txt_diem.getText());
                    prepare.setString(8, (String) view1_txt_status.getSelectionModel().getSelectedItem());
                    prepare.executeUpdate();

                    String insertStudentGrade = "INSERT INTO student_grade "
                            + "(MSSV,name) "
                            + "VALUES(?,?)";

                    prepare = connect.prepareStatement(insertStudentGrade);
                    prepare.setString(1, view1_txt_mssv.getText());
                    prepare.setString(2, view1_txt_name.getText());

                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    addStudentsShowListData();

                    addStudentsClear();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStudentsUpdate() {
        String updateData = "UPDATE student SET "
                + "MSSV = '" + view1_txt_mssv.getText()
                + "', name = '" + view1_txt_name.getText()
                + "', svnam = '" + view1_txt_svnam.getSelectionModel().getSelectedItem()
                + "', gioitinh = '" + view1_txt_gender.getSelectionModel().getSelectedItem()
                + "', khoa = '" + view1_txt_khoa.getText()
                + "', ngaysinh = '" + view1_txt_date.getValue()
                + "', trangthai = '" + view1_txt_status.getSelectionModel().getSelectedItem()
                + "' WHERE MSSV = '" + view1_txt_mssv.getText() + "'";

        connect = database.connectDb();

        try {
            Alert alert;
            if (view1_txt_mssv.getText().isEmpty()
                    || view1_txt_name.getText().isEmpty()
                    || view1_txt_svnam.getSelectionModel().getSelectedItem() == null
                    || view1_txt_gender.getSelectionModel().getSelectedItem() == null
                    || view1_txt_khoa.getText().isEmpty()
                    || view1_txt_date.getValue() == null
                    || view1_txt_diem.getText().isEmpty()
                    || view1_txt_status.getSelectionModel().getSelectedItem() == null) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Hãy điền hết ô trống");
                alert.showAndWait();

            } else {

                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Bạn chắc chắn cập nhật thông tin sinh viên " + view1_txt_name.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cập nhật thành công!!");
                    alert.showAndWait();

                    addStudentsShowListData();

                    addStudentsClear();

                } else {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStudentsDelete() {

        String deleteData = "DELETE FROM student WHERE MSSV = '"
                + view1_txt_mssv.getText() + "'";

        connect = database.connectDb();

        try {
            Alert alert;
            if (view1_txt_mssv.getText().isEmpty()
                    || view1_txt_name.getText().isEmpty()
                    || view1_txt_svnam.getSelectionModel().getSelectedItem() == null
                    || view1_txt_gender.getSelectionModel().getSelectedItem() == null
                    || view1_txt_khoa.getText().isEmpty()
                    || view1_txt_date.getValue() == null
                    || view1_txt_diem.getText().isEmpty()
                    || view1_txt_status.getSelectionModel().getSelectedItem() == null) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Hãy điền hết ô trống");
                alert.showAndWait();

            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Bạn chắc chắn muốn xóa thông tin sinh viên: " + view1_txt_name.getText() + "?");

                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {

                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    addStudentsShowListData();

                    addStudentsClear();

                } else {
                    return;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addStudentsSearch() {

        FilteredList<SinhVien> filter = new FilteredList<>(addStudentsListD, e -> true);

        view1_search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateStudentData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if /*(predicateStudentData.getMSSV().toString().contains(searchKey)) {
                    return true;
                } else if*/ (predicateStudentData.getName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getSvnam().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getGioitinh().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getKhoa().toLowerCase().contains(searchKey)) {
                    return true;
                }/* else if (predicateStudentData.getDiem().toLowerCase().contains(searchKey)) {
                    return true;
                }*/ else if (predicateStudentData.getNgaysinh().toString().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getTrangthai().toLowerCase().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<SinhVien> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(view1_table.comparatorProperty());
        view1_table.setItems(sortList);

    }

    public void addStudentsClear() {
        view1_txt_mssv.setText("");
        view1_txt_name.setText("");
        view1_txt_svnam.getSelectionModel().clearSelection();
        view1_txt_gender.getSelectionModel().clearSelection();
        view1_txt_khoa.setText("");
        view1_txt_diem.setText("");
        view1_txt_status.getSelectionModel().clearSelection();
        view1_txt_date.setValue(null);
    }

    //Mon hoc 
    private ObservableList<MonHoc> availableCourseList;

    public ObservableList<MonHoc> availableCourseListData() {

        ObservableList<MonHoc> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM course";

        connect = database.connectDb();

        try {
            MonHoc monhocl;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                monhocl = new MonHoc(result.getString("mamonhoc"),
                        result.getString("monhoc"),
                        result.getInt("solop"),
                        result.getString("mota"));

                listData.add(monhocl);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public void availableCourseShowListData() {
        availableCourseList = availableCourseListData();

        view2_table_mamonhoc.setCellValueFactory(new PropertyValueFactory<>("mamonhoc"));
        view2_table_monhoc.setCellValueFactory(new PropertyValueFactory<>("monhoc"));
        view2_table_solop.setCellValueFactory(new PropertyValueFactory<>("solop"));
        view2_table_mota.setCellValueFactory(new PropertyValueFactory<>("mota"));

        view2_table.setItems(availableCourseList);

    }

    public void availableCourseSelect() {
        MonHoc monhocl = view2_table.getSelectionModel().getSelectedItem();
        int num = view2_table.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        view2_txt_mamonhoc.setText(String.valueOf(monhocl.getMamonhoc()));
        view2_txt_monhoc.setText(monhocl.getMonhoc());
        view2_txt_solop.setText(String.valueOf(monhocl.getSolop()));
        view2_txt_mota.setText(monhocl.getMota());

    }

    public void availableCourseAdd() {

        String insertData = "INSERT INTO course (mamonhoc,monhoc,solop,mota) VALUES(?,?,?,?)";

        connect = database.connectDb();

        try {
            Alert alert;

            if (view2_txt_mamonhoc.getText().isEmpty()
                    || view2_txt_monhoc.getText().isEmpty()
                    || view2_txt_solop.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Hãy nhập hết ô trống");
                alert.showAndWait();
            } else {

                String checkData = "SELECT mamonhoc FROM course WHERE monhoc = '"
                        + view2_txt_monhoc.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Course: " + view2_txt_mamonhoc.getText() + " was already exist!");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, view2_txt_mamonhoc.getText());
                    prepare.setString(2, view2_txt_monhoc.getText());
                    prepare.setString(3, view2_txt_solop.getText());
                    prepare.setString(4, view2_txt_mota.getText());

                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Thêm thành công");
                    alert.showAndWait();

                    availableCourseShowListData();

                    availableCourseClear();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void availableCourseUpdate() {

        String updateData = "UPDATE course SET monhoc = '"
                + view2_txt_monhoc.getText() + "', solop = '"
                + view2_txt_solop.getText() + "', mota = '"
                + view2_txt_mota.getText() + "' WHERE mamonhoc = '"
                + view2_txt_mamonhoc.getText() + "'";

        connect = database.connectDb();

        try {
            Alert alert;

            if (view2_txt_mamonhoc.getText().isEmpty()
                    || view2_txt_monhoc.getText().isEmpty()
                    || view2_txt_solop.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Hãy điền hết ô trống!!");
                alert.showAndWait();
            } else {

                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Bạn có chắc chắn muốn sửa: " + view2_txt_monhoc.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Sửa thành công");
                    alert.showAndWait();

                    availableCourseShowListData();

                    availableCourseClear();

                } else {
                    return;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void availableCourseDelete() {

        String deleteData = "DELETE FROM course WHERE mamonhoc = '"
                + view2_txt_mamonhoc.getText() + "'";

        connect = database.connectDb();

        try {
            Alert alert;

            if (view2_txt_mamonhoc.getText().isEmpty()
                    || view2_txt_monhoc.getText().isEmpty()
                    || view2_txt_solop.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Hãy điền hết ô trống!!");
                alert.showAndWait();
            } else {

                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Bạn chắc chắn muốn xóa: " + view2_txt_monhoc.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Xóa thành công");
                    alert.showAndWait();

                    availableCourseShowListData();

                    availableCourseClear();

                } else {
                    return;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void availableCourseClear() {
        view2_txt_mamonhoc.setText("");
        view2_txt_monhoc.setText("");
        view2_txt_solop.setText("");
        view2_txt_mota.setText("");
    }

    //Diem
    private ObservableList<student_grade> availableScoreList;

    public ObservableList<student_grade> availableScoreListData() {

        ObservableList<student_grade> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM student_grade";

        connect = database.connectDb();

        try {
            student_grade score;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                score = new student_grade(result.getInt("MSSV"),
                        result.getString("name"),
                        result.getString("mamonhoc"),
                        result.getFloat("diem"));

                listData.add(score);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public void availableScoreShowListData() {
        availableScoreList = availableScoreListData();

        view3_table_mssv.setCellValueFactory(new PropertyValueFactory<>("MSSV"));
        view3_table_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        view3_table_monhoc.setCellValueFactory(new PropertyValueFactory<>("mamonhoc"));
        view3_table_diem.setCellValueFactory(new PropertyValueFactory<>("diem"));

        view3_table.setItems(availableScoreList);

    }
    
    public void availableScoreAdd() {
        
        String insertData = "INSERT INTO student_grade (MSSV, name, mamonhoc, diem)" +
        "VALUES(?,?,?,?)";               
    
        connect = database.connectDb();
        PreparedStatement statement1;
        PreparedStatement statement2;
        PreparedStatement statement3;
            try {
            String s = "set foreign_key_checks = 0";
            statement1 = connect.prepareStatement(s);
            statement1.executeUpdate();
            
            int msv = Integer.parseInt((String)view3_txt_mssv.getSelectionModel().getSelectedItem());
            String monhoc = (String)view3_txt_monhoc.getSelectionModel().getSelectedItem();
            String name = "";
            String aa = "SELECT name FROM student WHERE MSSV = ?";
            statement3 = connect.prepareStatement(aa);
            statement3.setInt(1,msv);
            ResultSet res = statement3.executeQuery();
            if(res.next()){
                name = res.getString("name");
            }
            
            Alert alert;
            if (  monhoc  == null || view3_txt_diem.getText().equals("")) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Hãy nhập hết ô trống");
                alert.showAndWait();
            } else {
                PreparedStatement statement4;
                float diem = 0;
                try{
                    diem =  Float.valueOf(view3_txt_diem.getText());
                    if(diem < 0 || diem > 10){
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText("diem khong hop le");
                        alert.showAndWait();
                        return;
                    }
                }catch(NumberFormatException e){
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText("diem khong hop le");
                        alert.showAndWait();
                        return;
                }
                String checkData = "SELECT * FROM student_grade WHERE MSSV = ?"
                       + " and mamonhoc = ?";
                statement4 = connect.prepareStatement(checkData);
                statement4.setInt(1,msv);
                statement4.setString(2,monhoc);
                result = statement4.executeQuery();

                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Course: " + view3_txt_mssv.getSelectionModel().getSelectedItem() + " was already exist!");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, (String) view3_txt_mssv.getSelectionModel().getSelectedItem());
                    prepare.setString(2, name);
                    prepare.setString(3, (String) view3_txt_monhoc.getSelectionModel().getSelectedItem());
                    prepare.setFloat(4,diem);

                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Thêm thành công");
                    alert.showAndWait();

                    availableScoreShowListData();

                    availableScoreClear();
                }
            }
            String s2 = "set foreign_key_checks = 1";
            statement2 = connect.prepareStatement(s2);
            statement2.executeUpdate();
         
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    public void availableScoreUpdate() {

       PreparedStatement statement1; 
       connect = database.connectDb();
       
      try{
          student_grade select  = view3_table.getSelectionModel().getSelectedItem();
          Dialog<student_grade> dialog = new Dialog<>();
          GridPane grid = new GridPane();
          TextField diem = new TextField();
          diem.setText(String.valueOf(select.getDiem()));
          
          grid.add(new Label("Diem:"), 0, 0);
          grid.add(diem,0,1);
          ButtonType button = ButtonType.OK;
          dialog.getDialogPane().setContent(grid);
          dialog.getDialogPane().getButtonTypes().add(button);
         
          dialog.showAndWait();
          float d = Float.valueOf(diem.getText());
          
          String sql1 = "update student_grade set diem = ? where MSSV = ? and mamonhoc = ?";
          statement1 = connect.prepareStatement(sql1);
          statement1.setFloat(1,d );
          statement1.setInt(2, select.getMSSV());
          statement1.setString(3,select.getMamonhoc());
          statement1.executeUpdate();
          availableScoreShowListData();
          
          
      }catch(Exception e){
          e.fillInStackTrace();
      }
       
    }
    
    public void availableScoreClear() {
        view3_txt_mssv.getSelectionModel().clearSelection();
        view3_txt_monhoc.getSelectionModel().clearSelection();
        view3_txt_diem.setText("");
    }

    private double x = 0;
    private double y = 0;

    public void dangxuat() {

        try {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("bạn có chắc chắn muốn đăng xuất?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

                btn_dangxuat.getScene().getWindow().hide();

                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();

            } else {
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void deleteStudentHandle(){
        student_grade select  = view3_table.getSelectionModel().getSelectedItem();
        ObservableList<student_grade> list = view3_table.getItems();
        if(select != null){
            list.remove(select);
            view3_table.setItems(list);
            view3_table.refresh(); 
            try{
            
            connect = database.connectDb();
            PreparedStatement statement;
            String s = "delete from student_grade where MSSV = ? and mamonhoc = ?";
            statement = connect.prepareStatement(s);
            statement.setInt(1,select.getMSSV());
            statement.setString(2,select.getMamonhoc());
            statement.executeUpdate();
            }catch(Exception e){
                e.fillInStackTrace();
            }
        }
    }
    
    // Dang ky
    
    private ObservableList<student_grade> availableSubjectList;

    public ObservableList<student_grade> availableSubjectListData() {

        ObservableList<student_grade> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM student_subject";

        connect = database.connectDb();

        try {
            student_grade score;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                score = new student_grade(result.getInt("MSSV"),
                        result.getString("name"),
                        result.getString("mamonhoc"));
                listData.add(score);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    
     public void availableSubjectShowListData() {
        availableSubjectList = availableSubjectListData();

        view4_table_mssv.setCellValueFactory(new PropertyValueFactory<>("MSSV"));
        view4_table_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        view4_table_mamonhoc.setCellValueFactory(new PropertyValueFactory<>("mamonhoc"));

        view4_table.setItems(availableSubjectList);

    }
    public void addSubjecthandle(ActionEvent event){
        connect = database.connectDb();
        PreparedStatement statement1;
        PreparedStatement statement2;
        PreparedStatement statement4;
        
        try{
           int msv = Integer.parseInt((String)view4_txt_mssv.getSelectionModel().getSelectedItem());
            String monhoc = (String)view4_txt_mamonhoc.getSelectionModel().getSelectedItem();
            String name = "";
            String aa = "SELECT name FROM student WHERE MSSV = ?";
            statement1 = connect.prepareStatement(aa);
            statement1.setInt(1,msv);
            ResultSet res = statement1.executeQuery();
            if(res.next()){
                name = res.getString("name");
            }
            
            
            String checkData = "SELECT * FROM student_subject WHERE mssv = ?"
                       + " and mamonhoc = ?";
                statement4 = connect.prepareStatement(checkData);
                statement4.setInt(1,msv);
                statement4.setString(2,monhoc);
                result = statement4.executeQuery();

                if (result.next()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Course: " + view3_txt_mssv.getSelectionModel().getSelectedItem() + " was already exist!");
                    alert.showAndWait();
                } else {
                   
                     String sql2 = "insert into student_subject(mssv,name,mamonhoc) "
                    + "values(?,?,?) ";
            
                     statement2 = connect.prepareStatement(sql2);
                     statement2.setInt(1,msv);
                     statement2.setString(2, name);
                     statement2.setString(3, monhoc);
                     statement2.executeUpdate();
                     
                     Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                     alert1.setTitle("Information Message");
                     alert1.setHeaderText(null);
                     alert1.setContentText("Thêm thành công");
                     alert1.showAndWait();

                     
                     availableSubjectShowListData();
                }

            
        }catch(Exception e){
            e.fillInStackTrace();
        }
            
            
    }
    
    public void cancelSubjectHandle(ActionEvent event){
        student_grade select  = view4_table.getSelectionModel().getSelectedItem();
        ObservableList<student_grade> list = view4_table.getItems();
        if(select != null){
            list.remove(select);
            view4_table.setItems(list);
            view4_table.refresh(); 
            try{
            
            connect = database.connectDb();
            PreparedStatement statement;
            String s = "delete from student_subject where mssv = ? and mamonhoc = ?";
            statement = connect.prepareStatement(s);
            statement.setInt(1,select.getMSSV());
            statement.setString(2,select.getMamonhoc());
            statement.executeUpdate();
            }catch(Exception e){
                e.fillInStackTrace();
            }
        }
    }
    
   
    
     public void switchForm(ActionEvent event) {
        if (event.getSource() == btn_thongtin) {
            view1.setVisible(true);
            view2.setVisible(false);
            view3.setVisible(false);
            view4.setVisible(false);

            addStudentsYearList();
            addStudentsGenderList();
            addStudentsStatusList();

        } else if (event.getSource() == btn_monhoc) {
            view1.setVisible(false);
            view2.setVisible(true);
            view3.setVisible(false);
            view4.setVisible(false);

            availableCourseShowListData();

        } else if (event.getSource() == btn_nhapdiem) {
            view1.setVisible(false);
            view2.setVisible(false);
            view3.setVisible(true);
            view4.setVisible(false);

            addStudentsCourseList();
            addStudentsMSSVList();
            availableScoreShowListData();

        } else if (event.getSource() == btn_dangkyhoc) {
            view1.setVisible(false);
            view2.setVisible(false);
            view3.setVisible(false);
            view4.setVisible(true);
            
            addStudentsCourseList2();
            addStudentsMSSVList2();
            availableSubjectShowListData();

        }
    }
    
    
    public void thoat() {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        addStudentsShowListData();
        addStudentsSelect();
        addStudentsYearList();
        addStudentsGenderList();
        addStudentsStatusList();

        addStudentsCourseList();
        addStudentsMSSVList();
        
        addStudentsCourseList2();
        addStudentsMSSVList2();

        availableScoreShowListData();

        availableCourseShowListData();
        
        availableSubjectShowListData();

    }

}
