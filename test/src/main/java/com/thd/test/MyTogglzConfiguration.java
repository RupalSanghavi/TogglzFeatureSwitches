package com.thd.test;

import org.togglz.core.manager.TogglzConfig;

import java.io.File;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.togglz.core.Feature;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.file.FileBasedStateRepository;
import org.togglz.core.user.FeatureUser;
import org.togglz.core.user.SimpleFeatureUser;
import org.togglz.core.user.UserProvider;
import org.togglz.servlet.user.ServletUserProvider;

@Component
public class MyTogglzConfiguration implements TogglzConfig{
	public Class<? extends Feature> getFeatureClass() {
        return ToggledFeature.class;
    }

    public StateRepository getStateRepository() {
        return new FileBasedStateRepository(new File("/tmp/features.properties"));
    }

    public UserProvider getUserProvider() {
    	 return new UserProvider() {
             @Override
             public FeatureUser getCurrentUser() {
                 return new SimpleFeatureUser("admin", true);
             }
         };
    	//String user = HttpServletRequest.getUserPrincipal().getName();
        //return new ServletUserProvider("admin");
    }

}
