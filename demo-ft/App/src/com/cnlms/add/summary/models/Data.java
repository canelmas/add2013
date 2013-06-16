package com.cnlms.add.summary.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2013 Pozitron.
 * <p/>
 * All rights reserved.
 * POZITRON PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * <p/>
 * User: can <can.elmas@pozitron.com>
 * Date: 6/14/13 1:25 AM
 */
public final class Data {

    private static List<Session> data;

    static {

        data = new ArrayList<Session>();

        for (int k = 1; k<= 20; k++) {

            Speaker speaker = Speaker.newSpeaker("Speaker " + k, "speaker info " + k, "speaker" + k + "@mail.com");
            Session session = Session.newSession("session " + k, speaker, "Hall " + (k%3 +1));
            data.add(session);

        }

    }

    public static List<Session> get() {
        return data;
    }
}
