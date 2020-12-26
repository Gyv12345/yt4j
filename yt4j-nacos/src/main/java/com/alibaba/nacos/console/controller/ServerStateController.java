package com.alibaba.nacos.console.controller;


import com.alibaba.nacos.common.util.VersionUtils;
import com.alibaba.nacos.core.utils.SystemUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xingxuechao
 * on:2019/2/27 11:17 AM
 */
@RestController
@RequestMapping("/v1/console/server")
public class ServerStateController {

    @GetMapping("state")
    public ResponseEntity serverState() {
        Map<String,String> serverState = new HashMap<>(3);
        serverState.put("standalone_mode",SystemUtils.STANDALONE_MODE ?
            SystemUtils.STANDALONE_MODE_ALONE : SystemUtils.STANDALONE_MODE_CLUSTER);

        serverState.put("function_mode", SystemUtils.FUNCTION_MODE);
        serverState.put("version", VersionUtils.VERSION);

        return ResponseEntity.ok().body(serverState);
    }

}
