package lawrence.shuttle.to;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.sql.Date;

import javax.persistence.Column;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ClipboardSession")
public class ClipboardSession {
	
	 @Id
	 @GenericGenerator(name = "uuid", strategy = "uuid2")
	 @GeneratedValue(generator = "uuid")
	 @Column(name = "clipboardsessionid")
	 private String clipboardsessionid;
	 @Column(name = "drivernamae")
	 private String drivername;
	 @Column(name = "count") 
	 private String count;
	 @Column(name = "date")
	 private Date date;
	 @Column(name = "driverid")
	 private String driverid;
	 
	public String getClipboardsessionid() {
		return clipboardsessionid;
	}
	public void setClipboardsessionid(String clipboardsessionid) {
		this.clipboardsessionid = clipboardsessionid;
	}
	public String getDrivername() {
		return drivername;
	}
	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDriverid() {
		return driverid;
	}
	public void setDriverid(String driverid) {
		this.driverid = driverid;
	}

}
