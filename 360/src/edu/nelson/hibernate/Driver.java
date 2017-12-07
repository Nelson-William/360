package edu.nelson.hibernate;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="driver")
public class Driver {

	@Id
	@GeneratedValue
	private Integer id;
	private String dname;
	private String dstate;
	private String session;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="register",
			joinColumns = {@JoinColumn(name="id")},
			inverseJoinColumns = @JoinColumn(name="vehicle_id")
			)
	private Set<Vehicle> vehicles;
	public Driver() {
		this.session = "";
	}
	
	@Override
	public String toString() {
		return "Driver{" +
				"id" + id +
				", dname='" + '\'' +
				", dstate='" + '\'' +
				", session='" + session + '\'' +
				'}';
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDstate() {
		return dstate;
	}
	public void setDstate(String dstate) {
		this.dstate = dstate;
	}
	public Set<Vehicle> getVehicles(){
		return vehicles;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}

}
