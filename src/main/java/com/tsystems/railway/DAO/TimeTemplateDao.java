package com.tsystems.railway.DAO;

import com.tsystems.railway.entity.TimeTemplate;

import java.util.List;

public interface TimeTemplateDao {

    void addTimeTempalte(TimeTemplate timeTemplate);

    void deleteTimeTemplate(int id);

    void updateTimeTemplate(TimeTemplate timeTemplate);

    TimeTemplate getTimeTemplateById(int id);

    List<TimeTemplate>getTimeTemplatesList();

    List<TimeTemplate> getListTimeTemplatesForRoute(int routeId);
}
