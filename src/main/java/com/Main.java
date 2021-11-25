package com;

import com.tool.JsonTool;

import java.util.Map;



public class Main {

    public static void main(String[] args) {
        Map map = JsonTool.fromJson("{\n" +
                "    \"trialUrl\": \"http://happyacerummy.win/new/\",\n" +
                "    \"operator_token\": \"hongtu\",\n" +
                "    \"hall_id\": \"0\",\n" +
                "    \"secret_key\": \"c2a8cd8c921344895e68995cce48f82a\",\n" +
                "    \"loginUrl\": \"http://handigame.b-cdn.net/index.html\",\n" +
                "    \"currency_agent_conf\": {\n" +
                "        \"INR\": {\n" +
                "            \"isNeedChangeRate\": true,\n" +
                "            \"rateConversion\": 0.001\n" +
                "        }\n" +
                "    },\n" +
                "    \"getRecordsUrl\": \"http://3rd.game.api.com/ha-callback-record/api-callback/ha/getRecords\"\n" +
                "}", Map.class);

        System.out.println(map);
    }
}
