import java.util.Random;

public class Easy extends Player {

    public Easy(String difficulty) {
        super(difficulty);
    }

    @Override
    protected int[] step(char[][] arr, char me, char enemy) {
        Random random = new Random();
        int[] place = {-1, -1};

        do {
            place[0] = random.nextInt(3) + 1;
            place[1] = random.nextInt(3) + 1;
        } while (!checkIfEmpty(arr, place[0], place[1]));

        System.out.println("Making move level \"" + this.difficulty + "\"");

        return place;
    }
}