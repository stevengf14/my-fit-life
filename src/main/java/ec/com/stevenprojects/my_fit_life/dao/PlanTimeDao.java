package ec.com.stevenprojects.my_fit_life.dao;

import ec.com.stevenprojects.my_fit_life.domain.PlanTime;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Steven Guamán - February 2022
 */
public interface PlanTimeDao extends CrudRepository<PlanTime, Long> {

    @Query(value = "SELECT PLAN_TIME_ID, PLAN_ID, PRICE, TIME_PERIOD, PLAN_TIME_DESCRIPTION\n"
            + "FROM my_fit_life.plan_time where PLAN_ID = :planId", nativeQuery = true)
    public List<PlanTime> findByPlanId(@Param("planId") Long planId);
}
