package com.matthewtomich.phonebook;

/**
 * Hello world!
 *
 */

import com.matthewtomich.phonebook.resources.ContactResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.dropwizard.Application;

import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class App extends Application<PhonebookConfiguration>
{

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) throws Exception
    {
        new App().run(args);
    }

    @Override
    public void run(PhonebookConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(new ContactResource());
        LOGGER.info("Method App#run() called");
        for (int i=0; i < configuration.getMessageRepetitions(); i++) {
            System.out.println(configuration.getMessage());
            System.out.println(configuration.getAdditionalMessage());
        }
    }

    @Override
    public void initialize(Bootstrap<PhonebookConfiguration> configurationBootstrap) {

    }
}
