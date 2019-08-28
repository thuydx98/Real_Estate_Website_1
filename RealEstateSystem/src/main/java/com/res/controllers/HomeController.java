package com.res.controllers;

import com.res.forms.ChartDataByYear;
import com.res.services.CustomerService;
import com.res.services.EmployeeService;
import com.res.services.PostService;
import com.res.utils.WebUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/")
    public String index(Model model) {

        List<ChartDataByYear> lstChartData = new ArrayList<>();
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        for (int i = 6; i >= 0; i--) {
            int year = cal.get(Calendar.YEAR) - i;
            int totalPosts = this.postService.totalPostsByYear(year);
            int totalUsers = this.customerService.totalCustomersByYear(year);

            ChartDataByYear data = new ChartDataByYear();
            data.setPeriod(String.valueOf(year));
            data.setValue1(totalPosts);
            data.setValue2(totalUsers);

            lstChartData.add(data);
        }

        model.addAttribute("lstChartData", lstChartData);
        model.addAttribute("totalPosts", postService.totalPosts());
        model.addAttribute("totalBlockedPosts", postService.totalBlockedPosts());
        model.addAttribute("totalEmployees", this.employeeService.totalEmployees());
        model.addAttribute("totalCustomers", customerService.totalCustomers());

        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginAdmin() {
        return "login";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName()
                    + ", but the page you are looking for can't have permission for you. " +
                    "Try checking the URL for the error, then hit the refresh button on your " +
                    "browser or try found something else in our app.";
            model.addAttribute("message", message);

        }

        return "errors/403Page";
    }

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String notFound(Model model, Principal principal) {
        return "errors/404Page";
    }

    @RequestMapping(value = "/500", method = RequestMethod.GET)
    public String internal(Model model, Principal principal) {
        return "errors/500Page";
    }
}
