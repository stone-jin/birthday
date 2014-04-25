package com.edu.birthday;

import java.util.ArrayList;
import java.util.List;

import com.edu.bean.Birth_listview_item;
import com.edu.sql.Sql_birth;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class birth extends Activity {

	//����ؼ�
	private Button birth_title_edit;
	private Button birth_title_add;
	private ListView birth_listview;
	
	private List<Birth_listview_item> listitems = new ArrayList<Birth_listview_item>();
	private birth_listview_adapter adapter;
	
	private Sql_birth sql_birth;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.birth);
		dateInit();
		viewInit();
	}
	
	private void dateInit(){
		sql_birth = new Sql_birth(this);
	}
	
	private void viewInit(){
		birth_title_edit = (Button) this.findViewById(R.id.birth_title_edit);
		birth_title_edit.setOnClickListener(onClickListener);
		birth_title_add = (Button) this.findViewById(R.id.birth_title_add);
		birth_title_add.setOnClickListener(onClickListener);
		birth_listview = (ListView) this.findViewById(R.id.birth_listview);
		adapter = new birth_listview_adapter();
		birth_listview.setAdapter(adapter);
	}
	
	OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.birth_title_edit:
				break;
			case R.id.birth_title_add:
				Intent intent = new Intent(birth.this,add_birthday.class);
				startActivity(intent);
				break;
			}
		}
	};
	
	private class birth_listview_adapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return listitems.size();
		}

		@Override
		public Birth_listview_item getItem(int position) {
			// TODO Auto-generated method stub
			return listitems.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			birth_listview_view view;
			if(convertView == null){
				convertView = getLayoutInflater().inflate(R.layout.birth_listview_item, null);
				view = new birth_listview_view();
				view.photo = (ImageView) convertView.findViewById(R.id.birth_listview_imageview);
				view.name = (TextView) convertView.findViewById(R.id.birth_listview_name);
				view.mouth = (TextView) convertView.findViewById(R.id.birth_listview_mouth);
				view.day = (TextView) convertView.findViewById(R.id.birth_listview_day);
				view.residue = (TextView) convertView.findViewById(R.id.birth_listview_residue);
				convertView.setTag(view);
			}else{
				view = (birth_listview_view) convertView.getTag();
			}
			Birth_listview_item item = listitems.get(position);
			if(item.getPhoto() != null){
				view.photo.setImageBitmap(item.getPhoto());
			}else{
				view.photo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.defaultboy));
			}
			view.name.setText(item.getName());
			view.mouth.setText(item.getMouth());
			view.day.setText(item.getDay());
			view.residue.setText(item.getResidue());
			return convertView;
		}
	}
	
	private class birth_listview_view{
		private ImageView photo;
		
		private TextView name;
		
		private TextView mouth;
		
		private TextView day;
		
		private TextView residue;
	}
}
