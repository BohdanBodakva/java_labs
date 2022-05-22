package ua.lviv.iot.lab8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.lab8.entity.Gem;
import ua.lviv.iot.lab8.repository.GemRepo;

@RestController
@RequestMapping("/gems")
public class GemController {

    @Autowired
    private GemRepo gemRepo;

    @PostMapping
    public ResponseEntity saveGem(@RequestBody Gem gem){
        try {
            if(gemRepo.findByUniqueName(gem.getUniqueName()) != null){
                return ResponseEntity.badRequest().body("Gem with such name already exists");
            }
            gemRepo.save(gem);
            return ResponseEntity.ok("Gem was saved");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Oops, gem was not saved");
        }
    }

    @GetMapping
    public ResponseEntity getGems(){
        try {
            return ResponseEntity.ok("Server is successfully running");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Oops, something went wrong");
        }
    }
}
