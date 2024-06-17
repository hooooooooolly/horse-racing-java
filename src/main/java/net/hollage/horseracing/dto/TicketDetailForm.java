package net.hollage.horseracing.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

/** 購入馬券情報 */
@Data
public class TicketDetailForm implements DetailForm {
  /** 購入点数_単勝 */
  @Min(0)
  private Integer quantityOneSingle = 0;

  /** 購入額_単勝 */
  @Min(0)
  private Integer stakeOneSingle = 0;

  /** 購入点数_複勝 */
  @Min(0)
  private Integer quantityOneMultiple = 0;

  /** 購入額_複勝 */
  @Min(0)
  private Integer stakeOneMultiple = 0;

  /** 購入点数_馬単 */
  @Min(0)
  private Integer quantityTwoSingle = 0;

  /** 購入額_馬単 */
  @Min(0)
  private Integer stakeTwoSingle = 0;

  /** 購入点数_馬連 */
  @Min(0)
  private Integer quantityTwoMultiple = 0;

  /** 購入額_馬連 */
  @Min(0)
  private Integer stakeTwoMultiple = 0;

  /** 購入点数_三連単 */
  @Min(0)
  private Integer quantityThreeSingle = 0;

  /** 購入額_三連単 */
  @Min(0)
  private Integer stakeThreeSingle = 0;

  /** 購入点数_三連複 */
  @Min(0)
  private Integer quantityThreeMultiple = 0;

  /** 購入額_三連複 */
  @Min(0)
  private Integer stakeThreeMultiple = 0;

  /** 購入点数_ワイド */
  @Min(0)
  private Integer quantityTwoWide = 0;

  /** 購入額_ワイド */
  @Min(0)
  private Integer stakeTwoWide = 0;

  /** 購入点数_枠連 */
  @Min(0)
  private Integer quantityTwoFrame = 0;

  /** 購入額_枠連 */
  @Min(0)
  private Integer stakeTwoFrame = 0;
}
