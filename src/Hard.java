public class Hard extends Player {

    public Hard(String dicculty) {
        super(dicculty);
    }


    @Override
    protected int[] step(char[][] arr, char me, char enemy) {
        int[] place;

        place = bestMove(arr, me, enemy);

        System.out.println("Making move level \"" + this.difficulty + "\"");

        return place;
    }

    private int[] bestMove(char[][] arr, char me, char enemy) {


        int[] place = {-1, -1};
        int bestScore = Integer.MIN_VALUE;
        //int bestScore = Integer.MAX_VALUE;

        char[][] duplicate = new char[3][3];

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(me != 'X' && arr[i][j] != '_') {
                    duplicate[i][j] = arr[i][j] == 'X' ? 'O' : 'X';
                }
                else {
                    duplicate[i][j] = arr[i][j];
                }
            }
        }




        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (duplicate[i][j] == '_') {
                    duplicate[i][j] = 'X';
                    int score = miniMax(duplicate, false);
                    duplicate[i][j] = '_';

                    if (bestScore < score) {
                        bestScore = score;
                        place[0] = 3 - i;
                        place[1] = j + 1 ;
                    }

                }
            }
        }

        return place;
    }
        private int miniMax ( char[][] arr, boolean isMaximizing) {
            int result = check(arr);

            if (result != 0){
                return result;
            }


            int score = 0;

            int bestScore;
            if (isMaximizing) {
                bestScore = Integer.MIN_VALUE;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (arr[i][j] == '_') {
                            arr[i][j] = 'X';

                            score = miniMax(arr, false);

                            bestScore = Math.max(score, bestScore);

                            arr[i][j] = '_';
                        }
                    }
                }
            }
            else {
                bestScore = Integer.MAX_VALUE;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (arr[i][j] == '_') {
                            arr[i][j] = 'O';

                            score = miniMax(arr, true);

                            bestScore = Math.min(score, bestScore);
                            arr[i][j] = '_';

                        }

                    }
                }
            }
            return bestScore;
        }
}
