package com.tensimiku.password;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class About extends Activity {
	
	public Button eggactive;
	public TextView egg1;
	public TextView egg2;
	public TextView egg3;
	public TextView egg4;
	public TextView egg5;
	public TextView egg6;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		// TODO Auto-generated constructor stub
		egg1 = (TextView)findViewById(R.id.egg1);
		egg2 = (TextView)findViewById(R.id.egg2);
		egg3 = (TextView)findViewById(R.id.egg3);
		egg4 = (TextView)findViewById(R.id.egg4);
		egg5 = (TextView)findViewById(R.id.egg5);
		egg6 = (TextView)findViewById(R.id.egg6);

		eggactive = (Button)findViewById(R.id.egbutton);
		eggactive.setOnClickListener(new View.OnClickListener() {
		int i = 0;
		String[] egg = {"야! 드디어 코드를 다 짰다!","후 이제 테스트기에 넣고 돌려볼까!","아..앙대잖아?","앱이 제대로 작동되지가 않아 앙대","이런 일이 일어날 조짐을 느꼈지.","하지만 내 두뇌가 오류를 잡지 못했어. 후 새드  ㅠㅠ..."};
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (i > 5)
				{
					egg1.setText(egg[0]);
				}
				if (i > 6)
				{
					egg2.setText(egg[1]);
				}
				if (i > 7)
				{
					egg3.setText(egg[2]);
				}
				if (i > 8)
				{
					egg4.setText(egg[3]);
				}
				if (i > 9)
				{
					egg5.setText(egg[4]);
				}
				if (i > 38)
				{
					egg6.setText(egg[5]);
				}
				i++;
			}
		});
			

		
		
		
		
		
		
		
		
	}


}
