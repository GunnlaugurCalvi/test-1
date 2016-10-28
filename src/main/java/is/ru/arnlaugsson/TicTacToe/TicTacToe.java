package is.ru.TicTacToe;

import net.joningi.icndb.ICNDBClient;
import net.joningi.icndb.Joke;


public class TicTacToe {

    final ICNDBClient client = new ICNDBClient();

        private char player;
        private char[][] board;

        public TicTacToe() {

            initialize();
        }   

        public void initialize() {
            board = new char[3][3];
            int counter = 49;
            for(int i =0; i< 3; i++) 
                for(int j = 0; j < 3; j++) {
                board[i][j] = (char) counter;
                counter++;
            }
            player = 'X';
        }

        public String gameOver() {
           for(int i = 0; i < 3; i++){
                if(board[i][0] == board[i][1] && board[i][1] == board[i][2]){
                    initialize();
                    return "true";
                }   
            }

        //checks for winner vertically
            for(int i = 0; i < 3; i++){
                if(board[0][i] == board[1][i] && board[1][i] == board[2][i]){
                    initialize();
                    return "true";
                }   
            }   

        //checks for winner diagonally
            if(board[0][0] == board[1][1] && board[1][1] == board[2][2]){
                initialize();
                return "true";
            }

        //checks for winner diagonally          
            if(board[0][2] == board[1][1] && board[1][1] == board[2][0]){
                initialize();
                return "true";
            }

            for(int i=0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if (board[i][j] != 'O' && board[i][j] != 'X')
                        return "false";
                }
            }

            initialize();
            return "draw";
        }


        public char turn(String s) {
            char input = s.charAt(0);
            if(board[(input - '1')/3][(input - '1')%3] == 'X' || board[(input - '1')/3][(input - '1')%3] == 'O') {
                return player;
            }

            else {
                board[(input - '1')/3][(input - '1')%3] = player;
                char thePlayer = player;
                if(player == 'X')
                    player = 'O';
                else if(player == 'O')
                    player = 'X';
                //return thePlayer;
            }
           
           return board[(input - '1')/3][(input - '1')%3];
        }

    public void alterName(String firstName, String lastName) {
        client.setFirstName(firstName);
        client.setLastName(lastName);
    }
}
