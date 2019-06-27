package com.example.BootcampProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestParam;

    @Controller
    @RequestMapping(value = "/", produces = "text/html;charset=UTF-8")
    public class Controller {

    @GetMapping ("")
    @ResponseBody
        public String homePage(@RequestParam(value ="name", required=false)String name, HttpServletRequest request,
                               HttpServletResponse response) {
        StringBuilder sb = new StringBuilder();
        sb.append("<a href='/signIn'>Sign In<a><br/>\n");
        sb.append("<a href='/createAccount'>Create Account<a><br/>\n");
        response.setStatus(HttpServletResponse.SC_OK);
        return sb.toString();
    }

    @GetMapping("/signIn")
    @ResponseBody
        public String signIn(@RequestParam(value="Username", required = false)
                                         String password, @RequestParam(value="Password", required = false)
            String username, HttpServletRequest request, HttpServletResponse response) {
        if (null == username || null == password) {
            return "<form action=">\n +
                    "Username: <input type='text' username = 'Username' value="><br/>\n"+
                    "Password: <input type='text' password = 'Password' value ="><br/>\n"+
                    "<input type='submit' value ='Login' </form><br/>\n" +
                            "<a href='/'>Back</a>\n";
        }
    }
}
