import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day01 {

    //private final String input;
    private final ArrayList<Integer> firstList;
    private final ArrayList<Integer> secondList;

    public Day01(String input) {
        List<Object> list = getInput(input);
        this.firstList = (ArrayList<Integer>) list.get(0);
        this.secondList = (ArrayList<Integer>) list.get(1);
    }

    public List<Object> getInput(String filePath){
        //getting the input and storing it as a String
        Path path = Path.of(filePath);
        String content;
        try {
            content = Files.readString(path);
        }
        catch (IOException e){
            System.out.print("Something went wrong when reading the file");
            return null;
        }
        catch (Exception e){
            System.out.print("Something went wrong");
            return null;
        }

        //converting the String input into two Arraylists based on the two columns of numbers in the input
        Scanner scanner = new Scanner(content);
        ArrayList<Integer> firstList = new ArrayList<>();
        ArrayList<Integer> secondList = new ArrayList<>();
        boolean state = true;

        while (scanner.hasNext()){
            if(state){
                firstList.add(scanner.nextInt());
                state = false;
            }

            else{
                secondList.add(scanner.nextInt());
                state = true;
            }
        }

        scanner.close();
        firstList.sort(null);
        secondList.sort(null);

        return Arrays.asList(firstList, secondList);
    }

    public int getAnswer () {
        int totalDistance = 0;
        for (int i = 0; i < this.firstList.size(); i++){
            //gets the numerical distance between each value pair
            totalDistance += Math.abs(this.firstList.get(i) - this.secondList.get(i));
        }
        return totalDistance;
    }
}
