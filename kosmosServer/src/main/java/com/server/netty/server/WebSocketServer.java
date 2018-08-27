package com.server.netty.server;
import com.client.netty.server.ClientListener;
import com.sun.deploy.util.StringUtils;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.netty.channel.Channel;

import java.net.URI;

public class WebSocketServer {
    private Logger logger= LoggerFactory.getLogger(WebSocketServer.class);
    private URI uri;
    private String host;
    private int port;
    private boolean ssl;
    private EventLoopGroup group;

    private void init(String url) {
        try {
            uri = new URI(url);
            String scheme = uri.getScheme() == null ? "http" : uri.getScheme();
            if (!"ws".equalsIgnoreCase(scheme) && !"wws".equalsIgnoreCase(scheme)) {
                logger.error("Only WS(S) is supported");
                return;
            }
            host = uri.getHost() == null ? "127.0.0.1" : uri.getHost();
            if (uri.getPort() == -1) {
                if ("http".equalsIgnoreCase(scheme)) {
                    port = 80;
                } else if ("https".equalsIgnoreCase(scheme)) {
                    port = 443;
                } else {
                    port = -1;
                }
            } else {
                port = uri.getPort();
            }
            ssl = "wws".equalsIgnoreCase(scheme);
            uri = new URI(scheme + "://" + host + ":" + port + uri.getPath());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
        public Channel establish(String url, ClientListener listener) {
            Channel ch=null;
            group=new NioEventLoopGroup();
            try {
                init(url);
                final SslContext sslCtx;
                if(ssl){
                    sslCtx= SslContextBuilder.forClient().trustManager(InsecureTrustManagerFactory.INSTANCE).build();
                }else {
                    sslCtx = null;
                }
            }catch (Exception e){

            }
            return null;
        }
}
