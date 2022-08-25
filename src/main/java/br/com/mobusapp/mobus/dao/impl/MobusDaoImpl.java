package br.com.mobusapp.mobus.dao.impl;

import br.com.mobusapp.mobus.dao.MobusDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class MobusDaoImpl implements MobusDao {

//    @Autowired
//    private SessionFactory sincSessionFactory;

    public Session getSession() {
//
        return null;
    }

}
