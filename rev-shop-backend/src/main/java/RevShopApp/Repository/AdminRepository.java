package RevShopApp.Repository;

import RevShopApp.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository <Admin, Long> {
}
