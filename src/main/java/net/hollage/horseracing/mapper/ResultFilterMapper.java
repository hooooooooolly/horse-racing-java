package net.hollage.horseracing.mapper;

import java.util.List;
import net.hollage.horseracing.domain.ResultFilterEntity;
import net.hollage.horseracing.dto.view.ResultViewModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResultFilterMapper {

  /**
   * 指定した検索条件で検索する.
   *
   * @param inDto 検索条件
   * @return 検索結果
   */
  public List<ResultViewModel> selectResult(ResultFilterEntity inDto);
}
