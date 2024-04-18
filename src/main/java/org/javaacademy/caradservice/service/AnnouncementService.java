package org.javaacademy.caradservice.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.caradservice.announcementDto.AnnouncementDto;
import org.javaacademy.caradservice.entity.Announcement;
import org.javaacademy.caradservice.repository.AnnouncementRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnnouncementService {
    private final AnnouncementRepository announcementRepository;

    public void createAnnouncement(AnnouncementDto dto) {
        UUID uuid = UUID.randomUUID();
        Announcement announcement = new Announcement(
                uuid.toString(),
                dto.getBrand(),
                dto.getColor(),
                dto.getPrice(),
                dto.getModel(),
                dto.getDate());
        announcementRepository.add(announcement);
    }

    public List<Announcement> getAnnouncements() {
        return announcementRepository.getAnnouncements();
    }

    public List<Announcement> findByDate(LocalDate date) {
        return announcementRepository.findByDate(date);
    }

    public void deleteById(String id) {
        announcementRepository.deleteById(id);
    }

    public Announcement findById(String id) {
        return announcementRepository.findById(id);
    }

    public List<Announcement> searchByParams(String brand,
                                            String color,
                                            BigDecimal price,
                                            String model) {
        return announcementRepository.searchByParams(brand, color, price, model);
    }
}
