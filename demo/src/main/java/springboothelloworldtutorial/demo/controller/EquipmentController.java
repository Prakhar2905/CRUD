package springboothelloworldtutorial.demo.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboothelloworldtutorial.demo.exception.ResourceNotFoundException;
import springboothelloworldtutorial.demo.model.Equipment;
import springboothelloworldtutorial.demo.repository.EquipmentRepository;

@RestController
@RequestMapping("/api/v1")
public class EquipmentController {
    @Autowired
    private EquipmentRepository equipmentRepository;

    @GetMapping("/equipment")
    public List < Equipment > getAllEquipment() {
        return equipmentRepository.findAll();
    }

    @GetMapping("/equipment/{id}")
    public ResponseEntity < Equipment > getEquipmentById(@PathVariable(value = "id") Long equipmentId)
    throws ResourceNotFoundException {
    	Equipment equipment = equipmentRepository.findById(equipmentId)
            .orElseThrow(() -> new ResourceNotFoundException("Equipment not found for this id :: " + equipmentId));
        return ResponseEntity.ok().body(equipment);
    }

    @PostMapping("/equipment")
    public Equipment createEquipment(@Valid @RequestBody Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    @PutMapping("/equipment/{id}")
    public ResponseEntity < Equipment > updateEquipment(@PathVariable(value = "id") Long equipmentId,
        @Valid @RequestBody Equipment equipmentDetails) throws ResourceNotFoundException {
    	Equipment equipment = equipmentRepository.findById(equipmentId)
            .orElseThrow(() -> new ResourceNotFoundException("equipment not found for this id :: " + equipmentId));

    	equipment.setLength(equipmentDetails.getLength());
    	equipment.setThickness(equipmentDetails.getThickness());
    	equipment.setVolume(equipmentDetails.getVolume());
        final Equipment updatedEmployee = equipmentRepository.save(equipment);
        return ResponseEntity.ok(updatedEmployee);
    } 

    @DeleteMapping("/equipment/{id}")
    public Map < String, Boolean > deleteEquipment(@PathVariable(value = "id") Long equipmentId)
    throws ResourceNotFoundException {
    	Equipment equipment = equipmentRepository.findById(equipmentId)
            .orElseThrow(() -> new ResourceNotFoundException("equipment not found for this id :: " + equipmentId));

    	equipmentRepository.delete(equipment);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}