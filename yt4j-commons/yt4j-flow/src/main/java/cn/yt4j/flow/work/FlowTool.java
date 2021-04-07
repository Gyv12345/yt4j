package cn.yt4j.flow.work;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author gyv12345@163.com
 */
@Slf4j
@Component
public class FlowTool {

    private Map<String, RuleWorkFlow> flows = new ConcurrentHashMap<>();

    public RuleWorkFlow getByName(String name) throws IOException {
        if (flows.containsKey(name)) {
            return flows.get(name);
        } else {
            String filePath = String.format("flow/"+name + "%s", ".json");
            ClassPathResource resource = new ClassPathResource(filePath);

            String flowJson = getStringFromInputStream(resource.getInputStream());
            FlowEntity entity = JSONUtil.toBean(flowJson, FlowEntity.class);
            RuleWorkFlow rootFlow=buildByEntity(entity);
            this.flows.put(rootFlow.getName(),rootFlow);
            return rootFlow;
        }
    }

    /**
     * //        NodeEntity startNode = entity.getNodes().stream().filter(node -> "start".equals(node.getType())).findFirst().get();
     * //        RuleWorkFlow startFlow = RuleWorkFlow.builder().id(startNode.getId()).name(startNode.getName()).beanId(startNode.getBeanId()).build();
     * @param entity
     * @return
     */
    private RuleWorkFlow buildByEntity(FlowEntity entity) {
        RuleWorkFlow rootFlow = RuleWorkFlow.builder().id(entity.getId()).name(entity.getName()).build();

        return buildByRecursive(rootFlow, ConvertFlowToTree.build(entity));
    }

    private RuleWorkFlow buildByRecursive(RuleWorkFlow parentFlow, List<TreeFlow> list) {
        for (TreeFlow item:list) {
            if (item.getParentId().equals(parentFlow.getId())){
                RuleWorkFlow child= RuleWorkFlow.builder().id(item.getId()).beanId(item.getBeanId()).name(item.getName()).condition(item.getCondition()).build();
                 parentFlow.getNextNodes().add(buildByRecursive(child,list));
            }
        }
        return parentFlow;
    }

    private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }

}
