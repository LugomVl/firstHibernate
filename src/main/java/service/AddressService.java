package service;

import bl.SessionUtil;
import dao.AddressDAO;
import entity.Address;
import org.hibernate.Session;
import org.hibernate.query.Query;


import java.util.List;

public class AddressService extends SessionUtil implements AddressDAO {
    @Override
    public void add(Address address) {
        openTransactionSession();
        Session session = getSession();
        session.save(address);

        closeTransactionSession();
    }

    @Override
    public List<Address> getAll() {
        openTransactionSession();

        String sql = "SELECT * FROM ADDRESS";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        List<Address> addresses = query.list();
        return addresses;
    }

    @Override
    public Address getById(Long id) {
        openTransactionSession();

        String sql = "SELECT * FROM ADDRESS WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        query.setParameter("id", id);

        Address address = (Address) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return address;
    }

    @Override
    public void update(Address address) {
        openTransactionSession();

        Session session = getSession();
        session.update(address);

        //close session with a transaction
        closeTransactionSession();
    }

    @Override
    public void remove(Address address) {
        openTransactionSession();

        Session session = getSession();
        session.remove(address);

        //close session with a transaction
        closeTransactionSession();
    }
}
