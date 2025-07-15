import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Day01 {
    public void getAnswer () {

        Path path = Path.of("input.txt");
        String content;

        try {
            content = Files.readString(path);
        }
        catch (IOException e){
            System.out.print("Something went wrong when reading the file");
            return;
        }
        catch (Exception e){
            System.out.print("Something went wrong");
            return;
        }

        Scanner scanner = new Scanner(content);
        boolean state = true;
        int totalDistance = 0;
        ArrayList<Integer> firstList = new ArrayList<>();
        ArrayList<Integer> secondList = new ArrayList<>();

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
        firstList.sort(null);
        secondList.sort(null);

        for (int i = 0; i < firstList.size(); i++){
            totalDistance += Math.abs(firstList.get(i) - secondList.get(i)); //gets the numerical distance between each value pair
        }
        System.out.print("The total distance is: " + totalDistance);
    }
}
