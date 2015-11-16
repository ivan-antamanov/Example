package graph.domain;

/**
 * Created by iantaman on 06.11.2015.
 */
public class NodeReference {

    private Integer source;
    private Integer target;

    public NodeReference() {
    }

    public NodeReference(Integer source, Integer target) {
        this.source = source;
        this.target = target;
    }

    @Override
    public String toString() {
        return "source=" + source + "--> target=" + target;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }
}
