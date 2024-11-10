import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Main class that converts an input PNG image to its ASCII representation.
 * If no image is provided, it prompts the user for the file path.
 *
 * @author Shane Ruegg
 * @since 11/09/2024
 */
public class ImageToASCII {

    public static void main(String[] args) throws FileNotFoundException {

        BufferedImage file = null;
        if (args.length == 1) {
            try {
                if (args[0].endsWith(".png")) {
                    file = ImageIO.read(new File(args[0]));
                }
                else file = promptUser();
                convert(file);
                System.exit(0);
            } catch (IOException ignored) {}
        }
        file = promptUser();
        convert(file);
    }

    /**
     * Prompts the user for a valid PNG file path until a readable image is provided.
     * If the provided path is valid, it reads and returns the image.
     *
     * @return A BufferedImage object representing the image read from the valid file path.
     */
    public static BufferedImage promptUser() {
        BufferedImage file = null;
        Scanner input = new Scanner(System.in);
        while (file == null) {
            System.out.println("The file path provided was invalid or not provided.");
            System.out.print("Please enter a new png file path or type 'EXIT' to terminate: ");
            try {
                String path = input.nextLine();
                File imageFile = new File(path);
                if (path.equalsIgnoreCase("EXIT")) {
                    System.exit(0);
                }
                if (path.length() > 4 && path.endsWith(".png")) {
                    file = ImageIO.read(imageFile);
                }

            } catch (IOException ignored) {}
        }
        input.close();
        return file;
    }

    /**
     * Converts the specified image to an ASCII representation and creates a
     * new text file containing the result.
     *
     * @param file The image to be converted to ASCII.
     */
    public static void convert(BufferedImage file) throws FileNotFoundException {
        File asciiImage = new File( "(ASCII).txt");
        PrintWriter writer = new PrintWriter(asciiImage);
        for (int row = 0; row < file.getHeight(); row++) {
            for (int col = 0; col < file.getWidth(); col++) {
                Color pixel = new Color(file.getRGB(col,row));
                int brightness = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
                if (brightness > 230) writer.write(" ");
                else if (brightness > 205) writer.write(".");
                else if (brightness > 180) writer.write(":");
                else if (brightness > 155) writer.write("-");
                else if (brightness > 130) writer.write("=");
                else if (brightness > 105) writer.write("+");
                else if (brightness > 80) writer.write("*");
                else if (brightness > 55) writer.write("#");
                else if (brightness > 30) writer.write("%");
                else writer.write("@");
            }
            writer.write(String.format("%n"));
        }
        writer.close();
    }
}
