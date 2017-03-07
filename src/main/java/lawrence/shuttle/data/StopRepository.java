package lawrence.shuttle.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import lawrence.shuttle.to.Stop;

public interface StopRepository extends JpaRepository<Stop, Long> {
	public Stop findStopByLatitudeAndLongitude(String latitude, String longitude);
	public Stop findByStopid(String stopid);
	@Modifying
    @Transactional
    @Query(value = "delete from Stop u where u.stopid = ?1")
    void deleteStopsByUserid(String stopid);
}
