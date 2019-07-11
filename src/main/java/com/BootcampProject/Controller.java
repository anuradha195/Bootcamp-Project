package com.BootcampProject;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.sun.net.httpserver.HttpExchange;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

@org.springframework.stereotype.Controller
public class Controller {

    private User user;
    private String clientID = "424969099056-3evvb3dehl985orl16u96pna1q212l9r.apps.googleusercontent.com";
    private String clientSecret = "LoavMBL_6hY0Ajzqjt3NR3EM";

    @GetMapping("/")
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(String username, String password) {

       // public String start(index index) {
           // return "home";
       // }
        User user = new User(username, password);
        this.user = user;
        return  "<a href='/getTokens'>Sign in with Google<a><br/>\n";
        //return "index";
    }


//        public void handle(HttpExchange he) throws IOException {
//            File file = new File("index.html");
//            he.sendResponseHeaders(200, file.length());
//            try (
//                    OutputStream os = he.getResponseBody()) {
//                Files.copy(file.toPath(), os);
//            }
//        }
//@RequestMapping("/index")
//public ModelAndView index(@RequestParam("index") int login) {
//    ModelAndView modelAndView = new ModelAndView();
//    modelAndView.setViewName("specimenDetails");
//   // List<SpecimenDTO> specimens = specimenService.fetchSpecimensByPlantId(plantId);
//    modelAndView.addObject("signin", login);
//    return modelAndView;
//}

    @GetMapping("/getTokens")
    public String redirect() {
        String redirectUrl = "https://accounts.google.com/o/oauth2/v2/auth?client_id=424969099056-3evvb3dehl985orl16u96pna1q212l9r.apps.googleusercontent.com&response_type=code&scope=https://www.googleapis.com/auth/fitness.activity.read&redirect_uri=http://localhost:8080/Chart&access_type=offline";
        return "redirect:" + redirectUrl;
    }

    @GetMapping("/Chart")
    @ResponseBody
    public String stepchart(@RequestParam String code) throws IOException {
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
        return graph(results);
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
