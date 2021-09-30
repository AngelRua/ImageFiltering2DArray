package ie.gmit.dip;

import java.util.Scanner;

public class ImageFilter {

	// Default value for Kernel, can be changed by user
	public static Kernel kernel = Kernel.IDENTITY;

	Scanner scanner = new Scanner(System.in);

	// It works with string, not number. This is how user can select a new filter to
	// apply.
	public String selection() {

		boolean checkFilter = false;
		String inputFilter;
		do {
			System.out.println(ConsoleColour.GREEN_BRIGHT);
			System.out.println("Please Type a Filter to Apply");
			System.out.println(ConsoleColour.WHITE_BRIGHT);
			inputFilter = scanner.next().toUpperCase().trim();// Converts to upper case and elemitates unnecesary spaces when
																												// user inputs
			try {// If user inputs the wrong filter name it will ask to try again
				setKernel(inputFilter);
				checkFilter = true;
			} catch (Exception e) {
				System.out.println(ConsoleColour.RED_BOLD_BRIGHT);
				System.out.println("OOPSSS!!! Something Went Wrong. Please Try Again");
				System.out.println(ConsoleColour.RESET);
				checkFilter = false;
			}
		} while (!checkFilter);

		if (checkFilter) {

			System.out.println(ConsoleColour.WHITE_BRIGHT);
			System.out.println("\nYour choice is filter " + inputFilter);// it displays the choosen filter
			System.out.println(ConsoleColour.RESET);

		}
		return inputFilter;
	}

	// Method to Set Kernel, user inputs the name of the filter as a String and it
	// compares to valueOf the Enum, to find the choosen filter and select it
	// to apply

	public static void setKernel(String inputFilter) {
		kernel = Kernel.valueOf(inputFilter);
	}

	public void selectFilter() {// options of filters that can be applied
		System.out.println(ConsoleColour.GREEN_BRIGHT);
		System.out.println("\nOptions of Filters as follow:");
		System.out.println(ConsoleColour.WHITE_BRIGHT);
		System.out.println(" Identity");
		System.out.println(" Edge_Detection_1");
		System.out.println(" Edge_Detection_2");
		System.out.println(" Laplacian");
		System.out.println(" Sharpen");
		System.out.println(" Vertical_Lines");
		System.out.println(" Horizontal_Lines");
		System.out.println(" Diagonal_45_Lines");
		System.out.println(" Box_blur");
		System.out.println(" Sobel_Horizontal");
		System.out.println(" Sobel_Vertical");
	}

}// end of class
