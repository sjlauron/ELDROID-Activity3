package com.lauron.activity3.models

import java.io.Serializable

data class Email(
    val senderName: String,
    val subject: String,
    val content: String
) : Serializable
