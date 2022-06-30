/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.yt4j.gateway.handle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger.web.*;

import java.util.Optional;

/**
 * @author xiaoymin 2020年10月29日 18:38:01
 */
@RestController
public class SwaggerHandler {

	@Autowired(required = false)
	private SecurityConfiguration securityConfiguration;

	@Autowired(required = false)
	private UiConfiguration uiConfiguration;

	private final SwaggerResourcesProvider swaggerResources;

	@Autowired
	public SwaggerHandler(SwaggerResourcesProvider swaggerResources) {
		this.swaggerResources = swaggerResources;
	}

	@GetMapping("/swagger-resources/configuration/security")
	public Mono<ResponseEntity<SecurityConfiguration>> securityConfiguration() {
		return Mono.just(new ResponseEntity<>(
				Optional.ofNullable(securityConfiguration).orElse(SecurityConfigurationBuilder.builder().build()),
				HttpStatus.OK));
	}

	@GetMapping("/swagger-resources/configuration/ui")
	public Mono<ResponseEntity<UiConfiguration>> uiConfiguration() {
		return Mono.just(new ResponseEntity<>(
				Optional.ofNullable(uiConfiguration).orElse(UiConfigurationBuilder.builder().build()), HttpStatus.OK));
	}

	@GetMapping("/swagger-resources")
	public Mono<ResponseEntity> swaggerResources() {
		return Mono.just((new ResponseEntity<>(swaggerResources.get(), HttpStatus.OK)));
	}

}
