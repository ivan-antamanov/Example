package Tests.hibernate_test.dao;

import Tests.hibernate_test.model.Model;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by iantaman on 26.11.2015.
 */
@Component
public interface ModelDao<T extends Model> {

    T findByName(String name);

    List<T> findAll();

    List<T> listByName(String name);

    T create(T entity);

    T read(Integer id);

    T update(T entity);

    T delete(T entity);

}
