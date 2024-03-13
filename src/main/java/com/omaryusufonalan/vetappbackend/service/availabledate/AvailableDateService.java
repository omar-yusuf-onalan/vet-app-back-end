package com.omaryusufonalan.vetappbackend.service.availabledate;

import com.omaryusufonalan.vetappbackend.dto.availabledate.AvailableDateCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.availabledate.AvailableDateResponse;
import com.omaryusufonalan.vetappbackend.dto.availabledate.AvailableDateUpdateRequest;
import com.omaryusufonalan.vetappbackend.entity.AvailableDate;
import com.omaryusufonalan.vetappbackend.repository.AvailableDateRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AvailableDateService implements AvailableDateCRUD, FilterAvailableDate {
    private final AvailableDateRepository availableDateRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<AvailableDate> getAllAvailableDates() {
        return availableDateRepository.findAll();
    }

    @Override
    public List<AvailableDateResponse> getAllAvailableDateResponses() {
        return getAllAvailableDates()
                .stream().map(availableDate -> modelMapper.map(availableDate, AvailableDateResponse.class))
                .toList();
    }

    @Override
    public AvailableDate getAvailableDateById(Long id) {
        return availableDateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("AvailableDate with ID " + id + " not found!"));
    }

    @Override
    public AvailableDateResponse getAvailableDateResponseById(Long id) {
        return modelMapper.map(getAvailableDateById(id), AvailableDateResponse.class);
    }

    @Override
    public AvailableDateResponse createAvailableDate(AvailableDateCreateRequest availableDateCreateRequest) {
        AvailableDate availableDateToBeCreated = modelMapper.map(availableDateCreateRequest, AvailableDate.class);

        return modelMapper.map(availableDateRepository.save(availableDateToBeCreated), AvailableDateResponse.class);
    }

    @Override
    public AvailableDateResponse updateAvailableDate(AvailableDateUpdateRequest availableDateUpdateRequest) {
        AvailableDate doesAvailableDateExist = getAvailableDateById(availableDateUpdateRequest.getId());

        modelMapper.map(availableDateUpdateRequest, doesAvailableDateExist);

        return modelMapper.map(availableDateRepository.save(doesAvailableDateExist), AvailableDateResponse.class);
    }

    @Override
    public void deleteAvailableDateById(Long id) {
        availableDateRepository.delete(getAvailableDateById(id));
    }

    @Override
    public List<AvailableDate> filterAvailableDatesByDoctorIdAndAvailableDate(Long doctorId, LocalDate availableDate) {
        return availableDateRepository.findByDoctorIdAndAvailableDate(doctorId, availableDate);
    }

    @Override
    public List<AvailableDateResponse> filterAvailableDateResponsesByDoctorIdAndAvailableDate(
            Long doctorId,
            LocalDate availableDate
    ) {
        return availableDateRepository.findByDoctorIdAndAvailableDate(doctorId, availableDate)
                .stream().map(object -> modelMapper.map(object, AvailableDateResponse.class))
                .toList();
    }
}
