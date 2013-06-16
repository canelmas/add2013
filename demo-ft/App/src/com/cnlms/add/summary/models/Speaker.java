package com.cnlms.add.summary.models;

import java.io.Serializable;

/**
 * Copyright 2013 Pozitron.
 * <p/>
 * All rights reserved.
 * POZITRON PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * <p/>
 * User: can <can.elmas@pozitron.com>
 * Date: 6/14/13 12:56 AM
 */
public class Speaker implements Serializable{

    private String name;
    private String info;
    private String email;

    public static Speaker newSpeaker(String name, String info, String email) {

        Speaker speaker = new Speaker();

        speaker.name    = name;
        speaker.info    = info;
        speaker.email   = email;

        return speaker;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public String getEmail() {
        return email;
    }
}
