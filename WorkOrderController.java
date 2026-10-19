package com.keystone.workorder;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@RestController @RequestMapping("/api/work-orders")
@CrossOrigin(origins={"http://localhost:5173","http://127.0.0.1:5173"})
public class WorkOrderController {
 private final WorkOrderRepository repository;
 public WorkOrderController(WorkOrderRepository repository){this.repository=repository;}
 @GetMapping public List<WorkOrder> all(@RequestParam(required=false) WorkOrderStatus status){
  return status==null?repository.findAll():repository.findByStatus(status);
 }
 @GetMapping("/{id}") public WorkOrder one(@PathVariable Long id){
  return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Work order not found"));
 }
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public WorkOrder create(@Valid @RequestBody WorkOrder input){
  input.setId(null); return repository.save(input);
 }
 @PutMapping("/{id}") public WorkOrder update(@PathVariable Long id,@Valid @RequestBody WorkOrder input){
  WorkOrder w=one(id); w.setTitle(input.getTitle()); w.setCustomerName(input.getCustomerName());
  w.setLocation(input.getLocation()); w.setDescription(input.getDescription()); w.setPriority(input.getPriority());
  w.setStatus(input.getStatus()); w.setAssignedTechnician(input.getAssignedTechnician()); return repository.save(w);
 }
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){repository.delete(one(id));}
}
