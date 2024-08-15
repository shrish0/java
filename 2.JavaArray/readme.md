In Java, an array is a container object that holds a fixed number of values of a single type. The length of an array is established when the array is created. After creation, its length is fixed.

### Declaring an Array

```java
// Declare an array of integers
int[] numbers;

// Declare an array of strings
String[] names;
```

### Initializing an Array

```java
// Initialize an array of integers with values
int[] numbers = {1, 2, 3, 4, 5};

// Initialize an array of strings with a fixed size
String[] names = new String[3];
names[0] = "Alice";
names[1] = "Bob";
names[2] = "Charlie";
```

### Accessing Array Elements

You can access elements in an array by using the index, starting from `0`:

```java
int firstNumber = numbers[0];  // Access the first element, which is 1
String firstName = names[0];   // Access the first element, which is "Alice"
```

### Iterating Over an Array

You can iterate over an array using a `for` loop or an enhanced `for` loop:

```java
// Using a for loop
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}

// Using an enhanced for loop
for (String name : names) {
    System.out.println(name);
}
```

### Common Array Operations

- **Finding the length of an array**:
  ```java
  int length = numbers.length; // The length of the array
  ```

- **Copying an array**:
  ```java
  int[] copy = Arrays.copyOf(numbers, numbers.length);
  ```

- **Sorting an array**:
  ```java
  Arrays.sort(numbers);
  ```

### Multi-Dimensional Arrays

Java supports multi-dimensional arrays (arrays of arrays):

```java
// Declaring and initializing a 2D array
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// Accessing elements in a 2D array
int value = matrix[1][2];  // Accesses the element at row 1, column 2 (value is 6)

// Iterating over a 2D array
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
```

---

### Merge sorted array in one array
The `MergeSortedArrayInSingleArray` class provides a method to merge two sorted arrays into one sorted array within the first array.

### **Explanation**:

1. **Initialization**:
   - `p` is initialized to the index of the last element of the initialized part of `nums1`.
   - `q` is initialized to the index of the last element of `nums2`.
   - `index` is set to the last position in `nums1`, which is the end of the array where the merged elements will be placed.

2. **Merging**:
   - The algorithm compares the elements at `p` and `q`. It places the larger of the two elements at the current `index` in `nums1`.
   - The corresponding pointer (`p` or `q`) and `index` are decremented.

3. **Copy Remaining Elements**:
   - If there are any remaining elements in `nums2` after `nums1` has been processed, they are copied to `nums1`.

This approach efficiently merges the arrays in place with a time complexity of O(m + n) and a space complexity of O(1), utilizing the extra space available at the end of `nums1`.

--- 

### Remove Element

**Single Pointer Approach**: Use a pointer `k` to track the position where the next non-`val` element should be placed.

1. **Iterate Through the Array**: Loop through each element in the array `nums`.

2. **Overwrite and Increment**: If the current element is not equal to `val`, place it at the `k`th position and increment `k`.

3. **Return Result**: After the loop, return `k`, which represents the number of elements in the array that are not equal to `val`.

This approach is simple, efficient (O(n) time complexity), and handles all edge cases effectively.


**Two-Pointer Approach**: Use two pointers, `start` (beginning of the array) and `last` (end of the array).

1. **Iterate with Conditions**: 
   - If `nums[start]` equals `val`, swap it with `nums[last]` and decrement `last`.
   - If `nums[start]` is not equal to `val`, simply move the `start` pointer forward.

2. **Continue Until Start Meets Last**: The loop continues until `start` exceeds `last`, ensuring all occurrences of `val` are removed.

3. **Return the Start Index**: The `start` index will represent the number of elements not equal to `val`.

This approach is efficient, potentially more so when many elements equal to `val` are present, but it involves more complex logic with swapping elements which cause more time in m/y access during swapping effect performance in term of m/y not in speed.

---
Here's an explanation for removing duplicates in both sorted and unsorted arrays, highlighting the optimal approaches for each scenario.

### **1. Removing Duplicates from a Sorted Array**

**Approach**: Two-Pointer Technique

When the array is sorted, duplicates will always appear consecutively. The two-pointer technique leverages this property to efficiently remove duplicates in-place.

**Steps**:
1. **Initial Check**: 
   - If the array is empty (`length == 0`), return 0 since there are no elements to process.

2. **Two-Pointer Technique**:
   - Use two pointers:
     - `k` to track the position where the next unique element should be placed.
     - `x` to iterate through the array.
   - Start iterating from the second element (`x = 1`).
   - Compare each element with the previous one:
     - If they are different, place the current element at the `k`-th position and increment `k`.
   
