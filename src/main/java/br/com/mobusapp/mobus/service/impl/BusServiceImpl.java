package br.com.mobusapp.mobus.service.impl;

import br.com.mobusapp.mobus.model.Bus;
import br.com.mobusapp.mobus.service.BusService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService {

    public static List<Bus> busList = new ArrayList<>();

//    static {
//        Bus bus = new Bus();
//        bus.setId("1234");
//        bus.setMacAddress("TE:ST:EM:AC:01");
//        bus.setLatitude("-23.459006");
//        bus.setLongitude("-47.419220");
//        busList.add(bus);
//    }


    @Override
    public Bus findById(String id) {
        return busList.get(0);
    }
}
