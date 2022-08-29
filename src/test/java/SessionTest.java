import com.automationanywhere.botcommand.samples.commands.basic.DemoForSession;
import com.automationanywhere.botcommand.samples.commands.basic.SessionDemo;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class SessionTest {
    @Test
    public void teste(){
        Map<String, Object> theMap = new HashMap<String, Object>();


        SessionDemo sessObj = new SessionDemo();
        sessObj.setSessionMap(theMap);


        sessObj.action("mysession");

        System.out.println("==================");
    }
}