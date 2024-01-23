package tw.com.eeit.project;

import java.io.Serializable;

public class Factory implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String area;
	private String city;
	private String name;
	private String address;
	private String phone;
	private String website;
	
	public Factory() {
		
	}
	
	public Factory(String area, String city,  String address, String phone, int id) {
		this.area = area;
		this.city = city;
		this.address = address;
		this.phone = phone;
		this.id = id;
	}
	
	
	public Factory(String area, String city, String name, String address, String phone, String website) {
		this.area = area;
		this.city = city;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.website = website;
	}
	
	public Factory(int id, String area, String city, String name, String address, String phone, String website) {
		this.id = id;
		this.area = area;
		this.city = city;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.website = website;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}
