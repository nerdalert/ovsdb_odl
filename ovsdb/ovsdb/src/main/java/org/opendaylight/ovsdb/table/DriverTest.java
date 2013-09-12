package org.opendaylight.ovsdb.table;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.io.StringReader;

public class DriverTest {
    public static void main(String[] args) {

        // ovs-vsctl show reply
        String almsg = "{\"id\":0,\"error\":null,\"result\":" +
                "{\"Port\":{\"d97ecd2f-a0f9-495d-8637-e0849f7de291\"" +
                ":{\"new\":{\"trunks\":[\"set\",[]],\"interfaces\":" +
                "[\"uuid\",\"f3b84c90-a85b-4d97-9ddd-cd710a5490ce\"],\"" +
                "name\":\"br0\",\"tag\":[\"set\",[]]}},\"" +
                "8be80f67-f27a-4822-8130-76aa43e8d292\":{\"new\"" +
                ":{\"trunks\":[\"set\",[]],\"interfaces\":[\"uuid\"," +
                "\"181a8348-5a0b-4e34-bc7a-786901c61493\"],\"name\"" +
                ":\"tap2\",\"tag\":[\"set\",[]]}},\"" +
                "7c1b9f41-8222-4c78-ad90-244e1a66baac\":{\"new\":{\"trunks\":" +
                "[\"set\",[]],\"interfaces\":[\"uuid\",\"" +
                "eb43c2ae-0e49-4ac1-b249-18d493f11422\"],\"name\":\"tap1\"," +
                "\"tag\":[\"set\",[]]}}," +
                "\"7eb5508f-b2d9-4343-b7f3-b109bcd0ae86\"" +
                ":{\"new\":{\"trunks\":[\"set\",[]],\"interfaces\":[\"uuid\"," +
                "\"79b2d0ba-9ead-4149-9e4c-428dd14dc987\"]," +
                "\"name\":\"JUNIT_BRIDGE_TEST\"" +
                ",\"tag\":[\"set\",[]]}}," +
                "\"303d6f72-340b-468e-8bb7-7e44f15b77af\"" +
                ":{\"new\":{\"trunks\":[\"set\",[]],\"interfaces\":[\"uuid\"," +
                "\"" +
                "e63cbe6f-ec12-4972-9170-079097e85c3d\"],\"name\":\"tap3\"," +
                "\"tag\"" +
                ":[\"set\",[]]}}}," +
                "\"Interface\":{\"181a8348-5a0b-4e34-bc7a-786901c61493\"" +
                ":{\"new\":{\"name\":\"tap2\",\"type\":\"\"," +
                "\"options\":[\"map\",[]]}},\"" +
                "f3b84c90-a85b-4d97-9ddd-cd710a5490ce\":{\"new\":{\"name" +
                "\":\"br0\"," +
                "\"type\":\"internal\",\"options\":[\"map\",[]]}},\"" +
                "e63cbe6f-ec12-4972-9170-079097e85c3d\":{\"new\":" +
                "{\"name\":\"tap3\",\"type\":\"\",\"options\":[\"map\",[]]}}," +
                "\"eb43c2ae-0e49-4ac1-b249-18d493f11422\":{\"new\":{\"name" +
                "\":\"tap1\"," +
                "\"type\":\"\",\"options\":[\"map\",[]]}}," +
                "\"79b2d0ba-9ead-4149-9e4c-428dd14dc987\"" +
                ":{\"new\":{\"name\":\"JUNIT_BRIDGE_TEST\"," +
                "\"type\":\"internal\"," +
                "\"options\":[\"map\",[]]}}},\"Open_vSwitch\":" +
                "{\"2cfdf9dd-e2a3-46b9-b09d-fbc68f23bc5d\":{\"new\":" +
                "{\"ovs_version\":\"1.4.3\",\"cur_cfg\":301," +
                "\"bridges\":[\"set\"," +
                "[[\"uuid\",\"3732d17d-339f-4f9d-a553-4396e1158df7\"]," +
                "[\"uuid\"," +
                "\"be7403fe-e124-4c29-931b-139cf060d021\"]]]," +
                "\"manager_options\":" +
                "[\"uuid\",\"fc37548a-aa08-427f-bf8d-cd88d81ae099\"]}}}," +
                "\"Bridge\"" +
                ":{\"3732d17d-339f-4f9d-a553-4396e1158df7\":{\"new\":{\"name" +
                "\":\"" +
                "br0\",\"ports\":[\"set\",[[\"uuid\"," +
                "\"303d6f72-340b-468e-8bb7-7e44f15b77af\"]" +
                ",[\"uuid\",\"7c1b9f41-8222-4c78-ad90-244e1a66baac\"]," +
                "[\"uuid\"" +
                ",\"8be80f67-f27a-4822-8130-76aa43e8d292\"],[\"uuid\"," +
                "\"d97ecd2f-a0f9-495d-8637-e0849f7de291\"]]],\"controller\":" +
                "[\"set\",[]],\"fail_mode\":[\"set\",[]]}}," +
                "\"be7403fe-e124-4c29-931b-139cf060d021\":{\"new\":{\"name\":" +
                "\"JUNIT_BRIDGE_TEST\",\"ports\":[\"uuid\"," +
                "\"7eb5508f-b2d9-4343-b7f3-b109bcd0ae86\"]," +
                "\"controller\":[\"set\"" +
                ",[]],\"fail_mode\":[\"set\",[]]}}},\"Manager\":{" +
                "\"fc37548a-aa08-427f-bf8d-cd88d81ae099\":{\"new\":{\"target" +
                "\":" +
                "\"ptcp:6634:172.16.58.128\",\"is_connected\":false}}}}}";

        // The rest are from the following monitor structure.
//        {"method":"monitor","id":0,"params":["Open_vSwitch",null,
//        {"Port":{"columns":["interfaces","name","tag","trunks","external_ids"]},
//        "Controller":{"columns":["is_connected","target"]},"Interface":
//        {"columns":["name","options","type"]},"Open_vSwitch":{"columns":
//        ["bridges","cur_cfg","manager_options","ovs_version"]},
//        "Manager":{"columns":["is_connected","target"]},
//        "Bridge":{"columns":["controller","fail_mode","name","ports"]}}]}

        // ## Each Table broken down individually for testing ##
        //Port table only
        String blmsg = "{\"id\":0,\"error\":null," +
                "" + "\"result\":{\"Port\":{\"ff306c93-bdef-4176-a4f3" +
                "-d02e15654c42\":{\"new\":{\"trunks\":[\"set\",[]]," +
                "\"external_ids\":[\"map\",[]],\"interfaces\":[\"uuid\"," +
                "\"89e67257-b713-4f93-b9af-a80427551972\"],\"name\":\"br1\"," +
                "\"tag\":[\"set\",[]]}}," +
                "\"52f4b20f-9667-40a7-ac4b-22745e1caff2\":{\"new\":{\"trunks" +
                "\":[\"set\",[]],\"external_ids\":[\"map\",[[\"key1\"," +
                "\"FOO\"]]],\"interfaces\":[\"uuid\"," +
                "\"33905368-e18e-4363-a29e-7312268e88bb\"],\"name\":\"vif0\"," +
                "\"tag\":[\"set\",[]]}}," +
                "\"a6064640-e0bb-4c8f-a8ab-4ba5a49c6b6a\":{\"new\":{\"trunks" +
                "\":[\"set\",[]],\"external_ids\":[\"map\",[]]," +
                "\"interfaces\":[\"uuid\"," +
                "\"da6059d2-da62-4135-947d-a41b98f72309\"],\"name\":\"gre1\"," +
                "\"tag\":[\"set\",[]]}}," +
                "\"c816ef48-055f-4929-bcc2-fbd6218211dd\":{\"new\":{\"trunks" +
                "\":[\"set\",[]],\"external_ids\":[\"map\",[]]," +
                "\"interfaces\":[\"uuid\"," +
                "\"472fea0a-2c38-4f7b-8cb5-95f9fcbee79b\"],\"name\":\"br0\"," +
                "\"tag\":[\"set\",[]]}}}}}";
        //Controller only
        String clmsg = "{\"id\":0,\"error\":null," +
                "" + "\"result\":{\"Controller\":{\"f0dbada6-838e-47a7-9ddc" +
                "-2fd74fa5ae9e\":{\"new\":{\"target\":\"tcp:192.168.1" +
                ".18:6633\",\"is_connected\":false}}}}}";

        //Interfaces table only
        String dlmsg = "{\"id\":0,\"error\":null," +
                "" + "\"result\":{\"Interface\":{\"33905368-e18e-4363-a29e" +
                "-7312268e88bb\":{\"new\":{\"name\":\"vif0\",\"type\":\"\"," +
                "\"options\":[\"map\",[]]}}," +
                "\"89e67257-b713-4f93-b9af-a80427551972\":{\"new\":{\"name" +
                "\":\"br1\",\"type\":\"internal\",\"options\":[\"map\",[]]}}," +
                "\"da6059d2-da62-4135-947d-a41b98f72309\":{\"new\":{\"name" +
                "\":\"gre1\",\"type\":\"gre\",\"options\":[\"map\"," +
                "[[\"remote_ip\",\"192.168.1.10\"]]]}}," +
                "\"472fea0a-2c38-4f7b-8cb5-95f9fcbee79b\":{\"new\":{\"name" +
                "\":\"br0\",\"type\":\"internal\",\"options\":[\"map\"," +
                "[]]}}}}}";

        //Bridge table only
        String elmsg = "{\"id\":0,\"error\":null," +
                "" + "\"result\":{\"Open_vSwitch\":{\"2cfdf9dd-e2a3-46b9-b09d" +
                "-fbc68f23bc5d\":{\"new\":{\"ovs_version\":\"1.4.3\"," +
                "\"cur_cfg\":412,\"bridges\":[\"set\",[[\"uuid\"," +
                "\"424544d3-eba9-412a-8fa6-844767f0ad32\"],[\"uuid\"," +
                "\"56f04394-7fba-4997-b784-5cf8ff5de1f2\"]]]," +
                "\"manager_options\":[\"uuid\"," +
                "\"2928ae71-fc80-4ead-b156-fbd2a97ee308\"]}}}," +
                "\"Bridge\":{\"424544d3-eba9-412a-8fa6-844767f0ad32\":{\"new" +
                "\":{\"name\":\"br0\",\"ports\":[\"set\",[[\"uuid\"," +
                "\"52f4b20f-9667-40a7-ac4b-22745e1caff2\"],[\"uuid\"," +
                "\"c816ef48-055f-4929-bcc2-fbd6218211dd\"]]]," +
                "\"controller\":[\"uuid\"," +
                "\"f0dbada6-838e-47a7-9ddc-2fd74fa5ae9e\"]," +
                "\"fail_mode\":[\"set\",[]]}}," +
                "\"56f04394-7fba-4997-b784-5cf8ff5de1f2\":{\"new\":{\"name" +
                "\":\"br1\",\"ports\":[\"set\",[[\"uuid\"," +
                "\"a6064640-e0bb-4c8f-a8ab-4ba5a49c6b6a\"],[\"uuid\"," +
                "\"ff306c93-bdef-4176-a4f3-d02e15654c42\"]]]," +
                "\"controller\":[\"set\",[]],\"fail_mode\":[\"set\",[]]}}}}}";

        //Manager table only
        String flmsg = "{\"id\":0,\"error\":null," +
                "" + "\"result\":{\"Manager\":{\"2928ae71-fc80-4ead-b156" +
                "-fbd2a97ee308\":{\"new\":{\"target\":\"ptcp:6634:172.16.58" +
                ".128\",\"is_connected\":false}}}}}\n";

        //All Tables returned together
        String lmsg = "{\"id\":0,\"error\":null," +
                "\"result\":{\"Port\":{\"ff306c93-bdef-4176-a4f3-d02e15654c42" +
                "\":{\"new\":{\"trunks\":[\"set\",[]]," +
                "\"external_ids\":[\"map\",[]],\"interfaces\":[\"uuid\"," +
                "\"89e67257-b713-4f93-b9af-a80427551972\"],\"name\":\"br1\"," +
                "\"tag\":[\"set\",[]]}}," +
                "\"52f4b20f-9667-40a7-ac4b-22745e1caff2\":{\"new\":{\"trunks" +
                "\":[\"set\",[]],\"external_ids\":[\"map\",[[\"key1\"," +
                "\"FOO\"]]],\"interfaces\":[\"uuid\"," +
                "\"33905368-e18e-4363-a29e-7312268e88bb\"],\"name\":\"vif0\"," +
                "\"tag\":[\"set\",[]]}}," +
                "\"a6064640-e0bb-4c8f-a8ab-4ba5a49c6b6a\":{\"new\":{\"trunks" +
                "\":[\"set\",[]],\"external_ids\":[\"map\",[]]," +
                "\"interfaces\":[\"uuid\"," +
                "\"da6059d2-da62-4135-947d-a41b98f72309\"],\"name\":\"gre1\"," +
                "\"tag\":[\"set\",[]]}}," +
                "\"c816ef48-055f-4929-bcc2-fbd6218211dd\":{\"new\":{\"trunks" +
                "\":[\"set\",[]],\"external_ids\":[\"map\",[]]," +
                "\"interfaces\":[\"uuid\"," +
                "\"472fea0a-2c38-4f7b-8cb5-95f9fcbee79b\"],\"name\":\"br0\"," +
                "\"tag\":[\"set\",[]]}}}," +
                "\"Controller\":{\"f0dbada6-838e-47a7-9ddc-2fd74fa5ae9e" +
                "\":{\"new\":{\"target\":\"tcp:192.168.1.18:6633\"," +
                "\"is_connected\":false}}}," +
                "\"Interface\":{\"33905368-e18e-4363-a29e-7312268e88bb" +
                "\":{\"new\":{\"name\":\"vif0\",\"type\":\"\"," +
                "\"options\":[\"map\",[]]}}," +
                "\"89e67257-b713-4f93-b9af-a80427551972\":{\"new\":{\"name" +
                "\":\"br1\",\"type\":\"internal\",\"options\":[\"map\",[]]}}," +
                "\"da6059d2-da62-4135-947d-a41b98f72309\":{\"new\":{\"name" +
                "\":\"gre1\",\"type\":\"gre\",\"options\":[\"map\"," +
                "[[\"remote_ip\",\"192.168.1.10\"]]]}}," +
                "\"472fea0a-2c38-4f7b-8cb5-95f9fcbee79b\":{\"new\":{\"name" +
                "\":\"br0\",\"type\":\"internal\",\"options\":[\"map\"," +
                "[]]}}}," +
                "\"Open_vSwitch\":{\"2cfdf9dd-e2a3-46b9-b09d-fbc68f23bc5d" +
                "\":{\"new\":{\"ovs_version\":\"1.4.3\",\"cur_cfg\":412," +
                "\"bridges\":[\"set\",[[\"uuid\"," +
                "\"424544d3-eba9-412a-8fa6-844767f0ad32\"],[\"uuid\"," +
                "\"56f04394-7fba-4997-b784-5cf8ff5de1f2\"]]],\"manager_options\":" +
                "[\"uuid\",\"2928ae71-fc80-4ead-b156-fbd2a97ee308\"]}}},\"Bridge\":" +
                "{\"424544d3-eba9-412a-8fa6-844767f0ad32\":{\"new\":{\"name\":" +
                "\"br0\",\"ports\":[\"set\",[[\"uuid\",\"" +
                "52f4b20f-9667-40a7-ac4b-22745e1caff2\"],[\"uuid\"," +
                "\"c816ef48-055f-4929-bcc2-fbd6218211dd\"]]],\"controller\":" +
                "[\"uuid\",\"f0dbada6-838e-47a7-9ddc-2fd74fa5ae9e\"],\"fail_mode\":" +
                "[\"set\",[]]}},\"56f04394-7fba-4997-b784-5cf8ff5de1f2\":{\"new\"" +
                ":{\"name\":\"br1\",\"ports\":[\"set\",[[\"uuid\"," +
                "\"a6064640-e0bb-4c8f-a8ab-4ba5a49c6b6a\"],[\"uuid\",\"" +
                "ff306c93-bdef-4176-a4f3-d02e15654c42\"]]],\"controller\":" +
                "[\"set\",[]],\"fail_mode\":[\"set\",[]]}}},\"Manager\":" +
                "{\"2928ae71-fc80-4ead-b156-fbd2a97ee308\":{\"new\":{\"target\"" +
                ":\"ptcp:6634:172.16.58.128\",\"is_connected\":false}}}}}";

        ObjectMapper mapper = new ObjectMapper();

        try {

            //  System.out.println(lmsg);
            JsonFactory jf = new MappingJsonFactory();
            JsonParser jp = jf.createParser(new StringReader(lmsg));
            Data p1 = jp.readValueAs(Data.class);

            JsonFactory jfactory = new MappingJsonFactory();
            jp = jfactory.createParser(new StringReader(lmsg));
            Data p2 = jp.readValueAs(Data.class);

            System.out.println("Raw String --> " + lmsg);
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println(p1.toString());
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println(p2.toString());

            JsonFactory jf2 = new MappingJsonFactory();
            JsonParser jp2 = jf2.createParser(new StringReader(lmsg));
            JsonNode root = jp2.readValueAsTree();
            root.getNodeType();
            System.out.println(root);
            System.out.println("--------------------------------------------------------------------------------");

            JsonParser jp4 = mapper.getFactory().createParser(lmsg);
            Data ob = jp4.readValueAs(Data.class);
            System.out.println(ob.toString());
            System.out.println("wtf");
            System.out.println("--------------------------------------------------------------------------------");

            System.out.println("json Node");
            JsonFactory jf3 = new MappingJsonFactory();
            JsonParser jp3 = jf3.createParser(new StringReader(lmsg));
            JsonNode root2 = jp3.readValueAsTree();
            Data hostreply = mapper.treeToValue(root2, Data.class);

            System.out.println
                    ("-----------Start of Return ---------------------------------------------------------------------");
            System.out.println("TREE");
            System.out.println(hostreply.toString());

            System.out.println
                    ("---------End of Return -----------------------------------------------------------------------");

        } catch (JsonMappingException e) {
            System.err.println(e);
        } catch (JsonParseException e) {
            System.err.println(e);
        } catch (JsonProcessingException e) {
            System.err.println(e);
        } catch (RuntimeJsonMappingException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
