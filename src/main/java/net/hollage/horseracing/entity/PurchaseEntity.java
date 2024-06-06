package net.hollage.horseracing.entity;

import jakarta.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import lombok.Data;

/** 購入情報 */
@Data
@Entity
@Table(name = "purchases")
public class PurchaseEntity implements DetailEntity {

  /** 通し番号 */
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchases_seq_gen")
  @SequenceGenerator(name = "purchases_seq_gen", sequenceName = "purchases_seq", allocationSize = 1)
  @Column(name = "id")
  private Long id;

  /** 開催日 */
  @Column(name = "purchase_date", nullable = false)
  private Date purchaseDate;

  /** 競馬場 */
  @Column(name = "venue", length = 15, nullable = true)
  private String venue;

  /** レース番号 */
  @Column(name = "race_no", nullable = true)
  private Integer raceNo;

  /** グレード */
  @Column(name = "grade", length = 10, nullable = true)
  private String grade;

  /** レース名 */
  @Column(name = "race_name", length = 30, nullable = true)
  private String raceName;

  /** コース（芝、ダート、障害） */
  @Column(name = "course", length = 3, nullable = true)
  private String course;

  /** 距離 */
  @Column(name = "distance", nullable = true)
  private Integer distance;

  /** 馬場状態（良、稍重、重、不良） */
  @Column(name = "course_condition", length = 2, nullable = true)
  private String courseCondition;

  /** 年齢（4歳上、3歳、2歳など） */
  @Column(name = "age", length = 4, nullable = true)
  private String age;

  /** 重量（ハンデ、馬齢、別定、定量） */
  @Column(name = "weight", length = 3, nullable = true)
  private String weight;

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
