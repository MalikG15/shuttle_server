package lawrence.shuttle.data;

import org.springframework.data.jpa.repository.JpaRepository;
import lawrence.shuttle.to.Stop;

public interface StopRepository extends JpaRepository<Stop, Long> {
	public Stop findByStopid(String stopid);
}
