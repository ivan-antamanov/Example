package Tests.hibernate_test.service;

import Tests.hibernate_test.model.Model;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by iantaman on 26.11.2015.
 */
@Component
public interface GraphService<T extends Model> {

    T findByName(String name);

    List<T> findAll();

    List<T> listByName(String name);

    T create(String name);

    T read(T entity);

    T update(T entity);

    T delete(T entity);

}
