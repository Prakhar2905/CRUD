package springboothelloworldtutorial.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboothelloworldtutorial.demo.model.Equipment;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}

