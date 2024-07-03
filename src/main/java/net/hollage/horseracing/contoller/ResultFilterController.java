package net.hollage.horseracing.contoller;

import lombok.AllArgsConstructor;
import net.hollage.horseracing.dto.ResultFilterForm;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@RestController
public class ResultFilterController {

  /** 画面に表示する結果情報 */
  //  private final ResultRepository resultRepository;

  /** 結果加工用Mapper */
  //  private final ResultMapper resultMapper;

  @GetMapping("/resultFilter")
  public ModelAndView getResultFilter(ModelAndView mav) {
    mav.addObject("form", new ResultFilterForm());
    mav.setViewName("resultFilter");
    return mav;
  }

  @PostMapping("/resultFilter/search")
  public ModelAndView searchResult(
      @ModelAttribute("form") @Validated ResultFilterForm form,
      BindingResult bindingResult,
      ModelAndView mav) {
    if (bindingResult.hasErrors()) {
      return mav;
    }
    System.out.println(form);

    mav.setViewName("resultFilter");
    return mav;
  }
}
