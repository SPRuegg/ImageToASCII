# Image to ASCII Converter
## Description
This Java application converts a PNG image to its ASCII representation. It reads an input PNG file, processes it, and generates a text file containing the ASCII art of the image. If no image file is provided through the command-line arguments, the program will prompt the user to input a valid file path. The output is saved as a text file named (ASCII).txt.

## Features
- PNG to ASCII Conversion: Converts a PNG image to ASCII art.
- File Input: Allows the user to provide an image path as a command-line argument or input it interactively.
- Output File: Saves the resulting ASCII art in a text file called (ASCII).txt.
- Interactive Mode: If no valid image path is provided, the program will repeatedly prompt the user until a valid PNG file is supplied.

## Requirements
- Java 8 or later: This project is built using Java and requires at least Java 8 to run.
- PNG Image: The image must be a PNG file, as other formats are not supported.

## How to Run

1. **Compile the Program**:
   Ensure you have the Java Development Kit (JDK) installed on your machine. To compile the program, run:
   
   ```bash
   javac ImageToASCII.java
   ```

2. **Run the Program**:
   If you want to convert the file immediately, then:
   
   ```bash
   java ImageToASCII "path_to_image.png"
   ```
   or, if you are unsure what file you'd like to convert, then:

   ```bash
   java ImageToASCII
   ```
3. **Output**:
   After the image is processed, the ASCII art will be saved in a file named (ASCII).txt in the same directory where the program is run.

## How it Works
1. The program takes in a valid file of png format.
2. It then calculates the brightness of each pixel, and determines which ASCII character to write it to
3. Out of 10 possible brightness ranges, it writes the ASCII image into a text file

## License
This project is licensed under the MIT License - see the LICENSE file for details.

## Author
Shane Ruegg
