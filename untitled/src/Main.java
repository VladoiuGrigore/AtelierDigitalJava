import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private Scanner sc = new Scanner(System.in);
    private File f = new File("649.txt");
    private File g = new File("540.txt");

    public void showResults() {
        System.out.println("Last result for 6/49");
        readFromFile(f);
        System.out.println("\n Last result for 5/40");
        readFromFile(g);
    }

    public void readFromFile(File f) {
        try {
            Process p = Runtime.getRuntime().exec("tail -" + 6 + " " + f.getPath());
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s;
            while ((s = streamReader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void writeInFile(int[] array, int howMany) { // 1-649, 2-540
        File file = g;
        if (howMany == 6) {
            file = f;
        }
        try {
            PrintStream fileOutputStream = new PrintStream(new FileOutputStream(file, true));
            for (int i : array) {
                fileOutputStream.print(i + " ");
            }
            fileOutputStream.println();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static int[] genNumb(int nr, int min, int max) {

        Random rand = new Random();
        int[] numbers = new int[nr];
        int currentNumber;

        for (int i = 0; i < numbers.length; i++) {
            currentNumber = rand.nextInt(max) + min;
            if (contains(currentNumber, i, numbers)) {
                i--;
            } else {
                numbers[i] = currentNumber;
            }
        }
        return numbers;
    }

    public static boolean contains(int nr, int poz, int[] currentArray) {

        for (int i = 0; i < poz; i++)
            if (currentArray[i] == nr)
                return true;

        return false;

    }

    public int CommonNumbersCount(int[] numbers, int[] numbers1) {
        int contor = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (contains(numbers[i], numbers1.length, numbers1)) {
                contor++;
            }
        }
        return contor;
    }

    public void showMenu() {
        System.out.println("LOTO GAME");
        System.out.println("\tPlease select your option:");
        System.out.println("\t\t1.Play 6/49");
        System.out.println("\t\t2.Play 5/40");
        System.out.println("\t\t3.Show last 3 options");
        System.out.println("\t\t4.Exit");
        System.out.print("Insert a number from 1 to 3:");
    }

    public void chooseOption() {
        int option = 0;
        // read an int from keyboard
        option = sc.nextInt();
        switch (option) {
            case 1:
                play(6, 49);
                break;
            case 2:
                play(5, 40);
                break;
            case 3:
                showResults();
                break;
            default:
                return;
        }
        System.out.println("Press 1 to go to menu or any other key to exit");
        if (sc.nextInt() == 1) {
            showMenu();
            chooseOption();

        }
    }

    private void play(int howMany, int from) {
        int[] NumbArray = new int[howMany];
        System.out.printf("Inserati %d numere naturale:\n", howMany);
        for (int i = 0; i < howMany; i++) {
            System.out.print(i + ":");
            NumbArray[i] = sc.nextInt();
        }
        int[] genNumb = genNumb(howMany, 0, from);
        System.out.println("The generated numbers are:");
        for (int j = 0; j < howMany; j++) {
            System.out.print(genNumb[j] + " ");
        }
        writeInFile(genNumb, howMany);
        int commonNumbersCount = CommonNumbersCount(genNumb, NumbArray);
        System.out.println("Your score:" + commonNumbersCount);
    }

    public static void main(String[] args) {
        Main l = new Main();
        l.showMenu();
        l.chooseOption();
    }

}