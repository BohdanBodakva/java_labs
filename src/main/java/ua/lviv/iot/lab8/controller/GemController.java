package ua.lviv.iot.lab8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ua.lviv.iot.lab8.entity.PreciousGemEntity;
import ua.lviv.iot.lab8.entity.auxiliaryClasses.SuperGem;
import ua.lviv.iot.lab8.entity.auxiliaryClasses.WarningGem;
import ua.lviv.iot.lab8.exceptions.GemAlreadyExistsException;
import ua.lviv.iot.lab8.exceptions.GemNotFoundException;

import ua.lviv.iot.lab8.exceptions.SortNotFoundException;

import ua.lviv.iot.lab8.service.GemService;

import javax.ws.rs.*;

import java.util.Map;


@RestController
@Consumes("application/json")
@Produces("application/json")
@Path("/gem")
public class GemController {

    private GemService gemService;

    public GemController(GemService gemService){
        this.gemService = gemService;
    }

    @POST
    @Path("/")
    public String saveGem(@RequestBody PreciousGemEntity gem){
        try {
            return gemService.addGem(gem);
        }catch (SortNotFoundException | GemAlreadyExistsException ex) {
            return ex.getMessage();
        }
    }

    @GET
    @Path("/{id}")
    public ResponseEntity<SuperGem> showGemById(@PathParam(value = "id") Long id) {
        try {
            return new ResponseEntity<SuperGem>(HttpStatus.NOT_FOUND);
//            return new ResponseEntity<SuperGem>(gemService.getGemById(id), HttpStatus.OK);
        } catch (GemNotFoundException e) {
            return new ResponseEntity<SuperGem>(HttpStatus.NOT_FOUND);
//            return new WarningGem(e.getMessage());
        }
    }


    @GET
    @Path("/")
    public Map<Long, PreciousGemEntity> showAllGems(){
        return gemService.getAllGems();
    }

    @PUT
    @Path("/{id}")
    public String updateGemById(@RequestBody PreciousGemEntity gem, @PathParam(value = "id") Long id){
        try {
            return gemService.updateGemById(gem, id);
        } catch (GemNotFoundException e) {
            return e.getMessage();
        }
    }

    @DELETE
    @Path("/{id}")
    public String deleteGem(@PathParam(value = "id") Long id){
        try {
            return gemService.deleteGemById(id);
        } catch (GemNotFoundException e) {
            return e.getMessage();
        }
    }

    @DELETE
    @Path("/")
    public String deleteAllGems(){
        return gemService.deleteAllGems();
    }
}
