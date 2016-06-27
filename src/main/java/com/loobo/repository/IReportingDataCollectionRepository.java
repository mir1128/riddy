package com.loobo.repository;

import com.loobo.domain.model.ReportingDataCollection;
import org.springframework.data.repository.Repository;

import java.time.LocalTime;
import java.util.List;

public interface IReportingDataCollectionRepository extends Repository<ReportingDataCollection, String> {

    ReportingDataCollection save(ReportingDataCollection data);

    void delete(ReportingDataCollection data);

    ReportingDataCollection findById(String uuid);

    List<ReportingDataCollection> findByReportingTimeBetween(LocalTime from, LocalTime to);
}
