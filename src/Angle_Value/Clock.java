package Angle_Value;
import java.util.Scanner;

public class Clock {
	
	static int hourValue;
	static int minuteValue;

	public static void main(String[] args) {
		GetTime();
		CalculateAngle(hourValue,minuteValue);
	}
	public static void GetTime(){
		System.out.println("Enter time in hh:mm format");
		
		Scanner val= new Scanner(System.in);
		String time= val.nextLine();		
		val.close(); 									//closing the reference for the object 'val'
		
		String[] value = time.split(":");
		hourValue= Integer.parseInt(value[0]);
		minuteValue= Integer.parseInt(value[1]);
		
		if(hourValue>=12 && hourValue<=24){
			hourValue = hourValue-12;					//conversion of 24hr to 12hr format
		}	
	}
	
	public static void CalculateAngle(int hh, int mm){
		if((hh >=0 && hh <=12) && (mm>=0 && mm<=60)){
			double hourHandPosition= hh*30 + mm*.5; 	//angle covered by hour hand by its value+ angle covered by hour hand due to motion of minute hand 
			double minuteHandPosition= mm*6;
			double resultantAngle = Math.abs(hourHandPosition-minuteHandPosition);
			if(resultantAngle>180){
				resultantAngle=360-resultantAngle;
			}
			System.out.println("The minimum angle between hour hand and minute hand is: "+resultantAngle);
			
		}else{
			System.out.println("Please enter a valid time!");
		}
	}	
}
