/**
 * 
 */
package com.backend.restbackend.user.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sk Saddam Hosan
 *27-Mar-20184:30:54 PM
 */
@Entity
@Table(name ="markers")
public class DistanceClass {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	private String name;
	private String address;
	private double lat;
	private double lng;
	public DistanceClass() {}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Distance [Id=" + Id + ", name=" + name + ", address=" + address + ", lat=" + lat + ", lng=" + lng + "]";
	}
	
	/**
	 * @param name
	 * @param address
	 * @param lat
	 * @param lng
	 */
	public DistanceClass(String name, String address, double lat, double lng) {
		super();
		this.name = name;
		this.address = address;
		this.lat = lat;
		this.lng = lng;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the lat
	 */
	public double getLat() {
		return lat;
	}
	/**
	 * @param lat the lat to set
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}
	/**
	 * @return the lng
	 */
	public double getLng() {
		return lng;
	}
	/**
	 * @param lng the lng to set
	 */
	public void setLng(double lng) {
		this.lng = lng;
	}
	
	
	

}
