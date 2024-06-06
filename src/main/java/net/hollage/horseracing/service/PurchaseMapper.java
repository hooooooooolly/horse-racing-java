package net.hollage.horseracing.service;

import java.sql.Date;
import net.hollage.horseracing.domain.RaceDetailForm;
import net.hollage.horseracing.entity.PurchaseEntity;
import org.springframework.stereotype.Component;

/** 入力情報をDB用Entityにマッピングする. */
@Component
public class PurchaseMapper {
  /**
   * 購入レース詳細をDB用EntityListにマッピングする.
   *
   * @param form 購入レース詳細
   * @return 加工後のEntity
   */
  public PurchaseEntity convert(RaceDetailForm form) {
    PurchaseEntity pe = new PurchaseEntity();
    pe.setPurchaseDate(Date.valueOf(form.getPurchaseDate()));
    pe.setVenue(form.getVenue());
    pe.setRaceNo(form.getRaceNo());
    pe.setGrade(form.getGrade());
    pe.setRaceName(form.getRaceName());
    pe.setCourse(form.getCourse());
    pe.setDistance(form.getDistance());
    pe.setCourseCondition(form.getCourseCondition());
    pe.setAge(form.getAge());
    pe.setWeight(form.getWeight());
    return pe;
  }
}
