package lawrence.shuttle.to;

import javax.persistence.Table;


import javax.persistence.Column;

@Table(name = "Clipboard")
public class Clipboard {
	
	@Column(name = "clipboardsessionid")
	private String clipboardsessionid;
	@Column(name = "userid")
	private String userid;
	@Column(name = "longitude")
	private String longitude;
	@Column(name = "lattitude")
	private String lattiude;
	
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
	public String getLattiude() {
		return lattiude;
	}
	public void setLattiude(String lattiude) {
		this.lattiude = lattiude;
	}

}
