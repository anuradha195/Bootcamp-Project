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
    }

    public String graph(DailySteps[] results) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < results.length; i++) {
            sb.append(results[i].getDate());
            sb.append(" ");
            sb.append(results[i].getSteps() + "<br/>");
        }
        return sb.toString();
    }
}
