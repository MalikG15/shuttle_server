package lawrence.shuttle.data;

import org.springframework.data.jpa.repository.JpaRepository;
import lawrence.shuttle.to.*;

public interface ShuttleLocationRepository extends JpaRepository<ShuttleLocation, Long> {
	  int findLattitudeByshuttleid(String shuttleid);
	  int findLongitudeByshuttleid(String shuttleid);
}
