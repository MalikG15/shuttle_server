package lawrence.shuttle.to;

import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name = "Clipboard")
public class Clipboard {
	
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(name = "clipboardid")
	private String clipboardid;
	@Column(name = "clipboardsessionid")
	private String clipboardsessionid;
	@Column(name = "userid")
	private String userid;
	@Column(name = "longitude")
	private String longitude;
	@Column(name = "latitude")
	private String latitude;
	
	public String getClipboardsessionid() {
		return clipboardsessionid;
	}
	public void setClipboardsessionid(String clipboardsessionid) {
		this.clipboardsessionid = clipboardsessionid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String lattiude) {
		this.latitude = lattiude;
	}
	public String getClipboardid() {
		return clipboardid;
	}
	public void setClipboardid(String clipboardid) {
		this.clipboardid = clipboardid;
	}

}
