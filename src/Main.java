import java.util.*;

public class Main {


    public static void main(String [] args)
    {

        Scanner scanner = new Scanner(System.in);
        String command;
        String[] parametres;


        while (true){

            command = scanner.nextLine();

            parametres = command.split(" ");

            if(parametres[0].equals("exit")){
                break;
            }

            if(parametres.length == 3){

                Game game = new Game();

                Player player1, player2;

                switch (parametres[1]) {
                    case("user"):
                        player1 = new Player(parametres[1]);
                        break;
                    case ("medium"):
                        player1 = new Medium(parametres[1]);
                        break;
                    case ("hard"):
                        player1 = new Hard(parametres[1]);
                        break;
                    default:
                         player1 = new Easy(parametres[1]);
                }

                switch (parametres[2]) {
                    case("user"):
                        player2 = new Player(parametres[2]);
                        break;
                    case ("medium"):
                        player2 = new Medium(parametres[2]);
                        break;
                    case ("hard"):
                        player2 = new Hard(parametres[2]);
                        break;
                    default:
                        player2 = new Easy(parametres[2]);
                }


                game.gameLoop(player1, player2);
            }
            else{
                System.out.println("Bad parametres");
            }


        }
    }
}





