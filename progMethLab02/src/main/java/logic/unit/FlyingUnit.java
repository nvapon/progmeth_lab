package logic.unit;

public class FlyingUnit extends BaseUnit{

    public FlyingUnit(int startColumn,int startRow, boolean isWhite, String name){
        super(startColumn, startRow, isWhite, name);

        this.hp = 2;
        this.isFlying = true;
    }

    public boolean move(int direction){
        int row = this.getRow();
        int column = this.getColumn();

        switch(direction) {
            case 0: if (row+2<=4){
                this.setRow(row+2);
                return true;
            } break;

            case 1: if (column+2<=4){
                this.setColumn(column+2);
                return true;
            } break;

            case 2: if (row-2>=0){
                this.setRow(row-2);
                return true;
            } break;

            case 3: if (column-2>=0){
                this.setColumn(column-2);
                return true;
            } break;

        }
        return false;
    }
}
