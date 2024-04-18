package org.javaacademy.caradservice.controller;

import lombok.RequiredArgsConstructor;
import org.javaacademy.caradservice.announcementDto.AnnouncementDto;
import org.javaacademy.caradservice.entity.Announcement;
import org.javaacademy.caradservice.service.AnnouncementService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/announcement")
@RequiredArgsConstructor
public class AnnouncementController {
    private final AnnouncementService announcementService;

    @GetMapping
    public List<Announcement> getAnnouncement() {
        return announcementService.getAnnouncements();
    }

    @PostMapping("/create")
    public void createAnnouncement(@RequestBody AnnouncementDto dto) {
        announcementService.createAnnouncement(dto);
    }

    @GetMapping("date/{date}")
    public List<Announcement> findByDate(@PathVariable LocalDate date) {
        return announcementService.findByDate(date);
    }

    @GetMapping("id/{id}")
    public Announcement findById(@PathVariable String id) {
        return announcementService.findById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteAnnouncement(@PathVariable String id) {
        announcementService.deleteById(id);
    }

    @GetMapping("/search")
    public List<Announcement> searchByParams(@RequestParam(required = false) String brand,
                                             @RequestParam(required = false) String color,
                                             @RequestParam(required = false) BigDecimal price,
                                             @RequestParam(required = false) String model) {
        return announcementService.searchByParams(brand, color, price, model);
    }
}
