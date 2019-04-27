package com.tsystems.railway.service.impl;

import com.tsystems.railway.DAO.TimeTemplateDao;
import com.tsystems.railway.DTO.TimeTemplateDTO;
import com.tsystems.railway.entity.TimeTemplate;
import com.tsystems.railway.mappers.TimeTemplateMapper;
import com.tsystems.railway.service.TimeTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TimeTemplateServiceImpl implements TimeTemplateService {

    @Autowired
    TimeTemplateDao timeTemplateDao;

    @Autowired
    TimeTemplateMapper timeTemplateMapper;

    @Override
    public void addTimeTemplate(TimeTemplateDTO timeTemplateDTO) {
        timeTemplateDao.addTimeTempalte(this.timeTemplateMapper.dtoToEntity(timeTemplateDTO));
    }

    @Override
    public void deleteTimeTemplate(int id) {
        timeTemplateDao.deleteTimeTemplate(id);
    }

    @Override
    public void updateTimeTemplate(TimeTemplateDTO timeTemplateDTO) {
        timeTemplateDao.updateTimeTemplate(timeTemplateMapper.dtoToEntity(timeTemplateDTO));
    }

    @Override
    public TimeTemplateDTO getTimeTemplateById(int id) {
        return timeTemplateMapper.entityToDto(timeTemplateDao.getTimeTemplateById(id));
    }

    @Override
    public List<TimeTemplateDTO> getTimeTemplateListForRoute(int routeId) {
        return  timeTemplateMapper.listEntityToDtoList(timeTemplateDao.getListTimeTemplatesForRoute(routeId));
    }

    @Override
    public List<TimeTemplateDTO> geTimetemplatesList() {
        return  timeTemplateMapper.listEntityToDtoList(timeTemplateDao.getTimeTemplatesList());
    }
}
