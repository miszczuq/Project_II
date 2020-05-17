import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreFileManager {
    private static final String PATH = "scores.txt";

    public static void addScore(String name){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH,true));
            bufferedWriter.write(name);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String[] getScoreList(){
        String[] tab=null;
        try {
            FileReader reader = new FileReader(PATH);
            BufferedReader br = new BufferedReader(reader);

            String line;
            int lines=0;

            while (br.readLine()!= null) {
                lines++;
            }

            reader.close();
            br.close();
            reader = new FileReader(PATH);
            br = new BufferedReader(reader);

            tab= new String[lines];
            lines =0;

            while ((line = br.readLine()) != null) {
                tab[lines++]=line;
            }

            br.close();
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        }

        return tab;
    }
}
