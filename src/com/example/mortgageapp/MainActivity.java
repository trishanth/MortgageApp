package com.example.mortgageapp;

//import com.example.myfirstapp.DisplayMessageActivity;
//import com.example.myfirstapp.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	
	public final static String EXTRA_MESSAGE = "com.example.mortgageapp.MESSAGE";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
/**    public void sendMessage(View view) {
        // Do something in response to button
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	EditText editText = (EditText) findViewById(R.id.down_payment);
    	String message = editText.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    } */
	
	public void calMortgage(View view) {
		
		Intent intent = new Intent(this, DisplayResultsActivity.class);
		
	    EditText text = (EditText) findViewById(R.id.down_payment);
	    String value = text.getText().toString();       

	    EditText text2 = (EditText)findViewById(R.id.monthly_payment);
	    String value2 = text2.getText().toString();              
          
	    double l1 = Double.parseDouble(value);
	    double l2 = Double.parseDouble(value2);

	    double result = l1 + l2;
	    //String value3 = result.
	    
	    String finalresult = Double.toString(result);
	    
	    intent.putExtra(EXTRA_MESSAGE, finalresult);
	    
	    startActivity(intent);
	}
   
}
