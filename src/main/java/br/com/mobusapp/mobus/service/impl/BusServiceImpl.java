package br.com.mobusapp.mobus.service.impl;

import br.com.mobusapp.mobus.dao.BusDao;
import br.com.mobusapp.mobus.model.Bus;
import br.com.mobusapp.mobus.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusDao dao;

    public static List<Bus> busList = new ArrayList<>();

    @Override
    public BusDao getDao() {
        return this.dao;
    }
}
