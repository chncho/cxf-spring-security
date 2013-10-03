package com.kaz3t.proto.secured;

import javax.inject.Named;
import javax.ws.rs.GET;

import com.kaz3t.proto.message.Message;

@Named("securedResource")
public class SecuredResourceImpl implements SecuredResource {

    @Override
    @GET
    public Message index() {
        return new Message("Secured resource only for authenticated users");
    }

}
