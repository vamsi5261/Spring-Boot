package com.example.realEstateWeb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.realEstateWeb.Repo.BookingRepo;
import com.example.realEstateWeb.booking.Booking;

@Service
public class BookingService {
    @Autowired
    private BookingRepo repo;

    public Booking addBooking(Booking booking) {
        return repo.save(booking);
    }
}
