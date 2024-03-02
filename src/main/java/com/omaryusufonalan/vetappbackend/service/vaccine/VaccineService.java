package com.omaryusufonalan.vetappbackend.service.vaccine;

import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineResponse;
import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineUpdateRequest;
import com.omaryusufonalan.vetappbackend.entity.Vaccine;
import com.omaryusufonalan.vetappbackend.exception.VaccineInEffectException;
import com.omaryusufonalan.vetappbackend.repository.VaccineRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VaccineService implements VaccineCRUD, ValidateVaccine {
    private final VaccineRepository vaccineRepository;
    private final ModelMapper modelMapper;

    @Override
    public Vaccine getVaccineById(Long id) {
        return vaccineRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vaccine with ID " + id + " not found!"));
    }

    @Override
    public VaccineResponse getVaccineResponseById(Long id) {
        return modelMapper.map(getVaccineById(id), VaccineResponse.class);
    }

    @Override
    public VaccineResponse createVaccine(VaccineCreateRequest vaccineCreateRequest) {
        Vaccine vaccineToBeCreated = modelMapper.map(vaccineCreateRequest, Vaccine.class);

        validateVaccine(vaccineToBeCreated);

        return modelMapper.map(vaccineRepository.save(vaccineToBeCreated), VaccineResponse.class);
    }

    @Override
    public VaccineResponse updateVaccine(VaccineUpdateRequest vaccineUpdateRequest) {
        Vaccine doesVaccineExist = getVaccineById(vaccineUpdateRequest.getId());

        modelMapper.map(vaccineUpdateRequest, doesVaccineExist);

        validateVaccine(doesVaccineExist);

        return modelMapper.map(vaccineRepository.save(doesVaccineExist), VaccineResponse.class);
    }

    @Override
    public void deleteVaccineById(Long id) {
        vaccineRepository.delete(getVaccineById(id));
    }

    @Override
    public void validateVaccine(Vaccine vaccine) {
        Optional<Vaccine> vaccineThatIsStillInEffect = vaccineRepository
                .validateVaccine(vaccine.getCode(), vaccine.getProtectionStartDate());

        if (vaccineThatIsStillInEffect.isPresent())
            throw new VaccineInEffectException("Vaccine is still in effect!");
    }
}
