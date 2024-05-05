public class Board {
    int size;
    int chance;
    PeiceType[][] board;
    boolean tie;
    boolean winner;

    public Board(int s){
        this.size=s;
        chance = s*s;
        board= new PeiceType[size][size];
        tie=false;
        winner=false;
    }

    public boolean addValue(String rowAndColumn, PeiceType type){
        if(checkForBoundaryConditions(rowAndColumn))return false;
        rowAndColumn = rowAndColumn.trim();
        int row = rowAndColumn.charAt(0)-'0', column = rowAndColumn.charAt(2)-'0';
        board[row][column]=type;
        this.chance--;
        if(checkIfWinner(row, column, type)){
            this.winner=true;
            return true;
        };
        if(chance==0){
            this.tie=true;
        }
        return true;
    }

    public boolean checkForBoundaryConditions(String rowAndColumn){
        if(rowAndColumn.isEmpty()){
            System.out.println("Please enter a row and column value");
            return true;
        }

        rowAndColumn = rowAndColumn.trim();

        if(rowAndColumn.length()<3){
            System.out.println("Please add a comma while entering the row anc column value");
            return true;
        }
        if(!Character.isDigit(rowAndColumn.charAt(0)) ||  !Character.isDigit(rowAndColumn.charAt(2))){
            System.out.println("Please enter valid row and column value");
            return true;
        }
        int row = rowAndColumn.charAt(0)-'0', column = rowAndColumn.charAt(2)-'0';

        if(row< 0 || column < 0 || row >= size || column >=size){
            System.out.println("Please a valid row and column value");
            return true;
        }

        if(board[row][column]==PeiceType.O || board[row][column]==PeiceType.X){
            System.out.println("This position is already filled, kindly select some other position");
            return true;
        }

        return false;
    }


    public boolean checkIfWinner(int row, int column, PeiceType type){
       int rowCount =0, columnCount =0, diagonalCount =0;

        for(int i=0;i<size;i++){
            if(board[row][i]==type) rowCount++;
        }
        if(rowCount==size)return true;

        for (int i = 0; i <size ; i++) {
            if(board[i][column]==type)columnCount++;
        }

        if(columnCount==size)return true;

        int i=row, j=column;
        while (i>=0 && j>=0){
            if(board[i--][j--]!=type)return false;
        }

        i=row;
        j=column;
        while (i<size && j<size){
            if(board[i++][j++]!=type)return false;
        }

        i=row;
        j=column;
        while (i >=0 && j<size){
            if(board[i--][j++]!=type)return false;
        }

        i=row;
        j=column;
        while (i <size && j>=0){
            if(board[i++][j--]!=type)return false;
        }
        return true;
    }

    public void Print(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(board[i][j]==null) System.out.print(" "+" | ");
                else   System.out.print(board[i][j]+" | ");
            }
            System.out.println();
        }
    }
}
