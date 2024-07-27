module com.mycompany.videoplayer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires org.controlsfx.controls;
    
    opens com.mycompany.videoplayer to javafx.fxml;
    exports com.mycompany.videoplayer;
}
