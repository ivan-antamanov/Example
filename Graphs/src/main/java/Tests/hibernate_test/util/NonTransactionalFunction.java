package Tests.hibernate_test.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by iantaman on 01.12.2015.
 */
@EnableTransactionManagement
public abstract class NonTransactionalFunction extends OperationModel {

    private SessionFactory sessionFactory;

    public NonTransactionalFunction(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void execute() {
        doWork(sessionFactory.openSession());
    }

}
