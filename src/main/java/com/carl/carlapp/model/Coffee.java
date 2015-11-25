package com.carl.carlapp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="coffee")
public class Coffee {
	String name;
	int quality;
	public Coffee(String name, int quality) {
		this.name = name;
		this.quality = quality;
	}
	public Coffee() {
	}
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public int getQuality() {
		return quality;
	}
	@XmlElement
	public void setQuality(int quality) {
		this.quality = quality;
	}
	

}
