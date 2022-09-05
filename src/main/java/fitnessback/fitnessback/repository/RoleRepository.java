package fitnessback.fitnessback.repository;

import fitnessback.fitnessback.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {

    @Query("select r from Roles r where r.name= ?1")
    Roles findByRoleName(String name);
}















