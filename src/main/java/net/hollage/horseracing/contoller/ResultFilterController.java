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

  @PostMapping("/resultFilter")
  public ModelAndView searchResult(
      @ModelAttribute("form") @Validated ResultFilterForm form,
      BindingResult bindingResult,
      ModelAndView mav) {
    if (bindingResult.hasErrors()) {
      return mav;
    }
    ResultFilterInDto inDto = modelMapper.map(form, ResultFilterInDto.class);
    List<ResultOutDto> outDtoList = resultMapper.selectResult(inDto);
    // 的中率と回収率を算出
    outDtoList.stream()
        .peek(dto -> dto.setHitRate(calcRate(dto.getPurchasePair(), dto.getHitPair()).toString()))
        .forEach(
            dto ->
                dto.setRecoveryRate(
                    calcRate(dto.getPurchaseAmount(), dto.getCollectionAmount()).toString()));
    mav.addObject("outDtoList", outDtoList);
    mav.setViewName("resultFilter");
    return mav;
  }

  /**
   * 百分率に変換する.
   *
   * @param divided 全体量
   * @param divisor 的中量
   * @return 小数第二位を四捨五入した結果
   */
  private Double calcRate(String divided, String divisor) {
    if (divided == null || divisor == null || "0".equals(divided)) {
      return 0.0d;
    } else {
      Long dividedLong = Long.valueOf(divided);
      Long divisorLong = Long.valueOf(divisor);
      double rate = ((double) divisorLong / dividedLong) * 100;
      return Math.round(rate * 100.0) / 100.0;
    }
  }
}
