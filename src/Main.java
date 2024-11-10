import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Main class that converts an input PNG image to its ASCII representation.
 * If no image is provided, it prompts the user for the file path.
 *
 * @author Shane Ruegg
 * @since 11/09/2024
 */
public class Main {

    public static void main(String[] args) {

        BufferedImage file = null;
        if (args.length == 1) {
            try {
                if (args[0].endsWith(".png"))
                    file = ImageIO.read(new File(args[0]));
                else file = promptUser();
                imageToASCII(file);
                System.exit(0);
            } catch (IOException ignored) {}
        }
        file = promptUser();
        imageToASCII(file);
    }

    /**
     * Prompts the user for a valid PNG file path until a readable image is provided.
     * If the provided path is valid, it reads and returns the image.
     *
     * @return A BufferedImage object representing the image read from the valid file path.
     */
    public static BufferedImage promptUser() {
        BufferedImage file = null;
        while (file == null) {
            Scanner input = new Scanner(System.in);
            System.out.println("The file path provided was invalid or not provided.");
            System.out.print("Please enter a new png file path or type 'EXIT' to terminate: ");
            try {
                String path = input.nextLine();
                if (path.equalsIgnoreCase("EXIT")) {
                    System.exit(0);
                }
                if (path.length() > 4 && path.endsWith(".png")) {
                    file = ImageIO.read(new File(path));
                } else continue;
            } catch (IOException ignored) {
                continue;
            }
            input.close();
        }
        return file;
    }

    /**
     * Converts the specified image to an ASCII representation and creates a
     * new text file containing the result.
     *
     * @param file The image to be converted to ASCII.
     */
    public static void imageToASCII(BufferedImage file) {

    }
}
