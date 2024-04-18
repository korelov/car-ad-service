package org.javaacademy.caradservice.repository;

import org.javaacademy.caradservice.entity.Announcement;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AnnouncementRepository {
    private final Map<String, Announcement> announcements = new HashMap<>();

    public void add(Announcement announcement) {
        announcements.put(announcement.getId(), announcement);
    }

    public List<Announcement> getAnnouncements() {
        return announcements.values().stream().toList();
    }

    public List<Announcement> findByDate(LocalDate date) {
        return announcements.values()
                .stream()
                .filter(announcement -> announcement.getDate().equals(date))
                .toList();
    }

    public void deleteById(String id) {
        announcements.remove(id);
    }

    public Announcement findById(String id) {
        return announcements.get(id);
    }

    public List<Announcement> searchByParams(String brand,
                                             String color,
                                             BigDecimal price,
                                             String model) {
        List<Announcement> announcementsSearchResult = new ArrayList<>();
        announcements.values().forEach(announcement -> {
            if ((brand == null || announcement.getBrand().equals(brand))
                    && (color == null || announcement.getColor().equals(color))
                    && (price == null || announcement.getPrice().equals(price))
                    && (model == null || announcement.getModel().equals(model))) {
                announcementsSearchResult.add(announcement);
            }
        });
        return announcementsSearchResult;
    }
}
