package com.keystone.workorder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
@Entity @Table(name="work_orders")
public class WorkOrder {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Size(max=120) private String title;
 @NotBlank @Size(max=120) private String customerName;
 @NotBlank @Size(max=180) private String location;
 @Size(max=1000) private String description;
 @Enumerated(EnumType.STRING) private Priority priority=Priority.MEDIUM;
 @Enumerated(EnumType.STRING) private WorkOrderStatus status=WorkOrderStatus.OPEN;
 private String assignedTechnician="Unassigned";
 private LocalDateTime createdAt=LocalDateTime.now();
 private LocalDateTime updatedAt=LocalDateTime.now();
 public WorkOrder() {}
 @PreUpdate public void beforeUpdate(){updatedAt=LocalDateTime.now();}
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public String getTitle(){return title;} public void setTitle(String v){title=v;}
 public String getCustomerName(){return customerName;} public void setCustomerName(String v){customerName=v;}
 public String getLocation(){return location;} public void setLocation(String v){location=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public Priority getPriority(){return priority;} public void setPriority(Priority v){priority=v;}
 public WorkOrderStatus getStatus(){return status;} public void setStatus(WorkOrderStatus v){status=v;}
 public String getAssignedTechnician(){return assignedTechnician;} public void setAssignedTechnician(String v){assignedTechnician=v;}
 public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime v){createdAt=v;}
 public LocalDateTime getUpdatedAt(){return updatedAt;} public void setUpdatedAt(LocalDateTime v){updatedAt=v;}
}
