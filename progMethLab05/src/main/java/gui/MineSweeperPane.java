package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class MineSweeperPane extends GridPane {
    private ArrayList<MineSweeperSquare> allCells;

    public MineSweeperPane() {
        allCells = new ArrayList<>();
        setHgap(8);
        setVgap(8);
        setPadding(new Insets(8));
        setPrefWidth(500);
        setAlignment(Pos.CENTER);

        setBorder(new Border(new BorderStroke(Color.LIGHTGRAY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        //กำหนดขนาดช่อง -> สร้างconstraints
        for (int i = 0; i < 5; i++) {
            ColumnConstraints col = new ColumnConstraints(100);
            RowConstraints row = new RowConstraints(100);
            this.getColumnConstraints().add(col);
            this.getRowConstraints().add(row);
        }

        //add square
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                MineSweeperSquare mineSweeperSquare = new MineSweeperSquare(j,i);
                allCells.add(mineSweeperSquare);
                add(mineSweeperSquare,j,i);
            }
        }
    }

    public ArrayList<MineSweeperSquare> getAllCells() { return allCells; }
}
