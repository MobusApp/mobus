package br.com.mobusapp.mobus.service.impl;

import br.com.mobusapp.mobus.dao.BusDao;
import br.com.mobusapp.mobus.model.Bus;
import br.com.mobusapp.mobus.model.dto.BusDTO;
import br.com.mobusapp.mobus.service.BusService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusDao dao;

    @Override
    public void updateGPS(String mac, String lat, String lng) {
        Bus bus = dao.findByMac(mac);
        if(bus == null){
            throw new RuntimeException("Onibus Não Encontrado");
        }
        bus.setLatitude(lat);
        bus.setLongitude(lng);
        dao.save(bus);
        System.out.println(bus);
    }

    @Override
    public List<BusDTO> findAll() {
        List<Bus> busList = dao.findAll();
        List<BusDTO> busDTOS = new ArrayList<>();

        busList.forEach(bus -> {
            BusDTO busDTO = new BusDTO();
            busDTO.toDto(bus);
            busDTOS.add(busDTO);
        });
        return busDTOS;
    }

    @Override
    public BusDTO findById(String id) {
        Bus bus = dao.findById(id).orElse(null);
        if(bus == null){
            throw new ObjectNotFoundException("Onibus não encontrado","Bus");
        }
        BusDTO dto = new BusDTO();
        dto.toDto(bus);
        return dto;
    }

    @Override
    public BusDao getDao() {
        return this.dao;
    }
}
