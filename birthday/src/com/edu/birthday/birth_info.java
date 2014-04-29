package com.edu.birthday;

import com.edu.bean.Birth_info_item;
import com.edu.sql.Sql_birth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class birth_info extends Activity {
	
	//View控件
	private TextView birth_info_name;
	private TextView birth_info_date1;
	private TextView birth_info_date2;
	private Button birth_info_title_back;
	private Button birth_info_title_edit;
	private ImageView birth_info_sex;
	private TextView birth_info_animal;
	private TextView birth_info_constellation;
	private TextView birth_info_date3;
	private TextView birth_info_date4;
	private TextView birth_info_date5;
	private Button birth_info_baike;
	private ImageView birth_info_photo;
	
	private int id;
	private Birth_info_item item;
	private Sql_birth sql_birth;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.birth_info);
		bundle();
		if(id != -1){
			dateInit();
			viewInit();
			viewDataInit();
		}else{
			Toast.makeText(getApplicationContext(), "前一个页面无参数过来", Toast.LENGTH_LONG).show();
		}
	}
	
	private void bundle(){
		Intent intent = getIntent();
		id = intent.getIntExtra("birth_info_by_id", -1);
	}
	
	private void dateInit(){
		sql_birth = new Sql_birth(this);
		item = new Birth_info_item();
		item = sql_birth.qurebyid(id, this);
	}
	
	private void viewInit(){
		birth_info_name = (TextView) this.findViewById(R.id.birth_info_name);
		birth_info_title_back = (Button) this.findViewById(R.id.birth_info_title_back);
		birth_info_title_back.setOnClickListener(onClickListener);
		birth_info_title_edit = (Button) this.findViewById(R.id.birth_info_title_edit);
		birth_info_title_edit.setOnClickListener(onClickListener);
		birth_info_date1 = (TextView) this.findViewById(R.id.birth_info_date1);
		birth_info_date2 = (TextView) this.findViewById(R.id.birth_info_date2);
		birth_info_sex = (ImageView) this.findViewById(R.id.birth_info_sex);
		birth_info_animal = (TextView) this.findViewById(R.id.birth_info_animal);
		birth_info_constellation =(TextView) this.findViewById(R.id.birth_info_constellation);
		birth_info_date3 = (TextView) this.findViewById(R.id.birth_info_date3);
		birth_info_date4 = (TextView) this.findViewById(R.id.birth_info_date4);
		birth_info_date5 = (TextView) this.findViewById(R.id.birth_info_date5);
		birth_info_baike = (Button) this.findViewById(R.id.birth_info_baike);
		birth_info_baike.setOnClickListener(onClickListener);
		birth_info_photo = (ImageView) this.findViewById(R.id.birth_info_photo);
	}
	
	OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.birth_info_title_back:
				birth_info.this.finish();
				break;
			case R.id.birth_info_title_edit:
				break;
			case R.id.birth_info_baike:
				Toast.makeText(getApplicationContext(), "百科功能还未上线", Toast.LENGTH_LONG).show();
				break;
			}
		}
	};
	
	private void viewDataInit(){
		if(item != null){
			birth_info_name.setText(item.getName());
			birth_info_date1.setText(item.getYear() + "-" + item.getMonth() + "-" + item.getDay());
		}
	}
}
