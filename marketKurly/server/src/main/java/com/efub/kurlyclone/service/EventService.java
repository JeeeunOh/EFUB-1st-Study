package com.efub.kurlyclone.service;

import com.efub.kurlyclone.domain.event.Event;
import com.efub.kurlyclone.domain.event.EventRepository;
import com.efub.kurlyclone.web.dto.EventResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public Event registerEvent(Event event) {
        Event newEvent = eventRepository.save(event);
        return newEvent;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long Id) {
        Optional<Event> foundEvent = eventRepository.findById(Id);
        return foundEvent;
    }

    public Optional<Event> updateEventById(Long id, Map<String, String> list) {
        String name = list.get("event_name");
        String descript = list.get("event_descript");
        Optional<Event> foundEvent = eventRepository.findById(id)
                .map( event -> {
                    event.setName(name);
                    event.setDescript(descript);
                    eventRepository.save(event);
                    return event;
                });
        Optional<Event> updated = eventRepository.findById(id);
        return updated;
    }

    public String deleteEventById(Long id) {
        eventRepository.deleteById(id);
        return "delete complete";
    }

    public List<EventResponseDto> getEventList(){
        List<Event> eventList = eventRepository.findAll();
        List<EventResponseDto> eventResponseDtoList = new ArrayList<>();

        for(Event event : eventList){
            EventResponseDto eventResponseDto = new EventResponseDto(event);
            eventResponseDtoList.add(eventResponseDto);
        }

        return eventResponseDtoList;
    }


}
