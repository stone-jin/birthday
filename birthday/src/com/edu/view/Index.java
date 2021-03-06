package com.edu.view;

import com.edu.interface1.OnIndex;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class Index extends View {
	
	//索引数据
	private String text[] = new String[27];
	private Paint paint;
	//索引字体的间距
	private int separation;
	private OnIndex onIndex;

	//构造函数
	public Index(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
		dateInit();
	}

	public Index(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		dateInit();
	}

	public Index(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		dateInit();
	}

	private void dateInit(){
		for(int i = 0; i < 27; i++){
			if(i == 0){
				text[i] = "#";
			}else{
				text[i] = (char)(64 + i) + "";
			}
		}
	}

	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.draw(canvas);
		paint = new Paint();
		paint.setTextSize(15.0f);
		paint.setColor(0xff000000);
		separation = this.getHeight() / 27;
		int width = this.getWidth();
		for(int i = 0; i < 27; i++){
			canvas.drawText(text[i], (width - getFontWidth(text[i]))/2, separation * i + separation / 2, paint);
		}
	}
	
	//获得字体宽度
	private int getFontWidth(String str){
		return (int)(paint.measureText(str));
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
		case MotionEvent.ACTION_MOVE:
			float y = event.getY();
			int index = (int)(y / separation);
			if(index < 0)
				index =0;
			if(index >= text.length){
				index = text.length - 1;
			}
			String str = text[index];
			if(onIndex != null){
				onIndex.onIndexSelect(str);
			}
			break;
		case MotionEvent.ACTION_UP:
			if(onIndex != null){
				onIndex.onIndexUp();
			}
			break;
		}
		return true;
	}

	public OnIndex getOnIndex() {
		return onIndex;
	}

	public void setOnIndex(OnIndex onIndex) {
		this.onIndex = onIndex;
	}
}
