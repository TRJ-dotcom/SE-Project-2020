package segame;

import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author trjansen
 */
public class SEGame extends Application {
    private final String appTitle = "CSC-20002 Game";
    private final int textAreaHeight = 200;
    private final int buttonWidth = 150;
    private final String buttonColour = "#191919"; // HEX
    private final String optionTextColour = "#FFFFFF"; // HEX
    private final String backgroundColour = "#A9A9A9"; // HEX
    
    private final String textAreaColour = "#191919"; // HEX
    private final String textAreaTextColour = "#FFFFFF"; // HEX
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenHeight = screenSize.height;
    int screenWidth = screenSize.width;
    
    @Override
    public void start(Stage primaryStage) {
        Button btn1 = new Button();
        btn1.minHeight(((screenHeight - textAreaHeight) / 2));
        btn1.setPrefHeight(((screenHeight - textAreaHeight) / 2));
        btn1.minWidth(buttonWidth);
        btn1.setPrefWidth(buttonWidth);
        btn1.maxWidth(buttonWidth);
        btn1.setBackground(new Background(new BackgroundFill(Color.web(buttonColour), CornerRadii.EMPTY, Insets.EMPTY)));
        btn1.setTextFill(Color.web(optionTextColour));
        btn1.setText("Option One");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Option 1 was chosen!");
            }
        });
        
        Button btn2 = new Button();
        btn2.minHeight(((screenHeight - textAreaHeight) / 2));
        btn2.setPrefHeight(((screenHeight - textAreaHeight) / 2));
        btn2.minWidth(buttonWidth);
        btn2.setPrefWidth(buttonWidth);
        btn2.maxWidth(buttonWidth);
        btn2.setBackground(new Background(new BackgroundFill(Color.web(buttonColour), CornerRadii.EMPTY, Insets.EMPTY)));
        btn2.setTextFill(Color.web(optionTextColour));
        btn2.setText("Option Two");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Option 2 was chosen!");
            }
        });
        
        TextArea textArea = new TextArea();
        textArea.minHeight(textAreaHeight);
        textArea.prefHeight(textAreaHeight);
        textArea.maxHeight(textAreaHeight);
        textArea.setBackground(new Background(new BackgroundFill(Color.web(textAreaColour), CornerRadii.EMPTY, Insets.EMPTY)));
        // textArea.setDisable(true);
        // textArea.setStyle("text-area-background: #191919;");
        // textArea.setStyle("-fx-text-color:#9CD777;") ;
        textArea.setStyle("-fx-font-family: Consolas; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: #00ff00; -fx-control-inner-background: #191919;");
        
        
        StringBuilder fieldContent = new StringBuilder("");
        
        int numberOfDialogLines = 2;
        String[] dialogLine = new String[numberOfDialogLines];
        
        dialogLine[0] = "Hello " + System.getProperty("user.name") + ".\n";
        dialogLine[1] = "Thank you for installing N0tAV1Rus by KANTY.";
        
        for (int j=0;j<numberOfDialogLines;j++) {
            int target = dialogLine[j].length();
            
            for (int i=0;i<target;i++)
            {
                char character = dialogLine[j].charAt(i);
                fieldContent.append(character);
            }
            textArea.setText(fieldContent.toString());
            
        }
        
        BorderPane root = new BorderPane();
        StackPane stackPaneTop = new StackPane();
        StackPane stackPaneLeft = new StackPane();
        StackPane stackPaneCenter = new StackPane();
        StackPane stackPaneBottom = new StackPane();
        
        BorderPane optionPane = new BorderPane();
        
        StackPane topOptionPane = new StackPane();
        StackPane bottomOptionPane = new StackPane();
        
        optionPane.setTop(topOptionPane);
        optionPane.setBottom(bottomOptionPane);
        
        topOptionPane.getChildren().add(btn1);
        bottomOptionPane.getChildren().add(btn2);
        stackPaneBottom.getChildren().add(textArea);
        
        root.setTop(stackPaneTop);
        root.setLeft(stackPaneLeft);
        root.setCenter(stackPaneCenter);
        root.setRight(optionPane);
        root.setBottom(stackPaneBottom);
        
        /*StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(textArea);*/
        
        Scene scene = new Scene(root, screenWidth, screenHeight, Color.web(backgroundColour));
        
        Platform.setImplicitExit(false);

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
            }
        });
        
        
        primaryStage.setTitle(appTitle);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.setResizable(false);
        primaryStage.setFullScreenExitHint("");
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
