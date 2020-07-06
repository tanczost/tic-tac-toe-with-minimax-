import java.util.Random;

public class Medium extends Player {


    public Medium(String difficulty) {
        super(difficulty);
    }

    @Override
    protected int[] step(char[][] arr, char me, char enemy) {
        Random random = new Random();
        int[] place = {-1, -1};
        int result;
        int meWin = me == 'X' ? 1 : -1;
        int enemyWin = enemy == 'O' ? -1 : 1;

        int j;
        int i;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (arr[i][j] == '_') {
                    arr[i][j] = me;
                    result = check(arr);

                    if(result == meWin){
                        place[0] = 3 - i ;
                        place[1] = j + 1;
                        arr[i][j] = '_';

                        break;
                    }

                    arr[i][j] = '_';
                }
            }
            if(j != 3) break;
        }
        if(place[0] == -1) {
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    if (arr[i][j] == '_') {
                        arr[i][j] = enemy;
                        result = check(arr);

                        if (result == enemyWin) {
                            place[0] = 3 - i;
                            place[1] = j + 1;
                            arr[i][j] = '_';

                            break;
                        }

                        arr[i][j] = '_';
                    }
                }
                if (j != 3) break;
            }
        }

        if(place[0] == -1){
            int a;
            int b;
            do{
                a = random.nextInt(3) + 1;
                b = random.nextInt(3) + 1;
            }while(!checkIfEmpty(arr,a ,b ));
            place[0] = a;
            place[1] = b;
        }

        System.out.println("Making move level \"" + this.difficulty + "\"");

        return place;

    }
}



