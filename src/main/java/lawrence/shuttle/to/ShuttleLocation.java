package lawrence.shuttle.to;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name = "ShuttleLocation")
public class ShuttleLocation {
	  
	@Id
	private int id;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	  	

}
