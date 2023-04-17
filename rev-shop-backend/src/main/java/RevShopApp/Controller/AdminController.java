package RevShopApp.Controller;

import RevShopApp.Model.Admin;
import RevShopApp.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    AdminService adminService;

    @Autowired
    AdminController (AdminService adminService)  {
        this.adminService = adminService;
    }

    @GetMapping("admin")
    public ResponseEntity<List<Buyer, Retailer>> getAllAccounts() {
        return this.adminService.getAllAccounts();
    }

    @PatchMapping("admin")
    public ResponseEntity<?> updateBlockedAccount (@RequestBody Admin admin) {
        return this.adminService.updateBlockedAccount(admin);
    }

    @GetMapping("admin/{id}")
    public ResponseEntity<?> viewComplaintsByUser (@RequestBody Admin admin) {
        return this.adminService.viewComplaintByUser(admin);
    }

    @GetMapping("admin")
    public ResponseEntity<?> viewRegistrationBySellers (@RequestBody Admin admin) {
        return this.adminService.viewRegistrationBySellers(admin);
    }
}
