package logic.unit;

import java.util.ArrayList;

public class BaseUnit {

    private int row;
    private int column;
    private boolean isWhite;
    private String name;
    protected int hp;
    protected int power;
    protected boolean isFlying;

    public BaseUnit (int startColumn, int startRow, boolean isWhite, String name){
        this.setColumn(startColumn); // จะ clamp 0-4
        this.setRow(startRow);       // จะ clamp 0-4
        this.setIsWhite(isWhite);
        this.setName(name);
        this.hp = 2;
        this.power = 1;
        this.isFlying = false;

    }

    public boolean move (int direction){
        switch(direction) {
            case 0:
                if(this.row+1<=4) {
                    this.row++;
                    return true;
                }
                break;
            case 1:
                if(this.column+1<=4) {
                    this.column++;
                    return true;
                }
                break;
            case 2:
                if(this.row-1>=0) {
                    this.row--;
                    return true;
                }
                break;
            case 3:
                if(this.column-1>=0) {
                    this.column--;
                    return true;
                }
                break;
        }
        return false;
    }


    public void attack ( ArrayList<BaseUnit> targetPieces ) {
        for (BaseUnit targetPiece : targetPieces){
            if ( targetPiece.getRow()==this.row && targetPiece.getColumn()==this.column && targetPiece.isFlying==false ) {
                System.out.println(this.getName() + " attacks " + targetPiece.getName() );
                targetPiece.hp -= this.power;
            }
        }
    }

    public void setName (String name){ this.name = name; }
    public void setIsWhite (boolean isWhite){ this.isWhite = isWhite; }
    public String getName() { return this.name;}
    public boolean isWhite() { return this.isWhite;}

    public void setRow(int startRow) {
        if(startRow < 0) this.row = 0;
        else if(startRow > 4) this.row = 4;
        else this.row = startRow;
    }

    public void setColumn(int startColumn) {
        if(startColumn < 0) this.column = 0;
        else if(startColumn > 4) this.column = 4;
        else this.column = startColumn;
    }

    public int getRow(){ return this.row;}
    public int getColumn(){ return this.column;}

    public int getHp() { return this.hp;}
    public int getPower() { return this.power;}
    public boolean isFlying() { return this.isFlying; }
}