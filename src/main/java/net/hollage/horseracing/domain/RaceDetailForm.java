package net.hollage.horseracing.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Data;

/** レース詳細 */
@Data
public class RaceDetailForm implements DetailForm {
  /** 開催日 */
  @NotEmpty private String purchaseDate = LocalDate.now().toString();

  /**
   * 競馬場<br>
   * 札幌, 函館, 福島, 新潟, 中山<br>
   * 東京, 中京, 京都, 阪神, 小倉
   */
  @Size(max = 20)
  private String venue;

  /** レース番号 */
  @Min(1)
  @Max(12)
  private Integer raceNo = 11;

  /** グレード */
  @Size(max = 10)
  //  private List<String> grade = Arrays.asList("G1", "G2", "G3", "L", "OP");
  private String grade;

  /** レース名 */
  @Size(max = 30)
  private String raceName;

  /** コース */
  @Size(max = 3)
  //  private List<String> course = Arrays.asList("芝", "ダート", "障害");
  private String course = "芝";

  /** 距離 */
  @Min(1000)
  @Max(5000)
  private Integer distance = 1800;

  /** 馬場状態 */
  @Size(max = 2)
  //  private List<String> courseCondition = Arrays.asList("良", "稍重", "重", "不良");
  private String courseCondition = "良";

  /** レース条件（4歳上、3歳、2歳など） */
  @Size(max = 4)
  private String age;

  /** 重量 */
  @Size(max = 3)
  //  private List<String> weight = Arrays.asList("ハンデ", "馬齢", "別定", "定量");
  private String weight;
}
