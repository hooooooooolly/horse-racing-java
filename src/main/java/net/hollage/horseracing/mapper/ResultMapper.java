package net.hollage.horseracing.mapper;

import java.util.List;
import net.hollage.horseracing.domain.ResultEntity;

public interface ResultMapper {

  /**
   * 総合成績（今年）を求めるSQL.
   *
   * @return 総合成績エンティティ
   */
  ResultEntity findThisYearTotal();

  /**
   * 馬券種別成績（今年）を求めるSQL.
   *
   * @return 馬券種別成績エンティティ
   */
  List<ResultEntity> findThisYearKind();

  /**
   * 総合成績（通算）を求めるSQL.
   *
   * @return 総合成績エンティティ
   */
  ResultEntity findTotal();

  /**
   * 馬券種別成績（通算）を求めるSQL.
   *
   * @return 馬券種別成績エンティティ
   */
  List<ResultEntity> findKind();
}
