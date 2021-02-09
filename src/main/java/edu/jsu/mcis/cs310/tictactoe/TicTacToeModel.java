package edu.jsu.mcis.cs310.tictactoe;

/**
* TicTacToeModel implements the Model for the Tic-Tac-Toe game.
*
* @author  Payton Askew
* @version 1.0
*/
public class TicTacToeModel {
    
    /**
     * The contents of the Tic-Tac-Toe game board
     */
    private TicTacToeSquare[][] board;
    
    /**
     * xTurn is true if X is the current player, or false if O is the current
     * player
     */
    private boolean xTurn;
    
    /**
     * The dimension (width and height) of the game board
     */
    private int dimension;

    /**
    * Default Constructor (uses the default dimension)
    */    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_DIMENSION);
        
    }
    
    /**
    * Constructor (uses specified dimension)
    * 
    * @param dimension The <em>dimension</em> (width and height) of the new
    * Tic-Tac-Toe board.
    */
    public TicTacToeModel(int dimension) {
        
        /* Initialize dimension; X goes first */
        
        this.dimension = dimension;
        xTurn = true;
        
        /* Create board as a 2D TicTacToeSquare array */
        
        board = new TicTacToeSquare[dimension][dimension];

        /* Initialize board (fill with TicTacToeSquare.EMPTY) */
        
        // INSERT YOUR CODE HERE
        for(int i = 0; i < dimension; i++){
            for (int j = 0; j < dimension; j++){
                board[i][j] = TicTacToeSquare.EMPTY;
            }
        }
        
        
    }
    /**
    * Use isValidSquare(int, int) to check if the specified square is in range,
    * and use isSquareMarked(int, int) to check if the square is currently
    * empty.  If both conditions are satisfied, create a mark in the square for
    * the current player, then toggle xTurn from true to false (or vice-versa)
    * to switch to the other player before returning TRUE.  Otherwise, return
    * FALSE.
    *
    * @param  row  the row (Y coordinate) of the square
    * @param  col  the column (X coordinate) of the square
    * @return      a Boolean value representing the result of the attempt to
    * make this mark: true if the attempt was successful, and false otherwise
    * @see         TicTacToeSquare
    */

    public boolean makeMark(int row, int col) {
        // INSERT YOUR CODE HERE
        
        boolean markMade = false;
        
        if(this.isValidSquare(row, col)== true){
            if(this.isSquareMarked(row, col) == false){

                if (this.xTurn == true){
                    this.board[row][col] = TicTacToeSquare.X;
                }

                if (this.xTurn == false){
                    this.board[row][col] = TicTacToeSquare.O;
                }

                this.xTurn = !this.xTurn;
                markMade = true;
            }
        }

        return markMade;
        
    }
    
    /**
    * Checks if the specified square is within range (that is, within the bounds
    * of the game board).
    *
    * @param  row  the row (Y coordinate) of the square
    * @param  col  the column (X coordinate) of the square
    * @return      a Boolean value: true if the square is in range, and false
    * if it is not
    */
    private boolean isValidSquare(int row, int col) {
        
        // INSERT YOUR CODE HERE

        if(row < this.dimension && col < this.dimension){
            return true;
        }
        else{
            return false;
        }
        
        
    }
    
    /**
    * Checks if the specified square is marked.
    *
    * @param  row  the row (Y coordinate) of the square
    * @param  col  the column (X coordinate) of the square
    * @return      a Boolean value: true if the square is marked, and false
    * if it is not
    */
    private boolean isSquareMarked(int row, int col) {
                
        // INSERT YOUR CODE HERE
        if (this.board[row][col] != TicTacToeSquare.EMPTY){
            return true;
        }
        else{
            return false; // this is a stub; you may need to remove it later!
        }
        
            
    }
    
    /**
    * Returns a {@link TicTacToeSquare} object representing the content of the
    * specified square of the Tic-Tac-Toe board.
    *
    * @param  row  the row (Y coordinate) of the square
    * @param  col  the column (X coordinate) of the square
    * @return      the content of the specified square
    * @see         TicTacToeSquare
    */
    public TicTacToeSquare getSquare(int row, int col) {
         
        // INSERT YOUR CODE HERE
        if (this.isValidSquare(row, col) == true){
            return this.board[row][col];
        }
        return this.board[row][col];  
    }
    
    /**
    * Use isMarkWin() to determine if X or O is the winner, if the game is a
    * tie, or if the game is still in progress. Return the current state of the
    * game as a {@link TicTacToeState} object.
    *
    * @return      the current state of the Tic-Tac-Toe game
    * @see         TicTacToeState
    */
    public TicTacToeState getState() {
        
        // INSERT YOUR CODE HERE
        
        TicTacToeState gameState = TicTacToeState.NONE;
        
        if(this.isMarkWin(TicTacToeSquare.X) == true){
            //gameState = this.board[0][0];
            gameState = TicTacToeState.X;
            //System.out.println("X has won");
        }

        else if(this.isMarkWin(TicTacToeSquare.O) == true){
            gameState = TicTacToeState.O;
            //System.out.println("O has won");
        }

        else if(this.isTie() == true){
            gameState = TicTacToeState.TIE;
            //System.out.println("It is a Tie");
        }
        
        //return null; // this is a stub; you should remove it later!
        
        return gameState;
    }
    
    /**
    * Check the squares of the Tic-Tac-Toe board to see if the specified player
    * is the winner.
    *
    * @param  mark  the mark representing the player to be checked (X or O)
    * @return       true if the specified player is the winner, or false if not
    * @see          TicTacToeSquare
    */
    private boolean isMarkWin(TicTacToeSquare mark) {
        
        // INSERT YOUR CODE HERE

        boolean horizCheck = true, vertCheck = true, leftDiagCheck = true, rightDiagCheck = true;


        //Checks Horizontal

        for(int i = 0; i < this.dimension; i++){
            for(int j = 0; j < this.dimension; j++){
                if (this.board[i][j] != mark){
                    horizCheck = false;
                }
            }
        }


        //Checks Vertical
        for(int i = 0; i < this.dimension; i++){
            for(int j = 0; j < this.dimension; j++){
                if (this.board[j][i] != mark){
                    vertCheck = false;
                }
            }
        }

        //Checks Diagonal (Top Left to Bottom Right)
        for(int i = 0; i < this.dimension; i++){
            if (this.board[i][i] != mark){
                leftDiagCheck = false;
                break;
            }
        }

        //Checks Diagonal (Top Right to Bottom Left)
        for(int i = 0; i < this.dimension; i++){
            for(int j = (this.dimension - 1); j >= 0; j--){
                if (board[i][j] != mark){
                    rightDiagCheck = false;
                    break;
                }
            }
        }

        System.out.println("This is H " + horizCheck + " for " + mark);
        System.out.println("This is V " + vertCheck + " for "+ mark);
        System.out.println("This is LD " + leftDiagCheck+ " for "+ mark);
        System.out.println("This is RD " + rightDiagCheck+ " for "+ mark);
        if(horizCheck == true || vertCheck == true || leftDiagCheck == true || rightDiagCheck == true){
            return true;
        }
        else{
            return false;
        }
        
    }
    
    /**
    * Check the squares of the board to see if the Tic-Tac-Toe game is currently
    * in a tie state.
    *
    * @return  true if the game is currently a tie, or false otherwise
    */	
    private boolean isTie() {
        
        // INSERT YOUR CODE HERE

        boolean readyForCheck = true;

        //Checks to see if all squares are filled
        for(int i = 0; i < this.dimension; i++){
            for(int j = 0; j < this.dimension; j++){
                if(this.board[i][j] == TicTacToeSquare.EMPTY){
                    readyForCheck = false;

                }
            }
        }

        //If all squares aren't filled, then it could still be won
        if (readyForCheck == false){
            return false;
        }

        //If all squares are filled and neither side won, then it is a tie
        else if(readyForCheck == true){
            if (this.isMarkWin(TicTacToeSquare.X) == false && this.isMarkWin(TicTacToeSquare.O) == false) {

                return true;
            }
        }
        
        return readyForCheck;
        
    }

    /**
    * Uses {@link #getState() getState} to checks if the Tic-Tac-Toe game is
    * currently over, either because a player has won or because the game is
    * in a tie state.
    *
    * @return  true if the game is currently over, or false otherwise
    */	
    public boolean isGameover() {
        
        return TicTacToeState.NONE != getState();
        
    }

    /**
    * Getter for xTurn.
    *
    * @return  true if X is the current player, or false if O is the current
    * player
    */
    public boolean isXTurn() {
        
        return xTurn;
        
    }
    
    /**
    * Getter for dimension.
    *
    * @return  the <em>dimension</em> (width and height) of the Tic-Tac-Toe
    * game board
    */
    public int getDimension() {
        
        return dimension;
        
    }
    
    /**
    * <p>Returns the current content and state of the Tic-Tac-Toe game board as
    * a formatted String.  This method <em>must</em> use a {@link StringBuilder}
    * to compose the output String, which should not include any empty lines.</p>
    * <p>Here is an example of how the output for a 3x3 game board should
    * appear (also see the example output on Canvas):</p>
    * <code>&nbsp;&nbsp;012<br>0&nbsp;O&nbsp;&nbsp;<br>1&nbsp;&nbsp;X&nbsp;<br>2&nbsp;O&nbsp;X</code>
    * @return      the representation of the Tic-Tac-Toe game board
    * @see         StringBuilder
    */
    @Override
    public String toString() {
        
        StringBuilder output = new StringBuilder();
        
        // INSERT YOUR CODE HERE
        output.append("  ");

        for(int i = 0; i < this.dimension; i++){
            output.append(i);
        }

        output.append("\n");

        for(int i = 0; i < this.dimension; i++){

            output.append(i + " ");

            for(int j = 0; j < this.dimension; j++){
                output.append(board[i][j]);
            }
            output.append("\n");
        }

        output.append("\n");


        return (output.toString());
        
    }
    
}