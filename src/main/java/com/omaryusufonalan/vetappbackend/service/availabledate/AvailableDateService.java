package com.omaryusufonalan.vetappbackend.service.availabledate;

import com.omaryusufonalan.vetappbackend.dto.availabledate.AvailableDateCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.availabledate.AvailableDateResponse;
import com.omaryusufonalan.vetappbackend.dto.availabledate.AvailableDateUpdateRequest;
import com.omaryusufonalan.vetappbackend.entity.AvailableDate;
import com.omaryusufonalan.vetappbackend.repository.AvailableDateRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvailableDateService implements AvailableDateCRUD {
    private final AvailableDateRepository availableDateRepository;
    private final ModelMapper modelMapper;

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
}
