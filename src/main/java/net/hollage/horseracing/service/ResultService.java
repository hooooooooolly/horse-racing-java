package net.hollage.horseracing.service;

import java.util.List;
import net.hollage.horseracing.domain.ResultEntity;
import net.hollage.horseracing.domain.ResultFilterEntity;
import net.hollage.horseracing.dto.view.ResultViewModel;

/** ResultServiceインターフェース. */
public interface ResultService {
  /**
   * 検索条件を基に結果を取得する.
   *
   * @param inDto 検索条件
   * @return フィルタリングした結果
   */
  public List<ResultViewModel> fetchResult(ResultFilterEntity inDto);

  /**
   * DBから取得した値をviewModelに変換する.
   *
   * @param entity DBから取得した値
   * @return htmlに表示する値
   */
  public ResultViewModel convert(ResultEntity entity);

  /**
   * DBから取得したリストをviewModelListに変換する.
   *
   * @param entityList DBから取得したリスト
   * @return htmlに表示するリスト
   */
  public List<ResultViewModel> convert(List<ResultEntity> entityList);
}
