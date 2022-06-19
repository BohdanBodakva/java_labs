package ua.lviv.iot.lab8.repository;

import org.springframework.data.repository.CrudRepository;

import ua.lviv.iot.lab8.entity.GemEntity;
import ua.lviv.iot.lab8.entity.PreciousGemEntity;

public interface GemRepo extends CrudRepository<PreciousGemEntity, Long> {
    PreciousGemEntity findByUniqueName(String uniqueName);
}
