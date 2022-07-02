package com.mercadolivro.exception

enum class Errors(val code: String, val message: String) {

    MLA0001("MLB-0001", "Invalid Request"),

    MLB1000("MLB-1000", "Book [%s] not exists"),
    MLB1001("MLB-1001", "Books don't exists"),
    MLB1002("MLB-1002", "Books already registered"),
    MLB1003("MLB-1003", "Cannot update book with status [%s]"),
    MLB1004("MLB-1004", "Some selected books [%s], could not be found"),


    MLC2000("MLC-2000", "Customer [%s] not exists"),
    MLC2001("MLC-2001", "Customer [%s] already registered")
}