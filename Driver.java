import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
/**
 * Jeremy Crook 
 * N01453446
 * This is the main class for Assignment 1. This class creats the linked lists of numerology objects
 * with random dates and predictions, and stores all of them. then it will print the results and 
 * prediction into a file 
 */
public class Driver 
{
	//Main method
	public static void main (String[] args) throws IOException 
	{
		
		//Linked list declaration
		SingleLinkedList singleList = new SingleLinkedList ();
		DoubleLinkedList doubleList = new DoubleLinkedList();
		
		//generating dates and stores in file
		genDates();
		
		//reads the dates file, stores them in numerology objects, calculates numerology and 
		//also stores predictions in linkedlists
		readNum(singleList, doubleList);
		
		//Prints out the dates and predictions by going forward in SLL
		System.out.println("Printing using SLL:");
		singleNode newNode = singleList.head();
		while (newNode != null)
		{
			System.out.println(newNode.num.toString());
			newNode = newNode.next;
		}//end while
		
		//Prints out the dates and predictions by going backwards in DLL
		System.out.println("Printing using DLL:");
		doubleNode newNode2 = doubleList.last();
		while (newNode2 != null)
		{
			System.out.println(newNode2.num.toString());
			newNode2 = newNode2.prev;
		}//end while
		
		//opens new file and createsd PrintWriter
		FileWriter fr = new FileWriter("Predict.txt");
		PrintWriter pr = new PrintWriter(fr);
		
		//prints predictions to file
		newNode = singleList.head();
		while (newNode != null)
		{
			pr.write(newNode.num.getPrediction() + "\n");
			newNode = newNode.next;
		}//end while
		
		//closes printwriter and filewriter
		pr.close();
		fr.close();
	}//end main method
	
	//Method for generating dates and storing in a new file
	public static void genDates () throws IOException 
	{
		//Random object
		Random rand = new Random();
		
		//File objects
		File dates = new File("dates.txt");
		PrintWriter printWriter = new PrintWriter ("dates.txt");
		
		//for loop for creating 100 dates
		for (int i = 0; i <100; i++) 
		{
			//creates and writes random Year and month
			int year = rand.nextInt(2020 - 1500) +1500;
			int month = rand.nextInt(12 - 1) +1;
			
			//Random day and If check
			int day;
			if (month == 2)
			{
				 day = rand.nextInt(28 - 1) +1;
			}//end if
			
			else if (month == 1 || month == 3 || month == 5 || month == 7
					|| month == 8 || month == 10 || month == 12)
			{
				 day = rand.nextInt(31 - 1) +1;
			}//end else if
			
			else
			{
				 day = rand.nextInt(30 - 1) +1;
			}//end else
			printWriter.println(month);
			printWriter.println(day);
			printWriter.println(year);
		}//end for loop
		
		//closes printwriter
		printWriter.close();
	}//end genDates()
	
	//Method for returning prediction
	public static String prediction (int x) 
	{
		//creating of string 
		String string = null;
		
		//switch case for returning predictions
		switch(x)
		{
		case 1: string = "You will have good luck soon!";
		break;
		
		case 2: string = "You will have bad luck soon!";
		break;
		
		case 3: string = "You will stumle across a fortune soon.";
		break;
		
		case 4: string = "You will recieve good news soon!";
		break;
		
		case 5: string = "You will recieve terrible news soon!";
		break;
		
		case 6: string = "You will gain some usefull knolwdge soon!";
		break;
		
		case 7: string = "You will gain more responsibility soom.";
		break;
		
		case 8: string = "You will loose a close relationtion.";
		break;
		
		case 9: string = "You will gain a new friend soon";
		break;
		
		}
		return string;
	}//end prediction

	//Method for calculating Numerology
	public static int calcNum (int temp)
	{
		
		//variable declaration
		int sum = 0;
		
		//calculation loop
		while (temp > 0 || sum > 9)
		{
			if (temp == 0) 
			{
				temp = sum;
				sum = 0;
			}
			sum += temp %10;
			temp /=10;
		}//end while
		
		return sum;
	}//end calcNum

	//Method for reading the dates file, scanning them into the linked lists, calling calculate and
	//prediction function
	public static void readNum (SingleLinkedList slist, DoubleLinkedList dlist) throws FileNotFoundException 
	{
		//OPening the file and creating scanner object
		File file = new File("Dates.txt");
		Scanner scan = new Scanner (file);
		
		//loop for creating 100 objects
		while (scan.hasNextInt()) 
		{
			//reading dates from file
			int month = scan.nextInt();
			int day = scan.nextInt();
			int year = scan.nextInt();
			
			//crunching result
			int x = month + day + year;
			int result = calcNum(x);
			
			//setting prediction
			String prediction = prediction(result);
			
			//creating numerology object and adding to Single and Double Linked Lists
			Numerology num = new Numerology (month, day, year, result, prediction);
			slist.addFirst(num);
			dlist.addDouble(num);
			
		}//end while
		scan.close();
	}//end readNum
	
}//end driver
