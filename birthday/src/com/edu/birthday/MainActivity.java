package com.edu.birthday;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity implements Runnable{
	//选项卡对象
	private TabHost tabHost;
	//选项卡按钮
	private RadioButton radioButton[] = new RadioButton[4];
	//选项卡按钮ID
	private int RadioButtonId[] = {
		R.id.mainactivity_tabs_birth, R.id.mainactivity_tabs_sms, R.id.mainactivity_tabs_center, R.id.mainactivity_tabs_more	
	};
	//图像对象
	private ImageView imageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainactivity);
		tabHostInit();
		viewInit();
		new Thread(this).start();
	}
	
	private void tabHostInit(){
		tabHost = getTabHost();
		tabHost.addTab(tabHost.newTabSpec("birth").setIndicator("11")
				.setContent(new Intent(this,birth.class)));
		tabHost.addTab(tabHost.newTabSpec("sms").setIndicator("22")
				.setContent(new Intent(this,sms.class)));
		tabHost.addTab(tabHost.newTabSpec("center").setIndicator("33")
				.setContent(new Intent(this,center.class)));
		tabHost.addTab(tabHost.newTabSpec("more").setIndicator("44")
				.setContent(new Intent(this,more.class)));
		for(int i = 0; i < 4; i++){
			radioButton[i] = (RadioButton) this.findViewById(RadioButtonId[i]);
			radioButton[i].setOnClickListener(onClickListener);
		}
		tabHost.setCurrentTabByTag("birth");
		radioButton[0].setChecked(true);
	}
	
	private void viewInit(){
		imageView = (ImageView) this.findViewById(R.id.mainactivity_imageview);
	}
	
	//单击监控
	OnClickListener onClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.mainactivity_tabs_birth:
				tabHost.setCurrentTabByTag("birth");
				break;
			case R.id.mainactivity_tabs_sms:
				tabHost.setCurrentTabByTag("sms");
				break;
			case R.id.mainactivity_tabs_center:
				tabHost.setCurrentTabByTag("center");
				break;
			case R.id.mainactivity_tabs_more:
				tabHost.setCurrentTabByTag("more");
				break;
			default:
				break;
			}
		}
	};
	
	Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			imageView.setVisibility(View.GONE);
		}
	};

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		handler.sendEmptyMessage(0);
	}
}
