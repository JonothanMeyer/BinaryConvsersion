
/**
 * Jonothan Meyer
 * Computer Science II, MW 2-4pm
 * 
 *
 * Bianary Conversion: This program takes input of a binary number from a .txt file, checks the length of the input to see that it is 8 characters long,
 * converts those numbers to digits and displays that to the user.
 */
import java.util.Scanner;   // ArrayList,
import java.io.*;
public class Binary1
{
 String keepGoing = "y";
 Scanner input = new Scanner(System.in);
 String[] textComingIn = new String[2];
 String userInput;
 public String userInput()
 {
  //do
  System.out.println("Please enter a binary number (8 characters long) that you would like to convert to binary. (");
  String user = input.next();
  // } while (keepGoing.equalsIgnoreCase("y") || keepGoing.equalsIgnoreCase("yes"));
   return userInput; 
    }
 public String[] readFile()
 {
  //this method will take a .txt file name as a parameter, and run it through this program.
  int i = 0;
  String line;
  boolean found = false;
  String textFile;
  System.out.println("Enter the filename you would like to convert from binary to digits.");
  while (found == false) {
  try {

      Scanner fileIn = new Scanner(new FileReader(input.nextLine()));
      while (fileIn.hasNextLine())
      {
      textComingIn[i] = fileIn.nextLine();
      i++;
      //System.out.println(line); (debugging)
    }

    found = true;
    fileIn.close();
     }
  catch (FileNotFoundException e)
  {
      System.out.println("File was not found. Please enter a valid file name.");
    }
}  
  return textComingIn;  
}
 public void printtextComingIn(String[] textComingIn)
 {
  //prints the text recieved from the file to the user.
  System.out.println("Here is what was found in that text file:");
  for (int i=0; i<textComingIn.length; i++)
  {
    System.out.println(textComingIn[i]);
    }
     
    }
 public int toDecimal(String[] dotTextFile, int i)
 {
        int sum = 0;
        int other;
        for(i = length-1; i <= 0; i--){
            other = (int)Math.pow(2, i);
            if(dotTextFile.charAt(i) == '1')
                sum= sum + other;
        }
     return sum;
    }
 public int changeToInt(String textFile)
 {
  //this method will convert a single String from the userto an int
  int intText = 0; 
  return intText;   }
 public String checkEight(String userInput)
 {
 //this method will check the length of the input from the parameter textfile, it will return true if the text is 8 characters long
 String checkEight = "Invalid";
 int eight = userInput.length();
 if (eight == 7) {
 userInput = "Valid";
}
 return userInput;   
}
 public String[] checkEight(String[] dotTextFile)
 {
  //this method checks the length of each index in the array from the text file, creates a new array with "valid" stored in the corresponding index
  //spot as the paramater array if the length is 8 characters, otherwise it puts "Invalid" in that spot if it has less or more.
  String[] checkEightFile = new String[15];
  String eight;
  for (int i=0;i<dotTextFile.length;i++){
      eight = dotTextFile[i];
      int isEight = eight.length();
       if (isEight == 8){
           dotTextFile[i] = "Valid";
        }
       else
           dotTextFile[i] = "Invalid";
    }
  for (int i=0;i<dotTextFile.length;i++){System.out.println(dotTextFile[i]);}
  return checkEightFile;
    }
 public int[] getDigitValue(String[] textComingIn)
 {
 //this method runs if the checkEight return value comes back true. it converts the binary value into digit value and thats what it returns.

 
 int[] digitValues = new int[textComingIn.length];
 for (int i = 0; i<textComingIn.length; i++) {
  digitValues[i] =  toDecimal(textComingIn, i);
  
    }
 return digitValues;   }
 public void printDigitValues(int[] binaryValues)
 {
 // this method gives a print out of all the bianary values
 for (int i=0;i<binaryValues.length;i++) 
        {
            System.out.println(binaryValues[i]);
    }
}
 private int digitAtSeven(String[] textComingIn, int i) 
 { 
  //helper method for converting the last binary value in the binary string to its digit
  char seven = textComingIn[i].charAt(7);
  int digitAtSeven = 0;
  if (seven == '1') digitAtSeven = 1;
 return digitAtSeven;
}
 private int digitAtSix(String[] textComingIn, int i) 
 { 
  //helper method for converting the last binary value in the binary string to its digit   
  int digitAtSix = 0;
  if (textComingIn[i].charAt(6) == '1') digitAtSix = 2;
 return digitAtSix;
}
 private int digitAtFive(String[] textComingIn, int i) 
 { 
  //helper method for converting the last binary value in the binary string to its digit   
  int digitAtFive = 0;
  char five = textComingIn[i].charAt(5);
  if (five == '1') digitAtFive = 4;
 return digitAtFive;
}
 private int digitAtFour(String[] textComingIn, int i) 
 { 
  //helper method for converting the last binary value in the binary string to its digit   
  int digitAtFour = 0;
  String four = textComingIn[i];
  char fourok = four.charAt(4);
  if (fourok == '1') digitAtFour = 8;
 return digitAtFour;
}
 private int digitAtThree(String[] textComingIn, int i) 
 { 
  //helper method for converting the last binary value in the binary string to its digit  
  int digitAtThree = 0;
  char three = textComingIn[i].charAt(3);
  if (three == '1') digitAtThree = 16;
 return digitAtThree;
}
 private int digitAtTwo(String[] textComingIn, int i) 
 { 
  //helper method for converting the last binary value in the binary string to its digit
  int digitAtTwo = 0;
  char two = textComingIn[i].charAt(2);
  if (two == '1') digitAtTwo = 32;
 return digitAtTwo;
}
 private int digitAtOne(String[] textComingIn, int i) 
 { 
  //helper method for converting the last binary value in the binary string to its digit   
  int digitAtOne = 0;
  char one = textComingIn[i].charAt(1);
  if (one == '1') digitAtOne = 64;
 return digitAtOne;
}
 private int digitAtZero(String[] textComingIn, int i) 
 { 
  //helper method for converting the last binary value in the binary string to its digit   
  int digitAtZero = 0;
  char zero = textComingIn[i].charAt(0);
  if (zero == '1') digitAtZero = 128;
 return digitAtZero;
}
private int sum(String[] textComingIn, int i)
{

  int sum = 0;
  sum += digitAtZero(textComingIn,i);
  sum += digitAtOne(textComingIn,i);
  sum += digitAtTwo(textComingIn,i);
  sum += digitAtThree(textComingIn,i);
  sum += digitAtFour(textComingIn,i);
  sum += digitAtFive(textComingIn,i);
  sum += digitAtSix(textComingIn,i);
  sum += digitAtSeven(textComingIn,i);
  return sum;
}
 /*public int sum(String[] textComingIn, int i)
 {
  int sum = 0;
  for (i=0;i<textComingIn.length;i++)
  {
  sum = textdigitAtZero + digitAtOne + digitAtTwo + digitAtThree + digitAtFour + digitAtFive + digitAtSix + digitAtSeven;
    }
  
  return sum;
    }*/

 public void output(int text, boolean checkEight, int digitValue)
 {
 //this method will be what the user sees after the program has ran, displaying the binary number, if it is 8 characters long, and if so, it's digit value.  
    }
 public static void main(String[] args)
 {
      Scanner input = new Scanner(System.in);
      Binary testReadFile = new Binary();
      String[] textComingIn = new String[50];
      textComingIn = testReadFile.readFile();
      testReadFile.printtextComingIn(textComingIn);
      testReadFile.checkEight(textComingIn);
      //String user = testReadFile.userInput();
      //testReadFile.checkEight(user);
      int[] binaryValues = new int[15];
      binaryValues = testReadFile.getDigitValue(textComingIn);
      testReadFile.printDigitValues(binaryValues);
      

    }
     
 
 
}
