package com.BootcampProject;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

@org.springframework.stereotype.Controller
public class Controller {

    private User user;
    private String clientID = "424969099056-3evvb3dehl985orl16u96pna1q212l9r.apps.googleusercontent.com";
    private String clientSecret = "LoavMBL_6hY0Ajzqjt3NR3EM";

    @GetMapping("/")
//    @ResponseBody
    public String login(String username, String password) {
        this.user = new User(username, password);
//        return  "<a href='/getTokens'>Sign in with Google<a><br/>\n";
        return "index";
    }

    @GetMapping("/getTokens")
    public String redirect() {
        String redirectUrl = "https://accounts.google.com/o/oauth2/v2/auth?client_id=424969099056-3evvb3dehl985orl16u96pna1q212l9r.apps.googleusercontent.com&response_type=code&scope=https://www.googleapis.com/auth/fitness.activity.read&redirect_uri=http://localhost:8080/Chart&access_type=offline";
        return "redirect:" + redirectUrl;
    }

    @GetMapping("/Chart")
    //@ResponseBody
    public String stepchart(@RequestParam String code, Model model) throws IOException {
        GoogleTokenResponse tokenResponse =
                new GoogleAuthorizationCodeTokenRequest(
                        new NetHttpTransport(),
                        JacksonFactory.getDefaultInstance(),
                        "https://www.googleapis.com/oauth2/v4/token",
                        clientID,
                        clientSecret,
                        code,
                        "http://localhost:8080/Chart")
                        .execute();
        user.setAccessToken(tokenResponse.getAccessToken());
        DailySteps[] results = user.login();
        model.addAttribute("steps", Arrays.asList(results).stream().map(u -> u.getSteps()).collect(Collectors.toList()));
        model.addAttribute("labels", Arrays.asList(results).stream().map(u -> u.getDate()).collect(Collectors.toList()));

        return "Chart";
        // return graph(results);
<<<<<<< HEAD
    } //end of stepchart

    @RequestMapping(value = {"/WeeklyChart"})
    @ResponseBody
    public String getWeeklyGraph() throws Exception {

        StepsWeekly reqWeeklyData = new StepsWeekly();
        reqWeeklyData.getWeeklyStepCount();
        String str = str1+str2;
        for (int i = 0; i < reqWeeklyData.stepsListWeekly.size(); i++) {
            str = str + "['" + reqWeeklyData.dateListWeekly.get(i) + "'" + ", " + reqWeeklyData.stepsListWeekly.get(i) + ", " + reqWeeklyData.stepsListWeekly.get(i) + "],\n";
        }
        str = str + str3;

        return str;
    }

    @RequestMapping(value = {"/MonthlyChart"})
    @ResponseBody
    public String getMonthlyGraph() throws Exception {

        StepsMonthly reqMonthlyData = new StepsMonthly();
        reqMonthlyData.getMonthlyStepCount();
        String str = str1+str4;
        for (int i = 0; i < reqMonthlyData.stepsListMonthly.size(); i++) {
            str = str + "['" + reqMonthlyData.dateListMonthly.get(i) + "'" + ", " + reqMonthlyData.stepsListMonthly.get(i)+ "],\n";
        }
        str = str +str3 ;
        return str;
    }

        public String graph(DailySteps[] results) {
=======
    }

    public String graph(DailySteps[] results) {
>>>>>>> 55d9c3c764bab79ef8411b88be59f7dbb0147519
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < results.length; i++) {
            sb.append(results[i].getDate());
            sb.append(" ");
            sb.append(results[i].getSteps() + "<br/>");
        }
        return sb.toString();
    }
<<<<<<< HEAD

    String str1="<!DOCTYPE html>\n"
            + "<html>\r\n" +
            "  <head>\r\n" +
            "<style>"+
            "body {\r\n" +
            "-webkit-animation: colorchange 60s infinite;"+
            "animation: colorchange 60s infinite;"+
            "}"+
            "@-webkit-keyframes colorchange {"+
            "0%  {background: #33FFF3;}"+
            "25%  {background: #78281F;}"+
            "50%  {background: #117A65;}"+
            "75%  {background: #DC7633;}"+
            "100% {background: #9B59B6;}"+
            "}"+
            "@keyframes colorchange {"+
            "0%  {background: #33FFF3;}"+
            "25%  {background: #78281F;}"+
            "50%  {background: #117A65;}"+
            "75%  {background: #DC7633;}"+
            "100% {background: #9B59B6;}"+
            "}"+

            "</style>"+
            "    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\r\n" +
            "    <script type=\"text/javascript\">\r\n" +
            "      google.charts.load('current', {'packages':['corechart']});\r\n" +
            "      google.charts.setOnLoadCallback(drawChart);\r\n" +
            "\r\n" +
            "      function drawChart() {\r\n" +
            "        var data = google.visualization.arrayToDataTable([\n";
    String str2="['Date', 'Steps', {type: 'number', role: 'annotation'}],\n";
    String str3="]);\r\n" +
            "\r\n" +
            "        var options = {\r\n" +
            "          title: 'Weekly Steps Count',\r\n" +
            "          curveType: 'function',\r\n" +
            "          legend: { position: 'bottom' }\r\n" +
            "        };\r\n" +
            "\r\n" +
            "        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));\r\n" +
            "\r\n" +
            "        chart.draw(data, options);\r\n" +
            "      }\r\n" +
            "    </script>\r\n" +
            "  </head>\r\n" +
            "  <body>\r\n" +
            "    <div id=\"curve_chart\" style=\"width: 900px; height: 500px\"></div>\r\n" +
            "  </body>\r\n" +
            "</html>";
    String str4="['Date', 'Steps'],\n";

=======
>>>>>>> 55d9c3c764bab79ef8411b88be59f7dbb0147519
}
