package com.ams.passengerService.report.service;

import com.ams.passengerService.report.dto.KpiResponse;
import com.ams.passengerService.flight.repository.FlightRepository;
import com.ams.passengerService.gate.repository.GateRepository;
import com.ams.passengerService.repository.PassengerRepository;
import com.ams.passengerService.staff.repository.StaffRepository;
import com.ams.passengerService.staff.repository.ShiftRepository;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    private final FlightRepository flightRepository;
    private final GateRepository gateRepository;
    private final PassengerRepository passengerRepository;
    private final StaffRepository staffRepository;
    private final ShiftRepository shiftRepository;

    public ReportService(
            FlightRepository flightRepository,
            GateRepository gateRepository,
            PassengerRepository passengerRepository,
            StaffRepository staffRepository,
            ShiftRepository shiftRepository
    ) {
        this.flightRepository = flightRepository;
        this.gateRepository = gateRepository;
        this.passengerRepository = passengerRepository;
        this.staffRepository = staffRepository;
        this.shiftRepository = shiftRepository;
    }

    public KpiResponse getKpis() {
        return new KpiResponse(
                flightRepository.count(),
                gateRepository.count(),
                passengerRepository.count(),
                staffRepository.count(),
                shiftRepository.count()
        );
    }
}