3. **Return the Result**:
   - The value of `k` represents the count of unique elements in the array.

**Time Complexity**: O(n)  
**Space Complexity**: O(1)

**Code**:

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int l1 = nums.length;
        if (l1 == 0) {
            return 0;
        }
        int k = 1; // Pointer for the position of unique elements
        for (int x = 1; x < l1; x++) {
            if (nums[x - 1] != nums[x]) {
                nums[k] = nums[x];
                k++;
            }
        }
        return k; // Return the count of unique elements
    }
}
```

### **2. Removing Duplicates from an Unsorted Array**

**Approach**: HashSet or Sorting + Two-Pointer Technique

When the array is unsorted, duplicates are scattered throughout the array. The most efficient ways to remove duplicates are either by using a `HashSet` or by sorting the array first and then applying the two-pointer technique.

#### **A. Using a HashSet**

A `HashSet` can be used to track elements as you iterate through the array. If an element is not in the set, it is unique and should be added to the set and the result.

**Steps**:
1. **Initialize a HashSet**:
   - This set will store all unique elements.

2. **Iterate through the Array**:
   - For each element, check if it is in the set.
   - If it’s not in the set, add it to the set and move it to the position tracked by `k`.

3. **Return the Result**:
   - The value of `k` represents the count of unique elements in the array.

**Time Complexity**: O(n)  
**Space Complexity**: O(n) (for storing unique elements)

**Code**:

```java
import java.util.HashSet;

