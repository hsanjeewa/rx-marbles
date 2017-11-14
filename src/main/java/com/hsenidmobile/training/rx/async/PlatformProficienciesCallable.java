package com.hsenidmobile.training.rx.async;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.hsenidmobile.training.rx.api.PlatformProficiency;
import com.hsenidmobile.training.rx.api.WorkHistory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.concurrent.Callable;

/**
 * Created by isuru on 11/13/2017.
 */
public class PlatformProficienciesCallable implements Callable<PlatformProficiency> {

    @Override
    public PlatformProficiency call() throws Exception {
        System.out.println("Platform Proficiencies History - Got called by " + Thread.currentThread().getName());
        Client client = ClientBuilder.newClient();
        client.register(JacksonJsonProvider.class);
        WebTarget target = client.target("http://demo2867744.mockable.io/platforms/089");
        PlatformProficiency platformProficiency = target.request().get(PlatformProficiency.class);
        return platformProficiency;
    }
}
