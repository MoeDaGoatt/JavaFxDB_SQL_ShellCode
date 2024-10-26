package org.example.javafxdb_sql_shellcode;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.javafxdb_sql_shellcode.db.ConnDbOps;

import java.io.File;
import java.net.URL;
import java.sql.DatabaseMetaData;
import java.util.List;
import java.util.ResourceBundle;



public class DB_GUI_Controller implements Initializable {

        private final ObservableList<Person> data =
                FXCollections.observableArrayList(
                        new Person(1, "Jacob", "Smith", "CPIS", "CS", null),
                        new Person(2, "Jacob2", "Smith1", "CPIS1", "CS", null)

                );
    @FXML
    private ImageView img_view;
    @FXML
        private MenuItem darkThemeMenuItem;

        @FXML
        private VBox listPlace;
        Stage stage;
        @FXML
        private MenuItem openMenuItem;

        @FXML
        TextField first_name, last_name, department, major;
        @FXML
        private TableView<Person> tv;
        @FXML
        private TableColumn<Person, Integer> tv_id;
        @FXML
        private TableColumn<Person, String> tv_fn, tv_ln, tv_dept, tv_major;

        private ConnDbOps dataBaseManager = new ConnDbOps();

    /**
     * initialize method
     * @param url
     * The location used to resolve relative paths for the root object, or
     * {@code null} if the location is not known.
     *
     * @param resourceBundle
     * The resources used to localize the root object, or {@code null} if
     * the root object was not localized.
     */
    @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

            tv_id.setCellValueFactory(new PropertyValueFactory<>("id"));
            tv_fn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            tv_ln.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            tv_dept.setCellValueFactory(new PropertyValueFactory<>("dept"));
            tv_major.setCellValueFactory(new PropertyValueFactory<>("major"));

            dataBaseManager.connectToDatabase();
            dataBaseManager.listAllUsers();
            tv.setItems(dataBaseManager.initialData);

            tv.setItems(data);

            openMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.F, KeyCombination.CONTROL_DOWN));
            openMenuItem.setOnAction(this::openFile);


        }

    /**
     * dar mode method
     */
    @FXML
        void darkMode(){
            Scene scene = img_view.getScene();
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("dark-theme.css").toExternalForm());
        }

    /**
     * light mode method
     */
        @FXML
        void lightMode() {
            Scene scene = img_view.getScene();
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("light-theme.css").toExternalForm());
        }


    /**
     * add new record method
     */
    @FXML
    protected void addNewRecord() {
        String imagePath = img_view.getImage() != null ? img_view.getImage().getUrl() : null;

        Person person = new Person(
                data.size() + 1,
                first_name.getText(),
                last_name.getText(),
                department.getText(),
                major.getText(),
                imagePath
        );

        data.add(person);

        clearForm();
    }


    /**
     * clear form method
     */
    @FXML
        protected void clearForm() {
            first_name.clear();
            last_name.setText("");
            department.setText("");
            major.setText("");
        }

    /**
     * close application method
     */
        @FXML
        protected void closeApplication() {
            System.exit(0);
        }

    /**
     * get record method
     */
        @FXML
        protected void editRecord() {
            Person p= tv.getSelectionModel().getSelectedItem();
            if (p != null) {
                p.setFirstName(first_name.getText());
                p.setLastName(last_name.getText());
                p.setDept(department.getText());
                p.setMajor(major.getText());

                tv.refresh();
                clearForm();
            }
        }

    /**
     * delete record method
     */
        @FXML
        protected void deleteRecord() {
            Person p= tv.getSelectionModel().getSelectedItem();
            if (p != null) {
                // Remove the selected Person from the data
                data.remove(p);
                clearForm(); // Clear the form after deletion
            }
        }


    /**
     * show image method
     */
        @FXML
        protected void showImage() {
            File file= (new FileChooser()).showOpenDialog(img_view.getScene().getWindow());
            if(file!=null){
                img_view.setImage(new Image(file.toURI().toString()));
            }
        }


    /**
     * selectedItem method
     * @param mouseEvent
     */
    @FXML
        protected void selectedItemTV(MouseEvent mouseEvent) {
            Person p= tv.getSelectionModel().getSelectedItem();
            first_name.setText(p.getFirstName());
            last_name.setText(p.getLastName());
            department.setText(p.getDept());
            major.setText(p.getMajor());


        }

    /**
     * open file method
     * @param actionEvent
     */
    @FXML
        public void openFile(ActionEvent actionEvent) {
            if (listPlace != null) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Files");
                Stage stage = (Stage) listPlace.getScene().getWindow();

                File selectedFile = fileChooser.showOpenDialog(stage);
            }

        }

    /**
     * initialize method
     */
    @FXML
        public void initialize() {
            openMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.F, KeyCombination.ALT_DOWN));
            openMenuItem.setOnAction(this::openFile);
        }

        public void showAbout(ActionEvent actionEvent) {

        }

    }




