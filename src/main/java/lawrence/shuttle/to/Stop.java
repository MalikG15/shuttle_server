package lawrence.shuttle.to;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import javax.persistence.Column;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Stop")
public class Stop {
	
	 @Id
	 @GenericGenerator(name = "uuid", strategy = "uuid2")
	 @GeneratedValue(generator = "uuid")
	 @Column(name = "stopid")
	 private String stopid;
	 @Column(name = "name") 
	 private String name;
	 @Column(name = "address")
	 private String address;
	 @Column(name = "lattitude") 
	 private int lattitude;
	 @Column(name = "longitude")
	 private String longitude;
	 
	public String getStopid() {
		return stopid;
	}
	public void setStopid(String stopid) {
		this.stopid = stopid;
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
	public int getLattitude() {
		return lattitude;
	}
	public void setLattitude(int lattitude) {
		this.lattitude = lattitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


}
