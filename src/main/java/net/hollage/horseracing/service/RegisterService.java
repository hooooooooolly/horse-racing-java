package net.hollage.horseracing.service;

import java.util.List;
import net.hollage.horseracing.domain.PurchaseEntity;
import net.hollage.horseracing.domain.TicketEntity;
import net.hollage.horseracing.dto.TicketDetailForm;

/** RegisterServiceインターフェース. */
public interface RegisterService {

  /**
   * 購入馬券情報をDB用EntityListにマッピングする.
   *
   * @param form 購入馬券情報
   * @return 加工後のEntityList
   */
  public List<TicketEntity> convert(TicketDetailForm form, PurchaseEntity pe);
}
