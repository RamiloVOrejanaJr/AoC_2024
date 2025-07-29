import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Day03 {

    private final String input;
    private final String formulas;

    public Day03(String inputFilePath){
        this.input = getInput(inputFilePath);
        this.formulas = readFormulas();
    }

    public String getInput(String filePath){
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

    public String getFormulas(){
        return this.formulas;
    }

    public String readFormulas(){

        String formulas =  this.input.replaceAll("[ \n]", "");
        Scanner scanner = new Scanner(formulas);
        StringBuilder formulasBuilder = new StringBuilder();

        while (scanner.hasNext()){
            //String toAdd = scanner.findWithinHorizon("mul[(][0-9]+,[0-9]+[)]", 0);
            String toAdd = scanner.findWithinHorizon("mul[(][0-9]+,[0-9]+[)]|do\\(\\)|don't\\(\\)", 0);

            if (toAdd == null){
                break;
            }

            toAdd += " ";

            formulasBuilder.append(toAdd);
        }

        formulas = formulasBuilder.toString();
        System.out.println(formulas);

        return formulas;
    }

    public int computeFirstAnswer(){
        int total = 0;
        String formulas = this.formulas;
        formulas = formulas.replaceAll("do\\(\\)|don't\\(\\)", "");
        formulas = formulas.replaceAll("mul\\(", "");
        formulas = formulas.replaceAll(",", " ");
        formulas = formulas.replaceAll("\\)", " ");

        Scanner scanner = new Scanner(formulas);
        //System.out.println(formulas);

        while (scanner.hasNextInt()){
            int value1 = scanner.nextInt();
            int value2 = scanner.nextInt();
            total += (value1*value2);
        }

        return total;
    }

    public int computeSecondAnswer(){
        int total = 0;
        String formulas = this.formulas;
        formulas = formulas.replaceAll("mul\\(", "");
        formulas = formulas.replaceAll(",", " ");
        formulas = formulas.replaceAll("\\)", " ");

        Scanner scanner = new Scanner(formulas);
        System.out.println(formulas);

        while (scanner.hasNextInt()){
            int value1 = scanner.nextInt();
            int value2 = scanner.nextInt();
            total += (value1*value2);
        }

        return total;
    }
}
