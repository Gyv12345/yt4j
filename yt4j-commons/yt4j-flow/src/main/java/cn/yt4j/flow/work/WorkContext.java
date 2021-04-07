package cn.yt4j.flow.work;

/**
 * 工作上下文
 *
 * @author gyv12345@163.com
 */
public class WorkContext<T extends Object,E extends Object> {

    private T data;

    private E response;

    public WorkContext(T data,E response) {
        this.data = data;
        this.response=response;
    }

    public T getData() {
        return data;
    }

    public E getResponse() {
        return response;
    }

}
