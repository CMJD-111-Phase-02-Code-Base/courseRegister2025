package lk.ijse.cmjd_111.CourseRegistration2025.service.impl;

import lk.ijse.cmjd_111.CourseRegistration2025.dto.Role;
import lk.ijse.cmjd_111.CourseRegistration2025.dto.UserDTO;
import lk.ijse.cmjd_111.CourseRegistration2025.service.AdminService;
import lk.ijse.cmjd_111.CourseRegistration2025.service.LecturerService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AdminServiceIMPL implements AdminService {


    @Override
    public UserDTO saveAdmin(UserDTO admin) {
        return null;
    }

    @Override
    public void deleteAdmin(String adminId) {

    }

    @Override
    public void updateAdmin(String adminId, UserDTO admin) {

    }

    @Override
    public UserDTO getSelectedAdmin(String adminId) throws Exception {
        var selectedAdmin = new UserDTO("ADM001", "Bimal",
                "Perera", "kamal@mail.com",
                "First Street", "Panadura South",
                "Panadura", "Panadura",
                "123", Role.ADMIN);
        if(adminId.equals(selectedAdmin.getUserId())){
            return selectedAdmin;
        }
        throw new Exception("Admin member not found");
    }

    @Override
    public List<UserDTO> getAllAdmins() {
        return Arrays.asList(
                new UserDTO("STU02", "Nimal",
                        "Fernando", "nimalf@mail.com",
                        "Lake Road", "Colombo 7",
                        "Colombo", "Colombo",
                        "abc123", Role.ADMIN),

                new UserDTO("STU03", "Sithara",
                        "Jayasinghe", "sithara.j@mail.com",
                        "Temple Lane", "Galle Fort",
                        "Galle", "Galle",
                        "pass456", Role.ADMIN),

                new UserDTO("STU04", "Ruwan",
                        "Silva", "ruwan.s@mail.com",
                        "Hill Street", "Kandy Central",
                        "Kandy", "Kandy",
                        "kandy321", Role.ADMIN),

                new UserDTO("STU05", "Dilani",
                        "Hettiarachchi", "dilani.h@mail.com",
                        "Marine Drive", "Negombo North",
                        "Negombo", "Negombo",
                        "negombo789", Role.ADMIN),

                new UserDTO("STU06", "Suresh",
                        "Wickramasinghe", "suresh.w@mail.com",
                        "Green Avenue", "Matara West",
                        "Matara", "Matara",
                        "matara123", Role.ADMIN)
        );
    }
}
