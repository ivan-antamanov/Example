package Tests.hibernate_test.util;

import org.hibernate.Session;

/**
 * Created by iantaman on 01.12.2015.
 */
public abstract class OperationModel {

    public abstract void doWork(Session session);
    protected abstract void execute();

}
