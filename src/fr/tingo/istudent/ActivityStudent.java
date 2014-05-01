package fr.tingo.istudent;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ActivityStudent extends Activity {
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);

        getActionBar().setDisplayHomeAsUpEnabled(true);	//on affiche el bouton back en haut � gauche de l'�cran
	}

	

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) 
	{
	    int itemId = item.getItemId();
	    
	    switch(itemId) {
	    case android.R.id.home:
	    	this.onBackPressed();
	        break;
	    }
	    return true;
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


}
