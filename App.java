package com.mycompany.edptcpclientapp;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author sophi
 */
public class App extends Application {

    /*
    initialise variables for server and javafx 
    */
    static InetAddress host;
    static final int PORT = 1234;
    Label label = new Label("Response from server: ");
    TextField textField = new TextField("");
    TextField className = new TextField();
    TextField classTime = new TextField();
    TextField classLength = new TextField();
    TextField classDays = new TextField();
    TextField classRoom = new TextField();
    TextField classCourse = new TextField();
    Button button = new Button("Add Class");
    Button buttonTwo = new Button("Remove Class");
    Button buttonThree = new Button("Display Schedule");
    Button buttonFour = new Button("Add");
    Button buttonFive = new Button("Remove");
    Button buttonSix = new Button("Display");
    Button back = new Button("Back");
    Label cName = new Label("Enter class name: ");
    Label cTime = new Label("Enter time of class: ");
    Label cLength = new Label("Enter length of class: ");
    Label cDays = new Label("Enter day(s) of class: ");
    Label room = new Label("Enter room(s) for class: ");
    Label course = new Label("Enter the course name: ");
    
    
    public void start (Stage stage){
        
        
        
        
        
        buttonFour.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent a){
                try
                {
                    host = InetAddress.getLocalHost();
                }
                catch(UnknownHostException e)
                {
                    System.out.println("Host ID not found.");
                    System.exit(1);
                }
                Socket link = null;
                try
                {
                    link = new Socket(host,PORT);
                    BufferedReader in = new BufferedReader(new InputStreamReader (link.getInputStream()));
                    PrintWriter out = new PrintWriter(link.getOutputStream(), true);
                    
                    String message = null;
                    String response = null;
                    
                    System.out.println("Enter message to be sent to server: ");
                    message = ((className.getText().toString()) + "," + (classTime.getText().toString()) + "," + (classLength.getText().toString()) + "," +
                           (classDays.getText().toString()) + "," + (classRoom.getText().toString()) + "," + (classCourse.getText().toString()));
                    out.println(message);
                    response = in.readLine();
                    label.setText(response);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    try
                    {
                        System.out.println("\n* Closing connection... *");
                        link.close();
                    }catch(IOException e)
                    {
                        System.out.println("Unable to disconnect.");
                        System.exit(1);
                    }
                }
            }
        });
        
        buttonFive.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent b){
                try
                {
                    host = InetAddress.getLocalHost();
                }
                catch(UnknownHostException e)
                {
                    System.out.println("Host ID not found.");
                    System.exit(1);
                }
                Socket link = null;
                try
                {
                    
                    link = new Socket(host,PORT);
                    BufferedReader in = new BufferedReader(new InputStreamReader (link.getInputStream()));
                    PrintWriter out = new PrintWriter(link.getOutputStream(), true);
                    
                    String message = null;
                    String response = null;
                    
                    System.out.println("Enter message to be sent to server: ");
                    message = cName.getText().toString();
                    out.println(message);
                    response = in.readLine();
                    label.setText(response);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    try
                    {
                        System.out.println("\n* Closing connection... *");
                        link.close();
                    }catch(IOException e)
                    {
                        System.out.println("Unable to disconnect.");
                        System.exit(1);
                    }
                }
            }
        });
        
        buttonSix.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent c){
                try
                {
                    host = InetAddress.getLocalHost();
                }
                catch(UnknownHostException e)
                {
                    System.out.println("Host ID not found.");
                    System.exit(1);
                }
                Socket link = null;
                try
                {
                    
                    link = new Socket(host,PORT);
                    BufferedReader in = new BufferedReader(new InputStreamReader (link.getInputStream()));
                    PrintWriter out = new PrintWriter(link.getOutputStream(), true);
                    
                    String message = null;
                    String response = null;
                    
                    System.out.println("Enter message to be sent to server: ");
                    message = cName.getText().toString();
                    out.println(message);
                    response = in.readLine();
                    label.setText(response);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    try
                    {
                        System.out.println("\n* Closing connection... *");
                        link.close();
                    }catch(IOException e)
                    {
                        System.out.println("Unable to disconnect.");
                        System.exit(1);
                    }
                }
            }
        });
        
        back.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent back){
                VBox box = new VBox(button, buttonTwo, buttonThree, label);
                box.setStyle("-fx-background-color: SLATEGRAY");
                var sceneStart = new Scene(box, 640, 480);
                stage.setScene(sceneStart);
                stage.show();
            }
        });
        
        button.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent a){
                VBox box = new VBox(cName, className,cLength, classLength, cTime, classTime, room, classRoom, cDays, classDays, course, classCourse, buttonFour, back, label);
                    box.setStyle("-fx-background-color: SLATEGRAY");
                    var sceneAddClass = new Scene(box, 640, 480);
                    stage.setScene(sceneAddClass);
                    stage.show(); 
            }
        }
        );
        
        buttonTwo.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent a){
               VBox box = new VBox(cName, className, buttonFive, back, label);
                    box.setStyle("-fx-background-color: SLATEGRAY");
                    var sceneRemoveClass = new Scene(box, 640, 480);
                    stage.setScene(sceneRemoveClass);
                    stage.show(); 
            }
        }
        );
        
        buttonThree.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent a){
               VBox box = new VBox(cName, className, course, classCourse, buttonSix, back, label);
                    box.setStyle("-fx-background-color: SLATEGRAY");
                    var sceneDisplaySchedule = new Scene(box, 640, 480);
                    stage.setScene(sceneDisplaySchedule);
                    stage.show(); 
            }
        }
        );
       
        /*
        setting initial start window
        */
        VBox box = new VBox(button, buttonTwo, buttonThree, label);
        var sceneStart = new Scene(box, 640, 480);
        sceneStart.setFill(Color.SLATEGRAY);
        box.setStyle("-fx-background-color: SLATEGRAY");
        stage.setScene(sceneStart);
        stage.show();
        
        /*
        styling buttons and labels directly 
        */
        button.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font: bold 10pt Arial;");
        buttonTwo.setStyle("-fx-background-color: #87CEFA; -fx-text-fill: white; -fx-font: bold 10pt Arial");
        buttonThree.setStyle("-fx-background-color: #ADD8E6; -fx-text-fill: white; -fx-font: bold 10pt Arial");
        buttonFour.setStyle("-fx-background-color: #B0C4DE; -fx-text-fill: white; -fx-font: bold 10pt Arial");
        buttonFive.setStyle("-fx-background-color: #B0C4DE; -fx-text-fill: white; -fx-font: bold 10pt Arial");
        buttonSix.setStyle("-fx-background-color: #B0C4DE; -fx-text-fill: white; -fx-font: bold 10pt Arial");
        back.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white; -fx-font: bold 10pt Arial");
        button.setMaxWidth(130);
        buttonTwo.setMaxWidth(130);
        buttonThree.setMaxWidth(130);
        buttonFour.setMaxWidth(100);
        buttonFive.setMaxWidth(100);
        buttonSix.setMaxWidth(100);
        
        label.setFont(new Font("Arial", 14));
        cName.setFont(new Font("Arial", 14));
        cTime.setFont(new Font("Arial", 14));
        cLength.setFont(new Font("Arial", 14));
        cDays.setFont(new Font("Arial", 14));
        room.setFont(new Font("Arial", 14));
        course.setFont(new Font("Arial", 15));
        label.setStyle("-fx-text-fill: white;");
        cName.setStyle("-fx-text-fill: white;");
        cTime.setStyle("-fx-text-fill: white;");
        cLength.setStyle("-fx-text-fill: white;");
        cDays.setStyle("-fx-text-fill: white;");
        room.setStyle("-fx-text-fill: white;");
        course.setStyle("-fx-text-fill: white;");
    }
    
    public static void main(String[] args){
        launch();
    }
}
