package com.valuemanage.services;

import com.valuemanage.domain.Comment;
import com.valuemanage.domain.NewReport;
import com.valuemanage.domain.Report;
import com.valuemanage.repositories.ReportRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;
    private final CommentService commentService;

    @Override
    public Report save(Report report) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        report.setDate(format.parse(format.format(report.getDate())));
        return reportRepository.save(report);
    }

    @Override
    public Report save(NewReport newReport) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Comment comment = Comment.builder().text(newReport.getText()).name(newReport.getName()).date(new Date()).build();
        Comment savedComment = commentService.save(comment);
        Report report = Report.builder().metNew(newReport.getMetNew()).metOld(newReport.getMetOld()).metTotal(newReport.getMetTotal()).orders(newReport.getOrders()).comment(savedComment).date(new Date()).build();
        report.setDate(format.parse(format.format(report.getDate())));
        return reportRepository.save(report);
    }
}
