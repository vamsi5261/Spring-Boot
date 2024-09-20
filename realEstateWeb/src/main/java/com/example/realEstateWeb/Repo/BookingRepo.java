package com.example.realEstateWeb.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.realEstateWeb.booking.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {
}
