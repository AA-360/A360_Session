/*
 * Copyright (c) 2020 Automation Anywhere.
 * All rights reserved.
 *
 * This software is the proprietary information of Automation Anywhere.
 * You shall use it only in accordance with the terms of the license agreement
 * you entered into with Automation Anywhere.
 */

/**
 *
 */
package com.automationanywhere.botcommand.samples.commands.basic;


import com.automationanywhere.botcommand.data.impl.SessionValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.botcommand.samples.commands.utils.Debugger;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;

import java.util.HashMap;
import java.util.Map;

import static com.automationanywhere.commandsdk.model.AttributeType.SESSION;
import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;

@BotCommand
@CommandPkg(label = "[[SessionDemo.label]]",
        description = "[[SessionDemo.description]]",
        icon = "sample.svg",
        name = "sessionDemo")
public class SessionDemo {

    @Sessions
    private Map<String, Object> sessionMap;

    @Execute
    public void action(
            @Idx(index = "1", type = TEXT)
            @Pkg(label = "Session Name")
            @NotEmpty
                    String SessionName
    ) {

        Debugger db = new Debugger();

        if (!sessionMap.containsKey(SessionName)) {
            Map<String, Object> Data = new HashMap<>();
            Data.put("primeiro", "hehe");
            Data.put("segundo", "hehe2");
            Data.put("terceiro", db);
            db.alert("asdasd");
            //db.alert(sessionMap.get(SessionName).getClass().getSimpleName());
            sessionMap.put(SessionName, Data);
        }
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

}


