package net.hollage.horseracing.contoller;

import java.util.List;
import lombok.AllArgsConstructor;
import net.hollage.horseracing.domain.ResultOutDto;
import net.hollage.horseracing.entity.ResultEntity;
import net.hollage.horseracing.repository.ResultRepository;
import net.hollage.horseracing.service.ResultMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@RestController
public class ResultController {

  /** 画面に表示する結果情報 */
  private final ResultRepository resultRepository;

  /** 結果加工用Mapper */
  private final ResultMapper resultMapper;

  @GetMapping("/result")
  public ModelAndView getResult(ModelAndView mav) {
    // 総合成績（今年）
    ResultEntity thisYearTotalEntity = resultRepository.findThisYearTotal();
    ResultOutDto thisYearTotalOutDto = resultMapper.convert(thisYearTotalEntity);

    // 馬券種別成績（今年）
    List<ResultEntity> thisYearKindEntityList = resultRepository.findThisYearKind();
    List<ResultOutDto> thisYearKindOutDtoList = resultMapper.convert(thisYearKindEntityList);

    // 総合成績（通算）
    ResultEntity overYearTotalEntity = resultRepository.findTotal();
    ResultOutDto overYearTotalOutDto = resultMapper.convert(overYearTotalEntity);

    // 馬券種別成績（通算）
    List<ResultEntity> overYearKindEntityList = resultRepository.findKind();
    List<ResultOutDto> overYearKindOutDtoList = resultMapper.convert(overYearKindEntityList);

    mav.addObject("thisYearTotalOutDto", thisYearTotalOutDto);
    mav.addObject("thisYearKindOutDtoList", thisYearKindOutDtoList);
    mav.addObject("overYearTotalOutDto", overYearTotalOutDto);
    mav.addObject("overYearKindOutDtoList", overYearKindOutDtoList);
    mav.setViewName("result");
    return mav;
  }
}
