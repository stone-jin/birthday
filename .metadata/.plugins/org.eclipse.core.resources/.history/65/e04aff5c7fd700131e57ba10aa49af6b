package src.com.rcp.day;

import java.util.ArrayList;
import java.util.List;

import rcp.com.Item.smsItem;
import rcp.com.other.ActivityMeg;
import rcp.src.com.adapter.list_msg_adapter;
import src.com.rcp.Sql.SqlDatebase;
import src.com.rcp.Sql.sql_brith;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

/**
 * 
 * 短信内容
 * 
 * @author toshiba
 * 
 */
public class sms_info extends Activity {

	private Button back;

	private SqlDatebase sqlDatebase;

	private ListView listview;

	private sql_brith db;

	private list_msg_adapter msgAdapter;

	private List<smsItem> smsData;

	/** 单个短信的数量 **/
	private List<String> Num;

	/** 人气数据容器 **/
	private List<String> popularity;

	private int start;

	private int position;

	private String end;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.sms_info);
		ActivityMeg.getInstance().addActivity(this);
		getsmsData();
		dataInit();
		Num = getrenqi("ZSMSCATEGORY", "ZNUM");
		popularity = getrenqi("ZSMSCONTENT", "ZPOPULARITY");

		getsmmData();
		viewInit();
	}

	/***
	 * 
	 * 得到短信内容
	 * 
	 */
	public void getsmmData() {
		switch (start) {
		case 0:
			smsData = getSMSWish(getIndex(0), end);
			break;
		case 1:
			smsData = getSMSWish(getIndex(1), end);
			break;
		case 2:
			smsData = getSMSWish(getIndex(2), end);
			break;
		case 3:
			smsData = getSMSWish(getIndex(3), end);
			break;
		}
	}

	public String getIndex(int index) {

		boolean isadd = true;

		int temp1 = Integer.parseInt(Num.get(3));

		int temp2 = temp1 + Integer.parseInt(Num.get(4));

		int temp3 = temp2 + Integer.parseInt(Num.get(5));

		int count = 0;
		if (position == 0) {
			switch (index) {
			case 0: {
				int temp = Integer.parseInt(Num.get(6 + position));
				end = (count + temp) + "";
			}
				return "0";
			case 1: {
				int temp = Integer.parseInt(Num.get(39 + position));
				end = (temp2 + temp) + "";
			}
				return temp2 + "";

			case 2: {
				int temp = Integer.parseInt(Num.get(24 + position));
				end = (temp1 + temp) + "";
			}
				return temp1 + "";
			case 3: {
				int temp = Integer.parseInt(Num.get(51 + position));
				end = (temp3 + temp) + "";
			}
				return temp3 + "";

			}

		}

		int temp = 0;

		for (int i = 0; i < position; i++) {

			System.out.println("--------------------------------" + i);
			switch (index) {
			case 0:
				count += Integer.parseInt(Num.get(6 + i));
				temp = Integer.parseInt(Num.get(6 + position));

				break;
			case 1:

				if (isadd) {
					count = temp2;
					isadd = false;
				}
				count += (Integer.parseInt(Num.get(39 + i)));
				temp = Integer.parseInt(Num.get(39 + position));
				break;
			case 2:
				if (isadd) {
					count = temp1;
					isadd = false;
				}
				count += (Integer.parseInt(Num.get(24 + i)));
				temp = Integer.parseInt(Num.get(24 + position));
				break;
			case 3:
				if (isadd) {
					count = temp3;
					isadd = false;
				}
				count += (Integer.parseInt(Num.get(51 + i)));
				temp = Integer.parseInt(Num.get(51 + position));
				break;
			}
		}
		end = (count + temp) + "";
		System.out.println(temp + "------>" + count + "-----" + end);
		return count + "";
	}

	public void getsmsData() {
		Intent intent = getIntent();
		int radiobutton = intent.getIntExtra("radiobutton", -1);

		position = intent.getIntExtra("position", -1);

		start = radiobutton - R.id.sms_btn1;

		System.out.println(radiobutton + "    " + position + "---->>>" + start);
	}

	public void dataInit() {
		sqlDatebase = new SqlDatebase(this);
		db = new sql_brith(this);

	}

	public void viewInit() {
		back = (Button) this.findViewById(R.id.sms_info_back);
		back.setOnClickListener(onClickListener);
		listview = (ListView) this.findViewById(R.id.sms_info_listview);
		listview.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long id) {
				Intent intent = new Intent(sms_info.this, rcp_msg_wish.class);
				intent.putExtra("sms", smsData.get(position).getInfo());
				sms_info.this.startActivity(intent);
			}

		});
		msgAdapter = new list_msg_adapter(smsData, getLayoutInflater(), db);
		listview.setAdapter(msgAdapter);
	}

	OnClickListener onClickListener = new OnClickListener() {

		public void onClick(View v) {
			Intent intent = new Intent(sms_info.this,
					Rcp_birthdayActivity.class);
			sms_info.this.startActivity(intent);
		}

	};

	// ZPOPULARITY ZSMSCATEGORY
	public List<String> getrenqi(String tab, String str) {
		List<String> Num1 = new ArrayList<String>();
		Cursor cursor = sqlDatebase.sqLiteDatabase_sms.query(tab,
				new String[] { str }, null, null, null, null, null);

		// 游标下标归零
		cursor.moveToPosition(0);
		// 取游标中的值
		while (true) {
			// 判断是否在最后
			if (cursor.isAfterLast()) {
				break;
			}
			String str1 = cursor.getString(0);
			Num1.add(str1);
			cursor.moveToNext();
		}
		return Num1;
	}

	/***
	 * 得到短信祝福语
	 * 
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public List<smsItem> getSMSWish(String start, String end) {

		int index = Integer.parseInt(start);
		List<smsItem> data = new ArrayList<smsItem>();

		Cursor cursor = null;

		try {
			cursor = sqlDatebase.sqLiteDatabase_sms.query("ZSMSCONTENT",
					new String[] { "ZCONTENT" }, "ZCONTENT_ID" + ">?" + " and "
							+ "ZCONTENT_ID" + "<?",
					new String[] { start, end }, null, null, null);
			if (cursor != null) {
				// 游标下标归零
				cursor.moveToPosition(0);
				// 取游标中的值
				while (true) {
					// 判断是否在最后
					if (cursor.isAfterLast()) {
						break;
					}
					smsItem smsItem = new smsItem();
					String str = cursor.getString(0);
					smsItem.setInfo(str);
					String renqi = popularity.get(index);
					smsItem.setRenqi(renqi);
					/** 添加到数据容器 */
					data.add(smsItem);
					index++;
					cursor.moveToNext();
				}
			}
		} finally {
			if (cursor != null) {

				try {

					cursor.close();

				} catch (Exception e) {

					// ignore this

				}

			}

		}
		return data;
	}
}
