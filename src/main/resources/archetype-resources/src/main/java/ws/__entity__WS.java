package ${package}.ws;

import ${package}.model.${entity};
import ${package}.repository.${entity}Repository;
import ${package}.ws.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by milazzog on 21/03/2020.
 */
@RestController
public class ${entity}WS {

    @Autowired
    private ${entity}Repository repository;

    @GetMapping("/api/${entity}")
    public List<${entity}> getAll() {
        return repository.findAll();
    }

    @GetMapping("/api/${entity}/{id}")
    public ResponseEntity<${entity}> getById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        ${entity} e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("no ${entity} with id [%09d]", id)));
        return ResponseEntity.ok().body(e);
    }

    @PostMapping("/api/${entity}")
    public ${entity} save(@Valid @RequestBody ${entity} e) {
        return repository.save(e);
    }

    @PutMapping("/api/${entity}/{id}")
    public ResponseEntity<${entity}> update(@PathVariable(value = "id") Long id, @Valid @RequestBody ${entity} e) throws ResourceNotFoundException {
        ${entity} e1 = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("no ${entity} with id [%09d]", id)));
        e1.setStubProp(e.getStubProp());
        final ${entity} e2 = repository.save(e1);
        return ResponseEntity.ok(e2);
    }

    @DeleteMapping("/api/${entity}/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        ${entity} e = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("no ${entity} with id [%09d]", id)));
        repository.delete(e);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
