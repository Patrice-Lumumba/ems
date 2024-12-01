package net.javaguides.ems.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.repository.EmployeeRepository;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {


        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployee(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        return null;
    }

    @Override
    public EmployeeDto getEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Employee with id " + employeeId + " not found"));
        return EmployeeMapper.mapToEmployee(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return List.of();
    }
}
