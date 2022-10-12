package com.valuemanage.services;

import com.valuemanage.domain.NewReport;
import com.valuemanage.domain.Report;

import java.text.ParseException;

public interface ReportService {
    public Report save(Report report) throws ParseException;

    public Report save(NewReport newReport) throws ParseException;
}
