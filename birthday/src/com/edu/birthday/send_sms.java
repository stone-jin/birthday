package com.edu.birthday;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class send_sms extends Activity {
	//�ؼ�
	private Button send_sms_title_back;
	private EditText send_sms_phone;
	private Button send_sms_search_contact;
	private EditText send_sms_content;
	private Button send_sms_special_sms;
	private Button send_sms_collect;
	private Button send_sms_Timing;
	private Button send_sms_send;
	
	//һ�����
	private boolean birth_info_to_send_sms;
	private boolean sms_info_to_send_sms;
	private String birth_info_phone;
	private String sms_info_content;
	public static final int SEARCH_CONTACT_FOR_PHONE = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send_sms);
		bundle();
		viewInit();
		if(birth_info_to_send_sms == true || sms_info_to_send_sms == true){
			viewDataInit();
		}
	}
	
	private void bundle(){
		Intent intent = getIntent();
		birth_info_to_send_sms = intent.getBooleanExtra("birth_info_to_send_sms", false);
		sms_info_to_send_sms = intent.getBooleanExtra("sms_info_to_send_sms", false);
		if(birth_info_to_send_sms == true)
			birth_info_phone = intent.getStringExtra("birth_info_to_send_sms_phone");
		if(sms_info_to_send_sms == true){
			sms_info_content = intent.getStringExtra("sms_info_to_send_sms_phone");
		}
	}
	
	private void viewInit(){
		send_sms_title_back = (Button) this.findViewById(R.id.send_sms_title_back);
		send_sms_title_back.setOnClickListener(onClickListener);
		send_sms_phone = (EditText) this.findViewById(R.id.send_sms_phone);
		send_sms_search_contact = (Button) this.findViewById(R.id.send_sms_search_contact);
		send_sms_search_contact.setOnClickListener(onClickListener);
		send_sms_content = (EditText) this.findViewById(R.id.send_sms_content);
		send_sms_special_sms = (Button) this.findViewById(R.id.send_sms_special_sms);
		send_sms_special_sms.setOnClickListener(onClickListener);
		send_sms_collect = (Button) this.findViewById(R.id.send_sms_collect);
		send_sms_collect.setOnClickListener(onClickListener);
		send_sms_Timing= (Button) this.findViewById(R.id.send_sms_Timing);
		send_sms_Timing.setOnClickListener(onClickListener);
		send_sms_send = (Button) this.findViewById(R.id.send_sms_send);
		send_sms_send.setOnClickListener(onClickListener);
	}
	
	private void viewDataInit(){
		if(birth_info_to_send_sms == true){
			send_sms_phone.setText(birth_info_phone);
		}
		if(sms_info_to_send_sms == true){
			send_sms_phone.setText("");
			send_sms_content.setText(sms_info_content);
		}
	}
	
	OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.send_sms_title_back:
				send_sms.this.finish();
				break;
			case R.id.send_sms_search_contact:
				Intent intent = new Intent(send_sms.this,search_contact.class);
				intent.putExtra("send_sms_search_contact_for_phone", true);
				startActivityForResult(intent, SEARCH_CONTACT_FOR_PHONE);
				break;
			case R.id.send_sms_special_sms:
				break;
			case R.id.send_sms_collect:
				break;
			case R.id.send_sms_Timing:
				break;
			case R.id.send_sms_send:
				Uri uri = Uri.parse("smsto:" + send_sms_phone.getText().toString());
				Intent intent1 = new Intent(Intent.ACTION_VIEW,uri);
				intent1.putExtra("sms_body", send_sms_content.getText().toString());
				startActivity(intent1);
				break;
			}
		}
	};
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(data == null){
			System.out.println("no data is commit to send_sms");
			return;
		}
		switch(requestCode){
		case SEARCH_CONTACT_FOR_PHONE:
			String phone = data.getStringExtra("send_sms_search_contact_for_phone");
			send_sms_phone.setText(phone);
			break;
		}
		return;
	};
}
