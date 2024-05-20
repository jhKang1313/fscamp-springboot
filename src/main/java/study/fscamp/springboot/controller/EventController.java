package study.fscamp.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/event")
@Controller
public class EventController {
  @GetMapping("/")
  public String event(){
    return "/events/index";
  }
  @GetMapping("/{eventId}")
  public String eventDetail(@PathVariable Integer eventId){
    return "/events/detail";
  }
}
