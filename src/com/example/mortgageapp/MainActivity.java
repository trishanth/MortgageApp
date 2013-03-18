package com.example.mortgageapp;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;


public class MainActivity extends Activity implements OnItemSelectedListener{
	
	public final static String EXTRA_MESSAGE = "com.example.mortgageapp.MESSAGE";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Code to populate values in the dropdown list
		
	    Spinner spinner = (Spinner) findViewById(R.id.years_dropdown);
	    
	    
	 // Create an ArrayAdapter using the string array and a default spinner layout
	    
	 ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
	         R.array.years_array, android.R.layout.simple_spinner_item);
	 
	 // Specify the layout to use when the list of choices appears
	 
	 adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	 
	 // Apply the adapter to the spinner
	 
	 spinner.setAdapter(adapter);
	 
	 //spinner.setOnItemSelectedListener(this);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void onItemSelected(AdapterView<?> parent, View view,int i, long l) {
        parent.getItemAtPosition(i).toString();
    }

    public void onNothingSelected(AdapterView<?> parent) {

    }
	
	public void calMortgage(View view) {
		
		Intent intent = new Intent(this, DisplayResultsActivity.class);
		
	    EditText text1 = (EditText) findViewById(R.id.down_payment);
	    String value1 = text1.getText().toString();       

	    EditText text2 = (EditText)findViewById(R.id.monthly_payment);
	    String value2 = text2.getText().toString();
	    
	    EditText text3 = (EditText)findViewById(R.id.interest_rate);
	    String value3 = text3.getText().toString();
	    
	    Spinner spinner = (Spinner) findViewById(R.id.years_dropdown);
	    spinner.setOnItemSelectedListener(this);
	    
	    String value4 = spinner.getSelectedItem().toString();
	    
	    System.out.println("Value of value4 is " + value4);
        
	    double l1 = Double.parseDouble(value1);
	    double l2 = Double.parseDouble(value2);
	    double l3 = Double.parseDouble(value3);
	    double l4 = Double.parseDouble(value4);
	    
	    
	    System.out.println("Value of l1 is " + l1);
	    System.out.println("Value of l2 is " + l2);
	    System.out.println("Value of l3 is " + l3);
	    System.out.println("Value of l4 is " + l4);
	    
	    //double l3 = (double)l3 / 12;
	    
	    double r = l3/1200; //to optimize to handle different payment periods.
	    
	    double n = l4*12;
	    
	    System.out.println("Value of l3 after getting divided by 12 is " + l3);

	    //l3 = l3 / 100;
	    
	    System.out.println("Value of l3 after getting divided by 100 is " + l3);
	    
	    double t = Math.pow(1+r,n)*r;
	    
	   // System.out.println("Value of l5 is " + l5);

	    double b = Math.pow(1+r,n)-1;
	    
	   // System.out.println("Value of l6 is " + l6);

	    double result = l2*b/ t;
	    
	    //result = ((result*100)+.5)/100;
	    
	   double totalpayment = result + l1;
	    
	    
	    
	    String finalresult = Double.toString(totalpayment);
	    
	    intent.putExtra(EXTRA_MESSAGE, finalresult);
	    
	    startActivity(intent);
	}
   
}
