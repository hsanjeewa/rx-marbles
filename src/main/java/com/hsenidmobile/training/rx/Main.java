package com.hsenidmobile.training.rx;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by isuru on 11/12/2017.
 */
public class Main {
    public static void main(String[] args) {
        NioEventLoopGroup group1 = new NioEventLoopGroup(1);
        NioEventLoopGroup group2 = new NioEventLoopGroup(2);

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(group1, group2);

        serverBootstrap.childHandler(new ServerChannelInitializer());
        serverBootstrap.option(ChannelOption.SO_BACKLOG, 2048);
        serverBootstrap.channel(NioServerSocketChannel.class);

        try {
            Channel channel = serverBootstrap.bind(8790).addListener((ChannelFutureListener) future -> System.out.println("Server initialization complete !!!")).sync().channel();

            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
