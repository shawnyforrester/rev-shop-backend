package RevShopApp.Service;

import RevShopApp.Model.Admin;
import RevShopApp.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AdminService {
    AdminRepository adminRepository;
    @Autowired
    AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    public ResponseEntity<List<Buyer,Retailer>> getAllAccounts() {
        return new ResponseEntity<>(this.adminRepository.finall(), HttpStatus.OK);

    }

    public ResponseEntity<?> updateBlockedAccount(Admin admin) {
    }

    public ResponseEntity<?> viewComplaintByUser(Admin admin) {
    }

    public ResponseEntity<?> viewRegistrationBySellers(Admin admin) {
    }
}
