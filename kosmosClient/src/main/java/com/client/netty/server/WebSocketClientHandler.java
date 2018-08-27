package com.client.netty.server;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class WebSocketClientHandler extends SimpleChannelInboundHandler<Object> {
    private  static final Logger logger= LoggerFactory.getLogger(WebSocketClientHandler.class);
    private final WebSocketClientHandshaker handshaker;
    private ChannelPromise handshakeFuture;
    private ClientListener clientListener;

    public WebSocketClientHandler(WebSocketClientHandshaker handshaker){
        this.handshaker=handshaker;
    }
    public ChannelFuture getHandshakeFuture(){
        return this.handshakeFuture;
    }
    public void setClientListener(ClientListener clientListener){
        this.clientListener=clientListener;
    }
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        handshakeFuture=ctx.newPromise();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
