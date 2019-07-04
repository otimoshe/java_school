package com.tsystems.railway.validator;

import com.tsystems.railway.DTO.PathDTO;
import com.tsystems.railway.DTO.RouteDTO;
import com.tsystems.railway.DTO.StationDTO;
import com.tsystems.railway.entity.Route;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Component
public class RouteValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Route.class.equals(aClass);
    }
    @Override
    public void validate(Object o, Errors errors) {
        RouteDTO route = (RouteDTO) o;
        Set<PathDTO> paths = route.getPaths();
        StationDTO firstStation = route.getFirstStation();
        StationDTO currentStation = firstStation;
        StationDTO prevStation = null;
        Set<StationDTO> visitedStations = new HashSet<>();

        int count = 0;
        Iterator<PathDTO> iterator;
        while ( count <= paths.size()&& (! paths.isEmpty()) )   {
            iterator = paths.iterator();
            while (iterator.hasNext()) {
                count++;
                PathDTO path = iterator.next();
                if ((path.getStation().equals(currentStation)) || (path.getNextStation().equals(currentStation))) {
                    if (prevStation == null) { // first station check
                        prevStation = new StationDTO(currentStation);
                    }
                    if (prevStation.equals(currentStation)) {
                        System.out.println("asdasdasd");
                        if (!visitedStations.add(prevStation)) {
                            errors.rejectValue("pathIds", "route.circle");
                        }
                    }
                    if (path.getNextStation().equals(currentStation)) {
                        currentStation = path.getStation();
                    } else {
                        currentStation = path.getNextStation();
                    }

                    prevStation = currentStation;
                    iterator.remove();
                    count = 0;
                }
            }
        }
        if (!visitedStations.add(prevStation)) { // add last station
            errors.rejectValue("pathIds", "route.circle");
        }
        if (!paths.isEmpty()) {
            errors.rejectValue("pathIds", "route.gap");
        }
    }
}
