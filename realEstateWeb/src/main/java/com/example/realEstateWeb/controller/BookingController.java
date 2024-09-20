package com.example.realEstateWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.realEstateWeb.Service.BookingService;
import com.example.realEstateWeb.booking.Booking;

@RestController
@RequestMapping("/api")
public class BookingController {
    @Autowired
    private BookingService service;

    @PostMapping("/bookings")
    public Booking addBooking(@RequestBody Booking booking) {
        return service.addBooking(booking);
    }
}
