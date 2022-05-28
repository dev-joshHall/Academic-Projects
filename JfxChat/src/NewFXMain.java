/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Joshua Hall
 */
public class NewFXMain extends Application {
    
    String userName = "Anonymous";
    String portNum = "4688";
    
    TextArea messageArea = new TextArea();
    
    public class InnerClass extends Thread {
        public void run() {
            ChatClient listener = new ChatClient("listener");
            listener.connect();
            ChatClient.ChatReader reader = listener.new ChatReader();
            String text = "";
            String newText;
            while (true) {
                try {
                    newText = reader.read();
                    if (!text.equals(newText)) {
                        if (!newText.startsWith(userName.toLowerCase())) {
                            String textInArea = messageArea.getText();
                            messageArea.setText(textInArea + newText + "\n");
                        }
                    }
                    text = newText;
                } catch (Exception e) {}
            }
        }
    }
    
    @Override
    public void start(Stage primaryStage) {
        Parameters parameters = getParameters();
        List<String> args = parameters.getRaw();
        if (args.size() > 0) {
            this.userName = args.get(0);
            if (args.size() > 1) {
                this.portNum = args.get(1);
            }
        }
        
        ChatClient client = new ChatClient(this.userName);
        client.connect();
        client.write("connect " + this.userName);
        
        InnerClass newThread = new InnerClass();
        newThread.start();
        
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 300, 200);
        
        TextField inputText = new TextField();
        
        this.messageArea.setEditable(false);
        this.messageArea.setWrapText(true);
        
        Button btn = new Button();
        btn.setText("Send");
        btn.setOnAction((ActionEvent event) -> {
            String message = inputText.getText().trim();
            inputText.clear();
            if (!message.toLowerCase().equals("disconnect " + this.userName.toLowerCase())) {
                String textInArea = this.messageArea.getText();
                this.messageArea.setText(textInArea + message + "\n");
                client.write(message);
            } else {
                String textInArea = this.messageArea.getText();
                this.messageArea.setText(textInArea + "Disconnecting...\n");
                client.disconnect();
            }
        });
        
        root.setLeft(inputText);
        root.setRight(btn);
        root.setBottom(this.messageArea);
        
        primaryStage.setTitle("Chat");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

