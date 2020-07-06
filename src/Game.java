public class Game {
    private char[][] arr;

    public Game() {
        this.arr = initialize();
    }

    public char[][] initialize() {

        //Scanner scanner = new Scanner(System.in);
        //String line = scanner.nextLine();
        //int counter = 0;
        char[][] _arr = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
               /* switch (line.charAt(counter)){
                    case 'X' :
                        this.arr[i][j] = 'X';
                        break;
                    case 'O' :
                        this.arr[i][j] = 'O';
                        break;
                    default :
                        this.arr[i][j] = '_';
                }
                counter++;*/
                _arr[i][j] = '_';
            }
        }
        return _arr;
    }

    public void print() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == 0 || i == 4) {
                    System.out.print("-");
                } else if (j == 0 || j == 8) {
                    System.out.print("|");
                } else if (j % 2 == 0) {
                    System.out.print(this.arr[i - 1][(j / 2) - 1]);
                } else System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void setNewCell(int[] place, char player) { 
        int row = place[0] - 1;
        int column = place[1] - 1;
        this.arr[2 - row][column] = (player == 'O' ? 'O' : 'X');
    }

    public int check() {

        //int empty = 0;
        //check wins
        for (int i = 0; i < 3; i++) {
            if (this.arr[i][0] == this.arr[i][1] && this.arr[i][1] == this.arr[i][2]) {
                if(this.arr[i][0] != '_' && this.arr[i][2] != '_') return  this.arr[i][0] == 'X' ? 1 : 2;
            } else if (this.arr[0][i] == this.arr[1][i] && this.arr[1][i] == this.arr[2][i]) {
                if(this.arr[0][i] != '_' && this.arr[2][i] != '_') return  this.arr[0][i] == 'X' ? 1 : 2;
            }
        }


        if (this.arr[0][0] == this.arr[1][1] && this.arr[1][1] == this.arr[2][2]) {
            if(this.arr[0][0] != '_' && this.arr[2][2] != '_') return  this.arr[1][1] == 'X' ? 1 : 2;

        } else if (this.arr[0][2] == this.arr[1][1] && this.arr[1][1] == this.arr[2][0]) {
            if(this.arr[0][2] != '_' && this.arr[2][0] != '_') return  this.arr[1][1] == 'X' ? 1 : 2;
        }

        for(char[] row : this.arr){
            for(char c : row){
                if(c == '_') return 3;
            }
        }
        return 0;

    }
    
    public char[][] getArr(){
        return this.arr;
    }

    public void gameLoop(Player player1, Player player2){

        int round = 0;
        int state = 3;

        initialize();
        print();

        while (state == 3){
            if(round % 2 == 0)
            {
                //System.out.print("Enter the coordinates: ");
                setNewCell(player1.step(getArr(), 'X', 'O'), 'X');
            }
            else{
                setNewCell(player2.step(getArr(), 'O', 'X'), 'O');
            }

            print();

            state = check();
            round++;

        }


        switch (state){
            case 1:
                System.out.println("X wins");
                break;
            case 2:
                System.out.println("O wins");
                break;
            case 3:
                System.out.println("Game not finished");
                break;
            default:
                System.out.println("Draw");
        }

    }
}