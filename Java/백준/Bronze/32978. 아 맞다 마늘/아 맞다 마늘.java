import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Main{

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashSet<String> ingredients = new HashSet<>(Arrays.asList(br.readLine().split(" ")));

        if(N > 1) {
            String usedIngredients[] = br.readLine().split(" ");

            for(String ingredient : usedIngredients) {
                ingredients.remove(ingredient);
            }
        }

        String missIngredients = ingredients.iterator().next();
        bw.write(missIngredients);

        bw.flush();
        br.close();
        bw.close();
    }
}