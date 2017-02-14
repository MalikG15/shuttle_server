package lawrence.shuttle.to;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import javax.persistence.Column;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "Route")
public class Route {
	
	 @Id
	 @GenericGenerator(name = "uuid", strategy = "uuid2")
	 @GeneratedValue(generator = "uuid")
	 @Column(name = "routeid")
	 private String routeid;
	 @Column(name = "name") 
	 private String name;
	 @Column(name = "stops")
	 private String stops;
	 @Column(name = "description") 
	 private String description;
	 @Column(name = "assigned")
	 private String assigned;
	 
	public String getRouteid() {
		return routeid;
	}
	public void setRouteid(String routeid) {
		this.routeid = routeid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStops() {
		return stops;
	}
	public void setStops(String stops) {
		this.stops = stops;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAssigned() {
		return assigned;
	}
	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}


}
