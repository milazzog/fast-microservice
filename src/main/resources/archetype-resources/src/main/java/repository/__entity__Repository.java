package ${package}.repository;

import ${package}.model.${entity};
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by milazzog on 20/03/2020.
 */
@Repository
public interface ${entity}Repository extends JpaRepository<${entity}, Long> {

}
