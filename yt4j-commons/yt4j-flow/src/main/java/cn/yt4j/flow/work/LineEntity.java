package cn.yt4j.flow.work;

import lombok.Data;

/**
 * @author gyv12345@163.com
 */
@Data
public class LineEntity {

    /**
     * 连线标题
     */
    private String label;
    /**
     * 上级节点
     */
    private String from;
    /**
     * 到哪个节点
     */
    private String to;
    /**
     * 条件
     */
    private String condition;
}
