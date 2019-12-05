package notFinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @RequestMapping(path = "/")
    public String showHomePage(){
        return "index";
    }

    @RequestMapping("/errors")
    public String showErrorPage(HttpServletRequest request,
                                Model model){
        int requestCode = (Integer) request.getAttribute("javax.servlet.error.status_code");

        String errorMsg;

        switch (requestCode){
            case 400:
                errorMsg = "Http Error 400: Bad Request";
                break;
            case 404:
                errorMsg = "Http Error 404: Resource not found";
                break;
            case 500:
                errorMsg = "Http Error 500: Internal server error";
                break;
            default:
                errorMsg = "Everything broke. Go to bed and start your day over again";
        }

        model.addAttribute("errorMessage",errorMsg);

        return "errors";
    }
}
