package Tests.hibernate_test.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by iantaman on 01.12.2015.
 */
public abstract class TransactionalFunction extends OperationModel {

    private SessionFactory sessionFactory;

    public TransactionalFunction(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void execute(){
        doWork(sessionFactory.openSession());
    }



    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
