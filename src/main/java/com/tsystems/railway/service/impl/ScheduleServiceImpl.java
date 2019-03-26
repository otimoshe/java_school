package com.tsystems.railway.service.impl;

import com.tsystems.railway.DAO.ScheduleDao;
import com.tsystems.railway.DTO.ScheduleDTO;
import com.tsystems.railway.mappers.ScheduleMapper;
import com.tsystems.railway.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleMapper scheduleMapper;

    @Autowired
    ScheduleDao scheduleDao;

    @Override
    public void addSchedule(ScheduleDTO scheduleDTO) {
        scheduleDao.addSchedule(scheduleMapper.dtoToEntity(scheduleDTO));
    }

    @Override
    public void deleteSchedule(long id) {
        scheduleDao.deleteSchedule(id);
    }

    @Override
    public void updateSchedule(ScheduleDTO scheduleDTO) {
        scheduleDao.updateSchedule(scheduleMapper.dtoToEntity(scheduleDTO));
    }

    @Override
    public List<ScheduleDTO> scheduleListForTrip(int tripId) {
        return scheduleMapper.listEntityToDtoList(scheduleDao.getSchedulesForTrip(tripId));
    }

    @Override
    public ScheduleDTO getScheduleById(long id) {
        return scheduleMapper.entityToDto(scheduleDao.getScheduleById(id));
    }
}
