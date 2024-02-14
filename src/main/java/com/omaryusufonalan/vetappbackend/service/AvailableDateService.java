package com.omaryusufonalan.vetappbackend.service;

import com.omaryusufonalan.vetappbackend.dto.availabledate.AvailableDateRequest;
import com.omaryusufonalan.vetappbackend.dto.availabledate.AvailableDateResponse;
import com.omaryusufonalan.vetappbackend.entity.AvailableDate;
import com.omaryusufonalan.vetappbackend.mapper.AvailableDateMapper;
import com.omaryusufonalan.vetappbackend.repository.AvailableDateRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvailableDateService implements GenericCRUD<AvailableDate, AvailableDateRequest, AvailableDateResponse> {
    private final AvailableDateRepository availableDateRepository;
    private final AvailableDateMapper availableDateMapper;

    @Override
    public AvailableDate getById(Long id) {
        return availableDateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("AvailableDate with ID " + id + " not found"));
    }

    @Override
    public AvailableDateResponse getResponseById(Long id) {
        AvailableDate availableDateRetrievedFromDatabase = getById(id);

        return availableDateMapper.asAvailableDateResponse(availableDateRetrievedFromDatabase);
    }

    @Override
    public AvailableDateResponse create(AvailableDateRequest availableDateRequest) {
        AvailableDate availableDateToBeCreated = availableDateMapper.asAvailableDate(availableDateRequest);

        AvailableDate copyReturnedFromDatabase = availableDateRepository.save(availableDateToBeCreated);

        return availableDateMapper.asAvailableDateResponse(copyReturnedFromDatabase);
    }

    @Override
    public AvailableDateResponse update(Long id, AvailableDateRequest availableDateRequest) {
        AvailableDate availableDateToBeUpdated = getById(id);

        availableDateMapper.update(availableDateToBeUpdated, availableDateRequest);

        AvailableDate copyReturnedFromTheDatabase = availableDateRepository.save(availableDateToBeUpdated);

        return availableDateMapper.asAvailableDateResponse(copyReturnedFromTheDatabase);
    }

    @Override
    public void delete(Long id) {
        AvailableDate availableDateToBeDeleted = getById(id);

        availableDateRepository.delete(availableDateToBeDeleted);
    }
}
