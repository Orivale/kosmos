package com.server.netty.entity;

import java.io.Serializable;

public class Message implements Serializable{

    private static final long serialVersionUID = -313632849503943998L;


    public enum ActionType{
        None,
        Login,
        Logout
    }
}
