package br.com.mobusapp.mobus.model.dto;

import br.com.mobusapp.mobus.model.Bus;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class BusDTO {

    private String id;
    private String macAddress;
    private String busLine;
    private String latitude;
    private String longitude;

    public void toDto(Bus entity){
        this.id = entity.getId();
        this.macAddress = entity.getMacAddress();
        this.busLine = entity.getBusLine();
        this.latitude = entity.getLatitude();
        this.longitude = entity.getLongitude();
    }
}
