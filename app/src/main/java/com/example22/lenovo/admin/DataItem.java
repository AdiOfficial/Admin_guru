package com.example22.lenovo.admin;

import com.google.gson.annotations.SerializedName;


public class DataItem{

	@SerializedName("jp_harga")
	private String jpHarga;

	@SerializedName("jp_nama")
	private String jpNama;

	@SerializedName("jp_jenjang")
	private String jpJenjang;

	@SerializedName("jp_id")
	private String jpId;

	public void setJpHarga(String jpHarga){
		this.jpHarga = jpHarga;
	}

	public String getJpHarga(){
		return jpHarga;
	}

	public void setJpNama(String jpNama){
		this.jpNama = jpNama;
	}

	public String getJpNama(){
		return jpNama;
	}

	public void setJpJenjang(String jpJenjang){
		this.jpJenjang = jpJenjang;
	}

	public String getJpJenjang(){
		return jpJenjang;
	}

	public void setJpId(String jpId){
		this.jpId = jpId;
	}

	public String getJpId(){
		return jpId;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"jp_harga = '" + jpHarga + '\'' + 
			",jp_nama = '" + jpNama + '\'' + 
			",jp_jenjang = '" + jpJenjang + '\'' + 
			",jp_id = '" + jpId + '\'' + 
			"}";
		}
}