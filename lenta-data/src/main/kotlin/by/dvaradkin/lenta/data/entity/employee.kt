package by.dvaradkin.lenta.data.entity

import org.apache.commons.lang3.builder.ToStringBuilder
import org.apache.commons.lang3.builder.ToStringStyle
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
data class Employee(
    var givenName: String = "",

    var familyName: String = "",

    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Long = 0

) {
    @OneToOne(mappedBy = "employee", cascade = [CascadeType.ALL], orphanRemoval = true)
    var contacts: EmployeeContacts = EmployeeContacts(this)
        set(value) {
            field = value
            field.employee = this
        }

    override fun toString(): String {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE)
    }
}

@Entity
data class EmployeeContacts(

    var mobilePhone: String? = null,

    var skypeName: String? = null,

    var emailAddress: String? = null,

    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Long = 0
) {
    @OneToOne
    lateinit var employee: Employee

    constructor(employee: Employee) : this() {
        this.employee = employee
    }
}