package edu.icet.pms.util;

import java.util.Collections;
import java.util.Map;

public class ResponseMapping {
    private ResponseMapping(){}
    public static Map<String, String> getMapping(String message){
        return Collections.singletonMap("Status", message);
    }
}
