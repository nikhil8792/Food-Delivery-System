package com.fooddelivery.model;

public class resturant {
	
private int resturantid;
private String name;
private String address;
private long phone;
private	float rating;
private	String cusineType;
private	boolean isactive;
private	String eta;
private	String adminuserid;
private	String imagepath;
	
	
	public resturant() {
		super();
		// TODO Auto-generated constructor stub
	}


	public resturant(int resturantid, String name, String address, long phone, float rating, String cusineType,
			boolean isactive, String eta, String adminuserid, String imagepath) {
		super();
		this.resturantid = resturantid;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.rating = rating;
		this.cusineType = cusineType;
		this.isactive = isactive;
		this.eta = eta;
		this.adminuserid = adminuserid;
		this.imagepath = imagepath;
	}


	public int getResturantid() {
		return resturantid;
	}


	public void setResturantid(int resturantid) {
		this.resturantid = resturantid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}


	public String getCusineType() {
		return cusineType;
	}


	public void setCuisineType(String cusineType) {
		this.cusineType=cusineType;
	}


	public boolean isIsactive() {
		return isactive;
	}


	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}


	public String getEta() {
		return eta;
	}


	public void setEta(String eta) {
		this.eta = eta;
	}


	public String getAdminuserid() {
		return adminuserid;
	}


	public void setAdminuserid(String adminuserid) {
		this.adminuserid = adminuserid;
	}


	public String getImagepath() {
		return imagepath;
	}


	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	@Override
    public String toString() {
        return "resturant {" +
                "ID=" + resturantid +
                ", Name='" + name + '\'' +
                ", Address='" + address + '\'' +
                ", Phone=" + phone +
                ", Rating=" + rating +
                ", Cuisine='" + cusineType + '\'' +
                ", Active=" + isactive +
                ", ETA='" + eta + '\'' +
                ", ImagePath='" + imagepath + '\'' +
                '}';
    }
	

}


