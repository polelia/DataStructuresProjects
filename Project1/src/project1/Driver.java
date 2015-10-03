
package project1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Creates collection array objects
 * Executes different sorting and searching operations
 * Displays output
 */
public class Driver {

    DecimalFormat frm = new DecimalFormat("0.##");
    public Collection array = new Collection(15);
    public Collection array2 = new Collection(50);
    public String[] searchArray = new String[15];

    /**
     * reads the provided files in, then uses the methods from the collection
     * class to output all the final data.
     */
    public void execute() {
        //2.a section
        readFile("Contest.Input.A.txt");
        array.bubbleSort();
        array.clear();

        readFile("Contest.Input.A.txt");
        array.selectionSort();
        array.clear();

        readFile("Contest.Input.A.txt");
        array.insertionSort();

        //2.b section
        readFile2("Contest.Input.A.txt");
        readFile2("Contest.Input.B.txt");
        readFile2("Contest.Input.C.txt");

        array2.sortArrays();
        array2.getMin();
        array2.getMax();
        array2.getAverage();
        array2.getMedian();

        //2.c section
        readFile3("Contest.Search.txt");
        array2.selectionSort();
        output();
        writeFile("Contest.Output.txt");
    }

    /**
     * @param inputFile Reads the txt file into the program. Instantiates each
     * line of the txt file as a Student object Closes the txt file
     */
    public void readFile(String inputFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            br.readLine();
            String line = null;
            while ((line = br.readLine()) != null) {
                array.add(new Student(line));  //creates a new student initialized with currentLine 
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.format("File Not Found Exception\n");
        } catch (IOException e) {
            System.err.format("IO Exception\n");
        } catch (Exception e) {
            System.err.format("Exception\n");
        }
    }

    /**
     *
     * @param inputFile Reads the txt file into the program. Instantiates each
     * line of the txt file as a Student object. Closes the txt file
     */
    public void readFile2(String inputFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            br.readLine();
            String line = null;
            while ((line = br.readLine()) != null) {
                array2.add(new Student(line));  //creates a new student initialized with currentLine 
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.format("File Not Found Exception\n");
        } catch (IOException e) {
            System.err.format("IO Exception\n");
        } catch (Exception e) {
            System.err.format("Exception\n");
        }
    }

    /**
     *
     * @param inputFile Reads the txt file into the program. Instantiates each
     * line of the txt file as a Student object. Closes the txt file
     */
    public void readFile3(String inputFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line = null;
            for (int i = 0; i < searchArray.length; i++) {
                line = br.readLine(); //assigns the read line to currentLine
                searchArray[i] = line;  //creates a new student initialized with currentLine 
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.format("File Not Found Exception\n");
        } catch (IOException e) {
            System.err.format("IO Exception\n");
        } catch (Exception e) {
            System.err.format("Exception\n");
        }
    }

    /**
     *
     * @param outputFileName Writes the contents of the students[] array to a
     * file. Closes the file
     */
    public void writeFile(String outputFileName) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName));

            while (!array2.isEmpty()) {
                bw.write(array2.remove());
                bw.newLine();
            }
            bw.close();

        } catch (IOException ex) {
            System.err.format("File Cannot Be Written");
        }
    }

    /**
     * Prints out all the data and formats it accordingly to display the final
     * product.
     */
    public void output() {
        System.out.println("Sort Algorithm Report:");
        System.out.format("The Bubble Sort algorithm required %d copies\n", array.numBubble);
        System.out.format("The Selection Sort algorithm required %d copies\n", array.numSelect);
        System.out.format("The Insertion Sort algorithm required %d copies\n\n", array.numInsert);

        System.out.println(String.format("%-20s %-8s %-8s %-8s %-8s", "Student Name", "Position", "Attempted", "Completed", "Total Points"));
        System.out.println(String.format("%-20s %-8s %-8s %-8s", "------------", "------------------", "---------", "------------"));

        array.display();
        System.out.println("");
        System.out.println("Statistics Report:");
        System.out.format("The maximum points earned was %d\n", array2.max);
        System.out.format("The minimum points earned was %d\n", array2.min);
        System.out.format("The average points earned was %s\n", frm.format(array2.avg));
        System.out.format("The median points earned was %s\n\n", frm.format(array2.median));

        System.out.println("Linear Search Results:");
        System.out.println(String.format("%-20s %-8s %-8s %-8s", "Search String", "Found", "Not Found", " # Probes"));
        System.out.println(String.format("%-20s %-8s %-8s %-8s", "-------------", "-----", "---------", "--------"));
        
        //Performs linear search algorithm and displays its results
        for (int i = 0; i < searchArray.length; i++) {
            array2.linearSearch(searchArray[i]);
            if (array2.foundLinear) {
                System.out.println(String.format("%-20s %5s %8s %12s", (searchArray[i]), "X", " ", array2.numLinearProbes));
            } else {
                System.out.println(String.format("%-20s %5s %8s %12s", (searchArray[i]), " ", "X", " "));
            }
        }
        System.out.println("");
        
        System.out.println("Binary Search Results:");
        System.out.println(String.format("%-20s %-8s %-8s %-8s", "Search String", "Found", "Not Found", " # Probes"));
        System.out.println(String.format("%-20s %-8s %-8s %-8s", "-------------", "-----", "---------", "---------"));
        
        //Performs binary search algorithm and displays its results
        for (int i = 0; i < searchArray.length; i++) {
            array2.binarySearch(searchArray[i]);
            if (array2.foundBinary) {
                System.out.println(String.format("%-20s %5s %8s %12s", (searchArray[i]), "X", " ", array2.numBinaryProbes));
            } else {
                System.out.println(String.format("%-20s %5s %8s %6s", (searchArray[i]), " ", "X", " "));
            }
        }
    }
}