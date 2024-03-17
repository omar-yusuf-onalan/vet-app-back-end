package com.omaryusufonalan.vetappbackend.service;

import com.omaryusufonalan.vetappbackend.core.ServiceTemplate;
import com.omaryusufonalan.vetappbackend.dto.request.VaccineRequest;
import com.omaryusufonalan.vetappbackend.dto.response.VaccineResponse;
import com.omaryusufonalan.vetappbackend.entity.Vaccine;
import com.omaryusufonalan.vetappbackend.exception.VaccineInEffectException;
import com.omaryusufonalan.vetappbackend.mapper.VaccineMapper;
import com.omaryusufonalan.vetappbackend.repository.VaccineRepository;
import com.omaryusufonalan.vetappbackend.service.filter.FilterVaccine;
import com.omaryusufonalan.vetappbackend.service.validate.ValidateVaccine;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VaccineService implements ServiceTemplate<Vaccine, VaccineRequest, VaccineResponse>,
        ValidateVaccine,
        FilterVaccine {
    private final VaccineRepository vaccineRepository;
    private final VaccineMapper vaccineMapper;

    @Override
    public List<VaccineResponse> getAll() {
        return vaccineMapper.entityToListResponse(vaccineRepository.findAll());
    }

    @Override
    public Vaccine getById(Long id) {
        return vaccineRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vaccine with ID " + id + " not found!"));
    }

    @Override
    public VaccineResponse getResponseById(Long id) {
        return vaccineMapper.entityToResponse(getById(id));
    }

    @Override
    public VaccineResponse create(VaccineRequest vaccineRequest) {
        return vaccineMapper.entityToResponse(
                vaccineRepository.save(
                        vaccineMapper.requestToEntity(vaccineRequest)
                )
        );
    }

    @Override
    public VaccineResponse update(Long id, VaccineRequest vaccineRequest) {
        Vaccine vaccineFromDb = getById(id);

        vaccineMapper.update(vaccineFromDb, vaccineRequest);

        return vaccineMapper.entityToResponse(vaccineRepository.save(vaccineFromDb));
    }

    @Override
    public void deleteById(Long id) {
        vaccineRepository.delete(getById(id));
    }


    @Override
    public void validateVaccine(Vaccine vaccine) {
        Optional<Vaccine> vaccineThatIsStillInEffect = vaccineRepository
                .validateVaccine(vaccine.getCode(), vaccine.getProtectionStartDate(), vaccine.getAnimal().getId());

        if (vaccineThatIsStillInEffect.isPresent())
            throw new VaccineInEffectException("Vaccine is still in effect!");
    }

    @Override
    public List<VaccineResponse> filterVaccineResponsesByAnimalName(String animalName) {
        return vaccineMapper.entityToListResponse(vaccineRepository.findByAnimalName(animalName));
    }

    @Override
    public List<VaccineResponse> findAllVaccineResponsesBetweenTwoDates(
            LocalDate startDate,
            LocalDate finishDate
    ) {
        return vaccineMapper.entityToListResponse(
                vaccineRepository.findAllVaccinesBetweenTwoDates(startDate, finishDate)
        );
    }
}