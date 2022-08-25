package br.com.mobusapp.mobus.dao.impl;

import br.com.mobusapp.mobus.dao.MobusLoginDao;
import br.com.mobusapp.mobus.model.Login;
import org.springframework.stereotype.Repository;

@Repository
public class MobusLoginDaoImpl extends GenericDaoImpl<Login,Integer> implements MobusLoginDao {
}
