public class Main {
    public static void main (String[] args){
        System.out.println("\n------------------Day 1------------------");
        Day01 day01 = new Day01("day1Input.txt");
        System.out.println("The total distance is: " + day01.getFirstAnswer());
        System.out.println("The similarity score of the two lists is: " + day01.getSecondAnswer());

        System.out.println("\n------------------Day 2------------------");
        Day02 day02 = new Day02("day2Input.txt");
        System.out.println("The total number of safe reports is: " + day02.getFirstAnswer());
    }
}