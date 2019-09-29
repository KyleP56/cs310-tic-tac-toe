package edu.jsu.mcis;

public class TicTacToeController implements ActionListener {

    private final TicTacToeModel model;
    private final TicTacToeView view;
    
    /* CONSTRUCTOR */

    public TicTacToeController(int width) {
        
        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView();
        
    }

    public void start() {
    
        /* MAIN LOOP (repeats until game is over) */

        /* Display the board using the View's "showBoard()", then use
           "getNextMove()" to get the next move from the player.  Enter
           the move (using the Model's "makeMark()", or display an error
           using the View's "showInputError()" if the move is invalid. */

        // INSERT YOUR CODE HERE
        while (!model.isGameOver()){
            view.showBoard();
            view.getNextMove();
            model.makeMark();
            
            if (!model.makeMark()){
                view.showInputError();
            }
        }
        
        /* After the game is over, show the final board and the winner */

        view.showBoard(model.toString());

        view.showResult(model.getResult().toString());
        
    }

    public String getMarkAsString(int row, int col){
        return (model.getMark(row,col).toString());
    }

    public TicTacToeView getView(){
        return view;
    }

    @Overrider
    public void actionPerformed(ActionEvent event){
        
        //insert your code here
       String name = ((JButton) event.getSource()).getName();

       int row;
       int col;
       row = Character.getNumericValue(name.charAt(6));
       col = Character.getNumericValue(name.charAt(7));

       model.makeMark(row, col);

       updateSquares();
       
       showResult();

       if(model.isGameOver()){
           disableSquares();
       }

}
