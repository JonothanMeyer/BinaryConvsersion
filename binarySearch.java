
/**
 * Jonothan Meyer
 * Done in class regarding binary search
 *
 *
 * This is about recursion for a binary search
 */
public class binarySearch
{
  int[] data = new int[5];
 public boolean binSearch (int key) {
     return binSearch (0, data.length-1, key);
    }
 private boolean binSearch (int key, int low, int high) { //helper method
     //base case #1
     if (low>high) {
         return false; //notfound
        }
     int mid = low + (high-low)/2;
     if (data[mid] == key) {
         return true;
        }
        
}
// version 2: return data object
//assume instance arry named data
public Student binSearch (int key) {
    return binSearch (key, 0, data.length-1);
}
private Student binSearch (int key, int low, int high) { //helper method
       //base case #1
       if (low>high) {
           return null; // not found 
        }
        int mid = (low+high)/2;
        if (data[mid].getStudentID == key) { //assuming we already have a method named .getStudentID to retrive the int value from the object "Student"
            return findClump(key);
            //return data[mid];
        }
        // not found, continue
        if (key < data[mid]) {
            return binSearch(key, low, mid-1);
        }
        return binSearch(key, mid+1, high);
    }
}
