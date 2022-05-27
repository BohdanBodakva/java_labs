package ua.lviv.iot.lab8.entity;

import javax.persistence.*;


@Entity
public class PreciousGemEntity extends GemEntity {

    @Enumerated(EnumType.STRING)
    private SortOfPreciousGemEntity sort;
    private boolean isMineral;

    public SortOfPreciousGemEntity getSort() {
        return sort;
    }

    public void setSort(SortOfPreciousGemEntity sort) {
        this.sort = sort;
    }

    public boolean isMineral() {
        return isMineral;
    }

    public void setMineral(boolean isMineral) {
        this.isMineral = isMineral;
    }

    public PreciousGemEntity(){
    }

}
