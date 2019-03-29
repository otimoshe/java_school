package com.tsystems.railway.mappers;


import com.tsystems.railway.DTO.TicketDTO;
import com.tsystems.railway.entity.Ticket;

import java.util.List;

public interface TicketMapper {

    Ticket dtoToEntity(TicketDTO ticketDTO);

    TicketDTO entityToDto(Ticket ticket);

    List<TicketDTO> listEntityToDtoList(List<Ticket > tickets);

    List<Ticket> listDtoToEntityList(List<TicketDTO> dtoList);
}
