package br.com.mobusapp.mobus.dao;

import br.com.mobusapp.mobus.model.Bus;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

public interface BusDao extends GenericDao<Bus,String> {

    @Query("SELECT bus FROM Bus bus WHERE bus.macAddress = :mac")
    Bus findByMac(String mac);

}