class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int k = 0; // Pointer for the position of unique elements
        
        for (int num : nums) {
            if (set.add(num)) { // add returns false if the element already exists
                nums[k++] = num;
            }
        }
        return k; // Number of unique elements
    }
}
```

#### **B. Sorting + Two-Pointer Technique**

Alternatively, you can first sort the array and then apply the two-pointer technique, as explained in the sorted array approach.

**Steps**:
1. **Sort the Array**: 
   - Sorting will bring all duplicates together.

2. **Apply the Two-Pointer Technique**:
   - Once sorted, follow the same two-pointer approach as described for sorted arrays.

**Time Complexity**: O(n log n) (due to sorting)  
**Space Complexity**: O(1) (if sorting is done in-place)

**Code**:

```java
import java.util.Arrays;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        // Sort the array
        Arrays.sort(nums);
        
        int k = 1; // Pointer for the position of unique elements
        
        for (int x = 1; x < nums.length; x++) {
            if (nums[x - 1] != nums[x]) {
                nums[k++] = nums[x];
            }
        }
        
        return k; // Number of unique elements
    }
}
```

### **Summary**

- **For Sorted Arrays**: The two-pointer technique is optimal with O(n) time complexity and O(1) space complexity.
- **For Unsorted Arrays**: 
  - **HashSet** is preferred for O(n) time complexity and O(n) space complexity.
  - **Sorting + Two-Pointer** is a good alternative when you need to minimize space usage, but it comes with a higher time complexity of O(n log n). 

Choose the method that best fits your requirements, whether it's minimal space usage, optimal time complexity, or simplicity of implementation.

The provided code defines a class `RemoveDuplicateElementCond` with a method `removeDuplicateElementCond` that removes duplicates from a sorted array such that each element appears at most twice. It maintains the relative order of the elements and returns the new length of the array after duplicates are removed. Here’s a detailed explanation:

---

### Remove Duplicate Element Condition where thier can be only atmost two unique element

1. **Method Definition**:
   ```java
   public int removeDuplicateElementCond(int[] nums) {
   ```
   The method `removeDuplicateElementCond` takes a sorted array `nums` as input.

2. **Edge Case Handling**:
   ```java
   if (nums.length == 0) {
       return 0;
   }
   ```
   If the array is empty (`nums.length == 0`), the method returns `0` since there are no elements to process.

3. **Initialization**:
   ```java
   int k = 0;
   ```
   `k` is initialized to `0`. This variable tracks the position where the next unique element should be placed in the array.

4. **Processing Each Element**:
   ```java
   for (int x = 0; x < nums.length; x++) {
       if (k < 2 || nums[x] != nums[k - 2]) {
           nums[k] = nums[x];
           k++;
       }
   }
   ```
   - The loop iterates over each element of the array.
   - **Condition Check**: The condition `k < 2 || nums[x] != nums[k - 2]` ensures that:
     - For the first two elements (`k < 2`), they are always added to the result.
     - For subsequent elements, only add them if they are not the same as the element two positions before (`nums[x] != nums[k - 2]`). This ensures that each element appears at most twice in the resulting array.
   - If the condition is true, the current element `nums[x]` is placed at `nums[k]`, and `k` is incremented.

5. **Returning the Result**:
   ```java
   return k;
   ```
   The method returns `k`, which represents the length of the array with each unique element appearing at most twice.

6. **Main Method**:
   ```java
   public static void main(String[] args) {
       RemoveDuplicateElementCond rm = new RemoveDuplicateElementCond();
       int nums[] = {1, 2, 2, 2, 4, 6, 6, 7, 7, 7, 32, 345};
       int k = rm.removeDuplicateElementCond(nums);
       System.out.println();
       for (int x = 0; x < k; x++) {
           System.out.print(nums[x] + "  ");
       }
   }
   ```
   - Creates an instance of `RemoveDuplicateElementCond`.
   - Defines an example sorted array `nums` with some duplicate elements.
   - Calls `removeDuplicateElementCond` to process the array.
   - Prints the elements of the modified array up to index `k`, which are the unique elements appearing at most twice.

### Summary

- **Purpose**: The method removes duplicates from a sorted array, ensuring that each element appears at most twice.
- **Time Complexity**: `O(n)`, where `n` is the number of elements in the array. Each element is processed once.
- **Space Complexity**: `O(1)`, as the algorithm modifies the array in place without using additional space.

This approach effectively ensures that the array will contain each unique element at most twice, with the relative order preserved.

---
Here’s both the initial **in-place reversal approach** (the efficient solution) and the **extra array approach** (less efficient but easier to understand) along with explanations and a driver code to run them.

### 1. **Efficient In-Place Reversal Approach**

**Code:**

```java
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len; // Handle cases where k is greater than the length of the array
        
        // Step 1: Reverse the entire array
        reverse(nums, 0, len - 1);
        
        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);
        
        // Step 3: Reverse the remaining n-k elements
        reverse(nums, k, len - 1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
```

**Explanation:**
- **reverse(nums, start, end):** A helper method that reverses the subarray between `start` and `end`.
- The `rotate` method first adjusts `k` to be within the bounds of the array length. Then it reverses the entire array, followed by reversing the first `k` elements and then the remaining `n-k` elements to achieve the rotation in-place with `O(1)` extra space.

### 2. **Less Efficient Extra Array Approach**

**Code:**

```java
class SolutionExtraArray {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len; // Handle cases where k is greater than the length of the array
        
        if (k == 0) {
            return;
        }

        int[] nums2 = new int[len];
        for (int x = 0; x < len; x++) {
            nums2[(x + k) % len] = nums[x]; // Place elements in their new positions
        }

        // Copy the elements from nums2 back into nums
        for (int x = 0; x < len; x++) {
            nums[x] = nums2[x];
        }
    }
}
```

**Explanation:**
- This method creates a new array `nums2` and places each element of `nums` into its rotated position. After populating `nums2`, the elements are copied back into `nums` to reflect the rotation.

### 3. **Driver Code to Run Both Solutions**

**Code:**

```java
public class RotateArrayTest {
    public static void main(String[] args) {
        // Test input
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        
        // Creating solution objects
        Solution inPlaceSolution = new Solution();
        SolutionExtraArray extraArraySolution = new SolutionExtraArray();
        
        // Running the efficient in-place solution
        System.out.println("Efficient In-Place Solution:");
        System.out.print("Before rotation: ");
        printArray(nums1);
        inPlaceSolution.rotate(nums1, k1);
        System.out.print("After rotation: ");
        printArray(nums1);
        
        // Running the extra array solution
        System.out.println("\nLess Efficient Extra Array Solution:");
        System.out.print("Before rotation: ");
        printArray(nums2);
        extraArraySolution.rotate(nums2, k2);
        System.out.print("After rotation: ");
        printArray(nums2);
    }
    
    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
```

### Explanation of the Driver Code:
- **Test Input:** We use two different arrays and rotation values (`k`) to test both approaches.
- **Solution Objects:** We create instances of `Solution` (the efficient in-place solution) and `SolutionExtraArray` (the less efficient extra array solution).
- **Running Solutions:** We first print the array before rotation, apply the rotation using one of the solutions, and then print the array after rotation.
- **printArray Method:** A helper method to print the contents of the array.

### Output:
When you run the driver code, you should see the following output:

```
Efficient In-Place Solution:
Before rotation: 1 2 3 4 5 6 7 
After rotation: 5 6 7 1 2 3 4 

Less Efficient Extra Array Solution:
Before rotation: -1 -100 3 99 
After rotation: 3 99 -1 -100 
```

This output confirms that both solutions correctly rotate the arrays as expected.