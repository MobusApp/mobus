package br.com.mobusapp.mobus.service;

import br.com.mobusapp.mobus.dao.GenericDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericService<T,ID> {
    public <DAO extends JpaRepository<T,ID>> DAO getDao();
}
