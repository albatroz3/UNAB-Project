package project.reto345.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.reto345.model.Admin;
import project.reto345.repository.AdminRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll() {
        return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id) {
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin admin) {
        if (admin.getIdAdmin() == null) {
            return adminRepository.save(admin);
        } else {
            Optional<Admin> aux = adminRepository.getAdmin(admin.getIdAdmin());
            if (aux.isPresent()) {
                return admin;
            } else {
                return adminRepository.save(admin);
            }
        }
    }
    public Admin update(Admin admin){
        if (admin.getIdAdmin() != null){
            Optional<Admin> c = adminRepository.getAdmin(admin.getIdAdmin());
            if (c.isPresent()){
                if (admin.getName() != null){
                    c.get().setName(admin.getName());
                }
                if (admin.getEmail() != null){
                    c.get().setEmail(admin.getEmail());
                }
                if (admin.getPassword() != null){
                    c.get().setPassword(admin.getPassword());
                }
                adminRepository.save(c.get());
                return c.get();
            }else {
                return admin;
            }
        }else{
            return admin;
        }
    }
    public boolean delete(int id) {
        boolean flag = false;
        Optional<Admin> c = adminRepository.getAdmin(id);
        if (c.isPresent()) {
            adminRepository.delete(c.get());
        }
        return flag;
    }
}
