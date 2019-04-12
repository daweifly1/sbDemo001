package com.devi.test.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TimeServer {
    private static final String IP = "127.0.0.1";
    private static final int PORT = 5888;
    private static final int BIZGROUPSIZE = Runtime.getRuntime().availableProcessors() * 2;

    private static final int BIZTHREADSIZE = 100;
    private static final EventLoopGroup bossGroup = new NioEventLoopGroup(BIZGROUPSIZE);
    private static final EventLoopGroup workerGroup = new NioEventLoopGroup(BIZTHREADSIZE);

    public static void service() throws Exception {
        try {


            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
            bootstrap.childHandler(new ChannelInitializer<Channel>() {

                @Override
                protected void initChannel(Channel ch) throws Exception {
                    // TODO Auto-generated method stub
                    ChannelPipeline pipeline = ch.pipeline();
//                    pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
//                    pipeline.addLast(new LengthFieldPrepender(4));
//                    pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
//                    pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
                    pipeline.addLast(new TimerServerHandler());
                }

            });
            ChannelFuture f = bootstrap.bind(IP, PORT).sync();
            f.channel().closeFuture().sync();
            System.out.println("TCP服务器已启动");
        } finally {
            shutdown();
        }
    }

    protected static void shutdown() {
        workerGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("开始启动TCP服务器...");
        TimeServer.service();
//            HelloServer.shutdown();
    }
}
