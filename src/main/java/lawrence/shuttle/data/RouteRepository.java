package lawrence.shuttle.data;

import org.springframework.data.jpa.repository.JpaRepository;
import lawrence.shuttle.to.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {
	public Route findByRouteid(String routeid);
}
