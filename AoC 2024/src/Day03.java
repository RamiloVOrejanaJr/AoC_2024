import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Day03 {

    private final String input;
    private final String formulas;

    public Day03(String inputFilePath){
        this.input = readInput(inputFilePath);
        this.formulas = readFormulas();
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

        //cleaning up formulas to boolean for do() and dont(), and only the integers for the mul() formulas
        formulas = formulas.replaceAll("do\\(\\)", "true");
        formulas = formulas.replaceAll("don't\\(\\)", "false");
        formulas = formulas.replaceAll("mul\\(", "");
        formulas = formulas.replaceAll(",", " ");
        formulas = formulas.replaceAll("\\)", " ");

        Scanner scanner = new Scanner(formulas);
        boolean doFormula = true;

        while (scanner.hasNext()){
            if (scanner.hasNextBoolean()){
                doFormula = scanner.nextBoolean();
                continue;
            }

            if (scanner.hasNextInt() && doFormula){
                int value1 = scanner.nextInt();
                int value2 = scanner.nextInt();
                total += (value1*value2);
            }

            else {
                scanner.next();
            }
        }

        return total;
    }
}
