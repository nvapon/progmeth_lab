package gui;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logic.GameLogic;
import logic.SquareMark;
import logic.SquareState;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

public class MineSweeperSquare extends Pane{

    private boolean isDrawn;
    private Color baseColor;
    private int xPosition;
    private int yPosition;
    private final String oURL;
    private final String oneURL;
    private final String mineURL;
    private final String flagURL;

	public MineSweeperSquare(int x,int y){
        oURL = "o.png";
        oneURL = "one.png";
        mineURL = "mine.png";
        flagURL = "flag.png";
        setxPosition(x);
        setyPosition(y);
        setPrefWidth(100);
        setPrefHeight(100);
        setBaseColor(Color.MOCCASIN);
        initializeCellColor();
        this.setOnMouseClicked(mouseEvent -> this.onClickHandle());
    }

    private void onClickHandle(){
        if(GameLogic.getInstance().isGameEnd()) return;

        SquareState squareState = GameLogic.getInstance().getBoardState()[xPosition][yPosition];
        boolean isSecureMode = GameLogic.getInstance().isSecureMode();
        if(squareState != SquareState.REVEALED && !isSecureMode){
            SquareMark squareMark = GameLogic.getInstance().getBoardMark()[xPosition][yPosition];
            switch(squareMark){
                case ONE:
                    Image oneURL_image = new  Image("one.png");
                    draw(oneURL_image,Color.ORANGE);
                    break;
                case NOTHING:
                    Image oURL_image = new  Image("o.png");
                    draw(oURL_image,Color.YELLOW);
                    break;
                case MINE:
                    Image mineURL_image = new  Image("mine.png");
                    draw(mineURL_image,Color.RED);
                    break;
            }
            GameLogic.getInstance().updateState(xPosition,yPosition,SquareState.REVEALED);
        }
        if(isSecureMode && !isDrawn){
            Image flagURL_image = new Image("flag.png");
            draw(flagURL_image,Color.GREEN);
            GameLogic.getInstance().updateState(xPosition,yPosition,SquareState.SECURED);
        }
    }

	private void draw(Image image, Color backgroundColor) {
		BackgroundFill bgFill = new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = {bgFill};
		BackgroundSize bgSize = new BackgroundSize(100,100,false,false,false,false);
		BackgroundImage bgImg = new BackgroundImage(image, null, null, null, bgSize);
		BackgroundImage[] bgImgA = {bgImg};
		this.setBackground(new Background(bgFillA,bgImgA));
        this.isDrawn = true;
	}

    public void initializeCellColor(){
        setBackground(new Background(new BackgroundFill(baseColor, null, null)));
        this.isDrawn = false;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public void setBaseColor(Color baseColor) {
        this.baseColor = baseColor;
    }
}
