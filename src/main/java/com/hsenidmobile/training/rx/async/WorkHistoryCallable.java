package com.hsenidmobile.training.rx.async;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.hsenidmobile.training.rx.api.Profile;
import com.hsenidmobile.training.rx.api.WorkHistory;
import io.netty.util.concurrent.DefaultThreadFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by isuru on 11/13/2017.
 */
public class WorkHistoryCallable implements Callable<WorkHistory> {


    private Profile profile;
    private PlatformProficienciesCallable callable;
    ExecutorService executorService = Executors.newFixedThreadPool(1, new DefaultThreadFactory("platfrom-proficiency-threadpool"));

    public WorkHistoryCallable(Profile profile, PlatformProficienciesCallable callable) {
        this.profile = profile;
        this.callable = callable;
    }

    @Override
    public WorkHistory call() throws Exception {
        Client client = ClientBuilder.newClient();
        client.register(JacksonJsonProvider.class);
        WebTarget target = client.target("http://demo2867744.mockable.io/workHistory/089");
        WorkHistory workHistory = target.request().get(WorkHistory.class);
        profile.setWorkHistory(workHistory);
        executorService.submit(callable);
        return workHistory;
    }
}
