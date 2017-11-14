package com.hsenidmobile.training.rx.async;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.hsenidmobile.training.rx.MyRequestHandler;
import com.hsenidmobile.training.rx.api.PlatformProficiency;
import com.hsenidmobile.training.rx.api.Profile;
import com.hsenidmobile.training.rx.api.WorkHistory;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.concurrent.Callable;

/**
 * Created by isuru on 11/13/2017.
 */
public class PlatformProficienciesCallable implements Callable<PlatformProficiency> {

    private final ChannelHandlerContext ctx;
    private final FullHttpRequest req;
    private final Profile profile;

    public PlatformProficienciesCallable(ChannelHandlerContext ctx, FullHttpRequest req, Profile profile) {

        this.ctx = ctx;
        this.req = req;
        this.profile = profile;
    }

    @Override
    public PlatformProficiency call() throws Exception {
        Client client = ClientBuilder.newClient();
        client.register(JacksonJsonProvider.class);
        WebTarget target = client.target("http://demo2867744.mockable.io/platforms/089");
        PlatformProficiency platformProficiency = target.request().get(PlatformProficiency.class);
        profile.setPlatformProficiency(platformProficiency);
        MyRequestHandler.itsJustTransport(ctx, req, profile);
        return platformProficiency;
    }
}
