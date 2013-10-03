package com.kaz3t.proto.message;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class Message {

    private String value;
    
    @JsonCreator
    public Message(@JsonProperty("value") String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
} 
