import java.util.*;

public class NQueens{
    static int N = 4;

    //ld is an array where its indices indicate row-col+N-1
    //(N-1) is for shifting the difference to store negative indices
    static int[] ld = new int[30];

    //rd is an array where its indices indicate row+col
    //and is used to check whether a queen can be placed on right diagonal or not
    static int[] rd = new int[30];

    //Column array where its indices indicate column and
    //used to check whether a queen can be placed in that row or not 
    static int[] cl = new int[30];

    //A utility function to print the solution
    static void printSolution(int board[][]){
        for(int i = 0; i< N; i++){
            for (int j=0; j< N;j++)
            System.out.printf(" %d ", board[i][j]);
            System.out.printf("\n");
           
        }
    }
    //A recursive utility function to solve N Queen problem
    static boolean solveNQUtil(int board[][], int col){
        //Basec case: if all queens are placed, then return true
        if(col >= N)
        return true;

        //Consider this column and try placing this queen in all rows one by one
        for(int i = 0; i < N; i++){
            //Check if the queen can be placed on board[i][col]
            if((ld[i-col+N-1] != 1 && rd[i+col] != 1) && cl[i] != 1){
                //Place this queen in board[i][col]
                board[i][col] = 1;
                ld[i-col+ N - 1] = rd[i + col] = cl[i] = 1;

                //Recur to place the rest of the queens
                if(solveNQUtil(board, col + 1))
                return true;

                //If placing queen in baord[i][col] doesn't lead to a solution,
                //remove queen from board[i][col] (BACKTRACK)
                board[i][col] = 0;
                ld[i - col + N -1] = rd[i + col] = cl[i] = 0;
            }
        }
        //If the queen cannot be placed in any row in this column col, return false
        return false;
    }
    //This fuction solves the N Queen probelm using Backtracking
    //It mainly uses solveNQUtil() to solve the problem. It returns false if queens
    //cannot be placed, otherwise, return true and prints the placement of queens in the form of 1s.
    //There may be multiple solutions, but this function prints one of the feasible solutions.
    static boolean solveNQ(){
        int board[][] = { { 0, 0, 0, 0 },
        {0, 0, 0, 0 },
        {0, 0, 0, 0 },
        {0, 0, 0, 0 },
        {0, 0, 0, 0 } };

        //Start the process from column 0
        if(solveNQUtil(board, 0) == false){
            System.out.printf("Solution does not exist");
            return false;
        }
        //If the solutionexists, print it
        printSolution(board);
        return true;
    }
    public static void main(String[] args){
        //Solve and display the solution
        solveNQ();
    }
    }
