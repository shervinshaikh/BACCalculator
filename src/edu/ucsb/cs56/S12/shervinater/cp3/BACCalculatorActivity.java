package edu.ucsb.cs56.S12.shervinater.cp3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
 
/** Calculator for BAC Activity
 @author Shervin Shaikh and Ramon Rovirosa
 @version 06/8/2012 for choice points
*/

public class BACCalculatorActivity extends Activity {
 
  private Spinner beer, wine, hardLiquor;
  private Button btnSubmit;
  private String hours, weight, message;
  private RadioGroup mORf;
  private int checkedRB;
  private RadioButton mfButton;
  private boolean isMale;
  private double BAC;
 
  @Override
  public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);
 
	androidGui();
  }
 
  // get 3 spinner's value, input fields, and male/female status
  public void androidGui() {
 
	//Value of number of drinks in String format  
	beer = (Spinner) findViewById(R.id.beerCount);
	wine = (Spinner) findViewById(R.id.wineCount);
	hardLiquor = (Spinner) findViewById(R.id.hardCount);
	
	//RadioGroup of Male or Female
	mORf = (RadioGroup) findViewById(R.id.radioGroupSex);
	
	btnSubmit = (Button) findViewById(R.id.submitButton);
 
	btnSubmit.setOnClickListener(new OnClickListener() {
 
	  public void onClick(View v) {
		  //So the application doesn't crash, preset values to 0
		  int h = 0;
		  int w = 0;
		  
		  //Get the text for number of hours
		  EditText hoursText = (EditText) findViewById(R.id.hoursF);
		  hours = hoursText.getText().toString();
	
		  //Get text for the weight from EditText field
		  EditText weightText = (EditText) findViewById(R.id.weightF);
		  weight = weightText.getText().toString();
	
		  //get Male or Female and set boolean value
			checkedRB = mORf.getCheckedRadioButtonId();
			mfButton = (RadioButton) findViewById(checkedRB);
			if(mfButton.getText().equals("Male")){
				isMale = true;
			}
			else if(mfButton.getText().equals("Female")){
				isMale = false;
			}
		  
			//Get the values from 
			if(!hours.equals("")) h = Integer.parseInt(hours);
			if(!weight.equals("")) w = Integer.parseInt(weight);
			int b = Integer.parseInt(beer.getSelectedItem().toString());
			int wi = Integer.parseInt(wine.getSelectedItem().toString());
			int hL = Integer.parseInt(hardLiquor.getSelectedItem().toString());
			//Run BAC Calculator to solve for the BAC value
			BAC = Calc.BAC(isMale, h, w, b, wi, hL);
			message = BACMessage.GuiMessage(BAC);
			
		  //Display the message as a toast
	    Toast.makeText(BACCalculatorActivity.this,
	    		message,
			Toast.LENGTH_LONG).show();
	  }
 
	});
  }
}