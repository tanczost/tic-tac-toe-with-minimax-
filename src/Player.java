import java.util.Scanner;

public class Player {
    String difficulty;


    public Player(String difficulty){
        this.difficulty = difficulty;
    }

    protected int check(char[][] arr) {

        //int empty = 0;
        //check wins
        for (int i = 0; i < 3; i++) {
            if (arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2]) {
                if (arr[i][0] != '_' && arr[i][2] != '_') return arr[i][0] == 'X' ? 1 : -1;
            } else if (arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i]) {
                if (arr[0][i] != '_' && arr[2][i] != '_') return arr[0][i] == 'X' ? 1 : -1;
            }
        }


        if (arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) {
            if (arr[0][0] != '_') return arr[1][1] == 'X' ? 1 : -1;

        } else if (arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0]) {
            if (arr[0][2] != '_') return arr[1][1] == 'X' ? 1 : -1;
        }

        for(char[] row : arr) {
            for(char c : row) {
                if(c == '_') return  0;
            }
        }
        return 2;
    }

    protected boolean checkIfEmpty(char [][] arr, int row, int column){
        return arr[2 - (row - 1)][column - 1] == '_';
    }

    protected int[] step(char[][] arr, char me, char enemy)
    {
        int[] place = {-1, -1};
        Scanner scanner = new Scanner(System.in);
        int row;
        int column;

        do{
            System.out.print("Enter coordinates (" + me + ") : ");
            String line = scanner.nextLine();

            if( Character.isDigit(line.charAt(0)) && Character.isDigit(line.charAt(2))) {

                column = Character.getNumericValue(line.charAt(0));
                row = Character.getNumericValue(line.charAt(2));

                if(row > 0 && row < 4 && column > 0 && column < 4) {
                    if(checkIfEmpty(arr, row, column)){
                        break;
                    }
                    else{
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                }
                else{
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            }
            else {
                System.out.println("You should enter numbers!");
            }
        }while (true);

        place[0] = row;
        place[1] = column;
        return place;
    }
}
