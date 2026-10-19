package com.keystone.workorder;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface WorkOrderRepository extends JpaRepository<WorkOrder,Long> {
 List<WorkOrder> findByStatus(WorkOrderStatus status);
}
