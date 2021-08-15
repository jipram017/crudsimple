package com.crudsimple.model;

import java.io.Serializable;

/**
 * If any API just need to send a message as reponse or error message then
 * this class can be used.
 * @author Aji Pramono
 * @version 1.0
 * @since 2021-08-16
 */
public class MessageResponse implements Serializable {
    private String message;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
