import java.util.Arrays;

public class GameHardLevel {
    public static void main(String[] args) {
        int[] scores = {1, 2, 6, 8, 3, 9, 4, 7};
        getGameHardLevel(scores);
    }

    private static void getGameHardLevel(int[] scores) {

        Arrays.sort(scores);

        int median = (scores.length-1)/2;
        int gameLevel;

        if(median % 2 == 0){
            gameLevel = scores[median];
        } else {
            gameLevel = (scores[median]+scores[median+1])/2;
        }

        System.out.println(gameLevel);
    }

}
