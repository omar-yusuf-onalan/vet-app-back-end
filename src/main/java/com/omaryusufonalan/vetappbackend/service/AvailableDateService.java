package com.omaryusufonalan.vetappbackend.service;

import com.omaryusufonalan.vetappbackend.core.ServiceTemplate;
import com.omaryusufonalan.vetappbackend.dto.request.AvailableDateRequest;
import com.omaryusufonalan.vetappbackend.dto.response.AvailableDateResponse;
import com.omaryusufonalan.vetappbackend.entity.AvailableDate;
import com.omaryusufonalan.vetappbackend.mapper.AvailableDateMapper;
import com.omaryusufonalan.vetappbackend.repository.AvailableDateRepository;
import com.omaryusufonalan.vetappbackend.service.filter.FilterAvailableDate;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AvailableDateService implements
        ServiceTemplate<AvailableDate, AvailableDateRequest, AvailableDateResponse>,
        FilterAvailableDate {
    private final AvailableDateRepository availableDateRepository;
    private final AvailableDateMapper availableDateMapper;

    @Override
    public List<AvailableDateResponse> getAll() {
        return availableDateMapper.entityToListResponse(availableDateRepository.findAll());
    }

    @Override
    public AvailableDate getById(Long id) {
        return availableDateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("AvailableDate with ID " + id + " not found!"));
    }

    @Override
    public AvailableDateResponse getResponseById(Long id) {
        return availableDateMapper.entityToResponse(getById(id));
    }

    @Override
    public AvailableDateResponse create(AvailableDateRequest availableDateRequest) {
        return availableDateMapper.entityToResponse(
                availableDateRepository.save(
                        availableDateMapper.requestToEntity(availableDateRequest)
                )
        );
    }

    @Override
    public AvailableDateResponse update(Long id, AvailableDateRequest availableDateRequest) {
        AvailableDate availableDateFromDb = getById(id);

        availableDateMapper.update(availableDateFromDb, availableDateRequest);

        return availableDateMapper.entityToResponse(availableDateRepository.save(availableDateFromDb));
    }

    @Override
    public void deleteById(Long id) {
        availableDateRepository.delete(getById(id));
    }

    @Override
    public List<AvailableDateResponse> filterAvailableDateResponsesByDoctorIdAndAvailableDate(
            Long doctorId,
            LocalDate availableDate
    ) {
        return availableDateMapper.entityToListResponse(
                availableDateRepository.findByDoctorIdAndAvailableDate(doctorId, availableDate)
        );
    }
}
