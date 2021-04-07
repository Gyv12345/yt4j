package cn.yt4j.flow.work;

/**
 * @author gyv12345@163.com
 */
public abstract class AbstractWorkFlow implements WorkFlow{

    private String name;

    private String id;

    AbstractWorkFlow(String name,String id){
        this.name=name;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
