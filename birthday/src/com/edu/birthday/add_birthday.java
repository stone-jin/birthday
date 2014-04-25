package com.edu.birthday;

import com.edu.bean.SQL_Person;
import com.edu.sql.Sql_birth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class add_birthday extends Activity {
	
	//界面控件
	private Button add_birthday_title_back;
	private ImageView add_birthday_photo;
	private Button add_birthday_search1;
	private Button add_birthday_search2;
	private RadioButton add_birthday_boy;
	private RadioButton add_birthday_girl;
	private Button add_birthday_save;
	private EditText add_birthday_name;
	private EditText add_birthday_phone;

	//普通变量
	public static final int SEARCH_CONTACT_FOR_NAME = 0;
	public static final int SEARCH_CONTACT_FOR_PHONE = 1;
	
	private Sql_birth sql_birth;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_birthday);
		dateInit();
		viewInit();
	}
	
	private void dateInit(){
		sql_birth = new Sql_birth(this);
	}
	
	private void viewInit(){
		add_birthday_title_back = (Button) this.findViewById(R.id.add_birthday_title_back);
		add_birthday_title_back.setOnClickListener(onClickListener);
		add_birthday_photo = (ImageView) this.findViewById(R.id.add_birthday_photo);
		add_birthday_photo.setOnClickListener(onClickListener);
		add_birthday_search1 = (Button) this.findViewById(R.id.add_birthday_search1);
		add_birthday_search1.setOnClickListener(onClickListener);
		add_birthday_search2 = (Button) this.findViewById(R.id.add_birthday_search2);
		add_birthday_search2.setOnClickListener(onClickListener);
		add_birthday_boy = (RadioButton) this.findViewById(R.id.add_birthday_boy);
		add_birthday_girl = (RadioButton) this.findViewById(R.id.add_birthday_girl);
		add_birthday_boy.setChecked(true);
		add_birthday_save = (Button) this.findViewById(R.id.add_birthday_save);
		add_birthday_save.setOnClickListener(onClickListener);
		add_birthday_name = (EditText) this.findViewById(R.id.add_birthday_name);
		add_birthday_phone = (EditText) this.findViewById(R.id.add_birthday_phone);
	}
	
	OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.add_birthday_title_back:
				add_birthday.this.finish();
				break;
			case R.id.add_birthday_photo:
				Toast.makeText(getApplicationContext(), "当前不支持切换头像", Toast.LENGTH_LONG).show();
				break;
			case R.id.add_birthday_search1:
				Intent intent = new Intent(add_birthday.this,search_contact.class);
				intent.putExtra("search_contact_for_name", true);
				startActivityForResult(intent, SEARCH_CONTACT_FOR_NAME);
				break;
			case R.id.add_birthday_search2:
				Intent intent1 = new Intent(add_birthday.this,search_contact.class);
				intent1.putExtra("search_contact_for_phone", true);
				startActivityForResult(intent1, SEARCH_CONTACT_FOR_PHONE);
				break;
			case R.id.add_birthday_save:
				saveTodb();
				add_birthday.this.finish();
				break;
			}
		}
	};

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(data == null){
			System.out.println("No data is commit");
		}else{
			switch(requestCode){
			case SEARCH_CONTACT_FOR_NAME:
				Bundle bundle = data.getExtras();
				String str = bundle.getString("search_contact_for_name");
				add_birthday_name.setText(str);
				break;
			case SEARCH_CONTACT_FOR_PHONE:
				Bundle bundle2 = data.getExtras();
				String str2 = bundle2.getString("search_contact_for_phone");
				add_birthday_phone.setText(str2);
				break;
			}
		}
	}
	
	private void saveTodb(){
		SQL_Person person = new SQL_Person();
		person.setName("金炳");
		person.setAge(21);
		person.setSex("男");
		person.setPhoto("");
		person.setGreyear(1991);
		person.setGremouth(11);
		person.setGreday(16);
		person.setPhone("18767120974");
		person.setAnimal("羊");
		person.setConstellation("天蝎座");
		person.setBeizhuInfo("生日吃水果");
		sql_birth.insert(person);
	}
}
