package com.example.vamostcc.classes

import java.io.Serializable

data class Usuario (
    var nome: String,
    var email: String,
    var senha: String
) : Serializable
