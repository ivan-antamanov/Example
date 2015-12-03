package Tests.hibernate_test.service;

import Tests.hibernate_test.dao.GraphDAOImpl;
import Tests.hibernate_test.dao.ModelDao;
import Tests.hibernate_test.model.GraphModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by iantaman on 26.11.2015.
 */

@Service("graphServiceImpl")
@Transactional //show that all method of this class are "transactional
public class GraphServiceImpl implements GraphService<GraphModel> {

    @Autowired
    @Qualifier("graphDAOImpl")
    private ModelDao<GraphModel> graphDAOIpl;

    public void setGraphDAOIpl(GraphDAOImpl graphDAOIpl) {
        this.graphDAOIpl = graphDAOIpl;
    }

    public GraphServiceImpl() {
    }

    public GraphServiceImpl(GraphDAOImpl graphDAOIpl) {
        this.graphDAOIpl = graphDAOIpl;
    }

    @Override
    public GraphModel create(String name) {
        //put validation like "is contain"
        GraphModel graphModel = new GraphModel(name);
        graphDAOIpl.create(graphModel);
        return graphModel;
    }

    @Override
    public GraphModel read(GraphModel entity) {
        return null;
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
    @Transactional
    public List<GraphModel> findAll() {
        return null;
    }

    @Override
    @Transactional
    public List<GraphModel> listByName(String name) {
        return null;
    }
}
