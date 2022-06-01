package ua.lviv.iot.lab8.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import org.yaml.snakeyaml.util.EnumUtils;
import ua.lviv.iot.lab5_6.Gem.Gem;
import ua.lviv.iot.lab8.entity.GemEntity;
import ua.lviv.iot.lab8.entity.PreciousGemEntity;
import ua.lviv.iot.lab8.entity.SortOfPreciousGemEntity;
import ua.lviv.iot.lab8.exceptions.GemAlreadyExistsException;
import ua.lviv.iot.lab8.exceptions.GemNotFoundException;

import ua.lviv.iot.lab8.exceptions.SortNotFoundException;
import ua.lviv.iot.lab8.repository.GemRepo;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.*;


@Service
public class GemService {

    private GemRepo gemRepo;

    @Autowired
    public GemService(GemRepo gemRepo){
        this.gemRepo = gemRepo;
    }

    public String addGem(PreciousGemEntity gem) throws GemAlreadyExistsException, SortNotFoundException {
        if(gemRepo.findByUniqueName(gem.getUniqueName()) != null){
            throw new GemAlreadyExistsException("Gem with such name already exists!");
        }
        for (SortOfPreciousGemEntity sort : SortOfPreciousGemEntity.values()){
            if(sort.equals(gem.getSort())){
                gemRepo.save(gem);
                return "Gem was saved";
            }
        }
        throw new SortNotFoundException("There is no such sort of precious gem!");
    }

    public GemEntity getGemById(Long id) throws GemNotFoundException {
        Optional<PreciousGemEntity> opt = gemRepo.findById(id);
        if(opt.isEmpty()){
            throw new GemNotFoundException("There is no gem with id=" + id);
        }
        GemEntity gem = gemRepo.findById(id).get();
        return gem;
    }

    public Map<Long, PreciousGemEntity> getAllGems(){
        List<PreciousGemEntity> gemList = (List<PreciousGemEntity>) gemRepo.findAll();
        Map<Long, PreciousGemEntity> gemMap = new HashMap<>();
        for(PreciousGemEntity gem : gemList){
            gemMap.put(gem.getId(), gem);
        }
        return gemMap;
    }

    public String updateGemById(PreciousGemEntity gem, Long id) throws GemNotFoundException {

        Optional<PreciousGemEntity> opt = gemRepo.findById(id);
        if(opt.isEmpty()){
            throw new GemNotFoundException("There is no gem with such id!");
        }

        PreciousGemEntity updatedGem = gemRepo.findById(id).get();
        updatedGem.setId(id);
        updatedGem.setUniqueName(gem.getUniqueName());
        updatedGem.setWeight(gem.getWeight());
        updatedGem.setPrice(gem.getPrice());
        updatedGem.setHardness(gem.getHardness());
        updatedGem.setPurity(gem.getPurity());
        updatedGem.setSort(gem.getSort());
        updatedGem.setMineral(gem.isMineral());
        gemRepo.save(updatedGem);

        return "Gem with id=" + id + " was updated successfully";
    }

    public String deleteGemById(Long id) throws GemNotFoundException {
        Optional<PreciousGemEntity> opt = gemRepo.findById(id);

        if(opt.isEmpty()){
            throw new GemNotFoundException("There is no gem with such id!");
        }

        gemRepo.deleteById(id);
        return "Gem with id=" + id + " was successfully deleted";
    }

    public String deleteAllGems(){
        gemRepo.deleteAll();
        return "All gems were successfully deleted";
    }



}
