package net.hollage.horseracing.repository;

import java.util.List;
import net.hollage.horseracing.entity.ResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/** 画面に表示する結果情報 */
@Repository
public interface ResultRepository extends JpaRepository<ResultEntity, Long> {

  /**
   * 総合成績（今年）を求めるSQL.<br>
   * 年ごとの成績を出そうとするとidの問題で上手くいかない、なぜ
   *
   * @return 総合成績エンティティ
   */
  @Query(
      value =
          """
          select
              -1 as id
              , to_char(purchases.purchase_date, 'YYYY') as purchase_year
              , NULL as ticket_id
              , NULL as ticket_code
              , sum(quantity) as purchase_pair
              , sum(hit_pair) as hit_pair
              , sum(stake) as purchase_amount
              , sum(collection_amount) as collection_amount
          from
              tickets
          left outer join purchases
              on tickets.purchase_id = purchases.id
              and purchases.is_deleted = false
          where tickets.is_deleted = false
              and tickets.hit_pair is not NULL
              and tickets.collection_amount is not NULL
              and to_char(purchases.purchase_date, 'YYYY') = to_char(current_date, 'YYYY')
          group by to_char(purchases.purchase_date, 'YYYY')
          order by purchase_year
          """,
      nativeQuery = true)
  ResultEntity findThisYearTotal();

  /**
   * 馬券種別成績（今年）を求めるSQL.
   *
   * @return 馬券種別成績エンティティ
   */
  @Query(
      value =
          """
          select
              max(tickets.id) as id
              , NULL as purchase_year
              , tickets.ticket_code as ticket_id
              , cdm.code_name as ticket_code
              , sum(quantity) as purchase_pair
              , sum(hit_pair) as hit_pair
              , sum(stake) as purchase_amount
              , sum(collection_amount) as collection_amount
          from
              tickets
          left outer join code_master cdm
              on tickets.ticket_code = cdm.code_value
              and cdm.code_category = '券種'
              and cdm.is_deleted = false
          where tickets.is_deleted = false
              and tickets.hit_pair is not NULL
              and tickets.collection_amount is not NULL
          group by tickets.ticket_code, cdm.code_name
          order by ticket_id
          """,
      nativeQuery = true)
  List<ResultEntity> findThisYearKind();

  /**
   * 総合成績（通算）を求めるSQL.
   *
   * @return 総合成績エンティティ
   */
  @Query(
      value =
          """
          select
              -2 as id
              , NULL as purchase_year
              , NULL as ticket_id
              , NULL as ticket_code
              , sum(quantity) as purchase_pair
              , sum(hit_pair) as hit_pair
              , sum(stake) as purchase_amount
              , sum(collection_amount) as collection_amount
          from
              tickets
          left outer join purchases
              on tickets.purchase_id = purchases.id
              and purchases.is_deleted = false
          where tickets.is_deleted = false
              and tickets.hit_pair is not NULL
              and tickets.collection_amount is not NULL
          """,
      nativeQuery = true)
  ResultEntity findTotal();

  /**
   * 馬券種別成績（通算）を求めるSQL.
   *
   * @return 馬券種別成績エンティティ
   */
  @Query(
      value =
          """
          select
              max(tickets.id) as id
              , NULL as purchase_year
              , tickets.ticket_code as ticket_id
              , cdm.code_name as ticket_code
              , sum(quantity) as purchase_pair
              , sum(hit_pair) as hit_pair
              , sum(stake) as purchase_amount
              , sum(collection_amount) as collection_amount
          from
              tickets
          left outer join code_master cdm
              on tickets.ticket_code = cdm.code_value
              and cdm.code_category = '券種'
              and cdm.is_deleted = false
          where tickets.is_deleted = false
              and tickets.hit_pair is not NULL
              and tickets.collection_amount is not NULL
          group by tickets.ticket_code, cdm.code_name
          order by ticket_id
          """,
      nativeQuery = true)
  List<ResultEntity> findKind();
}
