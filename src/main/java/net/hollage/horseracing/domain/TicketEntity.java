package net.hollage.horseracing.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

/** 馬券情報 */
@Data
@Entity
@Table(name = "tickets")
public class TicketEntity implements DetailEntity {

  /** 通し番号 */
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tickets_seq_gen")
  @SequenceGenerator(name = "tickets_seq_gen", sequenceName = "tickets_seq", allocationSize = 1)
  @Column(name = "id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "purchase_id")
  private PurchaseEntity purchases;

  /** 券種コード */
  @Column(name = "ticket_code", nullable = false)
  private Integer ticketCode;

  /** 購入点数 */
  @Column(name = "quantity", nullable = false)
  private Integer quantity;

  /** 購入額 */
  @Column(name = "stake", nullable = false)
  private Integer stake;

  /** 論理削除フラグ */
  @Column(name = "is_deleted", nullable = false)
  private Boolean isDeleted = false;

  /** 登録日時 */
  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt = LocalDateTime.now();

  /** 更新日時 */
  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updatedAt = LocalDateTime.now();
}
