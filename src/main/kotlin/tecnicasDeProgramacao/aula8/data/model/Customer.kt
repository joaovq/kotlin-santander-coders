package tecnicasDeProgramacao.aula8.data.model

import tecnicasDeProgramacao.aula8.enum.Gender
import java.time.LocalDate

open class Customer(
    id: Long = 0L,
    cpf: String,
    rg: String,
    firstName: String,
    lastName: String,
    birth: LocalDate,
    numTelephone: String,
    gender: Gender,
    email: String
) : PhysicalPerson(cpf, rg, firstName, lastName, birth, numTelephone, gender, email)