import gui.ControlGridPane;
import gui.ControlPane;
import gui.MineSweeperPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import logic.GameLogic;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        HBox hb = new HBox();
        hb.setPadding(new Insets(10));
        hb.setSpacing(10);
        hb.setPrefHeight(400);
        hb.setPrefWidth(800);

        MineSweeperPane pane = new MineSweeperPane();
        ControlPane controlPane = new ControlPane(pane);
        ControlGridPane controlGridPane = new ControlGridPane(controlPane);
        GameLogic.getInstance().setControlPane(controlPane);

        hb.getChildren().addAll(pane,controlGridPane);

        Scene scene = new Scene(hb);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MineSweeper");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
