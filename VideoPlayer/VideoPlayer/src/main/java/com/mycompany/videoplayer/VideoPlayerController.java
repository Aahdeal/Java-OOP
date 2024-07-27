package com.mycompany.videoplayer;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import org.controlsfx.dialog.ExceptionDialog;

public class VideoPlayerController {

    @FXML
    private MediaView mediaView;

    @FXML
    private Button playPauseButton;
    
    private MediaPlayer mediaPlayer;
    private boolean playing = false;
    
    public void initialize() throws MalformedURLException{
        URL url = VideoPlayerController.class.getResource("sts117.mp4");
        
        Media media = new Media(url.toExternalForm());
        
        mediaPlayer =  new MediaPlayer(media);
        
        mediaView.setMediaPlayer(mediaPlayer);
        
        mediaPlayer.setOnEndOfMedia(
                new Runnable(){
                    @Override
                    public void run() {
                        playing = false;
                        playPauseButton.setText("Play");
                        mediaPlayer.seek(Duration.ZERO);
                        mediaPlayer.pause();
                    }
                    
                }
        );
        
        mediaPlayer.setOnError(
                new Runnable(){
                    @Override
                    public void run() {
                        ExceptionDialog dialog = new ExceptionDialog(mediaPlayer.getError());
                        dialog.showAndWait();
                    }
                }
        );
        
        mediaPlayer.setOnReady(
                new Runnable(){
                    @Override
                    public void run() {
                        DoubleProperty width = mediaView.fitWidthProperty();
                        DoubleProperty height = mediaView.fitHeightProperty();
                        width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
                        height.bind(Bindings.selectDouble(mediaView.sceneProperty(),"height"));
                    }
                    
                }
        );
    }

    @FXML
    void playPauseButtonPressed(ActionEvent event) {
        playing = !playing;
        
        if (playing){
           playPauseButton.setText("Pause");
           mediaPlayer.play();
        }
        else{
            playPauseButton.setText("Play");
            mediaPlayer.pause();
        }
    }

}
