package com.BootCampAcademy.demo.repository;
import com.BootCampAcademy.demo.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName (String name);

}
