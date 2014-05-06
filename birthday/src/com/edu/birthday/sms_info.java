package com.edu.birthday;


import java.util.ArrayList;
import java.util.List;

import com.edu.bean.Sms_info_listview_item;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class sms_info extends Activity {
	//View�ؼ�
	private Button sms_info_title_back;
	private ListView sms_info_listview;
	
	//һ�����
	private int locationx;
	private int locationy;
	private listview_adapter adapter;
	private List<Sms_info_listview_item>items;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sms_info);
		bundle();
		dateInit();
		viewInit();
	}
	
	private void bundle(){
		Intent intent = getIntent();
		locationx = intent.getIntExtra("locationx", -1);
		locationy = intent.getIntExtra("locationy", -1);
	}
	
	private void dateInit(){
		 items = new ArrayList<Sms_info_listview_item>();
		 Sms_info_listview_item item = new Sms_info_listview_item();
		 item.setCollect(true);
		 item.setContent("Ը������ճ�������Ŀ��֣�Ը�����Ļ�����ܰ��Ը����������������Ը����һ���������!");
		 item.setPopularity(100);
		 items.add(item);
	}
	
	private void viewInit(){
		sms_info_title_back = (Button) this.findViewById(R.id.sms_info_title_back);
		sms_info_title_back.setOnClickListener(onClickListener);
		sms_info_listview = (ListView) this.findViewById(R.id.sms_info_listview);
		adapter = new listview_adapter();
		sms_info_listview.setAdapter(adapter);
		sms_info_listview.setOnItemClickListener(onItemClickListener);
	}
	
	OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.sms_info_title_back:
				sms_info.this.finish();
				break;
			}
		}
	};
	
	OnItemClickListener onItemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			Toast.makeText(getApplicationContext(), position, Toast.LENGTH_LONG).show();
		}
	};
	
	private class listview_adapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return items.size();
		}

		@Override
		public Sms_info_listview_item getItem(int position) {
			// TODO Auto-generated method stub
			return items.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			listview_view view;
			if(convertView == null){
				convertView = getLayoutInflater().inflate(R.layout.sms_info_item, null);
				view = new listview_view();
				view.contentText = (TextView) convertView.findViewById(R.id.sms_info_item_content);
				view.collectButton = (RadioButton) convertView.findViewById(R.id.sms_info_item_collectButton);
				view.popularityText = (TextView) convertView.findViewById(R.id.sms_info_item_popularity);
				convertView.setTag(view);
			}else{
				view = (listview_view) convertView.getTag();
			}
			view.contentText.setText(items.get(position).getContent());
			if(items.get(position).isCollect() == true){
				view.collectButton.setChecked(true);
			}else{
				view.collectButton.setChecked(false);
			}
			view.collectButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if(getItem(position).isCollect() == true){
						items.get(position).setCollect(false);
						adapter.notifyDataSetChanged();
					}else{
						items.get(position).setCollect(true);
						adapter.notifyDataSetChanged();
					}
				}
			});
			view.popularityText.setText("����:" + items.get(position).getPopularity());
			return convertView;
		}
		
	}
	
	private class listview_view{
		private TextView contentText;
		private RadioButton collectButton;
		private TextView popularityText;
	}
}