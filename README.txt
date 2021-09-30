# IMAGE FILTERING SYSTEM V0.1

## CONTENTS OF THIS FILE
   
* Introduction
* Requirements
* Installation
* Configuration
* Troubleshooting
* FAQ




## INTRODUCTION

* The Image Filtering System V0.1 is a program that provides many image editing features for raster images.
  It uses a matrix , 2D array of numbers that slides across the pixels and makes computations changing the value of each pixel.
  The program allows users to select an image an apply different filters. It displays a four option menu, where users can choose an image, 
  see the different filters available and select the desired filter and the last option allows the user to quit the program.

## REQUIREMENTS

* As it comes inside a zip compressed folder, all the files need to be extracted to a secure location in the user's machine.

* This program requires to be opened from a Terminal.



## INSTALLATION
 
* To Install the program we need to unzip the folder, to do that, we press and hold (or right-click) the folder, 
  and select Extract All.

* From there, navigate to src folder and open a Terminal, .

  	- In the Terminal the first step is to compile the java files, typing: javac ie\gmit\dip\*.java

 	- When the previous step is done, run the program with the following command: java ie.gmit.dip.Runner

	- After that, the main menu of the program will appear.


## CONFIGURATION
 
* Once the main menu is showing in the terminal we will see four options to choose from:

	- 1) Enter Image Name: The user will be able to select an image from its own machine, typing the full path
	     and pick a name to save the new image. This image will be saved in a folder called << resources >>, 
	     which is allocated in the src folder.

	- 2) Display Filters: A list of filters are shown so the user can choose which one to apply.

	- 3) Select Filter to Apply: The user can type (Non-case sensitive) the name of the filter to use. In this option, 
	     the filter's name should be typed as it appears in Option 2. Also, this option is configurated using java lang.string.trim(), 
	     a built-in function that eliminates leading and trailing spaces.

	- 4) Quit: Option used to quit the program.
	

## TROUBLESHOOTING

* When choosing the option << 1) Enter Image Name >> as first input, 
  the filter applied to the image it would be the default one, in this case, Kernel.IDENTITY.

	* For a better user experience we recommend running the program in this order:

	- 2) Display Filters 
	- 3) Select Filter to Apply
	- 1) Enter Image Name

* When choosing the option << 3) Filter to Apply >>, the user will need to type the name of the filter that wants to apply.
  This option is Non-case sensitive, meaning that the filters name with uppercase and lowercase letters are the same.
  An issue can appear when missing letters, or changing the order of them.

  	* Examples that will run:

		- Diagonal_45_Lines
		- DIAGONAL_45_LINES
		- DiaGOnAL_45_LiNeS

  	* Examples that will prompt the user to try again:

		- Diagonal_45Lines
		- DiagonalLines


## FAQ

Q: After running the program where can I find the new image?

A: The new image will be located inside the << resources >> folder, located in the program main folder.

Q: What happens when misspelling the name of the filter?

A: In this case, the user will be prompt to try again, until it types the filter name in a correct way.





