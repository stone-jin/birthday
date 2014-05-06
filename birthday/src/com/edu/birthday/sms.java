package com.edu.birthday;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class sms extends Activity {
	//View�ؼ�
	private GridView sms_gridview;
	
	//һ�����
	private final int SMS_RadioButtonID[] = {R.id.sms_radiobutton1, R.id.sms_radiobutton2, R.id.sms_radiobutton3, R.id.sms_radiobutton4};
	private RadioButton SMS_RadioButton[] = new RadioButton[4];
	private final int a_img[] = {
			R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8,
			R.drawable.a9, R.drawable.a10, R.drawable.a11, R.drawable.a12, R.drawable.a13, R.drawable.a14, R.drawable.a15, R.drawable.a16, R.drawable.a17, R.drawable.a18
	};
	private final String a_name[] = {
			"����", "�ְ�", "����", "�Ϲ�", "����", "ֿ��", "����", "ͬ��", "ͬѧ", "��ʦ", "�쵼", "Ա��", "�ͻ�", "����", "��", "�ֵ�", "����", "����"
	};
	private final int b_img[] = {
			R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4, R.drawable.b5, R.drawable.b6, R.drawable.b7, R.drawable.b8,
			R.drawable.b9, R.drawable.b10, R.drawable.b11
	};
	private final String b_name[] = {
			"����", "����", "Ӣ��", "����", "����", "��������", "��������", "����", "����", "������", "����"
	};
	private final int c_img[] = {
			R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5, R.drawable.c6, R.drawable.c7, R.drawable.c8,
			R.drawable.c9, R.drawable.c10, R.drawable.c11, R.drawable.c12, R.drawable.c13, R.drawable.c14, R.drawable.c15
	};
	private final String c_name[] = {
			"��������", "��Ĭ��Ц", "Ϭ������", "����ף��", "�ٵ��Ҹ�", "��ܰף��", "��ͷʫ", "ף��ʫ", "ʫ�ʷ�", "���ն���", "��ɫ��¼", "Ӱ�Ӿ���", "��澭��", "����ף��", "���Իظ�"
	};
	private final int d_img[] = {
			R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4, R.drawable.d5, R.drawable.d6, R.drawable.d7, R.drawable.d8,
			R.drawable.d9, R.drawable.d10, R.drawable.d11, R.drawable.d12, R.drawable.d13, R.drawable.d14, R.drawable.d15, R.drawable.d16
		};
	private final String d_name[] = {
			"���˽�", "Ԫ����", "����", "Ԫ����", "���˽�", "���˽�", "ĸ�׽�", "��ͯ��", "���׽�", "�����", "��Ϧ��", "��ʦ��", "�����", "�����", "�����", "ʥ����" 
	};
	
	private List<RadioButtonStyle> items = new ArrayList<sms.RadioButtonStyle>();
	private Sms_GriviewAdapter sms_gridviewAdapter;
	private int locationx,locationy;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sms);
		viewdateInit(1,1);
		viewInit();
	}
	
	private void viewdateInit(int x, int y){
		locationx = x;
		locationy = y;
		items.clear();
		if(locationx == 1){
			for(int i = 0; i < a_img.length; i++){
				RadioButtonStyle item = new RadioButtonStyle();
				item.setId(a_img[i]);
				item.setName(a_name[i]);
				item.setX(locationx);
				item.setY(locationy);
				items.add(item);
				locationy++;
			}
		}else if(locationx == 2){
			for(int i = 0; i < b_img.length; i++){
				RadioButtonStyle item = new RadioButtonStyle();
				item.setId(b_img[i]);
				item.setName(b_name[i]);
				item.setX(locationx);
				item.setY(locationy);
				items.add(item);
				locationy++;
			}
		}else if(locationx == 3){
			for(int i = 0; i < c_img.length; i++){
				RadioButtonStyle item = new RadioButtonStyle();
				item.setId(c_img[i]);
				item.setName(c_name[i]);
				item.setX(locationx);
				item.setY(locationy);
				items.add(item);
				locationy++;
			}
		}else if(locationx == 4){
			for(int i = 0; i < d_img.length; i++){
				RadioButtonStyle item = new RadioButtonStyle();
				item.setId(d_img[i]);
				item.setName(d_name[i]);
				item.setX(locationx);
				item.setY(locationy);
				items.add(item);
				locationy++;
			}
		}
	}
	
	private void viewInit(){
		for(int i = 0; i < 4; i++){
			SMS_RadioButton[i] = (RadioButton) this.findViewById(SMS_RadioButtonID[i]);
			SMS_RadioButton[i].setOnClickListener(onClickListener);
		}
		SMS_RadioButton[0].setChecked(true);
		sms_gridviewAdapter = new Sms_GriviewAdapter();
		sms_gridview = (GridView) this.findViewById(R.id.sms_gridview);
		sms_gridview.setAdapter(sms_gridviewAdapter);
		sms_gridview.setOnItemClickListener(oncItemClickListener);
	}
	
	OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.sms_radiobutton1:
				viewdateInit(1, 1);
				sms_gridviewAdapter.notifyDataSetChanged();
				break;
			case R.id.sms_radiobutton2:
				viewdateInit(2, 1);
				sms_gridviewAdapter.notifyDataSetChanged();
				break;
			case R.id.sms_radiobutton3:
				sms_gridviewAdapter.notifyDataSetChanged();
				viewdateInit(3, 1);
				break;
			case R.id.sms_radiobutton4:
				sms_gridviewAdapter.notifyDataSetChanged();
				viewdateInit(4, 1);
				break;
			}
		}
	};
	
	OnItemClickListener oncItemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			RadioButtonStyle item = items.get(position);
			Intent intent = new Intent(sms.this, sms_info.class);
			intent.putExtra("locationx", item.getX());
			intent.putExtra("locationy", item.getY());
			startActivity(intent);
		}
		
	};
	
	public class Sms_GriviewAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return items.size();
		}

		@Override
		public RadioButtonStyle getItem(int position) {
			// TODO Auto-generated method stub
			return items.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			SMS_gridview_view view;
			if(convertView == null){
				convertView = getLayoutInflater().inflate(R.layout.sms_gridview_item, null);
				view = new SMS_gridview_view();
				view.image = (ImageView) convertView.findViewById(R.id.sms_gridview_item_image);
				view.textview = (TextView) convertView.findViewById(R.id.sms_gridview_item_textview);
				convertView.setTag(view);
			}else{
				view = (SMS_gridview_view) convertView.getTag();
			}
			view.image.setBackgroundResource(items.get(position).getId());
			view.textview.setText(items.get(position).getName());
			return convertView;
		}
		
	}
	
	public class SMS_gridview_view{
		public ImageView image;
		public TextView textview; 
	}
	
	public class RadioButtonStyle{
		int x;
		int y;
		String name;
		int id;
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
	}
}
