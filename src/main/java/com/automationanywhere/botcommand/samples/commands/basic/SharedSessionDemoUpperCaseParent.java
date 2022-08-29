package com.automationanywhere.botcommand.samples.commands.basic;
import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.SessionValue;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;

import java.util.Map;

import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.SESSION;
import static com.automationanywhere.commandsdk.model.DataType.STRING;

@BotCommand
@CommandPkg(
        return_label = "SharedSessionDemoUpperCaseParent",
        node_label = "SharedSessionDemoUpperCaseParent",
        label = "SharedSessionDemoUpperCaseParent",
        description = "SharedSessionDemoUpperCaseParent",
        name = "SharedSessionDemoUpperCaseParent",
        return_type = SESSION,
        return_required = true
)
public class SharedSessionDemoUpperCaseParent {

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    @Sessions
    private Map<String, Object> sessionMap;

    @Execute
    public Value<?> execute(
            @Idx(index = "1", type = TEXT)
            @Pkg(label = "SetSession", description = "SetSession", default_value = "Default", default_value_type = STRING)
            @NotEmpty
                    String session
    ) {
        Object sessionObject = sessionMap.get(session);

        System.out.println("sessionObject: "+sessionObject);
        SessionValue sessionValue=new SessionValue((DemoForSession) sessionObject);
        sessionValue.set(session);
        return sessionValue;
    }
}