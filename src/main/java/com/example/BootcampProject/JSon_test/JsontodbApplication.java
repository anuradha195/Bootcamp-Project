//package com.example.BootcampProject.JSon_test;
//
//import com.example.BootcampProject.JSon_test.GoogleFitStepResponse;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import java.io.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
//import java.time.Instant;
//import java.time.LocalDate;
//import java.time.ZoneId;
//
//@SpringBootApplication
//public class JsontodbApplication {
//
//    static String data = "{\n" +
//            "  \"bucket\": [\n" +
//            "    {\n" +
//            "      \"startTimeMillis\": \"1561669200000\",\n" +
//            "      \"endTimeMillis\": \"1561755600000\",\n" +
//            "      \"dataset\": [\n" +
//            "        {\n" +
//            "          \"dataSourceId\": \"derived:com.google.step_count.delta:com.google.android.gms:aggregated\",\n" +
//            "          \"point\": []\n" +
//            "        }\n" +
//            "      ]\n" +
//            "    },\n" +
//            "    {\n" +
//            "      \"startTimeMillis\": \"1561755600000\",\n" +
//            "      \"endTimeMillis\": \"1561842000000\",\n" +
//            "      \"dataset\": [\n" +
//            "        {\n" +
//            "          \"dataSourceId\": \"derived:com.google.step_count.delta:com.google.android.gms:aggregated\",\n" +
//            "          \"point\": [\n" +
//            "            {\n" +
//            "              \"startTimeNanos\": \"1561786784531074393\",\n" +
//            "              \"originDataSourceId\": \"raw:com.google.step_count.cumulative:motorola:Moto G (5S) Plus:c5304cda931e8beb:Step Counter\",\n" +
//            "              \"endTimeNanos\": \"1561838045542278100\",\n" +
//            "              \"value\": [\n" +
//            "                {\n" +
//            "                  \"mapVal\": [],\n" +
//            "                  \"intVal\": 77\n" +
//            "                }\n" +
//            "              ],\n" +
//            "              \"dataTypeName\": \"com.google.step_count.delta\"\n" +
//            "            }\n" +
//            "          ]\n" +
//            "        }\n" +
//            "      ]\n" +
//            "    },\n" +
//            "    {\n" +
//            "      \"startTimeMillis\": \"1561842000000\",\n" +
//            "      \"endTimeMillis\": \"1561928400000\",\n" +
//            "      \"dataset\": [\n" +
//            "        {\n" +
//            "          \"dataSourceId\": \"derived:com.google.step_count.delta:com.google.android.gms:aggregated\",\n" +
//            "          \"point\": [\n" +
//            "            {\n" +
//            "              \"startTimeNanos\": \"1561865964180661531\",\n" +
//            "              \"originDataSourceId\": \"raw:com.google.step_count.cumulative:motorola:Moto G (5S) Plus:c5304cda931e8beb:Step Counter\",\n" +
//            "              \"endTimeNanos\": \"1561928400000000000\",\n" +
//            "              \"value\": [\n" +
//            "                {\n" +
//            "                  \"mapVal\": [],\n" +
//            "                  \"intVal\": 4470\n" +
//            "                }\n" +
//            "              ],\n" +
//            "              \"dataTypeName\": \"com.google.step_count.delta\"\n" +
//            "            }\n" +
//            "          ]\n" +
//            "        }\n" +
//            "      ]\n" +
//            "    },\n" +
//            "    {\n" +
//            "      \"startTimeMillis\": \"1561928400000\",\n" +
//            "      \"endTimeMillis\": \"1562014800000\",\n" +
//            "      \"dataset\": [\n" +
//            "        {\n" +
//            "          \"dataSourceId\": \"derived:com.google.step_count.delta:com.google.android.gms:aggregated\",\n" +
//            "          \"point\": [\n" +
//            "            {\n" +
//            "              \"startTimeNanos\": \"1561928400000000000\",\n" +
//            "              \"originDataSourceId\": \"raw:com.google.step_count.cumulative:motorola:Moto G (5S) Plus:c5304cda931e8beb:Step Counter\",\n" +
//            "              \"endTimeNanos\": \"1562011909250342513\",\n" +
//            "              \"value\": [\n" +
//            "                {\n" +
//            "                  \"mapVal\": [],\n" +
//            "                  \"intVal\": 8771\n" +
//            "                }\n" +
//            "              ],\n" +
//            "              \"dataTypeName\": \"com.google.step_count.delta\"\n" +
//            "            }\n" +
//            "          ]\n" +
//            "        }\n" +
//            "      ]\n" +
//            "    },\n" +
//            "    {\n" +
//            "      \"startTimeMillis\": \"1562014800000\",\n" +
//            "      \"endTimeMillis\": \"1562101200000\",\n" +
//            "      \"dataset\": [\n" +
//            "        {\n" +
//            "          \"dataSourceId\": \"derived:com.google.step_count.delta:com.google.android.gms:aggregated\",\n" +
//            "          \"point\": [\n" +
//            "            {\n" +
//            "              \"startTimeNanos\": \"1562047041090066141\",\n" +
//            "              \"originDataSourceId\": \"raw:com.google.step_count.cumulative:motorola:Moto G (5S) Plus:c5304cda931e8beb:Step Counter\",\n" +
//            "              \"endTimeNanos\": \"1562098104593284550\",\n" +
//            "              \"value\": [\n" +
//            "                {\n" +
//            "                  \"mapVal\": [],\n" +
//            "                  \"intVal\": 2514\n" +
//            "                }\n" +
//            "              ],\n" +
//            "              \"dataTypeName\": \"com.google.step_count.delta\"\n" +
//            "            }\n" +
//            "          ]\n" +
//            "        }\n" +
//            "      ]\n" +
//            "    },\n" +
//            "    {\n" +
//            "      \"startTimeMillis\": \"1562101200000\",\n" +
//            "      \"endTimeMillis\": \"1562187600000\",\n" +
//            "      \"dataset\": [\n" +
//            "        {\n" +
//            "          \"dataSourceId\": \"derived:com.google.step_count.delta:com.google.android.gms:aggregated\",\n" +
//            "          \"point\": [\n" +
//            "            {\n" +
//            "              \"startTimeNanos\": \"1562131189930196518\",\n" +
//            "              \"originDataSourceId\": \"raw:com.google.step_count.cumulative:motorola:Moto G (5S) Plus:c5304cda931e8beb:Step Counter\",\n" +
//            "              \"endTimeNanos\": \"1562185607690100594\",\n" +
//            "              \"value\": [\n" +
//            "                {\n" +
//            "                  \"mapVal\": [],\n" +
//            "                  \"intVal\": 603\n" +
//            "                }\n" +
//            "              ],\n" +
//            "              \"dataTypeName\": \"com.google.step_count.delta\"\n" +
//            "            }\n" +
//            "          ]\n" +
//            "        }\n" +
//            "      ]\n" +
//            "    },\n" +
//            "    {\n" +
//            "      \"startTimeMillis\": \"1562187600000\",\n" +
//            "      \"endTimeMillis\": \"1562263038000\",\n" +
//            "      \"dataset\": [\n" +
//            "        {\n" +
//            "          \"dataSourceId\": \"derived:com.google.step_count.delta:com.google.android.gms:aggregated\",\n" +
//            "          \"point\": [\n" +
//            "            {\n" +
//            "              \"startTimeNanos\": \"1562211578947832983\",\n" +
//            "              \"originDataSourceId\": \"raw:com.google.step_count.cumulative:motorola:Moto G (5S) Plus:c5304cda931e8beb:Step Counter\",\n" +
//            "              \"endTimeNanos\": \"1562260254803623356\",\n" +
//            "              \"value\": [\n" +
//            "                {\n" +
//            "                  \"mapVal\": [],\n" +
//            "                  \"intVal\": 2723\n" +
//            "                }\n" +
//            "              ],\n" +
//            "              \"dataTypeName\": \"com.google.step_count.delta\"\n" +
//            "            }\n" +
//            "          ]\n" +
//            "        }\n" +
//            "      ]\n" +
//            "    }\n" +
//            "  ]\n" +
//            "}";
//    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (DATE, STEP,) VALUES (?,?)";
//
//    public static void main(String[] args) throws IOException {
////		try {
////			String ip = "74.125.45.100";
////			String key = "9d64fcfdfacc213csfsfc7ddsf4ef911dfe97b55e4fdsf696be3532bf8302876c09ebad06b";
////			String url = "http://api.ipinfodb.com/v3/ip-city/?key=" + key + "&ip=" + ip + "&format=json";
////			URL obj = new URL(url);
////			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
////			// optional default is GET
////			con.setRequestMethod("GET");
////			//add request header
////			con.setRequestProperty("User-Agent", "Mozilla/5.0");
////			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
////			String inputLine;
////			StringBuffer response = new StringBuffer();
////			while ((inputLine = in .readLine()) != null) {
////				response.append(inputLine);
////			} in .close();
//        ObjectMapper mapper = new ObjectMapper();
//       GoogleFitStepResponse obj = mapper.readValue(data, GoogleFitStepResponse.class);
//       /*File resource = new File(root, "GOOGLE RESPONSE JSON");
//        InputStream inputStream = new FileInputStream(new File("GOOGLE RESPONSE JSON.json"));
//        TypeReference<List<GoogleFitStepResponse>> typeReference=new TypeReference<List<GoogleFitStepResponse>>(){};
//        GoogleFitStepResponse obj = mapper.readValue(inputStream, typeReference);*/
//        System.out.println(obj);
//        try {
//            String url = "jdbc:mysql://localhost:3306/sakila";
//            String username = "root";
//            String password = "Rupalidole123@";
//            Connection conn = DriverManager.getConnection(url, username, password);
//            Statement st = conn.createStatement();
//            System.out.println("Connected");
//            for (int i = 1; i < 7; i++) {
//                int steps = obj.getBucket()[i].getDataset()[0].getPoint()[0].getValue()[0].getIntVal();
//                String date = obj.getBucket()[i].getStartTimeMillis();
//                long date1 = Long.valueOf(date);
//                LocalDate date2 =
//                        Instant.ofEpochMilli(date1).atZone(ZoneId.systemDefault()).toLocalDate();
//              // System.out.println("date= "+date2+", step= "+steps);
//
//                System.out.println("INSERT INTO Persons (StepDate,Steps) " +
//                        "VALUES ('"+date2+"',"+steps+")");
//                //st.executeUpdate("create table Accounts ( name char(20) )");
//                st.executeUpdate("INSERT INTO Persons (StepDate,Steps) " +
//                        "VALUES ('"+date2+"',"+steps+")");
//            }
//
//            conn.close();
//        } catch (Exception e) {
//            System.err.println("Got an exception! ");
//            System.err.println(e.getMessage());
//        }
//    }
//
//
//}
//
