package br.com.mobusapp.mobus.dao;

import br.com.mobusapp.mobus.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusDao extends JpaRepository<Bus,String> {
}
