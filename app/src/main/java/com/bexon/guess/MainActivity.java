package com.bexon.guess;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.view.View;

public class MainActivity extends Activity {
	private int number;
	private String str;

	public void setNumber(int number) {
		this.number = number;
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
		final Button button = (Button)findViewById(R.id.button);
		
		button.setOnClickListener(new OnClickListener(){
				public void onClick(View arg0) {
					int guess = Integer.parseInt(editText.getText().toString());
					
					if (guess > number) {
						setStr("输入数字较大");
					}else if (guess < number) {
						setStr("输入数字较小");
					}else {
						setStr("您猜对了");
					}
					
					Toast.makeText(MainActivity.this,str, Toast.LENGTH_LONG).show();  
				}  
			}); 
			
		
		}
}
