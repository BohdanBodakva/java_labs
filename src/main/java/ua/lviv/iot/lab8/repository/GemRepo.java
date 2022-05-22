package ua.lviv.iot.lab8.repository;

import org.springframework.data.repository.CrudRepository;
import ua.lviv.iot.lab8.entity.Gem;

public interface GemRepo extends CrudRepository<Gem, Long> {
    Gem findByUniqueName(String uniqueName);
}
