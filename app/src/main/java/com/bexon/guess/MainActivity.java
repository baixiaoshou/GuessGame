package com.bexon.guess;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.*;
import android.graphics.*;

public class MainActivity extends Activity {
	private int number;
	private String str;
	private String random = "已随机生成了一个数";

	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setStr(String str) {
		this.str = str;
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		setNumber(50);			//设定正确值为50‚也可以自动生成
		
		final EditText editText = (EditText)findViewById(R.id.edittext);
		final TextView textView = (TextView)findViewById(R.id.text);
		textView.setTextSize(24);
		textView.setTextColor(this.getResources().getColor(R.color.gray_green));
		final Button buttonRandom = (Button)findViewById(R.id.button_random);
		
		buttonRandom.setOnClickListener(new OnClickListener(){
				public void onClick(View arg0) {
					final double d = Math.random();
					final int i = (int)(d*100);
					setNumber(i);
					
					Toast.makeText(MainActivity.this,random, Toast.LENGTH_LONG).show();  
					
					}
			});
		
		final Button button = (Button)findViewById(R.id.button_ok);
		
		button.setOnClickListener(new OnClickListener(){
				public void onClick(View arg0) {
					
					int guess = Integer.parseInt(editText.getText().toString());
					
					if (editText.getText().toString() == null) {
						textView.setText("请输入一个[0~100)的数");
					} else if (guess > number) {
						textView.setTextColor(Color.parseColor("#DC143C"));
						textView.setText("输入数字较大");
					
					} else if (guess < number) {
						textView.setTextColor(Color.parseColor("#DC143C"));
						textView.setText("输入数字较小");
						
					} else {
						textView.setTextColor(Color.parseColor("#5F9EA0"));
						textView.setText("您猜对了,生成的数字为：" + getNumber());
						
					}
					
					
				}  
			}); 
			
		
		}
}
