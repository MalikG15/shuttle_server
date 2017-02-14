package lawrence.shuttle.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import lawrence.shuttle.to.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {
	public Route findByRouteid(String routeid);
	@Modifying
    @Transactional
    @Query(value = "delete from Route u where u.routeid = ?1")
	public void deleteRouteByRouteid(String routeid);
}
