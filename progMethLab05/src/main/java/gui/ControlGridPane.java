package gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;



public class ControlGridPane extends GridPane {
    private final String miningImageURL;
    private ControlPane controlPane;

    public ControlGridPane(ControlPane controlPane){
        this.controlPane = controlPane;
        miningImageURL = "bitcoin.png";
        Image image =  new Image(miningImageURL);
        ImageView imv = new ImageView();
        imv.setImage(image);
        imv.setFitHeight(150);
        imv.setFitWidth(150);
        BorderPane bp = new BorderPane();
        bp.setPrefHeight(150);
        bp.setPrefWidth(150);
        bp.setCenter(imv);
        add(bp,0,0);
        add(controlPane,0,1);
    }
}
