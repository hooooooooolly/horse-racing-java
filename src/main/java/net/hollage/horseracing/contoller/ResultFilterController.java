package net.hollage.horseracing.contoller;

import java.util.List;
import lombok.AllArgsConstructor;
import net.hollage.horseracing.dto.ResultFilterForm;
import net.hollage.horseracing.dto.ResultFilterInDto;
import net.hollage.horseracing.dto.ResultOutDto;
import net.hollage.horseracing.mapper.ResultFilterMapper;
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

  /** MyBatisMapper */
  private final ResultFilterMapper resultMapper;

  /** ModelMapper */
  private final ModelMapper modelMapper;

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
    ResultFilterInDto inDto = modelMapper.map(form, ResultFilterInDto.class);
    List<ResultOutDto> outDto = resultMapper.selectResult(inDto);
    System.out.println(outDto);

    mav.setViewName("resultFilter");
    return mav;
  }
}
