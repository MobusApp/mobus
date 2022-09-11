package br.com.mobusapp.mobus.service;

import br.com.mobusapp.mobus.model.Bus;
import br.com.mobusapp.mobus.model.dto.BusDTO;

import java.util.List;

public interface BusService extends GenericService<Bus,String>{
    void updateGPS(String mac, String lat, String lng);

    List<BusDTO> findAll();

    BusDTO findById(String id);
}
