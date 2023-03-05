// Nikul Jethalal Halai
// COP 3330 (Spring 2023)
// ni014425

public class Bonfire 
{
    // Returns true if the needle is found in the haystack after the index.
    public static boolean containsValueAfterIndex(int needle, int [] haystack, int index) 
    {
        // Returning false if the haystack is empty.
        if (haystack.length == 0) 
        {
            return false;
        }
        
        index++;
        // Checking if any of the values in the haystack are equal to the needle.
        while (index < haystack.length) 
        {
            if (index >= 0 && haystack[index] == needle) 
            {
                return true;
            }

            index++;
        }

        return false;
    }

    // Returns the third largest value in the array.
    public static int getThirdLargest(int [] array) 
    {
        // Returing the minimum value if the array is less than 3.
        if (array.length < 3) 
        {
            return Integer.MIN_VALUE;
        }

        // Setting the max values to null.
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;

        // Looping through the array.
        for (Integer n : array) 
        {
            if (max1 == null || n > max1) 
            {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } 
            else if (max2 == null || n > max2) 
            {
                max3 = max2;
                max2 = n;
            } 
            else if (max3 == null || n > max3) 
            {
                max3 = n;
            }
        }
        
        // Returning the third largest value.
        if (max3 == null) {
            return max1;
        } else {
            return max3;
        }
    }

    // Prints the third largest value in the array.
    public static void printThirdLargest(int [] array) 
    {
        // Returing the minimum value if the array is less than 3.
        if (array.length < 3) 
        {
            System.out.println(Integer.MIN_VALUE);
        }

        // Setting the max values to null.
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;

        // Looping through the array.
        for (Integer n : array) 
        {
            if (max1 == null || n > max1) 
            {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } 
            else if (max2 == null || n > max2) 
            {
                max3 = max2;
                max2 = n;
            } 
            else if (max3 == null || n > max3) 
            {
                max3 = n;
            }
        }

        // Returning the third largest value.
        System.out.println(max3 == null ? max1 : max3);
    }

    // Returns true if the array is a rotation of the other.
    public static boolean isRotation(int [] array1, int [] array2) 
    {   
        // Checking if the arrays are the same length.
        if(array1.length == array2.length) 
        {   
            // Looping through the arrays.
            for (int i = 0; i < array1.length; i++) 
            {   
                // Checking if the first value in the first array is equal to the first value in the second array.
                if (array1[i] == array2[0]) 
                {   
                    // Generating the next rotation.
                    int [] temp = generateNthRotation(array2, i);
                    
                    // Checking if the arrays are equal.
                    for (int j = 0; j < array1.length; j++) 
                    {
                        if (array1[j] != temp[j]) 
                        {
                            break;
                        } 
                        else if (j == array1.length - 1) 
                        {
                            return true;
                        }
                    }
                }
            }
        }

        // Returning true if the arrays are empty, and false otherwise.
        if (array1.length == 0 && array2.length == 0) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }

    // Returns the array rotated n times.
    public static int [] generateNthRotation(int [] array, int n) 
    {
        // Checking if n is negative.
        if (n < 0) 
        {
            n = array.length + n;
        }

        // Looping through the array n times to rotate the array.
        for (int i = 0; i < n; i++) 
        {
            int temp = array[array.length - 1];
            for (int j = array.length - 1; j > 0; j--) 
            {
                array[j] = array[j - 1];
            }
            array[0] = temp;
        }

        // Returning the rotated array.
        return array;
    }

    // Print the ribbin of width n.
    public static void printRibbon(int n, int width) 
    {
        // Printing the top of the ribbon.
        System.out.print("+");
        for (int i = 0; i < width; i++) 
        {
            System.out.print("-");
        }
        System.out.println("+");

        for (int line = 1; line < width + 1; line++) 
        {
            // Printing the left side of the ribbon.
            System.out.print("|");
            for (int i = 0; i < line - 1; i++) 
            {
                System.out.print(" ");
            }
            
            // Determining if the @ or o should be printed.
            Boolean printAt = true;
            Boolean printO = false;

            // Printing the middle of the ribbon.
            for (int i = 0, times = 0; i < width - (line - 2); i += n, times++) 
            {
                // Printing the @ if printAt is true, the o if printO is true, and a space if pattern is printed three times.
                if (printAt && times < 3) 
                {
                    for (int j = 0; j < n && j + i < width - (line - 1); j++) 
                    {
                        System.out.print("@");
                    }
                    printAt = false;
                    printO = true;
                } 
                else if (printO && times < 3) 
                {
                    for (int j = 0; j < n && j + i < width - (line - 1); j++) 
                    {
                        System.out.print("o");
                    }
                    printAt = true;
                    printO = false;
                } 
                else 
                {
                    for (int j = 0; j < n && j + i < width - (line - 1); j++) 
                    {
                        System.out.print(" ");
                    }
                }
            }
            // Printing the right side of the ribbon.
            System.out.println("|");
        }

        // Printing the bottom of the ribbon.
        System.out.print("+");
        for (int i = 0; i < width; i++) 
        {
            System.out.print("-");
        }
        System.out.println("+");
    }

    // Hours spent on the assignment.
    public static double hoursSpent() 
    {
        return 5.8;
    }
    // Difficulty rating of the assignment.
    public static double difficultyRating() 
    {
        return 3.2;
    }
}
