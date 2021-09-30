package ie.gmit.dip;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;

import javax.imageio.ImageIO;

public class Menu {

	private Scanner s;
	private boolean keepRunning = true;

	ImageFilter imgfil2 = new ImageFilter();

	// Default value for Kernel, can be accessed by user to change.
	public static Kernel kernel;

	// Setting of the Enums.
	public static EnumSet<Kernel> selection = EnumSet.allOf(Kernel.class);

	public Menu() {
		s = new Scanner(System.in);
	}

	public void start() throws Exception {// code adapted from Week 9: March 29th - April 4th. Creating a Student Manager
																				// App
		while (keepRunning) {
			showOptions();
			int input = Integer.parseInt(s.next());// this is a block method
			switch (input) {
				case 1 -> getImage();
				case 2 -> showFilters();
				case 3 -> selectFilters();
				case 4 -> {
					System.out.println(ConsoleColour.RED_BOLD_BRIGHT);
					System.out.println("[INFO] Shutting down...please wait...");
					System.out.println(ConsoleColour.RESET);
					keepRunning = false;
				}
				default -> {// if user inputs a number other than 0-4, it will ask again
					System.out.println(ConsoleColour.RED_BOLD_BRIGHT);
					System.out.println("[ERROR] Invalid Input. Try again.");
					System.out.println(ConsoleColour.RESET);
				}

			}
		}

	}

	private void getImage() throws Exception {// It works, we get the image with the default filter
		try {
			BufferedImage inputImage = ImageIO.read(new File(ImageInputOutput.loadImage())); // we get the
																																												// file
			ImageInputOutput.readImage(inputImage, kernel);// Reference the file and the default filter
		} catch (Exception e) {
			System.out.println(ConsoleColour.RED_BOLD_BRIGHT);
			System.out.println("Invalid file name!. Please Try Again");// if user inputs wrong file name, it asks to try again
			System.out.println(ConsoleColour.RESET);
		}

	}

	private void showFilters() {// shows the filters available from ImageFilter class
		imgfil2.selectFilter();
	}

	private void selectFilters() {// directs to the method in ImageFilter where user can change and select filter
																// to use.
		String inputFilter;
		inputFilter = imgfil2.selection();
		ImageFilter.setKernel(inputFilter);
	}

	private void showOptions() {

		// System.out.println(ConsoleColour2.BLUE);
		System.out.println(ConsoleColour.BLUE_BRIGHT);
		System.out.println("");
		System.out.println("***************************************************");
		System.out.println("* GMIT - Dept. Computer Science & Applied Physics *");
		System.out.println("*                                                 *");
		System.out.println("*           Image Filtering System V0.1           *");
		System.out.println("*     H.Dip in Science (Software Development)     *");
		System.out.println("*                                                 *");
		System.out.println("***************************************************");
		System.out.println("1) Enter Image Name");// Ask user to specify the file to process.
		System.out.println("2) Display Filters"); // List of filters available in the class Kernel.javaSelect
		System.out.println("3) Select Filter to Apply");// User chooses a filter from option above.
		System.out.println("4) Quit"); // Terminate
		System.out.println("\nSelect Option [1-4]>");

	}

}// END CLASS
