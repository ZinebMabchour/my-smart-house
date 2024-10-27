package com.example.smarthouse.Controller;
import com.example.smarthouse.bean.Appareil;
import com.example.smarthouse.service.AppareilService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Target;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appareils")
public class AppareilController {

    @Autowired
    private AppareilService appareilService;

    @PostMapping()
    public int save(@RequestBody Appareil appareil) {
        return appareilService.save(appareil);
    }
    @GetMapping("id/{id}")
    public Optional<Appareil> findById(@PathVariable Long aLong) {
        return appareilService.findById(aLong);
    }
     @DeleteMapping("id/{id}")
    public void deleteById(Long aLong) {
        appareilService.deleteById(aLong);
    }
     @GetMapping()
    public List<Appareil> findAll(Sort sort) {
        return appareilService.findAll(sort);
    }
    @PutMapping("/switchOntoOff/{id}")
    public ResponseEntity<Integer> switchOntoOff(@PathVariable Long id) {
        int result = appareilService.switchOntoOff(id);
        if (result == 1) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PutMapping("/switchOfftoOn/{id}")
    public ResponseEntity<Integer> switchOfftoOn(@PathVariable Long id) {
        int result = appareilService.switchOfftoOn(id);
        if (result == 1) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PutMapping("/switchAllOn")
    public ResponseEntity<Integer> switchAllOn() {
        int result = appareilService.switchAllOn();
        return ResponseEntity.ok(result);
    }

    @PutMapping("/switchAllOff")
    public ResponseEntity<Integer> switchAllOff() {
        int result = appareilService.switchAllOff();
        return ResponseEntity.ok(result);
    }
}
