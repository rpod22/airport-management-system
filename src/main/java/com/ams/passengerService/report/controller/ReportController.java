package com.ams.passengerService.report.controller;

import com.ams.passengerService.report.dto.KpiResponse;
import com.ams.passengerService.report.service.ReportService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/kpi")
    public KpiResponse kpi() {
        return reportService.getKpis();
    }
}
