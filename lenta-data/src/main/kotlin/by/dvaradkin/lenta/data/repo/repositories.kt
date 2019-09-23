package by.dvaradkin.lenta.data.repo

import by.dvaradkin.lenta.data.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepo : JpaRepository<Employee, Long>