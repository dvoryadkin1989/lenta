package by.dvaradkin.lenta.data.integration

import by.dvaradkin.lenta.data.LentaDataConfig
import by.dvaradkin.lenta.data.entity.Employee
import by.dvaradkin.lenta.data.entity.EmployeeContacts
import by.dvaradkin.lenta.data.repo.EmployeeRepo
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [LentaDataConfig::class])
@TestPropertySource("classpath:test-application.properties")
class EmployeeRepoTest {

    @Autowired
    private lateinit var employeeRepo: EmployeeRepo

    @Test
    fun shouldSave() {
        val testEmployee = Employee("Sergey", "Dvaradkin")
        with(testEmployee.contacts) {
            emailAddress = "dvoryadkin1989@gmail.com"
            skypeName = "sdvaradkin"
            mobilePhone = "+375296098001"
        }
        testEmployee.contacts = EmployeeContacts("a", "b", "c")
        employeeRepo.save(testEmployee)
        employeeRepo.findAll().forEach(::println)
    }
}
