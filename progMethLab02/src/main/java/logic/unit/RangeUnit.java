package logic.unit;

import java.util.ArrayList;

public class RangeUnit extends BaseUnit{

    public RangeUnit(int startColumn, int startRow, boolean isWhite, String name) {
        super(startColumn, startRow, isWhite, name);

        this.hp = 2;
    }

    public void attack(ArrayList<BaseUnit> targetPieces){
        for (BaseUnit targetPiece : targetPieces) {
            int targetRow = this.isWhite() ? this.getRow()+1 : this.getRow()-1;
            if (targetPiece.getColumn()==this.getColumn()){
                if (targetPiece.getRow()==targetRow){
                    System.out.println(this.getName() + " attack " + targetPiece.getName());
                    targetPiece.hp -= this.getPower();
                }
            }
        }
    }
}

