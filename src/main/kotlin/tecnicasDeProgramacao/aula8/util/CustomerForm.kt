package tecnicasDeProgramacao.aula8.util

import tecnicasDeProgramacao.aula8.data.model.Customer
import tecnicasDeProgramacao.aula8.enum.Gender
import java.time.LocalDate


data class CustomerForm(
    val cpf: String,
    val rg: String,
    val firstNameForm: String,
    val lastNameForm: String,
    val birthForm: LocalDate,
    val numTelephoneForm: String,
    val genderForm: Gender,
    val emailForm: String
) : Customer(
        cpf = cpf,
        rg =  rg,
        firstName = firstNameForm,
        lastName = lastNameForm,
        birth = birthForm,
        numTelephone = numTelephoneForm,
        gender = genderForm,
        email = emailForm
    )
