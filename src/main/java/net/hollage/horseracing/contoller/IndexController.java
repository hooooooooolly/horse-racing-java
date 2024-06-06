package net.hollage.horseracing.contoller;

import lombok.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

  @GetMapping("/")
  public ModelAndView getIndex(@NonNull ModelAndView mav) {
    mav.setViewName("index");
    return mav;
  }
}
