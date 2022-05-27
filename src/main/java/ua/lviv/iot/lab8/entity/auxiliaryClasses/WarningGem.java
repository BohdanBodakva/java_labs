package ua.lviv.iot.lab8.entity.auxiliaryClasses;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WarningGem extends SuperGem {

    private String message;

    @JsonIgnore
    private Long id;

    public WarningGem(String message){
        this.message = message;
    }

    public WarningGem() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
