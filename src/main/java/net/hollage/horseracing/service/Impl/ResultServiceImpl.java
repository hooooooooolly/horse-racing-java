package net.hollage.horseracing.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import lombok.AllArgsConstructor;
import net.hollage.horseracing.domain.ResultEntity;
import net.hollage.horseracing.domain.ResultFilterEntity;
import net.hollage.horseracing.dto.view.ResultViewModel;
import net.hollage.horseracing.mapper.ResultFilterMapper;
import net.hollage.horseracing.service.ResultService;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ResultServiceImpl implements ResultService {

  /** MyBatisMapper */
  private ResultFilterMapper resultMapper;

  /** 数値のフォーマッター(1000 -> 1,000) */
  private final Function<Integer, String> formatFunc = num -> String.format("%,d", num);

  /** {@inheritDoc} */
  @Override
  public List<ResultViewModel> fetchResult(ResultFilterEntity inDto) {
    List<ResultViewModel> outDtoList = resultMapper.selectResult(inDto);
    outDtoList.forEach(
        dto -> {
          // 的中率の算出
          dto.setHitRate(calcRate(dto.getPurchasePair(), dto.getHitPair()));
          // 回収率の算出
          dto.setRecoveryRate(calcRate(dto.getPurchaseAmount(), dto.getCollectionAmount()));
        });
    return outDtoList;
  }

  /** {@inheritDoc} */
  @Override
  public ResultViewModel convert(ResultEntity entity) {
    ResultViewModel outDto = new ResultViewModel();
    if (entity == null) {
      return outDto;
    }
    outDto.setTicketType(entity.getTicketCode());
    outDto.setPurchasePair("%d 組".formatted(entity.getPurchasePair()));
    outDto.setHitPair("%d 組".formatted(entity.getHitPair()));
    outDto.setHitRate(format(entity.getPurchasePair(), entity.getHitPair(), "組"));
    outDto.setPurchaseAmount("%d 円".formatted(entity.getPurchaseAmount()));
    outDto.setCollectionAmount("%d 円".formatted(entity.getCollectionAmount()));
    outDto.setRecoveryRate(format(entity.getPurchaseAmount(), entity.getCollectionAmount(), "円"));
    return outDto;
  }

  /** {@inheritDoc} */
  @Override
  public List<ResultViewModel> convert(List<ResultEntity> entityList) {
    List<ResultViewModel> outDtoList = new ArrayList<>();
    entityList.forEach(
        entity -> {
          outDtoList.add(convert(entity));
        });
    return outDtoList;
  }

  /**
   * 画面表示用文字列に加工する.
   *
   * @param dividend 全体量
   * @param divisor 的中量
   * @param unit 単位（組, 円など）
   * @return 画面表示用文字列
   */
  private String format(Integer dividend, Integer divisor, String unit) {
    String rate = calcRate(dividend, divisor).toString();
    return String.format(
        "%s %% ( %s / %s %s )", rate, formatFunc.apply(divisor), formatFunc.apply(dividend), unit);
  }

  /**
   * 百分率に変換する.
   *
   * @param divided 全体量
   * @param divisor 的中量
   * @return 小数第二位を四捨五入した結果
   */
  private String calcRate(String divided, String divisor) {
    if (divided == null || divisor == null || "0".equals(divided)) {
      return String.valueOf(0.0d);
    } else {
      long dividedLong = Long.parseLong(divided);
      long divisorLong = Long.parseLong(divisor);
      double rate = ((double) divisorLong / dividedLong) * 100;
      return String.valueOf(Math.round(rate * 100.0) / 100.0);
    }
  }

  /**
   * 百分率に変換する.
   *
   * @param divided 全体量
   * @param divisor 的中量
   * @return 小数第二位を四捨五入した結果
   */
  private Double calcRate(Integer divided, Integer divisor) {
    if (divided == null || divisor == null || divided == 0) {
      return 0.0d;
    } else {
      double rate = ((double) divisor / divided) * 100;
      return Math.round(rate * 100.0) / 100.0;
    }
  }
}
