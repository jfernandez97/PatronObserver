package com.patronobserver.patronobserver.service;

import com.patronobserver.patronobserver.utils.ConfigObserver;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class ConfigSubject {
//    private static final Logger logger = (Logger) LoggerFactory.getLogger(ConfigSubject.class);

    private  final Set<ConfigObserver> observers;

    public  ConfigSubject(){
        observers= Collections.synchronizedSet(new HashSet<>());
    }
    public void addObserver(ConfigObserver observer){
//        logger.info("A new observer has been added");
        observers.add(observer);
    }
    public void removeObserver(ConfigObserver observer){
//        logger.info("An observer has been deleted");
        observers.remove(observer);
    }
    public  void notifyObservers(Object event){
        synchronized (observers){
//            logger.info("All observers notified");
            observers.forEach(observer -> observer.updateConfig(event));
        }
    }
}
