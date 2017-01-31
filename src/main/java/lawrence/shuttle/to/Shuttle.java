package lawrence.shuttle.to;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Shuttle")
public class Shuttle {
	
	 @Id
	 @GenericGenerator(name = "uuid", strategy = "uuid2")
	 @GeneratedValue(generator = "uuid")
	 @Column(name = "shuttleid")
	 private String shuttleid;
	 @Column(name = "shuttlename")
	 private String shuttlename;
	
	 public String getShuttleid() {
		return shuttleid;
	 }
	
	public void setShuttleid(String shuttleid) {
		this.shuttleid = shuttleid;
	}
	
	public String getShuttlename() {
		return shuttlename;
	}
	public void setShuttlename(String shuttlename) {
		this.shuttlename = shuttlename;
	}


}
