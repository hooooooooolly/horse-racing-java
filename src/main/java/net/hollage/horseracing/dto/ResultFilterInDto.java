package net.hollage.horseracing.dto;

import java.time.LocalDate;
import lombok.Data;

/** 詳細成績検索用inDto */
@Data
public class ResultFilterInDto {

  /** 抽出日（開始） */
  private LocalDate purchaseDateStart;

  /** 抽出日（終了） */
  private LocalDate purchaseDateEnd;

  /** 競馬場 */
  private String venue;

  /** レース番号 */
  private Integer raceNo;

  /** グレード */
  private String grade;

  /** レース名 */
  private String raceName;

  /** コース */
  private String course;

  /** 距離（開始） */
  private Integer distanceStart;

  /** 距離（終了） */
  private Integer distanceEnd;

  /** 馬場状態 */
  private String courseCondition;

  /** レース条件（4歳上、3歳、2歳など） */
  private String age;

  /** 重量 */
  private String weight;
}
