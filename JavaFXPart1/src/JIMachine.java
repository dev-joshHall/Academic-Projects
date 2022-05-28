
import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

/**
 *
 * @author Joshua Hall 10787004
 */
public class JIMachine extends Application {
    GridPane imgPane = new GridPane();
    Image image;
    ImageView view;
    GridPane btnPane = new GridPane();
    boolean imgSelected = false;
    double zoomLevel = 1;
    double aspectRatio = 0;
    double realWidth = 0;
    double realHeight = 0;
    double currentWidth = 0;
    double currentHeight = 0;
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1400, 900);
        
        Button openBtn = new Button("Open");
        Button ZoomInBtn = new Button("Zoom In");
        Button ZoomOutBtn = new Button("Zoom Out");
        Button FullViewBtn = new Button("100%");
        Button quitBtn = new Button("Quit");
        
        imgPane.add(new Text("No Picture Selected"), 0, 0);
        imgPane.setAlignment(Pos.CENTER);
        
        btnPane.add(openBtn, 0, 0);
        btnPane.add(ZoomInBtn, 1, 0);
        btnPane.add(FullViewBtn, 2, 0);
        btnPane.add(ZoomOutBtn, 3, 0);
        btnPane.add(quitBtn, 4, 0);
        btnPane.setAlignment(Pos.CENTER);
        btnPane.setHgap(15);
        
        root.setTop(imgPane);
        root.setBottom(btnPane);
        
        EventHandler<ActionEvent> event = (ActionEvent e) -> {
            chooseFile(e);
        };
        openBtn.setOnAction(event);
        
        EventHandler<ActionEvent> event2 = (ActionEvent e) -> {
            System.exit(0);
        };
        quitBtn.setOnAction(event2);
        
        EventHandler<ActionEvent> event3 = (ActionEvent e) -> {
            if (imgSelected) {
                this.currentHeight = this.currentHeight * .75;
                this.currentWidth = this.currentWidth * .75;
                this.view.setFitWidth(this.currentWidth);
                this.view.setFitHeight(this.currentHeight);
                this.zoomLevel = this.zoomLevel * .75;
            } else {
                System.out.println("No Image selected.");
            }
        };
        ZoomOutBtn.setOnAction(event3);
        
        EventHandler<ActionEvent> event4;
        event4 = (ActionEvent e) -> {
            if (imgSelected && this.zoomLevel < 1.9) {
                this.currentHeight = this.currentHeight * 1.25;
                this.currentWidth = this.currentWidth * 1.25;
                this.view.setFitWidth(this.currentWidth);
                this.view.setFitHeight(this.currentHeight);
                this.zoomLevel = zoomLevel * 1.25;
                if (this.zoomLevel > 1) {
                    Rectangle2D croppedPortion = new Rectangle2D(0, 0, this.realWidth, this.realHeight);
                    view.setViewport(croppedPortion);
                    view.setSmooth(true);
                }
            } else {
                System.out.println("No Image selected.");
            }
        };
        ZoomInBtn.setOnAction(event4);
        
        EventHandler<ActionEvent> event5;
        event5 = (ActionEvent e) -> {
            if (imgSelected) {
                this.currentHeight = this.currentHeight / this.zoomLevel;
                this.currentWidth = this.currentWidth / this.zoomLevel;
                this.view.setFitWidth(this.currentWidth);
                this.view.setFitHeight(this.currentHeight);
                this.zoomLevel = 1;
            } else {
                System.out.println("No Image selected.");
            }
        };
        FullViewBtn.setOnAction(event5);
            
        primaryStage.setTitle("Image Machine");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void chooseFile(ActionEvent actionEvent){
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files",
                        "*.bmp", "*.png", "*.jpg", "*.gif"));
        File file = chooser.showOpenDialog(new Stage());
        if(file != null) {
            try {
                String imagepath = file.toURI().toURL().toExternalForm();
                System.out.println(imagepath);
                this.image = new Image(imagepath);
                this.view = new ImageView();
                this.view.setImage(image);
                this.zoomLevel = 1;
                this.view.setX(10);
                this.view.setY(10);
                this.view.setFitWidth(600);
                this.view.setPreserveRatio(true);
                this.view.preserveRatioProperty().set(true);
                imgPane.getChildren().clear();
                imgPane.add(this.view, 0, 0);
                this.imgSelected = true;
                this.aspectRatio = image.getWidth() / image.getHeight();
                this.currentWidth = Math.min(600, this.view.getFitHeight() * aspectRatio);
                this.currentHeight = Math.min(400, this.view.getFitWidth() / aspectRatio);
                this.realWidth = currentWidth;
                this.realHeight = currentHeight;
            } catch (MalformedURLException ex) {
                Logger.getLogger(JIMachine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Please Select a File");
            alert.showAndWait();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
