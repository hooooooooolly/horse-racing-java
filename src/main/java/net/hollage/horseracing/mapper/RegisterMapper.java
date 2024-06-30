package net.hollage.horseracing.mapper;

import java.util.List;
import net.hollage.horseracing.domain.PurchaseEntity;
import net.hollage.horseracing.domain.TicketEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {

  /**
   * 購入情報を登録する.
   *
   * @param pe 購入情報
   */
  public void insertPurchase(PurchaseEntity pe);

  /**
   * 馬券情報を登録する.
   *
   * @param teList 馬券情報
   */
  public void insertTicket(List<TicketEntity> teList);
}
