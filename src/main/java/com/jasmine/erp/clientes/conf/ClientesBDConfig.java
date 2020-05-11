package com.jasmine.erp.clientes.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.jasmine.erp.app.dataaccess.AppBDConfig;
import com.jasmine.erp.app.service.AppConfigService;

@Configuration
@Import( { AppBDConfig.class, AppConfigService.class } )
public class ClientesBDConfig {
	
}
