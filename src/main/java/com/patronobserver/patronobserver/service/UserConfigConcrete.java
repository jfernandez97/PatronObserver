package com.patronobserver.patronobserver.service;

import com.patronobserver.patronobserver.utils.ConfigObserver;
import com.patronobserver.patronobserver.utils.ConfigType;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserConfigConcrete implements InitializingBean, ConfigObserver {

//    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserConfigConcrete.class);

    @Autowired
    ConfigSubject configSubject;
    @Autowired
    ConfigService configService;

    private String rol;
    private String email;
    private String phone;

    @Override
    public void updateConfig(Object event){
//        logger.info("Updates config");
        if (event.equals(ConfigType.USER)){
            this.rol = configService.getUserRol();
//            logger.info("New rol {}",this.rol);
            this.email=configService.getUserEmail();
//            logger.info("New email {}",this.email);
            this.phone=configService.getUserPhone();
//            logger.info("New phone {}",this.phone);
        }
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        configSubject.addObserver(this);
    }
}
