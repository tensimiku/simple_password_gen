package com.tsmk.pass;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        /*
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayUseLogoEnabled(false);
        */
        
        final EditText input;
        final TextView show;
        Button touch;
        
        input = (EditText)findViewById(R.id.input);
        show = (TextView)findViewById(R.id.show);
        touch = (Button)findViewById(R.id.touch);
        
        touch.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String stype;
				String well;
				if (input.getText().toString().length() < 2)
				{
				stype = input.getText().toString().toUpperCase(Locale.US);
				}
				else
				{
				stype = input.getText().toString().substring(input.getText().toString().length()-2,input.getText().toString().length()).toUpperCase(Locale.US);
				}
				well = input.getText().toString()+"BLAHBLAH";
				if (stype.length() == 0)
				{
					show.setText("Having Fun?");
				}
				else if (stype.contains("M5"))
				{
					show.setText(pwctr(hasher(well,"MD5")));
				}
				else if (stype.contains("S1"))
				{
					show.setText(pwctr(hasher(well,"SHA1")));
				}
				else if (stype.contains("S2"))
				{
					show.setText(pwctr(hasher(well,"SHA-256")));
				}
				else
				{
					show.setText(pwctr(hasher(well,"SHA-512")));
				}
			}
		});
        
        
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

	 public static String hasher(String input,String hashertype) {
         
	        String hash = null;

	        if(null == input) return null;

			try {
	        //Create MessageDigest object for MD5
	        MessageDigest digest;

			digest = MessageDigest.getInstance(hashertype);

	        //Update input string in message digest
	        digest.reset();
	        digest.update(input.getBytes());
	        byte messageDigest[] = digest.digest();
	        StringBuffer hexs = new StringBuffer();
	        for (int i = 0; i<messageDigest.length; i++)
	        {
	        	hexs.append(Integer.toString((messageDigest[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        hash = hexs.toString();
	        return hash;
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}



	       }

	 public static String pwctr(String input)
	 {
		 String pwd = input;
		 String temppw = null;
		 String fpw = null;
		 String spw = null;
		 String rpw = null;
		 String SecureLetter[] = {"!","@","#","$","%","^","&","*","(",")"};
		 String tmp = "";
		 String num = "";


		 temppw = pwd.substring(0, 24);
		 double div = temppw.length()/2;
		 int half = (int)div;
		 for (int i = 0; i < pwd.length() ; i++)
		 {
			tmp = pwd.substring(i,i+1);
			if(Character.isDigit(pwd.charAt(i)))
			{

				num += tmp;

			}
		 }


		 int secunum = Integer.valueOf(num.substring(0,1));


		 fpw = temppw.substring(0,half).toLowerCase(Locale.US)+SecureLetter[secunum];
		 spw = temppw.substring(half,temppw.length()).toUpperCase(Locale.US);
		 rpw = fpw + spw;

		 return rpw;

	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
        	Intent i = new Intent(this,About.class);
        	startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
