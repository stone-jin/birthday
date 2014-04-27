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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class birth extends Activity {

	//界面控件
	private Button birth_title_edit;
	private Button birth_title_add;
	private ListView birth_listview;
	
	//普通变量
	private List<Birth_listview_item> listitems = new ArrayList<Birth_listview_item>();
	private birth_listview_adapter adapter;
	
	private Sql_birth sql_birth;
	public static final int ADD_BIRTHDAY_TO_ADD = 1;
	private boolean isEdit = false;
	
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
		listitems = sql_birth.qure_byresidue();
		isEdit = false;
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
				isEdit = !isEdit;
				if(isEdit == true)
					birth_title_edit.setText("完成");
				else
					birth_title_edit.setText("编辑");
				listitems = sql_birth.qure_byresidue();
				adapter.notifyDataSetChanged();
				break;
			case R.id.birth_title_add:
				Intent intent = new Intent(birth.this,add_birthday.class);
				startActivityForResult(intent, ADD_BIRTHDAY_TO_ADD);
				break;
			}
		}
	};
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(data == null){
			System.out.println("no date is committed");
			return;
		}else{
			switch(requestCode){
			case ADD_BIRTHDAY_TO_ADD:
				isEdit = false;
				listitems = sql_birth.qure_byresidue();
				adapter.notifyDataSetChanged();
				break;
			}
		}
	}
	
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
			return (long)listitems.get(position).getId();
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			birth_listview_view view;
			if(convertView == null){
				view = new birth_listview_view();
				convertView = getLayoutInflater().inflate(R.layout.birth_listview_item, null);
				view.photo = (ImageView) convertView.findViewById(R.id.birth_listview_imageview);
				view.name = (TextView) convertView.findViewById(R.id.birth_listview_name);
				view.mouth = (TextView) convertView.findViewById(R.id.birth_listview_mouth);
				view.day = (TextView) convertView.findViewById(R.id.birth_listview_day);
				view.residue = (TextView) convertView.findViewById(R.id.birth_listview_residue);
				view.linearEmpty = (LinearLayout) convertView.findViewById(R.id.birth_listview_item_emptyLayout);
				view.delete = (Button) convertView.findViewById(R.id.birth_listview_item_delete);
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
			if(view.name == null){
				System.out.println("1");
			}
			if(view.mouth == null){
				System.out.println("222");
			}
			view.name.setText(item.getName());
			view.mouth.setText(item.getMouth() + "");
			view.day.setText(item.getDay() + "");
			view.residue.setText(item.getResidue() + "");
			if(isEdit == false){
				view.linearEmpty.setVisibility(View.VISIBLE);
				view.delete.setVisibility(View.GONE);
			}else{
				view.linearEmpty.setVisibility(View.GONE);
				view.delete.setVisibility(View.VISIBLE);
				view.delete.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						sql_birth.delete_byid((int)getItemId(position));
						listitems.remove(position);
						notifyDataSetChanged();
					}
				});
			}
			return convertView;
		}
	}
	
	private class birth_listview_view{
		private ImageView photo;
		
		private TextView name;
		
		private TextView mouth;
		
		private TextView day;
		
		private TextView residue;
		
		private LinearLayout linearEmpty;
		
		private Button delete;
	}
}
