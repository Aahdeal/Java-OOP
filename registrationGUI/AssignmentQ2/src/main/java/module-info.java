module com.mycompany.assignmentq2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.assignmentq2 to javafx.fxml;
    exports com.mycompany.assignmentq2;
}
