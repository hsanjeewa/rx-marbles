package com.hsenidmobile.training.rx.async;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.hsenidmobile.training.rx.api.WorkHistory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.concurrent.Callable;

/**
 * Created by isuru on 11/13/2017.
 */
public class WorkHistoryCallable implements Callable<WorkHistory> {


    @Override
    public WorkHistory call() throws Exception {
        Client client = ClientBuilder.newClient();
        client.register(JacksonJsonProvider.class);
        WebTarget target = client.target("http://demo2867744.mockable.io/workHistory/089");
        WorkHistory workHistory = target.request().get(WorkHistory.class);
        return workHistory;
    }
}
