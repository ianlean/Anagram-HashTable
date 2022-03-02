import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) throws FileNotFoundException {

        HashTable hashy = readFile();
        //System.out.println(hashy.getTable()[9073]);
        readFile2(hashy);
    }

    public static HashTable readFile() throws FileNotFoundException {
        int amount = 0;
        File wordFile = new File("src/words.txt");
        HashTable hashy = new HashTable();
        Scanner scan = new Scanner(wordFile);

        while(scan.hasNextLine()) {
            hashy.add(scan.nextLine());
            amount++;
        }
//        System.out.println(hashy.amount);
//        System.out.println(hashy);
        return hashy;
    }

    public static void readFile2(HashTable hashy) throws FileNotFoundException {
        File inputFile = new File("src/input.txt");
        Scanner scan = new Scanner(inputFile);
        int index;
        String s;
        while(scan.hasNextLine()) {
            s = scan.nextLine();
            index = hashy.search(s);
            System.out.print(s + " ");
            System.out.println(hashy.getTable()[index] + "\n");
        }
    }
}
