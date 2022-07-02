package com.mercadolivro.extension

import com.mercadolivro.exception.Notification
import org.springframework.validation.FieldError

fun FieldError.toNotificationResponse() : Notification {
    return Notification(this.defaultMessage ?: "Invalid", this.field)
}