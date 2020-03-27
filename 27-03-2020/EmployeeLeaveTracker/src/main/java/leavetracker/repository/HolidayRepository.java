package leavetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import leavetracker.model.Holidays;

public interface HolidayRepository  extends JpaRepository<Holidays, Long>{

}
