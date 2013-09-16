package org.opendaylight.ovsdb.table;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;


public class DriverTest {
    public static void main(String[] args) {


        String jjlmsg = "{\"id\":0,\"error\":null,\"result\":" +
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
                "\"tag\":[\"set\",[]]}},\"7eb5508f-b2d9-4343-b7f3-b109bcd0ae86\"" +
                ":{\"new\":{\"trunks\":[\"set\",[]],\"interfaces\":[\"uuid\"," +
                "\"79b2d0ba-9ead-4149-9e4c-428dd14dc987\"],\"name\":\"JUNIT_BRIDGE_TEST\"" +
                ",\"tag\":[\"set\",[]]}},\"303d6f72-340b-468e-8bb7-7e44f15b77af\"" +
                ":{\"new\":{\"trunks\":[\"set\",[]],\"interfaces\":[\"uuid\",\"" +
                "e63cbe6f-ec12-4972-9170-079097e85c3d\"],\"name\":\"tap3\",\"tag\"" +
                ":[\"set\",[]]}}},\"Interface\":{\"181a8348-5a0b-4e34-bc7a-786901c61493\"" +
                ":{\"new\":{\"name\":\"tap2\",\"type\":\"\",\"options\":[\"map\",[]]}},\"" +
                "f3b84c90-a85b-4d97-9ddd-cd710a5490ce\":{\"new\":{\"name\":\"br0\"," +
                "\"type\":\"internal\",\"options\":[\"map\",[]]}},\"" +
                "e63cbe6f-ec12-4972-9170-079097e85c3d\":{\"new\":" +
                "{\"name\":\"tap3\",\"type\":\"\",\"options\":[\"map\",[]]}}," +
                "\"eb43c2ae-0e49-4ac1-b249-18d493f11422\":{\"new\":{\"name\":\"tap1\"," +
                "\"type\":\"\",\"options\":[\"map\",[]]}},\"79b2d0ba-9ead-4149-9e4c-428dd14dc987\"" +
                ":{\"new\":{\"name\":\"JUNIT_BRIDGE_TEST\",\"type\":\"internal\"," +
                "\"options\":[\"map\",[]]}}},\"Open_vSwitch\":" +
                "{\"2cfdf9dd-e2a3-46b9-b09d-fbc68f23bc5d\":{\"new\":" +
                "{\"ovs_version\":\"1.4.3\",\"cur_cfg\":301,\"bridges\":[\"set\"," +
                "[[\"uuid\",\"3732d17d-339f-4f9d-a553-4396e1158df7\"],[\"uuid\"," +
                "\"be7403fe-e124-4c29-931b-139cf060d021\"]]],\"manager_options\":" +
                "[\"uuid\",\"fc37548a-aa08-427f-bf8d-cd88d81ae099\"]}}},\"Bridge\"" +
                ":{\"3732d17d-339f-4f9d-a553-4396e1158df7\":{\"new\":{\"name\":\"" +
                "br0\",\"ports\":[\"set\",[[\"uuid\",\"303d6f72-340b-468e-8bb7-7e44f15b77af\"]" +
                ",[\"uuid\",\"7c1b9f41-8222-4c78-ad90-244e1a66baac\"],[\"uuid\"" +
                ",\"8be80f67-f27a-4822-8130-76aa43e8d292\"],[\"uuid\"," +
                "\"d97ecd2f-a0f9-495d-8637-e0849f7de291\"]]],\"controller\":" +
                "[\"set\",[]],\"fail_mode\":[\"set\",[]]}}," +
                "\"be7403fe-e124-4c29-931b-139cf060d021\":{\"new\":{\"name\":" +
                "\"JUNIT_BRIDGE_TEST\",\"ports\":[\"uuid\"," +
                "\"7eb5508f-b2d9-4343-b7f3-b109bcd0ae86\"],\"controller\":[\"set\"" +
                ",[]],\"fail_mode\":[\"set\",[]]}}},\"Manager\":{" +
                "\"fc37548a-aa08-427f-bf8d-cd88d81ae099\":{\"new\":{\"target\":" +
                "\"ptcp:6634:172.16.58.128\",\"is_connected\":false}}}}}";


        String kmsg = "{\"id\":0,\"error\":null,\"result\":{\"Port\"" +
                ":{\"d97ecd2f-a0f9-495d-8637-e0849f7de291\":{\"new\"" +
                ":{\"trunks\":[\"set\",[]],\"interfaces\":[\"uuid\"," +
                "\"f3b84c90-a85b-4d97-9ddd-cd710a5490ce\"]," +
                "\"name\":\"br0\",\"tag\":[\"set\",[]]}}," +
                "\"8be80f67-f27a-4822-8130-76aa43e8d292\":" +
                "{\"new\":{\"trunks\":[\"set\",[]],\"interfaces\":" +
                "[\"uuid\",\"181a8348-5a0b-4e34-bc7a-786901c61493\"]," +
                "\"name\":\"tap2\",\"tag\":[\"set\",[]]}}," +
                "\"7c1b9f41-8222-4c78-ad90-244e1a66baac\":{\"new\":" +
                "{\"trunks\":[\"set\",[]],\"interfaces\":[\"uuid\"," +
                "\"eb43c2ae-0e49-4ac1-b249-18d493f11422\"]," +
                "\"name\":\"tap1\",\"tag\":[\"set\",[]]}}," +
                "\"7eb5508f-b2d9-4343-b7f3-b109bcd0ae86\":{\"new\":" +
                "{\"trunks\":[\"set\",[]],\"interfaces\":[\"uuid\"" +
                ",\"79b2d0ba-9ead-4149-9e4c-428dd14dc987\"],\"name\":" +
                "\"JUNIT_BRIDGE_TEST\",\"tag\":[\"set\",[]]}}," +
                "\"303d6f72-340b-468e-8bb7-7e44f15b77af\":{\"new\":" +
                "{\"trunks\":[\"set\",[]],\"interfaces\":[\"uuid\"" +
                ",\"e63cbe6f-ec12-4972-9170-079097e85c3d\"],\"name\":" +
                "\"tap3\",\"tag\":[\"set\",[]]}}}}}";

        String kkllmsg = "{\"id\":0,\"error\":null," +
                "\"result\":{\"Port\":{\"ff306c93-bdef-4176-a4f3-d02e15654c42\":{\"new\":{\"name\":\"br1\"," +
                "\"trunks\":[\"set\",[]],\"interfaces\":[\"uuid\",\"89e67257-b713-4f93-b9af-a80427551972\"],\"ta" +
                "g\":[\"set\",[]]}},\"a6064640-e0bb-4c8f-a8ab-4ba5a49c6b6a\":{\"new\":{\"name\":\"gre1\",\"trunks\":[\"set\",[]]" +
                ",\"interfaces\":[\"uuid\",\"da6059d2-da62-4135-947d-a41b98f72309\"],\"tag\":[\"set\",[]]}},\"" +
                "c816ef48-055f-4929-bcc2-fbd6218211dd\":{\"new\":{\"name\":\"br0\",\"trunks\":[\"set\",[]],\"interfaces\":[\"uuid\"" +
                ",\"472fea0a-2c38-4f7b-8cb5-95f9fcbee79b\"],\"tag\":[\"set\",[]]}}},\"Controller\":{\"f0dbada6-838e-47a7-9ddc-2fd74fa5ae9e\":{\"new\":" +
                "{\"target\":\"tcp:192.168.1.18:6633\",\"is_connected\":false}}},\"Interface\":{\"89e67257-b713-4f93-b9af-a80427551972\":{\"new\":" +
                "{\"name\":\"br1\",\"type\":\"internal\",\"options\":[\"map\",[]]}},\"da6059d2-da62-4135-947d-a41b98f72309\":{\"new\":{\"name\":\"gre1\"," +
                "\"type\":\"gre\",\"options\":[\"map\",[[\"remote_ip\",\"192.168.1.10\"]]]}},\"472fea0a-2c38-4f7b-8cb5-95f9fcbee79b\":{\"new\":{\"name\":\"br0\"" +
                ",\"type\":\"internal\",\"options\":[\"map\",[]]}}},\"Open_vSwitch\":{\"2cfdf9dd-e2a3-46b9-b09d-fbc68f23bc5d\":{\"new\":{\"ovs_version\":\"1.4.3\"," +
                "\"cur_cfg\":412,\"manager_options\":[\"uuid\",\"2928ae71-fc80-4ead-b156-fbd2a97ee308\"],\"bridges\":[\"set\",[[\"uuid\",\"424544d3-eba9-412a-8fa6-844767f0ad32\"]," +
                "[\"uuid\",\"56f04394-7fba-4997-b784-5cf8ff5de1f2\"]]]}}},\"Manager\":{\"2928ae71-fc80-4ead-b156-fbd2a97ee308\":{\"new\":{\"target\":\"ptcp:6634:172.16.58.128\"," +
                "\"is_connected\":false}}},\"Bridge\":{\"424544d3-eba9-412a-8fa6-844767f0ad32\":{\"new\":{\"name\":\"br0\",\"ports\":[\"uuid\",\"c816ef48-055f-4929-bcc2-fbd6218211dd\"]" +
                ",\"fail_mode\":[\"set\",[]],\"controller\":[\"uuid\",\"f0dbada6-838e-47a7-9ddc-2fd74fa5ae9e\"]}},\"56f04394-7fba-4997-b784-5cf8ff5de1f2\":{\"new\":{\"name\":\"br1\"" +
                ",\"ports\":[\"set\",[[\"uuid\",\"a6064640-e0bb-4c8f-a8ab-4ba5a49c6b6a\"],[\"uuid\",\"ff306c93-bdef-4176-a4f3-d02e15654c42\"]]],\"fail_mode\":[\"set\",[]],\"controller\":[\"set\",[]]}}}}}";

        String lfmsg = "{\"id\":0,\"error\":null," +
                "\"result\":{\"Port\":{\"ff306c93-bdef-4176-a4f3-d02e15654c42\":{\"new\":{\"trunks\":[\"set\",[]]," +
                "\"interfaces\":[\"uuid\",\"89e67257-b713-4f93-b9af-a80427551972\"],\"name\":\"br1\"," +
                "\"tag\":[\"set\",[]]}},\"52f4b20f-9667-40a7-ac4b-22745e1caff2\":{\"new\":{\"trunks\":[\"set\",[]],\"interfaces\":[\"uuid\",\"33905368-e18e-4363-a29e-7312268e88bb\"],\"name\":\"vif0\",\"tag\":[\"set\",[]]}},\"a6064640-e0bb-4c8f-a8ab-4ba5a49c6b6a\":{\"new\":{\"trunks\":[\"set\",[]],\"interfaces\":[\"uuid\",\"da6059d2-da62-4135-947d-a41b98f72309\"],\"name\":\"gre1\",\"tag\":[\"set\",[]]}},\"c816ef48-055f-4929-bcc2-fbd6218211dd\":{\"new\":{\"trunks\":[\"set\",[]],\"interfaces\":[\"uuid\",\"472fea0a-2c38-4f7b-8cb5-95f9fcbee79b\"],\"name\":\"br0\",\"tag\":[\"set\",[]]}}},\"Controller\":{\"f0dbada6-838e-47a7-9ddc-2fd74fa5ae9e\":{\"new\":{\"target\":\"tcp:192.168.1.18:6633\",\"is_connected\":false}}},\"Interface\":{\"33905368-e18e-4363-a29e-7312268e88bb\":{\"new\":{\"name\":\"vif0\",\"type\":\"\",\"options\":[\"map\",[]]}},\"89e67257-b713-4f93-b9af-a80427551972\":{\"new\":{\"name\":\"br1\",\"type\":\"internal\",\"options\":[\"map\",[]]}},\"da6059d2-da62-4135-947d-a41b98f72309\":{\"new\":{\"name\":\"gre1\",\"type\":\"gre\",\"options\":[\"map\",[[\"remote_ip\",\"192.168.1.10\"]]]}},\"472fea0a-2c38-4f7b-8cb5-95f9fcbee79b\":{\"new\":{\"name\":\"br0\",\"type\":\"internal\",\"options\":[\"map\",[]]}}},\"Open_vSwitch\":{\"2cfdf9dd-e2a3-46b9-b09d-fbc68f23bc5d\":{\"new\":{\"ovs_version\":\"1.4.3\",\"cur_cfg\":412,\"bridges\":[\"set\",[[\"uuid\",\"424544d3-eba9-412a-8fa6-844767f0ad32\"],[\"uuid\",\"56f04394-7fba-4997-b784-5cf8ff5de1f2\"]]],\"manager_options\":[\"uuid\",\"2928ae71-fc80-4ead-b156-fbd2a97ee308\"]}}},\"Bridge\":{\"424544d3-eba9-412a-8fa6-844767f0ad32\":{\"new\":{\"name\":\"br0\",\"ports\":[\"set\",[[\"uuid\",\"52f4b20f-9667-40a7-ac4b-22745e1caff2\"],[\"uuid\",\"c816ef48-055f-4929-bcc2-fbd6218211dd\"]]],\"controller\":[\"uuid\",\"f0dbada6-838e-47a7-9ddc-2fd74fa5ae9e\"],\"fail_mode\":[\"set\",[]]}},\"56f04394-7fba-4997-b784-5cf8ff5de1f2\":{\"new\":{\"name\":\"br1\",\"ports\":[\"set\",[[\"uuid\",\"a6064640-e0bb-4c8f-a8ab-4ba5a49c6b6a\"],[\"uuid\",\"ff306c93-bdef-4176-a4f3-d02e15654c42\"]]],\"controller\":[\"set\",[]],\"fail_mode\":[\"set\",[]]}}},\"Manager\":{\"2928ae71-fc80-4ead-b156-fbd2a97ee308\":{\"new\":{\"target\":\"ptcp:6634:172.16.58.128\",\"is_connected\":false}}}}}";

        //Port only
        String vlmsg = "{\"id\":0,\"error\":null," +
                "\"result\":{\"Port\":{\"ff306c93-bdef-4176-a4f3-d02e15654c42\":{\"new\":{\"trunks\":[\"set\",[]],\"external_ids\":[\"map\",[]],\"interfaces\":[\"uuid\",\"89e67257-b713-4f93-b9af-a80427551972\"],\"name\":\"br1\",\"tag\":[\"set\",[]]}},\"52f4b20f-9667-40a7-ac4b-22745e1caff2\":{\"new\":{\"trunks\":[\"set\",[]],\"external_ids\":[\"map\",[[\"key1\",\"FOO\"]]],\"interfaces\":[\"uuid\",\"33905368-e18e-4363-a29e-7312268e88bb\"],\"name\":\"vif0\",\"tag\":[\"set\",[]]}},\"a6064640-e0bb-4c8f-a8ab-4ba5a49c6b6a\":{\"new\":{\"trunks\":[\"set\",[]],\"external_ids\":[\"map\",[]],\"interfaces\":[\"uuid\",\"da6059d2-da62-4135-947d-a41b98f72309\"],\"name\":\"gre1\",\"tag\":[\"set\",[]]}},\"c816ef48-055f-4929-bcc2-fbd6218211dd\":{\"new\":{\"trunks\":[\"set\",[]],\"external_ids\":[\"map\",[]],\"interfaces\":[\"uuid\",\"472fea0a-2c38-4f7b-8cb5-95f9fcbee79b\"],\"name\":\"br0\",\"tag\":[\"set\",[]]}}}}}";
        //Controller only
        String dlmsg = "{\"id\":0,\"error\":null," +
                "\"result\":{\"Controller\":{\"f0dbada6-838e-47a7-9ddc-2fd74fa5ae9e\":{\"new\":{\"target\":\"tcp:192.168.1.18:6633\",\"is_connected\":false}}}}}";

        //Interfaces only
        String elmsg = "{\"id\":0,\"error\":null," +
                "\"result\":{\"Interface\":{\"33905368-e18e-4363-a29e-7312268e88bb\":{\"new\":{\"name\":\"vif0\",\"type\":\"\",\"options\":[\"map\",[]]}},\"89e67257-b713-4f93-b9af-a80427551972\":{\"new\":{\"name\":\"br1\",\"type\":\"internal\",\"options\":[\"map\",[]]}},\"da6059d2-da62-4135-947d-a41b98f72309\":{\"new\":{\"name\":\"gre1\",\"type\":\"gre\",\"options\":[\"map\",[[\"remote_ip\",\"192.168.1.10\"]]]}},\"472fea0a-2c38-4f7b-8cb5-95f9fcbee79b\":{\"new\":{\"name\":\"br0\",\"type\":\"internal\",\"options\":[\"map\",[]]}}}}}";

        //Bridge only
        String nlmsg = "{\"id\":0,\"error\":null," +
                "\"result\":{\"Open_vSwitch\":{\"2cfdf9dd-e2a3-46b9-b09d-fbc68f23bc5d\":{\"new\":{\"ovs_version\":\"1.4.3\",\"cur_cfg\":412,\"bridges\":[\"set\",[[\"uuid\",\"424544d3-eba9-412a-8fa6-844767f0ad32\"],[\"uuid\",\"56f04394-7fba-4997-b784-5cf8ff5de1f2\"]]],\"manager_options\":[\"uuid\",\"2928ae71-fc80-4ead-b156-fbd2a97ee308\"]}}},\"Bridge\":{\"424544d3-eba9-412a-8fa6-844767f0ad32\":{\"new\":{\"name\":\"br0\",\"ports\":[\"set\",[[\"uuid\",\"52f4b20f-9667-40a7-ac4b-22745e1caff2\"],[\"uuid\",\"c816ef48-055f-4929-bcc2-fbd6218211dd\"]]],\"controller\":[\"uuid\",\"f0dbada6-838e-47a7-9ddc-2fd74fa5ae9e\"],\"fail_mode\":[\"set\",[]]}},\"56f04394-7fba-4997-b784-5cf8ff5de1f2\":{\"new\":{\"name\":\"br1\",\"ports\":[\"set\",[[\"uuid\",\"a6064640-e0bb-4c8f-a8ab-4ba5a49c6b6a\"],[\"uuid\",\"ff306c93-bdef-4176-a4f3-d02e15654c42\"]]],\"controller\":[\"set\",[]],\"fail_mode\":[\"set\",[]]}}}}}";

        //Manager only
        String rlmsg = "{\"id\":0,\"error\":null," +
                "\"result\":{\"Manager\":{\"2928ae71-fc80-4ead-b156-fbd2a97ee308\":{\"new\":{\"target\":\"ptcp:6634:172.16.58.128\",\"is_connected\":false}}}}}\n";

        //All Tables w/FOO
        String knlmsg = "{\"id\":0,\"error\":null," +
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
                "\"424544d3-eba9-412a-8fa6-844767f0ad32\"],[\"uuid\",\"" +
                "56f04394-7fba-4997-b784-5cf8ff5de1f2\"]]],\"manager_options\"" +
                ":[\"uuid\",\"2928ae71-fc80-4ead-b156-fbd2a97ee308\"]}}},\"" +
                "Bridge\":{\"424544d3-eba9-412a-8fa6-844767f0ad32\":{\"new\"" +
                ":{\"name\":\"br0\",\"ports\":[\"set\",[[\"uuid\"," +
                "\"52f4b20f-9667-40a7-ac4b-22745e1caff2\"],[\"uuid\",\"" +
                "c816ef48-055f-4929-bcc2-fbd6218211dd\"]]],\"controller\"" +
                ":[\"uuid\",\"f0dbada6-838e-47a7-9ddc-2fd74fa5ae9e\"],\"fail_mode\":" +
                "[\"set\",[]]}},\"56f04394-7fba-4997-b784-5cf8ff5de1f2\":{\"new\"" +
                ":{\"name\":\"br1\",\"ports\":[\"set\",[[\"uuid\"," +
                "\"a6064640-e0bb-4c8f-a8ab-4ba5a49c6b6a\"],[\"uuid\",\"" +
                "ff306c93-bdef-4176-a4f3-d02e15654c42\"]]],\"controller\":" +
                "[\"set\",[]],\"fail_mode\":[\"set\",[]]}}},\"Manager\"" +
                ":{\"2928ae71-fc80-4ead-b156-fbd2a97ee308\":{\"new\":{\"target\":" +
                "\"ptcp:6634:172.16.58.128\",\"is_connected\":false}}}}}";

        //new
        String fflmsg = "{\"method\":\"update\",\"id\":null,\"params\":[null," +
                "{\"Manager\":{\"2928ae71-fc80-4ead-b156-fbd2a97ee308\":{\"old\":{\"is_connected\":false}," +
                "\"new\":{\"target\":\"ptcp:6634:172.16.58.128\",\"is_connected\":true}}}}]}";

        String oolmsg = "{\"method\":\"update\",\"id\":null,\"params\":[null," +
                "{\"Manager\":{\"2928ae71-fc80-4ead-b156-fbd2a97ee308\":{\"old\":{\"is_connected\":false}," +
                "\"new\":{\"target\":\"ptcp:6634:172.16.58.128\",\"is_connected\":true}}}}]}";
        ObjectMapper mapper = new ObjectMapper();

        String tlmsg = "{\"Manager\":{\"2928ae71-fc80-4ead-b156-fbd2a97ee308\":{\"old\":{\"is_connected\":false},\"new\":{\"target\":\"ptcp:6634:172.16.58" +
                ".128\",\"is_connected\":true}}}}]}";

        String lmsg = "{\"id\":0,\"error\":null,\"result\":{\"Port\":{\"873dbd1b-6a6e-4a0f-9c1c-efce6cd4b566\":{\"new\":{\"trunks\":[\"set\",[]]," +
                "\"interfaces\":[\"uuid\",\"778eb6a5-55c3-4337-9aa4-0bbd8d347a40\"],\"name\":\"del\",\"tag\":[\"set\",[]]}}," +
                "\"ff306c93-bdef-4176-a4f3-d02e15654c42\":{\"new\":{\"trunks\":[\"set\",[]],\"interfaces\":[\"uuid\"," +
                "\"89e67257-b713-4f93-b9af-a80427551972\"],\"name\":\"br1\",\"tag\":[\"set\",[]]}}," +
                "\"52f4b20f-9667-40a7-ac4b-22745e1caff2\":{\"new\":{\"trunks\":[\"set\",[]],\"interfaces\":[\"uuid\"," +
                "\"33905368-e18e-4363-a29e-7312268e88bb\"],\"name\":\"vif0\",\"tag\":[\"set\",[]]}}," +
                "\"a6064640-e0bb-4c8f-a8ab-4ba5a49c6b6a\":{\"new\":{\"trunks\":[\"set\",[]],\"interfaces\":[\"uuid\"," +
                "\"da6059d2-da62-4135-947d-a41b98f72309\"],\"name\":\"gre1\",\"tag\":[\"set\",[]]}}," +
                "\"c816ef48-055f-4929-bcc2-fbd6218211dd\":{\"new\":{\"trunks\":[\"set\",[]],\"interfaces\":[\"uuid\"," +
                "\"472fea0a-2c38-4f7b-8cb5-95f9fcbee79b\"],\"name\":\"br0\",\"tag\":[\"set\",[]]}}}," +
                "\"Controller\":{\"f0dbada6-838e-47a7-9ddc-2fd74fa5ae9e\":{\"new\":{\"target\":\"tcp:192.168.1.18:6633\",\"is_connected\":false}}}," +
                "\"Interface\":{\"778eb6a5-55c3-4337-9aa4-0bbd8d347a40\":{\"new\":{\"name\":\"del\",\"type\":\"internal\",\"options\":[\"map\"," +
                "[]]}},\"33905368-e18e-4363-a29e-7312268e88bb\":{\"new\":{\"name\":\"vif0\",\"type\":\"\",\"options\":[\"map\",[]]}}," +
                "\"89e67257-b713-4f93-b9af-a80427551972\":{\"new\":{\"name\":\"br1\",\"type\":\"internal\",\"options\":[\"map\",[]]}}," +
                "\"da6059d2-da62-4135-947d-a41b98f72309\":{\"new\":{\"name\":\"gre1\",\"type\":\"gre\",\"options\":[\"map\",[[\"remote_ip\"," +
                "\"192.168.1.10\"]]]}},\"472fea0a-2c38-4f7b-8cb5-95f9fcbee79b\":{\"new\":{\"name\":\"br0\",\"type\":\"internal\"," +
                "\"options\":[\"map\",[]]}}},\"Open_vSwitch\":{\"2cfdf9dd-e2a3-46b9-b09d-fbc68f23bc5d\":{\"new\":{\"ovs_version\":\"1.4.3\"," +
                "\"cur_cfg\":718,\"bridges\":[\"set\",[[\"uuid\",\"424544d3-eba9-412a-8fa6-844767f0ad32\"],[\"uuid\"," +
                "\"56f04394-7fba-4997-b784-5cf8ff5de1f2\"],[\"uuid\",\"c1f4bf03-dc6d-4db4-867b-a00031dd68b4\"]]],\"manager_options\":[\"uuid\"," +
                "\"2928ae71-fc80-4ead-b156-fbd2a97ee308\"]}}},\"Bridge\":{\"c1f4bf03-dc6d-4db4-867b-a00031dd68b4\":{\"new\":{\"name\":\"del\"," +
                "\"ports\":[\"uuid\",\"873dbd1b-6a6e-4a0f-9c1c-efce6cd4b566\"],\"controller\":[\"set\",[]],\"fail_mode\":[\"set\",[]]}}," +
                "\"56f04394-7fba-4997-b784-5cf8ff5de1f2\":{\"new\":{\"name\":\"br1\",\"ports\":[\"set\",[[\"uuid\"," +
                "\"a6064640-e0bb-4c8f-a8ab-4ba5a49c6b6a\"],[\"uuid\",\"ff306c93-bdef-4176-a4f3-d02e15654c42\"]]],\"controller\":[\"set\",[]],\"fail_mode\":[\"set\",[]]}},\"424544d3-eba9-412a-8fa6-844767f0ad32\":{\"new\":{\"name\":\"br0\",\"ports\":[\"set\",[[\"uuid\",\"52f4b20f-9667-40a7-ac4b-22745e1caff2\"],[\"uuid\",\"c816ef48-055f-4929-bcc2-fbd6218211dd\"]]],\"controller\":[\"uuid\",\"f0dbada6-838e-47a7-9ddc-2fd74fa5ae9e\"],\"fail_mode\":[\"set\",[]]}}},\"Manager\":{\"2928ae71-fc80-4ead-b156-fbd2a97ee308\":{\"new\":{\"target\":\"ptcp:6634:172.16.58.128\",\"is_connected\":false}}}}}";
        try {

            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("Raw String ====" + lmsg);
            System.out.println("--------------------------------------------------------------------------------");

            JsonFactory jf = new MappingJsonFactory();
            JsonParser jp = jf.createParser(new StringReader(lmsg));
            JsonNode jn = jp.readValueAsTree();
            Data hostreply = mapper.treeToValue(jn, Data.class);
            //All elements
            System.out.println("All Tables ==> " + hostreply.getResults());
            System.out.println("--------------------------------------------------------------------------------");
            //Single Table out
            System.out.println("Port Table Only ==> " + hostreply.getResults().getPortTable());
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("Bridge Table Only ==> " + hostreply.getResults().getBridgeTable());

            System.out.println("--------------------------------------------------------------------------------");
            int i_port = 1;
            Set portTable = hostreply.getResults().getPortTable().entrySet();
            Iterator itport = portTable.iterator();
            while(itport.hasNext()) {
                System.out.println("Port Table Row " + i_port++ + "==> " + itport.next());
            }
            System.out.println("--------------------------------------------------------------------------------");
            //Get Port UUIDs
            Set<String> portuuids = hostreply.getResults().getPortTable().keySet();
            System.out.println("Port UUIDs ==> " + portuuids);
            System.out.println("--------------------------------------------------------------------------------");
            //Get Bridge UUIDs
            System.out.println("Bridge UUIDs ==> " + hostreply.getResults().getBridgeTable().keySet());
            System.out.println("Bridge UUIDs ==> " + hostreply.getResults().getBridgeTable().values());
            System.out.println("--------------------------------------------------------------------------------");
            //Get Hash
            int i_bridge = 1;
            Set bridgeTable = hostreply.getResults().getBridgeTable().entrySet();
            Iterator itbridge = bridgeTable.iterator();
            while(itbridge.hasNext()) {
                System.out.println("Bridge Table Row " + i_bridge++ + "==> " + itbridge.next());
            }
            System.out.println("--------------------------------------------------------------------------------");



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
