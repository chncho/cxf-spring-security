package com.kaz3t.proto.open;

import javax.inject.Named;
import javax.ws.rs.GET;

import com.kaz3t.proto.message.Message;

@Named("openResource")
public class OpenResourceImpl implements OpenResource {

    @Override
    @GET
    public Message index() {
        return new Message("Resource accessible to everybody");
    }

}
