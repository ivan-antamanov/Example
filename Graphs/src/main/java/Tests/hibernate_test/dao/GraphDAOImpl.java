package Tests.hibernate_test.dao;

import Tests.hibernate_test.model.GraphModel;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by iantaman on 26.11.2015.
 */
@Repository("graphDAOImpl")
public class GraphDAOImpl implements ModelDao<GraphModel> {

    private static final Logger logger = Logger.getLogger(GraphDAOImpl.class.getName());


    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public GraphDAOImpl() {
    }

    public GraphDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getCurrentSession(){
        return  sessionFactory.getCurrentSession();
    }

    @Override
    public GraphModel create(GraphModel entity) {
        logger.info("Try to create graph with name: " + entity.getName());
        getCurrentSession().persist(entity);
        logger.info("Graph with name: " + entity.getName() + " have saved successfully");
        return entity;
    }

    @Override
    public GraphModel read(Integer id) {
        return  null;
    }

    @Override
    public GraphModel update(GraphModel entity) {
        return null;
    }

    @Override
    public GraphModel delete(GraphModel entity) {
        return null;
    }

    @Override
    public GraphModel findByName(String name) {
        return null;
    }

    @Override
    public List<GraphModel> findAll() {
        return null;
    }

    @Override
    public List<GraphModel> listByName(String name) {
        return null;
    }
}
