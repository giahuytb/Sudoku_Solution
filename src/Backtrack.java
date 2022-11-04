
import java.util.Arrays;


public class Backtrack {

//    sudokuBoard = new int[][]
//        { {0, 0, 8,   0, 6, 2,   0, 0, 0},
//          {0, 3, 0,   8, 4, 0,   9, 0, 2},
//          {9, 0, 6,   0, 0, 0,   0, 1, 4},
//          
//          {0, 1, 2,   0, 0, 8,   6, 0, 0}, 
//          {3, 0, 0,   0, 7, 9,   0, 2, 0},
//          {0, 6, 0,   1, 0, 0,   0, 3, 7}, 
//          
//          {0, 0, 1,   7, 8, 0,   3, 0, 0}, 
//          {6, 8, 5,   2, 0, 0,   7, 4, 0},
//          {4, 0, 0,   0, 9, 6,   0, 0, 1}};
    
    static int[][] sudokuBoard;
    static boolean[][][] markMatrix;
    static boolean[][] markRow;
    static boolean[][] markCol;

    public static void solver(int i, int j) throws InterruptedException{
        if(i < 9 && j < 9){
            if(sudokuBoard[i][j] == 0){
                for (int k = 1; k <= 9; k++) {
                    if(!markRow[i][k-1] && !markCol[j][k-1] && !markMatrix[i/3][j/3][k-1]){
                        markRow[i][k-1] = true;
                        markCol[j][k-1] = true;
                        markMatrix[i/3][j/3][k-1] = true;
                        sudokuBoard[i][j] = k; 
                        printResult();
                        System.out.println();
                        Thread.sleep(1000);
                        solver(i, j + 1);
                        
                        markRow[i][k-1] = false;
                        markCol[j][k-1] = false;
                        markMatrix[i/3][j/3][k-1] = false;
                        sudokuBoard[i][j] = 0;
                        
                    }
                }
            }else{
                solver(i, j+1);
            }
        }else if(i < 9 && j >= 9){
            solver(i+1, 0);
        }else if( i >= 9){
            printResult();
        }
    }
    
    public static void printResult(){
        for(int i = 0; i < sudokuBoard.length; i++){
            System.out.println(Arrays.toString(sudokuBoard[i]));
        }
    }
    
    public static void main(String[] args) throws InterruptedException {

        sudokuBoard = new int[][]
        { {0, 0, 8,   0, 6, 2,   0, 0, 0},
          {0, 3, 0,   8, 4, 0,   9, 0, 2},
          {9, 0, 6,   0, 0, 0,   0, 1, 4},
          
          {0, 1, 2,   0, 0, 8,   6, 0, 0}, 
          {3, 0, 0,   0, 7, 9,   0, 2, 0},
          {0, 6, 0,   1, 0, 0,   0, 3, 7}, 
          
          {0, 0, 1,   7, 8, 0,   3, 0, 0}, 
          {6, 8, 5,   2, 0, 0,   7, 4, 0},
          {4, 0, 0,   0, 9, 6,   0, 0, 1}};
        
        markRow = new boolean[9][9];
        markCol = new boolean[9][9];
        markMatrix = new boolean[3][3][9];
        
        for (int i = 0; i < sudokuBoard.length; i++) {
            for (int j = 0; j < sudokuBoard[i].length; j++) {
                if(sudokuBoard[i][j] != 0){
                    int num = sudokuBoard[i][j];
                    //System.out.println("= " + num);
                    markRow[i][num-1] = true;
                    //System.out.println("= " + sudokuBoard[i][num-1]);
                    markCol[j][num-1] = true;
                    markMatrix[i/3][j/3][num-1] = true; 
                    
                }
            }
        }
        
        solver(0, 0);
    }
    
    
}
