package net.hollage.horseracing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/** 結果エンティティ */
@Entity
@Data
public class ResultEntity implements DetailEntity {

  /** ID */
  @Id private Long id;

  /** 購入年 */
  @Column(name = "purchase_year")
  private String purchaseYear;

  /** 馬券コード（ソート用） */
  @Column(name = "ticket_id")
  private Integer ticketId;

  /** 馬券種類 */
  @Column(name = "ticket_code")
  private String ticketCode;

  /** 購入組数 */
  @Column(name = "purchase_pair")
  private Integer purchasePair;

  /** 的中組数 */
  @Column(name = "hit_pair")
  private Integer hitPair;

  /** 購入額 */
  @Column(name = "purchase_amount")
  private Integer purchaseAmount;

  /** 回収額 */
  @Column(name = "collection_amount")
  private Integer collectionAmount;
}
