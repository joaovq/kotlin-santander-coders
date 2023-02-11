package tecnicasDeProgramacao.aula8.util

enum class PatternForm(val pattern:String) {
    CPF("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$"),
    RG("^\\d{2}\\.\\d{3}\\.\\d{3}-\\d{2}$"),
    EMAIL("^\\d{2}\\.\\d{3}\\.\\d{3}-\\d{2}$"),
    BIRTH("dd/MM/yyyy"),
}
