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
		String[] egg = {"��! ���� �ڵ带 �� ®��!","�� ���� �׽�Ʈ�⿡ �ְ� ��������!","��..�Ӵ��ݾ�?","���� ����� �۵������� �ʾ� �Ӵ�","�̷� ���� �Ͼ ������ ������.","������ �� �γ��� ������ ���� ���߾�. �� ����  �Ф�..."};
			
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
