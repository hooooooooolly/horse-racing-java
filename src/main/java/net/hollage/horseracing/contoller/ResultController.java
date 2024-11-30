package net.hollage.horseracing.contoller;

import java.util.List;
import lombok.AllArgsConstructor;
import net.hollage.horseracing.domain.ResultEntity;
import net.hollage.horseracing.dto.view.ResultViewModel;
import net.hollage.horseracing.mapper.ResultMapper;
import net.hollage.horseracing.service.ResultService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@RestController
public class ResultController {

  /** 画面に表示する結果情報 */
  private final ResultMapper resultMapper;

  /** サービスクラス */
  private final ResultService resultService;

  @GetMapping("/result")
  public ModelAndView getResult(ModelAndView mav) {
    // 総合成績（今年）
    ResultEntity thisYearTotalEntity = resultMapper.findThisYearTotal();
    ResultViewModel thisYearTotalOutDto = resultService.convert(thisYearTotalEntity);

    // 馬券種別成績（今年）
    List<ResultEntity> thisYearKindEntityList = resultMapper.findThisYearKind();
    List<ResultViewModel> thisYearKindOutDtoList = resultService.convert(thisYearKindEntityList);

    // 総合成績（通算）
    ResultEntity overYearTotalEntity = resultMapper.findTotal();
    ResultViewModel overYearTotalOutDto = resultService.convert(overYearTotalEntity);

    // 馬券種別成績（通算）
    List<ResultEntity> overYearKindEntityList = resultMapper.findKind();
    List<ResultViewModel> overYearKindOutDtoList = resultService.convert(overYearKindEntityList);

    mav.addObject("thisYearTotalOutDto", thisYearTotalOutDto);
    mav.addObject("thisYearKindOutDtoList", thisYearKindOutDtoList);
    mav.addObject("overYearTotalOutDto", overYearTotalOutDto);
    mav.addObject("overYearKindOutDtoList", overYearKindOutDtoList);
    mav.setViewName("result");
    return mav;
  }
}
