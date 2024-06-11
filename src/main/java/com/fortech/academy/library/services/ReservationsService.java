package com.fortech.academy.library.services;

import com.fortech.academy.library.entities.Hotel;
import com.fortech.academy.library.entities.Reservation;
import com.fortech.academy.library.entities.Room;
import com.fortech.academy.library.entities.User;
import com.fortech.academy.library.models.ReservationDto;
import com.fortech.academy.library.repositories.HotelsRepository;
import com.fortech.academy.library.repositories.ReservationsRepository;
import com.fortech.academy.library.repositories.RoomsRepository;
import com.fortech.academy.library.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationsService {

    private final ReservationsRepository reservationsRepository;

    private final HotelsRepository hotelsRepository;

//    private final UsersRepository usersRepository;
//
//    private final RoomsRepository roomsRepository;
    @Autowired
    private ModelMapper modelMapper;

    public void addReservation(Reservation newReservation) {
        reservationsRepository.save(newReservation);
    }

    public Reservation getReservationById(Long id) throws NoSuchElementException {
        return reservationsRepository.findById(id).orElseThrow();

    }

    public List<ReservationDto> getAllReservations() {

        log.info("getAllReservations");
        List<Reservation> reservations = reservationsRepository.findAll();
        List<ReservationDto> reservationDtoList = new ArrayList<>();
        for (Reservation reservation : reservations) {
            ReservationDto currentDto = modelMapper.map(reservation, ReservationDto.class);
            Optional<Hotel> currentHotel = hotelsRepository.findById((long) reservation.getHotelId());
//            Optional<User> currentUser = usersRepository.findById((long) reservation.getUserId());
//            Optional<Room> currentRoom = roomsRepository.findById((long) reservation.getRoomId());
            currentDto.setHotelName(currentHotel.get().getHotelName());
            currentDto.setHotelLocation(currentHotel.get().getHotelLocation());
//            currentDto.setUsername(currentUser.get().getUsername());
            currentDto.setFirstName(reservation.getFirstName());
            currentDto.setLastName(reservation.getLastName());
            currentDto.setCheckInDate(reservation.getCheckInDate());
            currentDto.setCheckOutDate(reservation.getCheckOutDate());
            currentDto.setRoomType(reservation.getRoomType());
            currentDto.setRoomPrice(reservation.getRoomPrice());
            currentDto.setTotalPayment(reservation.getTotalPayment());
            currentDto.setPaymentMethod(reservation.getPaymentMethod());
            currentDto.setPhoneNumber(reservation.getPhoneNumber());
            currentDto.setEmailAddress(reservation.getEmailAddress());

            reservationDtoList.add(currentDto);

        }
        return reservationDtoList;
    }

    public void deleteReservationById(Long id) {
        reservationsRepository.deleteById(id);
    }

    public Reservation updateReservationById(Long id) {
        Reservation reservation = reservationsRepository.findById(id).orElseThrow();
        return reservationsRepository.save(reservation);
    }
}
