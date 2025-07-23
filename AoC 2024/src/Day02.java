import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Day02 {

    private final ArrayList<ArrayList<Integer>> reports;

    public Day02(String inputFilePath) {
        this.reports = getInput(inputFilePath);
    }

    //returns the input file as an arraylist containing arraylists<Integer>, where integers are the levels in the report
    public ArrayList<ArrayList<Integer>> getInput(String filePath) {
        //getting the input and storing it as a String

        ArrayList<ArrayList<Integer>> data = new ArrayList<>(); //the value to be returned
        Path path = Path.of(filePath);
        String content;

        try {
            content = Files.readString(path);
        }
        catch (IOException e) {
            System.out.print("Something went wrong when reading the file");
            return null;
        }
        catch (Exception e) {
            System.out.print("Something went wrong");
            return null;
        }

        Scanner dataScanner = new Scanner(content);

        while (dataScanner.hasNextLine()){
            Scanner reportScanner = new Scanner(dataScanner.nextLine());
            ArrayList<Integer> report = new ArrayList<>();

            while (reportScanner.hasNext()){
                report.add(reportScanner.nextInt());
            }

            data.add(report);
        }

        return data;
    }

    public int getFirstAnswer(){//ArrayList<ArrayList<Integer>> nums){
        int safeListAmount = 0;

        for (ArrayList<Integer> levels: this.reports){
            if (this.isSafe(levels)){
                safeListAmount += 1;
            }
        }

        return safeListAmount;
    }

    public boolean isSafe(ArrayList<Integer> nums){
        int generalDiff = nums.getFirst()-nums.getLast();

        for (int i = 1; i < nums.size(); i++){

            int diff = Math.abs(nums.get(i-1) - nums.get(i));
            boolean withinDistance = (diff >= 1 && diff <= 3);

            boolean sameDirection = (generalDiff * (nums.get(i-1) - nums.get(i)) > 0);

            if (!(withinDistance && sameDirection)){
                return false;
            }
        }

        return true;
    }
}
