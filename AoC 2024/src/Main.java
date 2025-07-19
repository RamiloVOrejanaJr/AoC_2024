public class Main {
    public static void main (String[] args){
        Day01 day01 = new Day01("input.txt");
        System.out.println("The total distance is: " + day01.getFirstAnswer());
        System.out.println("The similarity score of the two lists is: " + day01.getSecondAnswer());
    }
}