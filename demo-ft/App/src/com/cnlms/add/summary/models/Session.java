package com.cnlms.add.summary.models;

import java.io.Serializable;

/**
 * Copyright 2013 Pozitron.
 * <p/>
 * All rights reserved.
 * POZITRON PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * <p/>
 * User: can <can.elmas@pozitron.com>
 * Date: 6/14/13 12:54 AM
 */
public class Session implements Serializable{

    private String sessionName;
    private Speaker speaker;
    private String hall;


    public static Session newSession(String sessionName, Speaker speaker, String hall) {

        Session session = new Session();

        session.sessionName = sessionName;
        session.speaker     = speaker;
        session.hall        = hall;

        return session;
    }

    public String getSessionName() {
        return sessionName;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public String getHall() {
        return hall;
    }
}
