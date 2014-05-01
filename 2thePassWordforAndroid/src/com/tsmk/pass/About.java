package com.tsmk.pass;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class About extends Activity {
	 		protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.about);
	        TextView link1;
	        TextView link2;
	        link1 = (TextView)findViewById(R.id.link);
	        link2 = (TextView)findViewById(R.id.link2);
	        
	        link1.setText(
	                Html.fromHtml(
	                    "<a href=\"https://tensimiku.github.io\">@tensimiku</a> "));
	        link1.setMovementMethod(LinkMovementMethod.getInstance());

	        link2.setText(
	                    Html.fromHtml(
	                        "<a href=\"http://unity-chan.com/\">Unity-chan project</a> "));
	        link2.setMovementMethod(LinkMovementMethod.getInstance());  
	 }
}
