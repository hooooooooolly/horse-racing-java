package net.hollage.horseracing.contoller;

import java.util.List;
import lombok.AllArgsConstructor;
import net.hollage.horseracing.domain.ResultFilterEntity;
import net.hollage.horseracing.dto.request.ResultFilterForm;
import net.hollage.horseracing.dto.view.ResultViewModel;
import net.hollage.horseracing.service.ResultService;
import org.modelmapper.ModelMapper;
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

  /** ModelMapper */
  private final ModelMapper modelMapper;

  /** ResultService */
  private final ResultService resultService;

  @GetMapping("/resultFilter")
  public ModelAndView getResultFilter(ModelAndView mav) {
    mav.addObject("form", new ResultFilterForm());
    mav.setViewName("resultFilter");
    return mav;
  }

  @PostMapping("/resultFilter")
  public ModelAndView searchResult(
      @ModelAttribute("form") @Validated ResultFilterForm form,
      BindingResult bindingResult,
      ModelAndView mav) {
    if (bindingResult.hasErrors()) {
      return mav;
    }
    ResultFilterEntity inDto = modelMapper.map(form, ResultFilterEntity.class);
    List<ResultViewModel> outDtoList = resultService.fetchResult(inDto);
    mav.addObject("outDtoList", outDtoList);
    mav.setViewName("resultFilter");
    return mav;
  }
}
