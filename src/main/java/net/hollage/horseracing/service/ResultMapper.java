package net.hollage.horseracing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import net.hollage.horseracing.domain.ResultOutDto;
import net.hollage.horseracing.entity.ResultEntity;
import org.springframework.stereotype.Component;

/** DBの取得結果をDtoにマッピングする. */
@Component
public class ResultMapper {

  /** 数値のフォーマッター(1000 -> 1,000) */
  Function<Integer, String> formatFunc = num -> String.format("%,d", num);

  /**
   * DBから取得したデータをOutDtoに加工する.
   *
   * @param entity エンティティ
   * @return 加工後のOutDto
   */
  public ResultOutDto convert(ResultEntity entity) {
    ResultOutDto outDto = new ResultOutDto();
    outDto.setTicketType(entity.getTicketCode());
    outDto.setPurchasePair(entity.getPurchasePair() + " 組");
    outDto.setHitPair(entity.getHitPair() + " 組");
    outDto.setHitRate(format(entity.getPurchasePair(), entity.getHitPair(), "組"));
    outDto.setPurchaseAmount(entity.getPurchaseAmount() + " 円");
    outDto.setCollectionAmount(entity.getCollectionAmount() + " 円");
    outDto.setRecoveryRate(format(entity.getPurchaseAmount(), entity.getCollectionAmount(), "円"));
    return outDto;
  }

  /**
   * DBから取得したデータをOutDtoリストに加工する
   *
   * @param entityList エンティティリスト
   * @return 加工後のOutDtoリスト
   */
  public List<ResultOutDto> convert(List<ResultEntity> entityList) {
    List<ResultOutDto> outDtoList = new ArrayList<>();
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
   * @param dividend 全体量
   * @param divisor 的中量
   * @return 小数第二位を四捨五入した結果
   */
  private Double calcRate(Integer dividend, Integer divisor) {
    if (dividend == null || divisor == null || dividend == 0) {
      return 0.0d;
    } else {
      double rate = ((double) divisor / dividend) * 100;
      return Math.round(rate * 100.0) / 100.0;
    }
  }
}
