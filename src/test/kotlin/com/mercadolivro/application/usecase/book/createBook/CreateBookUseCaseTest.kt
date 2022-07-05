package com.mercadolivro.application.usecase.book.createBook

import com.mercadolivro.BookBuilder
import com.mercadolivro.BookBuilder.Companion.BuildBook
import com.mercadolivro.CommandsBuilder
import com.mercadolivro.CustomerBuilder
import com.mercadolivro.exception.Errors
import com.mercadolivro.exception.customException.AlreadyRegisteredException
import com.mercadolivro.exception.customException.NotFoundException
import com.mercadolivro.infrastructure.model.BookModel
import com.mercadolivro.infrastructure.repository.IBookRepository
import com.mercadolivro.infrastructure.repository.ICustomerRepository
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import java.util.*

@ExtendWith(MockKExtension::class)
class CreateBookUseCaseTest{

    @MockK
    private lateinit var customerRepository: ICustomerRepository
    @MockK
    private lateinit var bookRepository: IBookRepository
    @InjectMocks
    private lateinit var createBookUseCase: ICreateBookUseCase

    @Test
    fun `When receive a valid command, should create a book`(){
        createBookUseCase = CreateBookUseCase(customerRepository, bookRepository)

        var customer = CustomerBuilder.BuildCustomer()
        var command = CommandsBuilder.createBookCoomandBuilder(customer.get().id!!)
        var bookModel = BuildBook(command, customer.get())
        every { customerRepository.findById(customer.get().id!!) } returns customer
        every { bookRepository.existsByNameAndCustomerModel(command.name, customer.get()) } returns false
        every { bookRepository.save(any<BookModel>()) } returns bookModel.get()

        var commandResponse = createBookUseCase.execute(command)

        verify(exactly = 1) {customerRepository.findById(customer.get().id!!)}
        verify(exactly = 1) {bookRepository.existsByNameAndCustomerModel("bookName", customer.get())}
        verify (exactly = 1) {bookRepository.save(any<BookModel>()) }

        Assertions.assertEquals(bookModel.get().id, commandResponse.id)



    }

    @Test
    fun `When receive a valid command, but customer not found throw NotFoundException`(){
        createBookUseCase = CreateBookUseCase(customerRepository, bookRepository)

        var customer = CustomerBuilder.BuildCustomer()
        var command = CommandsBuilder.createBookCoomandBuilder(customer.get().id!!)
        var bookModel = BuildBook(command, customer.get())
        every { customerRepository.findById(customer.get().id!!) } returns Optional.empty()
        every { bookRepository.existsByNameAndCustomerModel(command.name, customer.get()) } returns false
        every { bookRepository.save(any<BookModel>()) } returns bookModel.get()

        var exception = assertThrows<NotFoundException>
        {
            createBookUseCase.execute(command)
        }

        Assertions.assertEquals("Customer [${customer.get().id!!}] not exists", exception.message)
        Assertions.assertEquals("MLC-2000", exception.errorCode)
        verify(exactly = 1) {customerRepository.findById(customer.get().id!!)}
        verify(exactly = 0) {bookRepository.existsByNameAndCustomerModel("bookName", customer.get())}
        verify (exactly = 0) {bookRepository.save(any<BookModel>()) }

    }
    @Test
    fun `When receive a valid command, but book already registered throw AlreadyRegisteredException`(){
        createBookUseCase = CreateBookUseCase(customerRepository, bookRepository)

        var customer = CustomerBuilder.BuildCustomer()
        var command = CommandsBuilder.createBookCoomandBuilder(customer.get().id!!)
        var bookModel = BuildBook(command, customer.get())
        every { customerRepository.findById(customer.get().id!!) } returns customer
        every { bookRepository.existsByNameAndCustomerModel(command.name, customer.get()) } returns true
        every { bookRepository.save(any<BookModel>()) } returns bookModel.get()

       var exception =  assertThrows<AlreadyRegisteredException>
        {
            createBookUseCase.execute(command)
        }

        Assertions.assertEquals("Books already registered",exception.message)
        Assertions.assertEquals("MLB-1002",exception.errorCode)
        verify(exactly = 1) {customerRepository.findById(customer.get().id!!)}
        verify(exactly = 1) {bookRepository.existsByNameAndCustomerModel("bookName", customer.get())}
        verify (exactly = 0) {bookRepository.save(any<BookModel>()) }

    }
}