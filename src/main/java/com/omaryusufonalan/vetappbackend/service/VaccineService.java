package com.omaryusufonalan.vetappbackend.service;

import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineRequest;
import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineResponse;
import com.omaryusufonalan.vetappbackend.entity.Vaccine;
import com.omaryusufonalan.vetappbackend.mapper.VaccineMapper;
import com.omaryusufonalan.vetappbackend.repository.VaccineRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VaccineService implements GenericCRUD<Vaccine, VaccineRequest, VaccineResponse> {
    private final VaccineRepository vaccineRepository;
    private final VaccineMapper vaccineMapper;

    @Override
    public Vaccine getById(Long id) {
        return vaccineRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vaccine with ID " + id + " not found"));
    }

    @Override
    public VaccineResponse getResponseById(Long id) {
        Vaccine vaccineRetrievedFromDatabase = getById(id);

        return vaccineMapper.asVaccineResponse(vaccineRetrievedFromDatabase);
    }

    @Override
    public VaccineResponse create(VaccineRequest vaccineRequest) {
        // TODO: check if vaccine is valid

        Vaccine vaccineToBeCreated = vaccineMapper.asVaccine(vaccineRequest);

        Vaccine copyReturnedFromDatabase = vaccineRepository.save(vaccineToBeCreated);

        return vaccineMapper.asVaccineResponse(copyReturnedFromDatabase);
    }

    @Override
    public VaccineResponse update(Long id, VaccineRequest vaccineRequest) {
        Vaccine vaccineToBeUpdated = getById(id);

        vaccineMapper.update(vaccineToBeUpdated, vaccineRequest);

        Vaccine copyReturnedFromTheDatabase = vaccineRepository.save(vaccineToBeUpdated);

        return vaccineMapper.asVaccineResponse(copyReturnedFromTheDatabase);
    }

    @Override
    public void delete(Long id) {
        Vaccine vaccineToBeDeleted = getById(id);

        vaccineRepository.delete(vaccineToBeDeleted);
    }
}
