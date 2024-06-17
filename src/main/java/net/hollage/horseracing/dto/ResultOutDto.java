package net.hollage.horseracing.dto;

import lombok.Data;

/** 結果表示用OutDto */
@Data
public class ResultOutDto {

  /** 馬券種類 */
  private String ticketType;

  /** 購入組数 */
  private String purchasePair;

  /** 的中組数 */
  private String hitPair;

  /** 的中率 */
  private String hitRate;

  /** 購入額 */
  private String purchaseAmount;

  /** 回収額 */
  private String collectionAmount;

  /** 回収率 */
  private String recoveryRate;
}
