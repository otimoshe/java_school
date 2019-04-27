package com.tsystems.railway.DTO;

import com.tsystems.railway.entity.Station;

import java.sql.Time;
import java.util.HashMap;
import java.util.List;


public class TimeTemplatesForm {

    private int templateId;
    private HashMap<String, List<String>> templateStationMap;

    public HashMap<String, List<String>> getTemplateStationMap() {
        return templateStationMap;
    }

    public void setTemplateStationMap(HashMap<String, List<String>> templateStationMap) {
        this.templateStationMap = templateStationMap;
    }

    public TimeTemplatesForm(HashMap<String, List<String>> templateStationMap) {
        this.templateStationMap = templateStationMap;
    }

    public TimeTemplatesForm(int templateId, HashMap<String, List<String>> templateStationMap) {
        this.templateId = templateId;
        this.templateStationMap = templateStationMap;
    }

    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    public TimeTemplatesForm() {
    }
}
