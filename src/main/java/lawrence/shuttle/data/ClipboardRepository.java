package lawrence.shuttle.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import lawrence.shuttle.to.Clipboard;

public interface ClipboardRepository extends JpaRepository<Clipboard, Long> {
	public Clipboard findByUserid(String userid);
	//public void dele
	@Modifying
    @Transactional
    @Query(value = "delete from Clipboard u where u.userid = ?1")
    void deleteUsersByUserid(String userid);
}
