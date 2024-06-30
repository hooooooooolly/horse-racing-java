package net.hollage.horseracing.contoller;

import jakarta.transaction.Transactional;
import java.util.List;
import lombok.AllArgsConstructor;
import net.hollage.horseracing.domain.PurchaseEntity;
import net.hollage.horseracing.domain.TicketEntity;
import net.hollage.horseracing.dto.RaceDetailForm;
import net.hollage.horseracing.dto.TicketDetailForm;
import net.hollage.horseracing.mapper.RegisterMapper;
import net.hollage.horseracing.service.RegisterService;
import org.modelmapper.ModelMapper;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@RestController
public class RegisterController {

  /** SQLMapper */
  private final RegisterMapper registerMapper;

  /** 馬券情報マッパー */
  private final RegisterService registerService;

  /** ModelMapper */
  private final ModelMapper modelMapper;

  @GetMapping("/register")
  public ModelAndView getRegister(ModelAndView mav) {
    mav.addObject("raceDetailForm", new RaceDetailForm());
    mav.addObject("ticketDetailForm", new TicketDetailForm());
    mav.setViewName("register");
    return mav;
  }

  @PostMapping("/register")
  @Transactional
  public ModelAndView postRegister(
      @Validated RaceDetailForm raceDetailForm,
      BindingResult resultRace,
      @Validated TicketDetailForm ticketDetailForm,
      BindingResult resultTicket,
      ModelAndView mav) {
    if (resultRace.hasErrors() || resultTicket.hasErrors()) {
      return mav;
    }
    PurchaseEntity pe = modelMapper.map(raceDetailForm, PurchaseEntity.class);
    registerMapper.insertPurchase(pe);
    List<TicketEntity> teList = registerService.convert(ticketDetailForm, pe);
    registerMapper.insertTicket(teList);

    mav.setViewName("register");
    return mav;
  }
}
