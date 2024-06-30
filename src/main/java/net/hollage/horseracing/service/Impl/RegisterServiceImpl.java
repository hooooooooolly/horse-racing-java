package net.hollage.horseracing.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.hollage.horseracing.domain.PurchaseEntity;
import net.hollage.horseracing.domain.TicketEntity;
import net.hollage.horseracing.dto.TicketDetailForm;
import net.hollage.horseracing.service.RegisterService;

public class RegisterServiceImpl implements RegisterService {
  private PurchaseEntity pe;

  @Override
  public List<TicketEntity> convert(TicketDetailForm form, PurchaseEntity pe) {
    this.pe = pe;
    List<TicketEntity> ticketEntityList = new ArrayList<>();
    ticketEntityList.add(getEntity(1, form.getQuantityOneSingle(), form.getStakeOneSingle()));
    ticketEntityList.add(getEntity(2, form.getQuantityOneMultiple(), form.getStakeOneMultiple()));
    ticketEntityList.add(getEntity(3, form.getQuantityTwoSingle(), form.getStakeTwoSingle()));
    ticketEntityList.add(getEntity(4, form.getQuantityTwoMultiple(), form.getStakeTwoMultiple()));
    ticketEntityList.add(getEntity(5, form.getQuantityThreeSingle(), form.getStakeThreeSingle()));
    ticketEntityList.add(
        getEntity(6, form.getQuantityThreeMultiple(), form.getStakeThreeMultiple()));
    ticketEntityList.add(getEntity(7, form.getQuantityTwoWide(), form.getStakeTwoWide()));
    ticketEntityList.add(getEntity(8, form.getQuantityTwoFrame(), form.getStakeTwoFrame()));
    return ticketEntityList.stream().filter(Objects::nonNull).toList();
  }

  /**
   * 購入馬券情報をDB用Entityにマッピングする.
   *
   * @param code 券種
   * @param quantity 購入点数
   * @param stake 購入額
   * @return 加工後のEntity
   */
  private TicketEntity getEntity(Integer code, Integer quantity, Integer stake) {
    if (quantity == 0 || stake == 0) {
      return null;
    }
    TicketEntity te = new TicketEntity();
    te.setTicketCode(code);
    te.setQuantity(quantity);
    te.setStake(stake * 100);
    te.setPurchases(this.pe);
    return te;
  }
}
