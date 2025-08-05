import java.util.ArrayList;

public class Main {
    public static void main (String[] args){
        /*System.out.println("\n------------------Day 1------------------");
        Day01 day01 = new Day01("day01Input.txt");
        System.out.println("The total distance is: " + day01.getFirstAnswer());
        System.out.println("The similarity score of the two lists is: " + day01.getSecondAnswer());

        System.out.println("\n------------------Day 2------------------");
        Day02 day02 = new Day02("day02Input.txt");
        System.out.println("The total number of safe reports is: " + day02.getFirstAnswer());

        System.out.println("\n------------------Day 3------------------");
        Day03 day03 = new Day03("day03Input.txt");
        System.out.println("Total results of mul() formulas: " + day03.computeFirstAnswer());
        System.out.println("Total results of mul() formulas, taking into account do and dont: " + day03.computeSecondAnswer());*/

        System.out.println("\n------------------Day 4------------------");
        Day04 day04 = new Day04("day04Input.txt");

        ArrayList<String> sample = new ArrayList<>();
        sample.add("XMASXMASAMX");
        sample.add("SAMXMASSA");
        //System.out.println("Day 4 sample input: " + sample);
        System.out.println("Day 4 sample first question: " + day04.countInRows(sample));
    }
}