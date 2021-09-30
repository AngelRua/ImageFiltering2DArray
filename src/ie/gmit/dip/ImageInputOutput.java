package ie.gmit.dip;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class ImageInputOutput {

	private static Scanner s = new Scanner(System.in);

	private static final String DIRECTORY = "./resources"; // References resources folder in the project directory

	// Default value for Kernel
	public static Kernel kernel;

	public static void readImage(BufferedImage inputImage, Kernel filter) throws IOException {// References the image and
																																														// the default kernel
		kernel = filter;
		writeImage(inputImage);
	}

	// Method to get the file as String input from user

	public static File getFile(String userPath) throws Exception {
		File f = new File(userPath);

		if (f.exists()) {
			return f;
		} else {
			System.out.println(ConsoleColour.RED_BOLD_BRIGHT);
			throw new Exception("Invalid File Name...!");

		}
	}

	// Method to prompt user to specify the file that wants to load

	public static String loadImage() throws Exception {// It works
		System.out.println(ConsoleColour.GREEN_BRIGHT);
		System.out.print("Enter Full Path to Image File: ");
		System.out.println(ConsoleColour.WHITE);
		String userPath = s.nextLine();
		System.out.println(ConsoleColour.RESET);
		File f = getFile(userPath);
		BufferedImage image = ImageIO.read(f);

		// System.out.println(image); // This writes out a lot of useful meta-data about
		// the image.

		System.out.println(ConsoleColour.YELLOW);
		System.out.println("Image Loaded Successfully! ");
		System.out.println(ConsoleColour.RESET);
		return userPath;

	}

	public static BufferedImage applyFilter(BufferedImage image) throws IOException {

		BufferedImage output = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

		int width = image.getWidth();
		int height = image.getHeight();

		for (int y = 0; y < height; y++) { // Loop over the 2D image pixel-by-pixel
			for (int x = 0; x < width; x++) {
				// int pixel = image.getRGB(x, y); // Get the pixel at an (x, y) coordinate

				image.setRGB(x, y, 0); // Set the pixel colour at (x, y)

				int r = 0, g = 0, b = 0;// for kernel

				for (int row = 0; row < ImageFilter.kernel.getKernel().length; row++) {
					for (int col = 0; col < ImageFilter.kernel.getKernel()[row].length; col++) {

						try {

							// We get the colors for the image and then multiply them with the selected
							// kernel taking into account cols and rows
							Color color = new Color(image.getRGB(x + col, y + row));

							r += color.getRed() * ImageFilter.kernel.getKernel()[col][row];
							b += color.getBlue() * ImageFilter.kernel.getKernel()[col][row];
							g += color.getGreen() * ImageFilter.kernel.getKernel()[col][row];
						} catch (Exception e) {
						}

					}
				}

				r = Math.min(255, Math.max(0, r));
				g = Math.min(255, Math.max(0, g));
				b = Math.min(255, Math.max(0, b));
				Color color = new Color(r, g, b);
				output.setRGB(x, y, color.getRGB());

			} // CLOSING THE SECOND LOOP
		} // CLOSING THE FIRST LOOP
		System.out.println(ConsoleColour.YELLOW);
		System.out.println("Working Some Magic...Please Wait.");
		System.out.println(ConsoleColour.RESET);
		return output;

	}// END OF applyFilter

	// Writing the output image

	private static void writeImage(BufferedImage inputImage) throws IOException {
		String finalImage = saveFile() + ".png";
		BufferedImage outputImage = applyFilter(inputImage);
		try {
			ImageIO.write(outputImage, "png", new File(DIRECTORY + "/" + finalImage));
		} catch (FileNotFoundException e) {
			System.out.println(ConsoleColour.RED_BOLD_BRIGHT);
			System.out.println("OOPSSS!!! Something Went Wrong...\nSaving as Default.");
			System.out.println(ConsoleColour.RESET);
			ImageIO.write(outputImage, "png", new File("output.png"));
		}
	}// END OF writeImage

	// Method to ask user to choose name for output file

	private static String saveFile() throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		System.out.println(ConsoleColour.GREEN_BRIGHT);
		System.out.println("\nChoose File Name for Output:");
		System.out.println(ConsoleColour.RESET);
		String savedImage = scan.nextLine().trim();
		System.out.println(ConsoleColour.WHITE_BRIGHT);
		System.out.println("\nImage saved as " + savedImage + ".png");
		System.out.println(ConsoleColour.RESET);
		return savedImage;
	}// END OF saveFile

}// END OF CLASS
