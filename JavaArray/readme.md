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

Let me know if you need more details or examples!