import java.util.Arrays;

public class Frog {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;
    protected int position;

    public Frog() {
        position = 5;
    }

    public boolean jump(int steps) {
        // сделаем прыжок, если прыжок слишком большой
        // для поля, то не прыгнем и вернём false
        if ((steps + position) <= MAX_POSITION && (steps + position) >= MIN_POSITION) {
            position += steps;
            return true;
        } else {
            return false;
        }
    }

    public void print() {
        int[] pole = new int[MAX_POSITION + 1];
        pole[position] = 8;
        System.out.println(Arrays.toString(pole));
    }

}
