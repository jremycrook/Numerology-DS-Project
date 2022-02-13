/**
 * This class contains the setters and getters for Numerology 
 * and a to string to pring the results
 */
public class Numerology 
{
	//variable declaration
	private int month;
	private int day;
	private int year;
	private int result;
	private String prediction;
	
	//constructor with parameters
	public Numerology(int month, int day, int year, int result, String prediction) 
	{

		this.month = month;
		this.day = day;
		this.year = year;
		this.result = result;
		this.prediction = prediction;
	}//end constructor
	
	//constructor
	public Numerology() {
		month = 0;
		day = 0;
		year = 0;
		result = 0;
		prediction = null;
	}//end Numerology()
	
	
	//method for returning month
	public int getMonth() {
		return month;
	}//end get month
	
	//method for setting month
	public void setMonth(int month) {
		this.month = month;
	}//end set month
	
	//method for returning day
	public int getDay() {
		return day;
	}//end getDay
	
	//method for setting the day
	public void setDay(int day) {
		this.day = day;
	}//end setDay
	
	//method for returning year
	public int getYear() {
		return year;
	}//end getyear
	
	//method for setting year
	public void setYear(int year) {
		this.year = year;
	}//end setyear
	
	//method for returning result
	public int getResult() {
		return result;
	}//end getResult
	
	//method for setting result
	public void setResult(int result) {
		this.result = result;
	}//end setresult
	
	//method for returning prediction
	public String getPrediction() {
		return prediction;
	}//end getPrediction
	
	//method for setting prediction
	public void setPrediction(String prediction) {
		this.prediction = prediction;
	}//end setPrediction

	//toString for printing back the Numerology class
	@Override
	public String toString() {
		return  month +"/" + day + "/" +  year + "/" + result +"/" + prediction + "\n";
	}//end to string
}//end class
