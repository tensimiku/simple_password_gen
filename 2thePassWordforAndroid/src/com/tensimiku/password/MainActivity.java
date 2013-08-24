package com.tensimiku.password;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	
	
	private EditText code;
	private TextView pw;
	private Button mkpw;
	private String stype;
	private String well;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		code = (EditText)findViewById(R.id.code);
		mkpw = (Button)findViewById(R.id.mkpw);
		pw = (TextView)findViewById(R.id.pw);
		
		
		mkpw.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
				{
				// TODO Auto-generated method stub
				if (code.getText().toString().length() < 2)
				{
				stype = code.getText().toString().toUpperCase(Locale.US);
				}
				else
				{
				stype = code.getText().toString().substring(code.getText().toString().length()-2,code.getText().toString().length()).toUpperCase(Locale.US);
				}
				well = code.getText().toString()+"Identify";
				if (stype.isEmpty())
				{
					 pw.setText("Having Fun?");
				}
				else if (stype.contains("M5"))
				{
					 pw.setText(pwctr(hasher(well,"MD5")));
				}
				else if (stype.contains("S1"))
				{
					 pw.setText(pwctr(hasher(well,"SHA1")));
				}
				else if (stype.contains("S2"))
				{
					 pw.setText(pwctr(hasher(well,"SHA-256")));
				}
				else
				{
					 pw.setText(pwctr(hasher(well,"SHA-512")));
				}
				}
			}
		
		);
		
		
		
		
		
		
		
	}//场
	
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
	 
	//集绊集绊倒府绊集绊
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
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		if (item.getItemId()==R.id.About)
		{
			 Intent intent = new  Intent(this, About.class);
			 startActivity(intent);

			
			return true;
		}
		else
		{
			return false;
		}
	}

}
