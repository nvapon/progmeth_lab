package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.GameLogic;

import java.util.ArrayList;

public class ControlPane extends VBox {
    private Text gameText;
    private Button newGameButton;
    private Button secureModeButton;
    private MineSweeperPane mineSweeperPane;

    public ControlPane(MineSweeperPane mineSweeperPane){
        this.mineSweeperPane = mineSweeperPane;
        this.setAlignment(Pos.CENTER);
        this.setPrefWidth(300);
        setSpacing(20);
        initializeGameText();
        initializeNewGameButton();
        initializeSecureModeButton();

        this.getChildren().addAll(gameText, newGameButton, secureModeButton);
    }

    private void initializeGameText(){
        gameText = new Text(" Tiles left : " + GameLogic.getInstance().getTileCount());
        gameText.setFont(new Font(35));
    }

    public void updateGameText(String text){
        gameText.setText(text);
    }

    private void initializeNewGameButton(){
        newGameButton = new Button("New Game");
        newGameButton.setPrefWidth(100);
        newGameButton.setOnAction(newGame -> this.newGameButtonHandler());
    }

    private void initializeSecureModeButton(){
        secureModeButton = new Button("Secure mode : OFF");
        secureModeButton.setPrefWidth(150);
        secureModeButton.setOnAction(secureMode -> this.secureModeButtonHandler());
    }

    private void newGameButtonHandler(){
        GameLogic.getInstance().newGame();
        secureModeButton.setText("Secure mode : OFF");
        GameLogic.getInstance().setSecureMode(false);
        gameText.setText("Tiles left : " + GameLogic.getInstance().getTileCount());
        for(MineSweeperSquare square:mineSweeperPane.getAllCells()){
            square.initializeCellColor();
        }
    }

    private void secureModeButtonHandler(){
        GameLogic.getInstance().toggleSecureMode();
        if(GameLogic.getInstance().isSecureMode()){
            secureModeButton.setText("Secure mode : ON");
        }
        else{
            secureModeButton.setText("Secure mode : OFF");
        }
    }
}
