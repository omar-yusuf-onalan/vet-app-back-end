package com.omaryusufonalan.vetappbackend.service;

import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineResponse;
import com.omaryusufonalan.vetappbackend.dto.page.PageResponse;
import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineRequest;
import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineResponse;
import com.omaryusufonalan.vetappbackend.entity.Vaccine;
import com.omaryusufonalan.vetappbackend.entity.Vaccine;
import com.omaryusufonalan.vetappbackend.exception.VaccineInEffectException;
import com.omaryusufonalan.vetappbackend.mapper.VaccineMapper;
import com.omaryusufonalan.vetappbackend.repository.VaccineRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VaccineService implements GenericCRUD<Vaccine, VaccineRequest, VaccineResponse> {
    private final VaccineRepository vaccineRepository;
    private final VaccineMapper vaccineMapper;
    private final PageService<VaccineResponse> pageService;

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
    public PageResponse<VaccineResponse> getPageResponse(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);

        Page<Vaccine> pageOfVaccines = vaccineRepository.findAll(pageable);

        Page<VaccineResponse> pageOfVaccineResponses = pageOfVaccines
                .map(vaccine -> vaccineMapper.asVaccineResponse(vaccine));

        return pageService.createPageResponse(page, pageSize, pageOfVaccineResponses);
    }

    @Override
    public VaccineResponse create(VaccineRequest vaccineRequest) {
        checkValidityOf(vaccineRequest);

        Vaccine vaccineToBeCreated = vaccineMapper.asVaccine(vaccineRequest);

        Vaccine copyReturnedFromDatabase = vaccineRepository.save(vaccineToBeCreated);

        return vaccineMapper.asVaccineResponse(copyReturnedFromDatabase);
    }

    private void checkValidityOf(VaccineRequest vaccineRequest) {
        Optional<Vaccine> vaccineMayBeInEffect = this.vaccineRepository.checkForVaccineInEffect(
                vaccineRequest.getCode(),
                vaccineRequest.getAnimal().getId(),
                vaccineRequest.getProtectionStartDate()
        );

        if (vaccineMayBeInEffect.isPresent())
            throw new VaccineInEffectException("Vaccine is still in effect");
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
