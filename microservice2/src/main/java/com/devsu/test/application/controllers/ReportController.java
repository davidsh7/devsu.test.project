package com.devsu.test.application.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsu.test.application.responses.MovementResponse;
import com.devsu.test.application.services.MovementService;

/**
 * The Class ReportController.
 * 
 * @author David Sepulveda
 */
@RestController
@RequestMapping("api/reports")
public class ReportController {

    /** The movement service. */
    private final MovementService movementService;

    /**
     * Instantiates a new report controller.
     *
     * @param movementService the movement service
     */
    public ReportController(final MovementService movementService) {
        this.movementService = movementService;
    }

    /**
     * Gets the report.
     *
     * @param startDate      the start date
     * @param endDate        the end date
     * @param identification the identification
     * @return the report
     */
    @GetMapping
    public List<MovementResponse> getReport(
            @RequestParam(name = "startDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam(name = "endDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
            @RequestParam(name = "identification", required = false) String identification) {

        return this.movementService.getReportMovementsByClient(startDate, endDate, identification);
    }

}
