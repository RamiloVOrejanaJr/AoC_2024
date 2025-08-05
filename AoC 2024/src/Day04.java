import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class Day04 {
    private final String input;

    public Day04(String inputFilePath){
        this.input = readInput(inputFilePath);
    }

    public String readInput(String filePath){
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

        return content;
    }

    public String getInput(){
        return this.input;
    }

    public int countInRows(ArrayList<String> lines){
        int totalOccurrences = 0;

        //for string in arraylist lines - assumes that input lines is an iterable of strings
        //  for character in string
        //      if character is not x, continue to next iteration
        //      if character is not m, continue to next iteration
        //      if character is not a, continue to next iteration
        //      if character is not s, continue to next iteration
        //      totalOccurrences +=1

        for (String line: lines){
            char[] lineArray = line.toCharArray();


            for (int j = 0; j < lineArray.length-3; j++){
                if (lineArray[j] != 'X'){continue;}

                if (lineArray[j+1] != 'M'){continue;}

                if (lineArray[j+2] != 'A'){continue;}

                if (lineArray[j+3] == 'S'){
                    totalOccurrences +=1;
                }
            }

            for (int j = (lineArray.length-1); j > 2; j--){
                if (lineArray[j] != 'X'){continue;}

                if (lineArray[j-1] != 'M'){continue;}

                if (lineArray[j-2] != 'A'){continue;}

                if (lineArray[j-3] == 'S'){
                    totalOccurrences +=1;
                }
            }
        }
        return totalOccurrences;
    }
}

