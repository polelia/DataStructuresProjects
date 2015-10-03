
package project1;

/**
 *creates an array of student objects and performs various methods on them.
 */
public class Collection {
    
    public Student[] array;   //reference to array
    private int numElem;     //number of elements in the array
    public int numBubble = 0;
    public int numSelect = 0;
    public int numInsert = 0;
    public int numLinearProbes = 0;
    public int numBinaryProbes = 0;
    public int max = 0;
    public int min = 0;
    public double avg = 0;
    public double median = 0;
    public boolean foundLinear = false;
    public boolean foundBinary = false;
    public boolean test = false;
    
    /**
    * constructor for arrays
     */       
    public Collection(int num)
    {
        array = new Student[num];
        numElem = 0;
    }
    /**
     * resets the number of elements in the array.
     */
    public void clear()
    {
       numElem = 0;
    }
   
    
    /**
     * @param st1 
     * adds the students to the array
     */
    public void add(Student st1)
    {
       array[numElem] = st1; 
       numElem++; //tracks number of elements in array
    }
   
 
    /**
     * @param searchVal
     * Searches the array using a binary search to determine whether the
     * data is in the file or not
     * @return foundBinary
     */
    public boolean binarySearch(String searchVal) {
        int index = -1; 
        int lower = 0; 
        int upper = numElem; 
        int current = 0; 
        numBinaryProbes = 0;
        
        while((lower <= upper) && (index == -1))
        {
            foundBinary = false;  
            current = (lower+upper)/2; 
            if(searchVal.compareToIgnoreCase(array[current].getFullName())== 0)  
            {
                index = current; 
                foundBinary = true;
            }
            else 
            { 
                if((array[current].getFullName().compareToIgnoreCase(searchVal)) < 0) { 
                    lower = current + 1;
                }
                else {
                    upper = current - 1;
                }
            }
          numBinaryProbes++;  //number of comparisons;
        }  
        return foundBinary;
    }
    
    /**
     * sorts the students array by their full name using the bubble sort
     */
    public void bubbleSort() 
    {
        boolean swapped = true;
        for (int y = 0; y < numElem && swapped; y++) 
        { 
            swapped = false;
            for (int x = 0; x < numElem - (y + 1); x++) {
                if (array[x].getFullName().compareToIgnoreCase(array[x+1].getFullName()) > 0) { 
                    swap(x, x + 1);
                    numBubble+=3; //counts the number of swaps
                    swapped = true;
                }
            }
        }
    }
    /**
     * @param pos1
     * @param pos2 
     * gives a place holder so no data gets lost when sorting
     */
    public void swap(int pos1, int pos2) {
        Student temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }
    /**
     * sorts the student array by their full name using the selection sort
     */
    public void selectionSort() 
    {
        int minim;
        for (int y = 0; y < numElem - 1; y++) { 
            minim = y; 
            for (int i = y + 1; i < numElem; i++) { 
                if (array[i].getFullName().compareToIgnoreCase(array[minim].getFullName()) < 0) 
                {
                    minim = i; 
                }
            }
            if (minim > y)
            {
            swap(y, minim); 
            numSelect+=3;  //count number of swaps
            }
        }
    }
    /**
     * sorts the student array by their full name using the insertion sort
     */
    public void insertionSort() {
        int i; 
        Student temp;
        for (int y = 1; y < numElem; y++)
        {
            temp = array[y];
            i = y;
            while (i > 0 && array[i-1].getFullName().compareToIgnoreCase(temp.getFullName())> 0)      
            {
                array[i] = array[i - 1];
                numInsert++;
                i--;
            }
            array[i] = temp; 
        }
    }

    
    /**
    * gets the average of the total points of the students
    * @return avg
    */
    public double getAverage() 
    {
        int sum = 0;
        for (int x = 0; x < numElem; x++) {
            sum += array[x].getPoints();
        }
        avg = (double)sum/numElem;
        return avg;
    }
    /**
    * the the largest number of points
    * @return max
    */
    public int getMax() {
        max = array[0].getPoints();
        for (int x = 0; x < numElem; x++) {
            if (array[x].getPoints() > max) {
                max = array[x].getPoints();
            }
        }
        return max;
    }
    /**
     * gets the minium number of total points of the students
     * @return min
     */
    public int getMin() 
    {
        min = array[0].getPoints();
        for (int x = 0; x < numElem; x++) 
        {
            if (array[x].getPoints() < min) 
            {
                min = array[x].getPoints();
            }
        }
        return min;
    }
    /**
    * gets the middle value of number of total points
    * @return median
    */
    public double getMedian() 
    {
       median = 0; // If our array's length is even, then we need to find the average of the two centered values
       if (numElem % 2 == 0)
       {
           int indexA = (numElem - 1) / 2;
           int indexB = numElem / 2;
           median = ((array[indexA].getPoints() + array[indexB].getPoints())) / 2;
       } // Else if our array's length is odd, then we simply find the value at the center index
       else
       {
           int index = numElem / 2;
           median = array[index].getPoints();
       }
       return median;
    }
    /**
     * sorts the array using the selection sort for the total points
     */
    public void sortArrays()
    {
         int min;
         for(int y = 0; y < numElem - 1; y++) { // Traverse array multiple times
             min = y; // Set minimum value pointer
             for(int x = y + 1; x < numElem; x++) { // Traverses the array
                 if(array[x].getPoints() < array[min].getPoints()) { // Compare two elements
                     min = x; // Update minimum value pointer
                 }
            }
            if(min > y) { // Only swap the elements if they are not in the same position
                swap(y, min); // Perform the swap once per traversal
            }
        }
    }
     
    /**
     * @param obj
     * searches the array using the linear search to determine
     * whether the data is there or not
     * @return foundLinear
     */
    public boolean linearSearch(String obj)
    {
        int index = -1; // Defaults to NOT FOUND condition
        numLinearProbes = 0;
       
        // Loop through the array until the value is found or end of array is reached
        for(int i = 0; i < numElem && index == -1; i++) { 
            if(array[i].getFullName().equals(obj)) { // Compare a value in the array to the search object
                index = i; // Set index variable to the array index with the value
                foundLinear = true;
            }
            else
            {
                foundLinear = false;
            }
            numLinearProbes++; //counts number of probes
        }
        return foundLinear;
    }

    /**
     * removes the object of students from the file
     * @return wrLine
     */
    public String remove()
    {
        String wrLine = null;
        for(int i = 0; i <= numElem; i++)
        {
            wrLine = array[i].toString();
            --numElem;
        }
        
        return wrLine;
    }

    /**
     * tests whether the their is still data or not
     * @return test
     */ 
    public boolean isEmpty(){
        if (numElem == 0)
            test = true;
        return test;
    }
        
    /**
     * displays the array and prints the values
     */
    public void display() {
        for(int i = 0;i < numElem;i++)
        {
            System.out.println(array[i]);
        }
    }
}
