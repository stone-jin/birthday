package com.edu.bean;

import android.graphics.Bitmap;

public class Birth_listview_item {
	//id
	private int id;
	//ͷ��
	private Bitmap photo;
	//����
	private String name;
	//��
	private int mouth;
	//��
	private int day;
	//ʣ������
	private int residue;
	
	public Bitmap getPhoto() {
		return photo;
	}
	public void setPhoto(Bitmap photo) {
		this.photo = photo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMouth() {
		return mouth;
	}
	public void setMouth(int mouth) {
		this.mouth = mouth;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getResidue() {
		return residue;
	}
	public void setResidue(int residue) {
		this.residue = residue;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
