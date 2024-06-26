package study.fscamp.springboot.controller.api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APIEventController {

  @GetMapping("/events")
  public List<String> getEvents(){
    return List.of("event1", "event2");
  }

  @PostMapping("/events")
  public Boolean createEvents(){
    return true;
  }

  @GetMapping("/events/{eventId}")
  public String getEvent(@PathVariable Integer eventId){
    return "event" + eventId;
  }

  @PutMapping("/events/{eventId}")
  public Boolean modifyEvent(@PathVariable Integer eventId){
    return true;
  }

  @DeleteMapping("events/{eventId}")
  public Boolean removeEvent(@PathVariable Integer eventId){
    return true;
  }

}
