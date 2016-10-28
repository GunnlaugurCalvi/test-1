package is.ru.TicTacToe;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;


public class TicTacToeWeb implements SparkApplication {

    public static void main(String[] args) {
        staticFileLocation("/public");
        SparkApplication ticweb = new TicTacToeWeb();

        String port = System.getenv("PORT");
        if (port != null) {
            port(Integer.valueOf(port));
        }

        ticweb.init();
    }

    @Override
    public void init() {
        final TicTacToe tic = new TicTacToe();
        post("/turn", (req, res) -> tic.turn(req.queryParams("inputID")));
        post("/gameover", (req,res) -> tic.gameOver());
    }

}
