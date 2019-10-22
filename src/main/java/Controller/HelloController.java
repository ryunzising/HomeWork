package Controller;

import POJO.flight;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class HelloController {
    @Autowired
    private UserService userServiceimpl;

    @ResponseBody
    @RequestMapping(value = "/Flight/{schedules}",method = RequestMethod.GET)
    public List<flight> getFlightInfoBySchedules(@PathVariable String schedules){
        return userServiceimpl.queryBySchedules(schedules);
    }
    @ResponseBody
    @RequestMapping(value = "/Airline/{airline}",method = RequestMethod.GET)
    public List<flight> getFlightInfoByAirlines(@PathVariable String airline){
        return userServiceimpl.queryByAirlines(airline);
    }
    @ResponseBody
    @RequestMapping(value = "/Departure/{City}",method = RequestMethod.GET)
    public List<flight> getFlightInfoByDeCity(@PathVariable String City){
        return userServiceimpl.queryByDeCity(City);
    }
    @ResponseBody
    @RequestMapping(value = "/Landing/{City}",method = RequestMethod.GET)
    public List<flight> getFlightInfoByLaCity(@PathVariable String City){
        return userServiceimpl.queryByLaCity(City);
    }
    @RequestMapping(value = "/insertData",method = RequestMethod.POST)
    public String addFlightData(@RequestParam(value = "deCity")String deCity,@RequestParam(value = "laCity")String laCity,@RequestParam(value = "schedules")String schedules
    ,@RequestParam(value = "airlines")String airlines,@RequestParam(value = "models")String models,@RequestParam(value = "deAirport")String deAirport,@RequestParam(value = "laAirport")String laAirport){
        int result=userServiceimpl.addFlightData(deCity,laCity,schedules,airlines,models,deAirport,laAirport);
        if (result==1) return "success";
        else return "fail";
    }


}
