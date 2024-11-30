package net.hollage.horseracing.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Data;

@Data
public class ResultFilterForm implements DetailForm {

  /** 抽出日（開始） */
  private LocalDate purchaseDateStart;

  /** 抽出日（終了） */
  private LocalDate purchaseDateEnd;

  /** 競馬場 */
  @Size(max = 20)
  private String venue;

  /** レース番号 */
  @Min(1)
  @Max(12)
  private Integer raceNo;

  /** グレード */
  @Size(max = 10)
  private String grade;

  /** レース名 */
  @Size(max = 30)
  private String raceName;

  /** コース */
  @Size(max = 3)
  private String course;

  /** 距離（開始） */
  @Min(1000)
  @Max(5000)
  private Integer distanceStart;

  /** 距離（終了） */
  @Min(1000)
  @Max(5000)
  private Integer distanceEnd;

  /** 馬場状態 */
  @Size(max = 2)
  private String courseCondition;

  /** レース条件（4歳上、3歳、2歳など） */
  @Size(max = 4)
  private String age;

  /** 重量 */
  @Size(max = 3)
  private String weight;
}
