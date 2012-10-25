package edu.ucsb.cs56.S12.shervinater.cp3;

/** Calculator for BAC
 @author Shervin Shaikh and Ramon Rovirosa
 @version 05/11/2012 for choice points
*/

public final class Calc{


    /**
       Constructor 
    */
    private Calc(){}



    /** 
	Calculates the Blood Alcohol Content from the parameters given through the constructor
	@param beer number of beers drank
	@param wine glasses of wine drank
	@param hardLiquor number of hard liquor shots taken
	@return BAC Blood Alcohol Concentration for the specific inputted values
    */
    public static double BAC(boolean isMale, int hours, int weight, int beer, int wine, int hardLiquor){
	//assigns the proper gender distribution ratio according to the gender
	double genderDistRatio = isMale ? .73 : .66;
	
	//finds the number of liquid ounces of alcohol consumed by the person
	double liquidOunces = (beer*.6)+(wine*.6)+(hardLiquor*.5);
	
	//calculates the Blood Alcohol Concentration with the given values
	double BAC = (liquidOunces*5.14)/(weight*genderDistRatio)-(hours*.015);

	if(BAC > 0){ return BAC;}
	else if(BAC > 1){ return 1.0;}
	return 0.0;
    }
}