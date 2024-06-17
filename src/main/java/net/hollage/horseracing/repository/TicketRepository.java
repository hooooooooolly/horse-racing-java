package net.hollage.horseracing.repository;

import net.hollage.horseracing.domain.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** 馬券情報 */
@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {}
