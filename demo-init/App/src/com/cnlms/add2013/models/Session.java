package com.cnlms.add2013.models;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Copyright 2013 Pozitron.
 * <p/>
 * All rights reserved.
 * POZITRON PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * <p/>
 * User: can <can.elmas@pozitron.com>
 * Date: 6/12/13 3:55 PM
 */
public final class Session implements Serializable{

    private String name;
    private String speaker;
    private String venue;
    private String time;
    private String description;

    public static Session dummy(int index) {

        Session session = new Session();

        session.name           = generateRandomString(4);
        session.speaker        = generateRandomString(10);
        session.venue          = generateRandomString(10);
        session.time           = DateFormat.getTimeInstance(DateFormat.SHORT).format(new Date(System.currentTimeMillis() - 1000 * 60 * 30 * index));
        session.description    = "Session [name = " + session.name + ", speaker = " + session.speaker +
                ", venue = " + session.venue + ", time = " + session.time + "]";

        return session;

    }

    public static List<Session> dummyList(final int size) {

        List<Session> sessionList = new ArrayList<Session>(size);

        for (int k = 0 ; k<size; k++) {

            sessionList.add(Session.dummy(k + 1));

        }

        return sessionList;

    }

    private static String generateRandomString(int length) {

        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }

        return sb.toString();

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSpeaker() {
        return speaker;
    }

    public String getVenue() {
        return venue;
    }

    public String getTime() {
        return time;
    }

}
