package com.tsystems.railway.service;

import com.tsystems.railway.DTO.TimeTemplateDTO;
import com.tsystems.railway.entity.TimeTemplate;

import java.util.List;

public interface TimeTemplateService {

    void addTimeTemplate(TimeTemplateDTO timeTemplateDTO);
    void deleteTimeTemplate(int id);
    void updateTimeTemplate(TimeTemplateDTO timeTemplateDTO);
    TimeTemplateDTO getTimeTemplateById(int id);
    List<TimeTemplateDTO>geTimetemplatesList();
    List<TimeTemplateDTO>getTimeTemplateListForRoute(int routeId);
}
