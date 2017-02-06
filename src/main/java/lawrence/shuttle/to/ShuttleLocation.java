package lawrence.shuttle.to;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name = "ShuttleLocation")
public class ShuttleLocation {
	  
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(name = "shuttleid")
	private String shuttleid;
	@Column(name = "lattitude")
	private int lattitude;
	@Column(name = "longitude")
	private int longitude;
	
	public String getShuttleid() {
		return shuttleid;
	}
	public void setShuttleid(String shuttleid) {
		this.shuttleid = shuttleid;
	}
	public int getLattitude() {
		return lattitude;
	}
	public void setLattitude(int lattitude) {
		this.lattitude = lattitude;
	}
	public int getLongitude() {
		return longitude;
	}
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	} 	

}
